// naam: jochen hansoul
'use strict';

class Persoon {
    constructor(id, naam) {
        if (!Number.isInteger(id) || id <= 0) throw new Error("Id is not a number or is smaller than 0");
        if (typeof naam !== "string") throw new Error("Naam is not a string");
        this._id = id;
        this._naam = naam;
    }
    // methoden
    toString() {
        return `[${this._id}]${this._naam}`
    }
}

class Loonwerker extends Persoon {
    constructor(id, naam, loonPerUur, aantalUrenGewerkt) {
        super(id, naam);
        if (!Number.isInteger(loonPerUur) || loonPerUur <= 0) throw new Error("Loon per uur is not a number or smaller than 0"); // Number.isInteger() is verkeerd geplaatst
        if (!Number.isInteger(aantalUrenGewerkt) || aantalUrenGewerkt <= 0) throw new Error("Loon per uur is not a number or smaller than 0"); // zelfde fout
        this._loonPerUur = loonPerUur;
        this._aantalUrenGewerkt = aantalUrenGewerkt;
    }
    berekenLoon() {
        return this._aantalUrenGewerkt * this._loonPerUur
    }
    toString() {
        return `${super.toString()} = ${this.berekenLoon()}`;
    }
}

class Manager extends Persoon {
    constructor(id, naam) {
        super(id, naam);
        this._loonWerkers = [];
    }
    voegLoonWerkerToe(loonWerker) {
        if (!(loonWerker instanceof Loonwerker)) throw new Error("Loonwerker is not an instance of class Loonwerker");
        this._loonWerkers.push(loonWerker)
    }
    berekenLoon() {
        let loon = 0;
        for (let loonWerker of this._loonWerkers) {
            loon += loonWerker.berekenLoon();
        }
        loon *= 0.2;
        return Math.round(loon)
    }
    toString() {
        return `${super.toString()} = ${this.berekenLoon()}`;
    }
}

try {
    let persoon = new Persoon(1,"mieke");
    let manager = new Manager(2,"jan");
    let werker1 = new Loonwerker(3,"tim",11,13);
    let werker2 = new Loonwerker(4,"sofie",2,50);
    manager.voegLoonWerkerToe(werker1);
    manager.voegLoonWerkerToe(werker2);
    console.log(persoon.toString());
// [1] mieke
    console.log(werker1.toString());
// [3] tim = 143
    console.log(werker2.toString());
// [4] sofie = 100
    console.log(manager.toString());
// [2] jan = 49
} catch (e) {
    console.log(e)
}