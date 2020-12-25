'use strict';


const print = accountNummer => {
    console.log(accountNummer.accountNummer + ", amount: " + accountNummer.saldo)
};


class Account {
    constructor (landcode, bankNummer, randomNummer, saldo) {
        if (bankNummer <= 9) {
            bankNummer = "0" + bankNummer;
        }
        randomNummer = "0".repeat(10 - randomNummer.toString().length) + randomNummer; // moet concverteren naar string
        let controleNummer = randomNummer % 97;
        if (controleNummer <= 9) {
            controleNummer = "0" + controleNummer;
        }
        this.accountNummer = landcode + bankNummer + "" + randomNummer + "" + controleNummer;
        this.saldo = saldo || 0;
    }
    // setters
    set accountNummer(accountNummer) {
        this._accountNummer = accountNummer
    }
    set saldo(saldo) {
        this._saldo = saldo
    }
    // getters
    get accountNummer() {
        return this._accountNummer
    }
    get saldo() {
        return this._saldo
    }
    // methoden
    print() {
        console.log(`${this.accountNummer}, amount: ${this.saldo}`)
    }
}


let account1 = new Account("BE", 8, 99, 10);
print(account1); //dit is de functie
account1.saldo = 50;
account1.print();