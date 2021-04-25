package be.jochenhansoul.inheritance;

public class Super {
    private static int counter = 0;

    final String TEST_FINAL = "original static";

    String testDynamic = "original dynamic";

    public static int getAmount() {
        return counter;
    }

    protected static String staticMethod() {
        return "original static method";
    }

    protected String dynamicMethod() {
        return "original dynamic method";
    }

    @Override
    public String toString() {
        return TEST_FINAL;
    }
}
