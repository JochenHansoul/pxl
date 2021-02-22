"use strict";
import {URL_PERSONS} from './modules/links.js'
import {TOKEN_ID, TOKEN_FIRST_NAME, TOKEN_LAST_NAME} from './modules/tokens.js'


let app = new Vue({
    el: '#app',
    data: {
        firstName: "",
        lastName: "",
        error: "",
    },
    methods: {
        login(){
            this.status = "";
            if (this.firstName === "" || this.lastName === "") {
                this.error = "Name not filled in!";
            } else {
                // fetches only returns the person who's first name and last name are given (if exists)
                fetch(`${URL_PERSONS}?firstName=${this.firstName}&lastName=${this.lastName}`)
                    .then((response) => {
                        if (response.status === 200) {
                            return response.json();
                        }
                        throw new Error(`error with status ${response.status}`);
                    })
                    .then((persons) => {
                        let person = persons[0]; //return type is still an array
                        sessionStorage.setItem(TOKEN_ID, person.id);
                        sessionStorage.setItem(TOKEN_FIRST_NAME, person.firstName);
                        sessionStorage.setItem(TOKEN_LAST_NAME, person.lastName);
                        window.location.href = "./activities.html";
                    })
                    .catch(error => this.error = error);
            }
        }
    }
});