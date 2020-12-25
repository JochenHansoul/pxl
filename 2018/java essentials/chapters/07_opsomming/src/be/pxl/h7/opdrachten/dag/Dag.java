package be.pxl.h7.opdrachten.dag;

public enum Dag {
    MAANDAG(true),
    DINSDAG(true),
    WOENSDAG(true),
    DONDERDAG(true),
    VRIJDAG(true),
    ZATERDAG(false),
    ZONDAG(false); // positie is belangrijk! begint te tellen vanaf 0

    private boolean weekdag;

    // constructor
    // roept bij enumeratie de default constructor al op
    // wanneer ge een constructor ingeeft met een waarde in moet de referenties van de instanties ook dit invoer bevatten.
    private Dag() {} // kan ook default constructor aanmaken en zaterdag en zondag gewoon leeglaten, werkt ook
    private Dag(boolean weekdag) {
        this.weekdag = weekdag;
    }

    // getter
    public boolean getWeekdag() {
        return weekdag;
    } //zou beter isWeekdag moeten zijn
}