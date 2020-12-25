'use strict';


class Date {
    constructor(year, month, day) {
        this.year = year;
        this.month = month;
        this.day = day;
        Date.MONTHS = ["jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"] // Oef7_Date voor static te maken?
    }
    // setters
    set year(year) {
        this._year = year
    }
    set month(month) {
        this._momth = month
    }
    set day(day) {
        this._day = day
    }
    // getters
    get year() {
        return this._year
    }
    get month() {
        return this._momth
    }
    get day() {
        return this._day
    }
    // methods
    print() {
        console.log(`${this.day}/${this.month}/${this.year}`)
    }
    printMonth() {
        console.log(`${this.day}/${Date.MONTHS[this.month - 1]}/${this.year}`)
    }
    static make(year, month, day) {
        return new Date(year, month, day)
    }
}


let date1 = new Date(2019, 5, 11);
date1.print();
date1.printMonth();
date1.day = 12;
console.log(date1.day);
let date2 = Date.make(2019, 2, 6);
date2.printMonth();