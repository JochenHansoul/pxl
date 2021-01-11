package be.pxl.h8.oefeningen.oef3_huwelijk;

public class Township {
    private final char[] charAfterThisNeedsToBeUpper = new char[]{' ', '*', '\'', '-'};
    private int postalCode;
    private String name;

    // constructors
    public Township(int postcode, String name) {
        setPostalCode(postcode);
        setName(name);
    }

    // setters
    public void setPostalCode(int postalCode) {
        while (postalCode > 9999) {
            postalCode /= 10;
        }
        while (postalCode < 1000) {
            postalCode *= 10;
        }
        this.postalCode = postalCode;
    }
    public void setName(String name) {
        // all numbers are removes, all uppercase characters are set to lower
        // (except after the ones in the charAfterThisNeedsToBeUpper)
        name = name.replaceAll("[0-9]", "").toLowerCase();
        StringBuilder nameBuilder = new StringBuilder();
        char previousChar = ' ';
        for (char c : name.toCharArray()) {
            if (Character.isLetter(c)) {
                boolean containsChar = false;
                int counter = 0;
                while (counter < charAfterThisNeedsToBeUpper.length && !containsChar) {
                    if (previousChar == charAfterThisNeedsToBeUpper[counter]) {
                        c = Character.toUpperCase(c);
                        containsChar = true;
                    }
                    counter++;
                }
            }
            nameBuilder.append(c);
            previousChar = c;
        }
        this.name = nameBuilder.toString();
    }

    // getters
    public int getPostalCode() {
        return postalCode;
    }
    public String getName() {
        return name;
    }

    // methoden
    public String toString() {
        return postalCode + " " + name;
    }
}