package oef1;

public class TheTest {
    public static void main(String[] args) {
        Bow bow = new Bow();
        final long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            bow.setDurabilityModifier(i);
            double yeet = bow.getDurability();
            System.out.println(yeet);
        }
        final long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}