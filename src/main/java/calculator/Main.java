package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);
        System.out.println(
                """
                     Welcome to calculator!\s
                     '+','-','*' and '/' operators are available\s
                     You have to type ONLY TWO INTEGER arguments\s
                     Example: 364+278\s
                     Type 'e' to exit"""
        );
        while (true){
            System.out.print("Input: ");
            input = in.nextLine();
            if (input.equals("e")) break;
            Calculator calculator = new Calculator();
            try {
                calculator.inputProcessor(input);
                System.out.println("Result is: " + calculator.getResult());
            } catch (IllegalArgumentException | ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
