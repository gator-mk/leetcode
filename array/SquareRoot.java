import java.lang.Math;

// rounded off to nearest int
public class SquareRoot {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x < 1) return 0;
        if (x <= 3) return 1;
        double est = x;
        while (!isPrecise (est, x)) {
            est = (est + x / est) / 2.0;
        }
        return (int)est;
    }
    
    private boolean isPrecise (double estimate, int x) {
        return (Math.abs(estimate * estimate - x) / x) < 0.01;
    }
    
    public static void main (String[] args) {
        SquareRoot test = new SquareRoot ();
        System.out.println (test.mySqrt (0) + ", " + test.mySqrt (2) + ", " + test.mySqrt (3) + ", "
                           + test.mySqrt (16) + ", " + test.mySqrt (12) + ", " + test.mySqrt (9));
    }
}