"use strict";
import {URL_PERSONS, URL_ACTIVITIES, URL_PERSON_ACTIVITIES} from "./links.js";
import {TOKEN_FIRST_NAME, TOKEN_ID, TOKEN_LAST_NAME} from "./tokens.js";

export const INVALID_CHARACTERS = /[`!@#$%^&*()_+\-=\[\]{};:"\\|,.<>\/?~0123456789]/;
export const MINIMUM_AGE = 4;

const CATEGORIES = [
    {
        id: 1,
        name: "scratch"
    },
    {
        id: 2,
        name: "lego mindstorms"
    },
    {
        id: 3,
        name: "python"
    }];


// object used by the createClearOrRemovePersonActivity function
let emptyPersonActivities = {
    id: undefined,
    activities: []
};


// returns true if the string contains and invalid character.
export const containsInvalidCharacters = s => INVALID_CHARACTERS.test(s);


// can be used to add a new personActivities object to the database (POST)
// or to clear all the past activities of it (PUT)
// or to completely remove the personActivities object from the database (DELETE)
// if succeeded it redirects the page to the given location
// change error to error = {message: ""}. error is now optional and does not
// require the if conditions
export const createClearOrRemovePersonActivity = (method, id, location, error) => {
    if (error) {
        error.message =""
    }
    emptyPersonActivities.id = id;
    let url = method === "POST" ? URL_PERSON_ACTIVITIES : URL_PERSON_ACTIVITIES + id; // POST may not contain id extension
    let body = method === "DELETE" ? undefined : JSON.stringify(emptyPersonActivities); // DELETE does not require body
    fetch(url,{
        method: method,
        body: body,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (response.status === 200 || response.status === 201) {
                window.location.href = location
            } else {
                throw new Error(`Fout bij personActivity ${response.status}`)
            }
        })
        .catch(e => {
            if (error) {
                error.message = e.message
            }
        });
};


const createPerson = (person, location, method, error) => {
    let url = method === "PUT" ? URL_PERSONS + person.id : URL_PERSONS;
    fetch(url,{
        method: method,
        body: JSON.stringify(person),
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    })
        .then(response => {
            if (response.status === 200) {
                window.location.href = location; // PUT
                throw new Error("") //no error, just needs to exit out of the function
            } else if (response.status === 201) {
                return response.json() // POST
            }
            throw new Error(`Fout bij het aanmaken van de persoon. Status ${response.status}`)
        })
        .then(person => {
            sessionStorage.setItem(TOKEN_ID, person.id);
            sessionStorage.setItem(TOKEN_FIRST_NAME, person.firstName);
            sessionStorage.setItem(TOKEN_LAST_NAME, person.lastName);
            // ads a new personActivities object to the database with the same user id
            createClearOrRemovePersonActivity("POST", person.id, location, error)
        })
        .catch(e => {
            if (error) {
                error.message = e.message
            }
        });
};


// checking if the person with the same first name and last name is already added
// if not then uses createPerson to update or create a new person
const checkIfPersonIsAlreadyAdded = (person, method, location, error) => {
    if (error) {
        error.message =""
    }
    fetch(`${URL_PERSONS}?firstName=${person.firstName}&lastName=${person.lastName}`)
        .then((response) => {
            if (response.status === 200) {
                return response.json();
            }
            throw new Error(`Fout bij controle of de persoon al toegevoegd is. Status ${response.status}`);
        })
        .then((persons) => {
            if (persons[0] === undefined) {
                createPerson(person, location, method, error)
            } else {
                throw new Error("De persoon met deze naam en voornaam is al aangemaakt")
            }
        })
        .catch(e => {
            if (error) {
                error.message = e.message
            }
        })
};


// creates a new person in the database if the person with the same first and last name does not exists
// error needs te be an object with property message
export const createPersonIfNotExists = (person, location, error) => {
    checkIfPersonIsAlreadyAdded(person, "POST", location, error)
};


// updates a person in the database if the person with the same first and last name does not exists
// error needs to be an object with property message
export const changePersonIfNotExists = (person, location, error) => {
    checkIfPersonIsAlreadyAdded(person, "PUT", location, error)
};


// all the activities of the current person are gathered and put in the activitiesArray
// creates an url and places all activityId's in it to use it to fetch the name, category id and description of the corresponding activities
const addActivitiesOfPersonToActivitiesArray = (activitiesOfPerson, activitiesArray, error) => {
    let urlIds = `?id=${activitiesOfPerson[0].id}`;
    // only ads more activities if the returned amount of activities for the person is more than 1
    for (let i = 1; i < activitiesOfPerson.length; i++) {
        urlIds += `&id=${activitiesOfPerson[i].id}`
    }
    // fetches all activities (id, name, category, description) corresponding with the activityId's of the current person
    fetch(URL_ACTIVITIES + urlIds)
        .then((response) => {
            if (response.status === 200) {
                return response.json()
            }
            throw new Error(`Failed to get the corresponding activities. Status ${response.status}`)
        })
        .then(activities => {
            // ads the gathered activities and dates to the activities array
            for (let i = 0; i < activities.length; i++) {
                activitiesArray.push({
                    category: CATEGORIES[activities[i].category - 1].name, //gets the name of the categories corresponding with the category id. Need to do -1 because the category start at 1
                    name: activities[i].name,
                    date: activitiesOfPerson[i].date,
                    description: activities[i].description
                })
            }
        })
        .catch(e => {
            if (error) {
                error.message = e.message
            }
        })
};


// this method gets all the activities of the person(id, date) and then uses the method
// addActivitiesOfPersonToActivitiesArray(personActivities) which gathers all the activities of the user
// and ads them to the activitiesCurrentPerson array.
// error needs to be an object and is optional
export const getPersonActivitiesWithId = (id, activitiesArray, error) => {
    if (error) {
        error.message = ""
    }
    activitiesArray.length = 0; // resets the array
    fetch(URL_PERSON_ACTIVITIES + id)
        .then((response) => {
            if (response.status === 200) {
                return response.json()
            }
            throw new Error(`error with status ${response.status}`)
        })
        .then(personActivities => {
            let activities = personActivities.activities;
            if (activities.length === 0) {
                throw new Error("Helaas; Je hebt nog geen activiteiten gedaan.") // in case there are no results for this person
            }
            addActivitiesOfPersonToActivitiesArray(activities, activitiesArray, error);
        })
        .catch(e => {
            if (error) {
                error.message = e.message
            }
        })
};