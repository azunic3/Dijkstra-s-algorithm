package ba.unsa.etf.rpr;
import java.lang.Double;
import java.util.Stack;

/**
 * @author Azra Žunić
 * @version 1.0
 * method ExpressionEvaluator used for calculating Dijkstr algorithm
 * code mainly copied from task on c2
 * objects are inserted and removed according to the first-in first-out (FIFO) principle.
 */
public class ExpressionEvaluator {
    private static Stack<Double> vals = new Stack<>();
    private static Stack<String> ops = new Stack<>();

    /**
     * parsing string and putting words in an array
     * @param s
     * @return s.split
     */
    public static String[] parsedString(String s){
        String [] c = s.split(" "); //napravi novi element u stacku kad naidje na razmak
        return s.split(" ");
    }

    /**
     * using foreach loop to go through an array
     * covering all input cases with if - else as defined in a task
     * using Java String equals() Method
     * @param string
     * @return value of expression sent as a parameter of evaluate method
     */
    public static Double evaluate(String string) {
        String[] niz = (parsedString(string));
        for (String e : niz) {
            if (e.equals("(")) ;
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
                if (e.equals("+")) {
                    v = vals.pop() + v;
                } else if (e.equals("-")) {
                    v = vals.pop() - v;
                } else if (e.equals("*")) {
                    v = vals.pop() * v;
                } else if (e.equals("/")) {
                    v = vals.pop() / v;
                } else if (e.equals("sqrt")) {
                    Math.sqrt(v);
                }
            }
            else{
                vals.push(Double.parseDouble(e));
            }

        }

 return vals.pop();
}
}



