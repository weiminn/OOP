import java.util.*;

// This class is used to check that your Rational class works correctly
public class RationalTest {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        // Prompt user for the first rational number
        System.out.print ("Enter numerator of a rational number: ");
        int firstNumerator = sc.nextInt();
        System.out.print ("Enter denominator of a rational number: ");
        int firstDenominator = sc.nextInt();

        System.out.println();

        // Prompt user for the second rational number
        System.out.print ("Enter numerator of 2nd rational number: ");
        int secondNumerator = sc.nextInt();
        System.out.print ("Enter denominator of 2nd rational number: ");
        int secondDenominator = sc.nextInt();

        // create the two Rational objects
        Rational firstRational = new Rational(firstNumerator, firstDenominator);
        Rational secondRational = new Rational(secondNumerator, secondDenominator);

        System.out.println("For r = "+ firstRational.toString() + " and s = "
                + secondRational.toString());
        // or
        // System.out.println("For r = "+ firstRational + " and s = " + secondRational);

        // test the add method of Rational
        Rational answer = firstRational.add(secondRational);
        System.out.println("    r + s = " + answer);

        // test the subtract method of Rational
        answer = firstRational.subtract(secondRational);
        System.out.println("    r - s = " + answer);

        // test the multiply method of Rational
        answer = firstRational.multiply(secondRational);
        System.out.println("    r * s = " + answer);

        // test the divide method of Rational
        answer = firstRational.divide(secondRational);
        System.out.println("    r / s = " + answer);
    }
}