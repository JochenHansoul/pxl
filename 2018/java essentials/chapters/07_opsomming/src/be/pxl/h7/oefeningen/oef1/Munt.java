package be.pxl.h7.oefeningen.oef1;

public enum Munt {
    VIJFHONDERD(50000),
    TWEEHONDERD(20000),
    HONDERD(10000),
    VIJFTIG(5000),
    TWINTIG(2000),
    TIEN(1000),
    VIJF(500),
    TWEE(200),
    EEN(100),
    VIJFTIGCENT(50),
    TWINTIGCENT(20),
    TIENCENT(10),
    VIJFCENT(5),
    TWEECENT(2),
    EENCENT(1);

    int waarde;

    private Munt(int waarde) { // constructor voor de opsomming
        this.waarde = waarde;
    }

    public int getWaarde() { // getter voor de waarde te verkrijgen
        return waarde;
    }
}