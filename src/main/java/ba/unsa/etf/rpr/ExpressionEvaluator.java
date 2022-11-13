package ba.unsa.etf.rpr;
import java.lang.Double;
import java.util.Stack;

/**
 * @author Azra Žunić
 * @version 1.0
 * method ExpressionEvaluator,
 */
public class ExpressionEvaluator {
    private static Stack<Double> val = new Stack<>();
    private static Stack<Double> op = new Stack<>();

    public static String[] parsedString(String s){
        String [] c = s.split(" ");

        return s.split(" ");
    }
    /**
     * a private method for performing given arithmetic operations
     * @param o an operand to be used in arithmetic operations of type String
     * @param  a a double value which will be used in an arithmetic operation with operand o
     * @param b  a double value which will be used in an arithmetic operation with operand o
     * @return  a double value which represents the result of an arithmetic operation
     */
    public static double value(String o, double a, double b){
        double result = 0;  //has to be intitialised
//da li se u switch automatski koristi equals?
        if(o.equals("+")){  //equals!!!
            result = a + b;
        }
        else if(o.equals("-")){
            result = a - b;
        }
        else if(o.equals("*") ){
            result = a * b;
        }
        if(o.equals("/")){
            result = a / b;
        }

        return result;
    }

    /**
     * checks if the expression is in the right format, if the valid operators and operands are used
     * @param s String to be validated
     */

    public static void validate(String s){
        //checks if the expression is in the right format (blank spaces between every part of the expression)
        int expr = 0;
        int ws = 0;
        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) != ' '){  // ne treba equals jer su char?
                while(s.charAt(i) >= 0 && s.charAt(i) <= 9) {//conditions based on ASCII code
                    //if we come across a number, we need to count it aw a whole, and not its separate digits
                    i = i + 1;
                }
                expr = expr + 1;
            }
            else ws = ws + 1;
        }


        if(ws < expr - 1) {
            throw new RuntimeException("Invalid expression!");
        }
        //checks if the expression has valid operand / operators
        for(int i = 0; i < s.length(); i++){

            if(!(s.charAt(i) >= 0 && s.charAt(i) <= 9 || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/'))  // ne treba equals jer su char?
                throw new RuntimeException("Invalid operands and/or operators!");
        }
    }

    // public

    /**
     * a public class for performing arithmetic operations given in a String expression
     * @param s a String containing the expression to be calculated
     * @return a double value representing the result of an expression
     */
    public static double evaluate(String s) {
        //parse s
        String[] exp = parsedString(s);

        //go through exp
        for (String x : exp) {
            double dx = 0;
            //  val = new Stack<>();
            // Stack<String> op = new Stack<>();
            if(x.equals(")")) {  // if we come across a right parentheses, it's time to calculate a value and put it in a val stack
                while (!(op.peek()).equals("(")) { //while the top is not a left parenthesis
                    String o = String.valueOf(op.pop());
                    double b = val.pop();  //b comes first due to FIFO principle of a stack
                    double a = val.pop();
                    double v = value(o, a, b);
                    val.push(v);
                }
                op.pop(); //a left parenthesis is now removed
            }
            else if (!(x.equals(")"))) {  //operands and operators are  pushed in the right stack
                if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("("))
                    op.push(Double.valueOf(x));
                else {
                    dx = Double.parseDouble(x);
                    val.push(dx);
                }
            }

        }

        return val.pop(); //the last remaining value in val stack is the required one
    }

}


