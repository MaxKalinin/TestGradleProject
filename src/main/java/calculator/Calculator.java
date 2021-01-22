package calculator;

public class Calculator {
    private int result;
    private final int FIRST_ARG_POSITION = 0;
    private final int SECOND_ARG_POSITION = 1;

    public void inputProcessor(String input){
        //remove all whitespaces from input string
        input = input.replaceAll(" ", "");
        //define math operator or throw exception
        String operator = "INVALID_OPERATOR";
        if(input.matches("^\\d+\\+\\d+$")) operator = "\\+";
        if(input.matches("^\\d+-\\d+$")) operator = "-";
        if(input.matches("^\\d+\\*\\d+$")) operator = "\\*";
        if(input.matches("^\\d+/\\d+$")) operator = "/";
        if(operator.equals("INVALID_OPERATOR")) throw new IllegalArgumentException("Illegal statement!");
        //parsing arguments
        String[] args = input.split(operator);
        int aArg = Integer.parseInt(args[FIRST_ARG_POSITION]);
        int bArg = Integer.parseInt(args[SECOND_ARG_POSITION]);
        //performing math function according to operator value
        switch (operator){
            case "\\+":
                result = sum(aArg, bArg);
                break;
            case "-":
                result = differ(aArg, bArg);
                break;
            case "/":
                result = div(aArg, bArg);
                break;
            case "\\*":
                result = multiply(aArg, bArg);
                break;
            default:
                break;
        }
    }

    private int sum(final int aArg, final int bArg){
        return aArg + bArg;
    }

    private int differ(final int aArg, final int bArg){
        return aArg - bArg;
    }

    private int div(final int aArg, final int bArg){
        if (bArg == 0) throw new ArithmeticException("Division by zero!");
        else return aArg / bArg;
    }

    private int multiply(final int aArg, final int bArg){
        return aArg * bArg;
    }

    public int getResult(){
        return result;
    }
}
