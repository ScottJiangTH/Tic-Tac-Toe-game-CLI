package TicTacToe;

import java.util.Random;

/**
 * The type Random generator.
 */
public class RandomGenerator {

    /**
     * Discrete int.
     *
     * @param lo the lo
     * @param hi the hi
     * @return the int
     */
    int discrete(int lo, int hi) {
        if (lo >= hi) {
            System.out.println("Error discrete, lo >= hi");
            System.exit(0);
        }
        Random r = new Random();
        int d = r.nextInt(hi - lo + 1) + lo;
        return d;
    }

}