package be.pxl.ja.variables;

public class Functions {
    public static void main(String[] args) {
        System.out.println(generateWelcomeMessage("Bob and Dave"));
    }

    public static String generateWelcomeMessage(String name) {
        return "hello " + name;
    }
}
