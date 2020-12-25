package be.pxl.h7.oefeningen.exoef;

public enum TShirtSize {
    EXTRA_SMALL(86),
    SMALL(94),
    MEDIUM(102),
    LARGE(110),
    EXTRA_LARGE(118),
    EXTRA_EXTRA_LARGE(128),
    EXTRA_EXTRA_EXTRA_LARGE(140);

    private int borstomtrek;

    TShirtSize(int borstomtrek) {
        this.borstomtrek = borstomtrek;
    } // is altijd private, publiek is niet toegestaan

    public int getBorstomtrek() {
        return borstomtrek;
    }
}