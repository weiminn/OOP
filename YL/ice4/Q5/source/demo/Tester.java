package demo;

import java.util.Scanner;
import javax.mail.*;

import demo.util.*;

public class Tester {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter your email: ");
            String email = sc.nextLine();

            Emailer.sendEmail(email);
            System.out.println("Email sent!");
    }
}
