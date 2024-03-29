package factorial;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Long> {
    private long number;

    public FactorialCalculator(long number) {
        this.number = number;
    }

    @Override
    public Long call() throws Exception {
        try {
            if (number < 0) {
                throw new Exception();
            }
            return calculate(number);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private long calculate(long num) {
        return num >= 1 ? num * calculate(num - 1) : 1L;
    }
}