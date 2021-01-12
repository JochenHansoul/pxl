package be.pxl.h8.oefeningen.oef3_huwelijk;

public class Township {
    public static final char[] charAfterThisNeedsToBeUpper = new char[]{' ', '*', '\'', '-'};
    private int postcode;
    private String name;

    // constructors
    public Township(int postcode, String name) {
        setPostcode(postcode);
        setName(name);
    }

    // setters
    public void setPostcode(int postcode) {
        while (postcode > 9999) {
            postcode /= 10;
        }
        while (postcode < 1000) {
            postcode *= 10;
        }
        this.postcode = postcode;
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
    public int getPostcode() {
        return postcode;
    }
    public String getName() {
        return name;
    }

    // methoden
    public String toString() {
        return postcode + " " + name;
    }
}