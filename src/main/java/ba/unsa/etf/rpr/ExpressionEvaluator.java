package ba.unsa.etf.rpr;
import java.lang.Double;
import java.util.Stack;

/**
 * @author Azra Žunić
 * @version 1.2
 * method ExpressionEvaluator used for calculating Dijkstra algorithm
 * code mainly copied from task on c2
 * objects are inserted and removed according to the first-in first-out (FIFO) principle.
 */

public class ExpressionEvaluator {
    private static Stack<Double> vals = new Stack<>();
    private static Stack<String> ops = new Stack<>();

    /**
     * parsing String by whitespaces and putting words in an array
     * @param s that we need to split by whitespace into words
     * @return s.split
     */
    public static String[] parsedString(String s){
        return s.split(" ");
    }

    /**
     * using foreach loop to go through an array
     * covering all input cases with if - else as defined in a task
     * using Java String equals() Method
     * checking if there is other input except the specified ones
     * @param string that we need to parse
     * @return value of expression sent as a parameter of evaluate method
     */

    public static Double evaluate(String string)  {
        String[] niz = (parsedString(string));
        int rparenthesis=0;
        int lparenthesis=0;
        for (String e : niz) {
            //checking if there is same number of right and left brackets
            if(e.equals("(")){
                rparenthesis++; }
            else if (e.equals(")")){
                lparenthesis++;}
            if (e.equals("("));
            else if (e.equals("+")) {
                ops.push(e);
            } else if (e.equals("-")) {
                ops.push(e);
            } else if (e.equals("*")) {
                ops.push(e);
            } else if (e.equals("/")) {
                ops.push(e);
            } else if (e.equals("sqrt")) {
                ops.push(e);
            } else if (e.equals(")")) {
                    String op = ops.pop();
                    Double v = vals.pop();
                    if (op.equals("+")) {
                        v = vals.pop() + v;
                    } else if (op.equals("-")) {
                        v = vals.pop() - v;
                    } else if (op.equals("*")) {
                        v = vals.pop() * v;
                    } else if (op.equals("/")) {
                        v = vals.pop() / v;
                    } else if (op.equals("sqrt")) {
                       v= Math.sqrt(v);
                    } else if (e != "-" || e != "+" || e != "*" || e != "/" || e != "(" || e != ")" || e != "sqrt") {
                        throw new IllegalArgumentException("Illegal parametres");
                    }
            vals.push(v);}
            else {
                        vals.push(Double.parseDouble(e));
                    }
            }
        if(rparenthesis!=lparenthesis)
            throw new RuntimeException("Illegal parameter");
 return vals.pop();
}
}



