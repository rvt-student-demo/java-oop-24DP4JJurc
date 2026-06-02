package rvt;

import java.util.Scanner;

public class temperaturasparv {

    public static double cToF(double c) {
        return (c * 9.0 / 5) + 32;
    }

    public static double fToC(double f) {
        return (f - 32) * 5.0 / 9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ievadi temperatūru Celsijā:");
        double c = scanner.nextDouble();

        double f = cToF(c);
        System.out.println(c + " °C = " + f + " °F");

        System.out.println();

        System.out.println("Ievadi temperatūru Fārenheitā:");
        double fahr = scanner.nextDouble();

        double cels = fToC(fahr);
        System.out.println(fahr + " °F = " + cels + " °C");

        scanner.close();
    }
}
