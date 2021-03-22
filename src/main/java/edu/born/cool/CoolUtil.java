package edu.born.cool;

public class CoolUtil {

    private CoolUtil() {
    }

    public static boolean isInvalidAmount(int amount) {
        return !(0 <= amount && amount <= 100);
    }
}
