package ba.unsa.etf.rpr;
import java.util.Scanner;

import static ba.unsa.etf.rpr.ExpressionEvaluator.parsedString;

/**
 * @version 1.0
 * @author Azra Žunić
 * implementing auxiliary method parsedString from ExpressionEvaluator
 **/
public class App {
    public static void main(String[] args) throws RuntimeException {
/**
 * expression is invalid if there is no whitespace
 **/

       try{
            int length = args.length;
            if(length %2==0) {
                throw new RuntimeException();
            }
            String string = null;
            int i=0;
            while(i!=args.length-1){
                string+= args[i].concat("+");
                i++;
            }
           ExpressionEvaluator.evaluate(string);
           double result = ExpressionEvaluator.evaluate(string);
        }
       catch(RuntimeException e){
           System.out.println(e);
        }
    }
}
