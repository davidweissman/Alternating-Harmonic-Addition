/* Takes in a double r and approximates it by adding terms in the alternating
 * harmonic series
 * 
 * Execution: java ConditionalConvergence r
 * 
 */

public class ConditionalConvergence {
    public static void main(String[] args) {
        double r = Double.parseDouble(args[0]);
        //double r = 0.0 + in;
        double[] positives = new double[50000000];
        double[] negatives = new double[50000000];
        int negCounter = 0;
        int posCounter = 0;
        for (double i = 1.0; i < 100000000.0; i++) {
            double x = Math.pow(-1, i + 1) * 1 / i;
            if (x < 0) {
                negatives[negCounter] = x;
                negCounter++;
            } else {
                positives[posCounter] = x;
                posCounter++;
            }
        }
        double approx = 0;
        int j = 0;
        int k = 0;
        //boolean isDone = false;
        while (true) {
            while (approx < r && j < 50000000) {
                approx += positives[j];
                j++;
            }
            while (approx > r && k < 50000000) {
                approx += negatives[k];
                k++;
            }
            if (j == 50000000 || k == 50000000 || approx == r) {
                break;
            }
        }
        //System.out.println("hello");
        System.out.println("Approximation of " + r + ": " + approx);
        double error = (r - approx) / r;
        System.out.println("Error Percentage: " + error * 100 + "%");
        System.out.println("Terms added: " + j);
        System.out.println("Terms subtracted: " + k);
    }
}
