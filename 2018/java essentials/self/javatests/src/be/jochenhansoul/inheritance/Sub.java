package be.jochenhansoul.inheritance;

public class Sub extends Super {
    private static int counter = 10;

    protected final String TEST_FINAL = super.TEST_FINAL  + " and override static";

    protected String testDynamic =super.testDynamic + " and override dynamic";

    public static int getAmount() {
        return counter;
    }

    protected static String staticMethod() {
        return "override static method";
    }

    @Override
    protected String dynamicMethod() {
        return "override dynamic method";
    }

    @Override
    public String toString() {
        return TEST_FINAL;
    }
}
