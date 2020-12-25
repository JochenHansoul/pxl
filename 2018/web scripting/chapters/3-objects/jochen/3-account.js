'use strict';

class Account {
    constructor (landcode, bankNummer, randomNummer, bedrag) {
        if (bankNummer <= 9) bankNummer = "0" + bankNummer;
        randomNummer = "0".repeat(10 - randomNummer.toString().length) + randomNummer; // moet concverteren naar string
        let controleNummer = randomNummer % 97;
        if (controleNummer <= 9) controleNummer = "0" + controleNummer;
        this._accountNummer = landcode + bankNummer + "" + randomNummer + "" + controleNummer;
        this._saldo = bedrag || 0
    }
    // methoden
    stort(bedrag) {
        this._saldo += bedrag
    }
    neemOp(bedrag) {
        if (this._saldo < bedrag) {
            console.log(`U kunt maar ${this._saldo} ophalen`);
            this._saldo = 0
        } else {
            this._saldo -= bedrag;
        }
    }
    print() {
        console.log(`Rekeningnummer: ${this._accountNummer}, saldo: ${this._saldo}`)
    }
}

let account1 = new Account("BE", 8, 99);
account1.print();
account1.stort(500);
account1.print();
account1.neemOp(300);
account1.print();