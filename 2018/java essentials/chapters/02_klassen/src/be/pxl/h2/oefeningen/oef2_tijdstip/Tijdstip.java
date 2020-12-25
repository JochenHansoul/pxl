package be.pxl.h2.oefeningen.oef2_tijdstip;

public class Tijdstip {
    private int uren;
    private int minuten;
    private int seconden;

    // constructors
    public Tijdstip() {}
    public Tijdstip(int uren, int minuten, int seconden) {
        this.uren = uren;
        this.minuten = minuten;
        this.seconden = seconden;
        controleTijd();
    }
    public Tijdstip(int seconden) {
        this.seconden = seconden;
        controleTijd();
    }
    public Tijdstip (Tijdstip tijdstip) {
        this(tijdstip.uren, tijdstip.minuten, tijdstip.seconden);
    }

    // setters
    public void setUren(int uren) {
        this.uren = uren;
        controleTijd();
    }
    public void setMinuten(int minuten) {
        this.minuten = minuten;
        controleTijd();
    }
    public void setSeconden(int seconden) {
        this.seconden = seconden;
        controleTijd();
    }

    // getters
    public int getUren() {
        return uren;
    }
    public int getMinuten() {
        return minuten;
    }
    public int getSeconden() {
        return seconden;
    }

    // methoden
    private void controleTijd() {
        if (seconden >= 60) {
            minuten += seconden / 60;
            seconden %= 60;
        }
        if (minuten >= 60) {
            uren += minuten / 60;
            minuten %= 60;
        }
        if (uren >= 24) {
            uren %= 24;
        }
    }
    public void voegUrenToe() {
        voegUrenToe(1);
    }
    public void voegUrenToe(int uren) {
        this.uren += uren;
        controleTijd();
    }
    public void voegMinutenToe(int minuten) {
        this.minuten += minuten;
        controleTijd();
    }
    public void voegSecondenToe(int seconden) {
        this.seconden += seconden;
        controleTijd();
    }
    public String toStringTijd(boolean engelseNotatie) {
        String uren;
        String minuten;
        String ampm;
        if (engelseNotatie) {
            minuten = this.minuten + "";
            if (minuten.length() < 2) {
                minuten = "0" + minuten;
            }
            if (this.uren < 12) {
                ampm = "AM";
                if (this.uren == 0) {
                    uren = "12";
                } else {
                    uren = this.uren + "";
                }
                if (uren.length() < 2) {
                    uren = "0" + uren;
                }
            } else if (this.uren == 12) {
                ampm = "AM";
                uren = "12";
            } else {
                ampm = "PM";
                uren = (this.uren - 12) + "";
            }
            return uren + ":" + minuten + " " + ampm;
        } else {
            minuten = this.minuten + "";
            if (minuten.length() < 2) {
                minuten = "0" + minuten;
            }
            return this.uren + ":" + minuten + " u";
        }
    }
    public String toStringTechnisch() {
        return String.format("%02d:%02d:%02d", uren, minuten, seconden); // left pad lengte 2 met nullen "0"
        /*String uren;
        String minuten;
        String seconden;
        uren = String.valueOf(this.uren);
        minuten = String.valueOf(this.minuten);
        seconden = String.valueOf(this.seconden);
        if (uren.length() < 2) {
            uren = "0" + uren;
        }
        if (minuten.length() < 2) {
            minuten = "0" + minuten;
        }
        if (seconden.length() < 2) {
            seconden = "0" + seconden;
        }
        return uren + ":" + minuten + ":" + seconden;*/
    }
}
