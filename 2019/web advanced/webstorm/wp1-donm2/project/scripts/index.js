"use strict";

new Vue({
    el: '#app',
    data: {
        error: "",
    },
    methods: {
        goToRegister() {
            window.location.href = "./register.html";
        },
        goToLogin() {
            window.location.href = "./login.html";
        },
        goToOverview() {
            window.location.href = "./overview.html";
        }
    }
});