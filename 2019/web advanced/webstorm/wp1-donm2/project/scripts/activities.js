'use strict';
import {URL_PERSON_ACTIVITIES, URL_ACTIVITIES, URL_CATEGORIES} from './modules/links.js'
import {TOKEN_ID, TOKEN_FIRST_NAME, TOKEN_LAST_NAME} from './modules/tokens.js'
import {getPersonActivitiesWithId} from "./modules/functions.js";


Vue.component("activities-table", {
    props: ["activities"],
    template:
        "        <table>\n" +
        "            <thead>\n" +
        "            <tr>\n" +
        "                <th>category</th>\n" +
        "                <th>name</th>\n" +
        "                <th>date</th>\n" +
        "                <th>description</th>\n" +
        "            </tr>\n" +
        "            </thead>\n" +
        "            <tbody>\n" +
        "            <tr v-for=\"activity in activities\">\n" +
        "                <td>{{ activity.category }}</td>\n" +
        "                <td>{{ activity.name }}</td>\n" +
        "                <td>{{ activity.date }}</td>\n" +
        "                <td>{{ activity.description }}</td>\n" +
        "            </tr>\n" +
        "            </tbody>\n" +
        "        </table>"
});

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        categoryId: -1,
        activities: []
    },
    mutations: {
        setActivities (state, activities) {
            state.activities = activities
        },
        setCategoryId (state, categoryId) {
            state.categoryId = categoryId
        }
    },
    getters: {
        activitiesFilteredByCategory: state => {
            if (state.categoryId == -1) {
                return state.activities;
            }
            return state.activities.filter(activity => activity.category == state.categoryId);
        }
    }
});

let app = new Vue({
    el: '#app',
    store,
    data: {
        firstName: sessionStorage.getItem(TOKEN_FIRST_NAME),
        lastName: sessionStorage.getItem(TOKEN_LAST_NAME),
        id: sessionStorage.getItem(TOKEN_ID),
        categories: [], // all categories (categoryId, name). Added in beforeCreate()
        activitiesCurrentPerson: [], // the activities of the current person (category, name, data, description). added in beforeMount()
        allActivities: [], // al the activities in the database (id, category, name, description). Added in the method GetAllActivities()
        addActivityBool: false, //bool for eater displaying the button for showing the to added activities or the option the add one of those activities
        categoryId : 0,
        error: {message: ""},
    },
    computed: {
        activitiesFilteredByCategory () {
            return this.$store.getters.activitiesFilteredByCategory
        }
    },
    methods: {
        // gets all activities and puts them in "allActivities" and makes the category and activities visible
        getAllActivities() {
            fetch(URL_ACTIVITIES)
                .then((response) => {
                    if (response.status === 200) {
                        return response.json();
                    }
                    throw new Error(`error with status ${response.status}`)
                })
                .then(activities => {
                    this.allActivities = activities;
                    store.commit('setActivities', activities);
                })
                .catch(e => this.error.message = e.message);
            this.addActivityBool = true;
        },

        // Checks if the activity is already added
        // If not then uses the method updateActivitiesOfPerson(activityId) to add the selected activity to the user and refreshes the page
        // if already added throws and error
        addActivity() {
            // getting activityId of the selected activity
            let select = document.getElementById("all-activities");
            let activityId = parseInt(select.options[select.selectedIndex].value);
            // checking if the activity is not already added
            fetch(URL_PERSON_ACTIVITIES + this.id)
                .then((response) => {
                    if (response.status === 200) {
                        return response.json()
                    }
                    throw new Error(`error with getting person activities status ${response.status}`)
                })
                .then(personActivities => {
                    let activities = personActivities.activities;
                    // if no activities have been added yet the new activity can directly be added
                    if (activities.length !== 0) {
                        // checking if same the activity is not already added
                        for (let activity of activities) {
                            if (activity.id === activityId) {
                                throw new Error("deze activiteit is al toegevoegd")
                            }
                        }
                    }
                    personActivities.activities.push({id: activityId, date: new Date()});
                    this.updateActivitiesOfPerson(personActivities);
                })
                .catch(e => this.error.message = e);
        },

        // sub-function of addActivity()
        // receives the personActivities object with the added activity in it and updates it in the database
        updateActivitiesOfPerson(personActivities) {
            fetch(URL_PERSON_ACTIVITIES + personActivities.id,{
                method: "PUT",
                body: JSON.stringify(personActivities),
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    if (response.status === 200) {
                        return response.json()
                    }
                    throw new Error(`error with status ${response.status}`)
                })
                .then(() => window.location.href = window.location.pathname) // reloads page
                .catch(e => this.error.message = e);
        },

        logOut() {
            sessionStorage.removeItem(TOKEN_ID);
            sessionStorage.removeItem(TOKEN_FIRST_NAME);
            sessionStorage.removeItem(TOKEN_LAST_NAME);
            window.location.href= "./index.html";
        },

        selectCategory() {
            this.$store.commit('setCategoryId', this.categoryId)
        }
    },

    beforeCreate() {
        // fetches names and id's all the activity categories and stores it into "categories" before everything else
        fetch(URL_CATEGORIES)
            .then((response) => {
                if (response.status === 200) {
                    return response.json()
                }
                throw new Error(`error with status ${response.status}`)
            })
            .then(categories => this.categories = categories)
            .catch(e => this.error.message = e.message);
    },

    // when the page loads a table for all the activities of the current person is generated
    // this method gets all the activities of the person(id, date) and then uses the method
    // addActivitiesOfPersonToActivitiesArray(personActivities) which gathers all the activities of the user
    // and ads them to the activitiesCurrentPerson array.
    beforeMount() {
        // checking if the "id" token is correctly stored into the browser
        if (this.id !== undefined && this.id !== "") {
            getPersonActivitiesWithId(this.id, this.activitiesCurrentPerson, this.error);
        } else {
            this.error.message = "Er is een fout opgetreden. Gelieve opnieuw in te loggen" // upon error the user is asked to login again
        }
    }
});
