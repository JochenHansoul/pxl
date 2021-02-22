"use strict";
import {INVALID_CHARACTERS, MINIMUM_AGE, createPersonIfNotExists, containsInvalidCharacters} from "./modules/functions.js";

let app = new Vue({
    el: '#app',
    data: {
        invalidCharacters: INVALID_CHARACTERS,
        minimumAge: MINIMUM_AGE,
        person: {
            firstName: "",
            lastName: "",
            age: undefined,
        },
        errorFirstName: false,
        errorLastName: false,
        errorFirstNameChar: false,
        errorLastNameChar: false,
        errorAge: false,
        errorMinimumAge: false,
        error: {message: ""}
    },
    methods: {
        addPerson() {
            this.status = "";
            // checks if the input fields "first name", "last name" and "age" are not empty strings and "age" is a number
            let boolFirstName = this.person.firstName !== "";
            let boolLastName = this.person.lastName !== "";
            let boolFirstNameChar = !containsInvalidCharacters(this.person.firstName);
            let boolLastNameChar = !containsInvalidCharacters(this.person.lastName);
            let boolAge = this.person.age !== undefined && !isNaN(this.person.age);
            let boolMinimumAge = this.person.age >= MINIMUM_AGE;
            // if all input fields are filled in correctly the person is added to the database
            if (boolFirstName && boolLastName && boolFirstNameChar && boolLastNameChar && boolAge && boolMinimumAge) {
                this.person.age = parseInt(this.person.age); //age is converted to a number
                // checks if this person is already added (based on first and last name) and if not then ads him to the database
                createPersonIfNotExists(this.person, "./activities-new-user.html", this.error);
            } else {
                // if there is an error in the input field the "div" elements become visible depending on their boolean value
                this.errorFirstName = !boolFirstName;
                this.errorLastName = !boolLastName;
                this.errorFirstNameChar = !boolFirstNameChar;
                this.errorLastNameChar = !boolLastNameChar;
                this.errorAge = !boolAge;
                this.errorMinimumAge = !boolMinimumAge;
            }
        },


    }
});