"use strict";
import {URL_PERSONS} from "./modules/links.js"
import {INVALID_CHARACTERS, MINIMUM_AGE, containsInvalidCharacters, changePersonIfNotExists, getPersonActivitiesWithId, createClearOrRemovePersonActivity} from "./modules/functions.js"


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

let app = new Vue({
    el: '#app',
    data: {
        persons: [],
        selectedPerson: undefined,
        activitiesCurrentPerson: [],
        errorInput: "",
        errorCharacters: "",
        errorMinimumAge: "",
        error : {message: ""}
    },
    methods: {
        goToIndex() {
            console.log("index");
            window.location.href = "./index.html";
        },
        updatePerson(person) {
            let age = person.age;
            // checks if the input fields "first name", "last name" and "age" are not empty strings and "age" is a number
            let boolFirstName = person.firstName !== "";
            let boolLastName = person.lastName !== "";
            let boolFirstNameChar = !containsInvalidCharacters(person.firstName);
            let boolLastNameChar = !containsInvalidCharacters(person.lastName);
            let boolAge = age !== ""; // this still works
            let boolMinimumAge = person.age >= MINIMUM_AGE;
            // if all input fields are filled in correctly the person's data is updated
            if (boolFirstName && boolLastName && boolFirstNameChar && boolLastNameChar && boolAge && boolMinimumAge) {
                person.age = parseInt(person.age);
                changePersonIfNotExists(person, window.location.pathname, this.error);
            } else {
                // if there is an error in the input field an error message is displayed depending on which input fields are wrong
                if (!boolFirstName || !boolLastName || !boolAge) {
                    let errorMessage = "vul in: ";
                    if (!boolFirstName) errorMessage += "voornaam";
                    if (!boolLastName) errorMessage += (!boolFirstName ? ", achternaam" : "achternaam");
                    if (!boolAge) errorMessage += (!boolFirstName || !boolLastName ? ", leeftijd" : "leeftijd");
                    this.errorInput = errorMessage
                } else {
                    this.errorInput = "";
                }
                this.errorCharacters = (boolFirstNameChar && boolLastNameChar) ? "" : "may not contain: " + INVALID_CHARACTERS;
                this.errorMinimumAge = boolMinimumAge ? "" : "minimum age is " + MINIMUM_AGE
            }
        },
        deletePerson(id) {
            this.status = "";
            this.error = "";
            // this deletes the account of the user
            fetch(URL_PERSONS + id,
                {
                    method: "DELETE",
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    }
                })
                .then((response) => {
                    if (response.status !== 200) {
                        throw new Error(`error deleting person status ${response.status}`)
                    }
                    // The personActivities corresponding with the person must also be deleted
                    createClearOrRemovePersonActivity("DELETE", id, "./overview.html", this.error)
                })
                .catch(error => this.error = error);
        },
        deletePersonActivities(id) {
            if (id === undefined) {
                id = this.selectedPerson.id; // I couldn't add the id directly to the button to delete all the activities
            }
            // updates the personActivity with the given id and reloads the page
            createClearOrRemovePersonActivity("PUT", id, "./overview.html", this.error)
        },
        getActivities(person) {
            this.activitiesCurrentPerson = []; // resets the array
            this.selectedPerson = person;
            getPersonActivitiesWithId(person.id, this.activitiesCurrentPerson, this.error)
        }
    },
    beforeCreate() {
        // gets all the persons
        fetch(URL_PERSONS)
            .then((response) => {
                if (response.status === 200) {
                    return response.json()
                }
                throw new Error(`error with status ${response.status}`);
            })
            .then(persons => this.persons = persons)
            .catch(error => this.error.message = error);
    }
});