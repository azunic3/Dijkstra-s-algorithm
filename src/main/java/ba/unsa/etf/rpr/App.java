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
           double result = ExpressionEvaluator.evaluate(args[0]);
           System.out.println("Result: "+result);
        }

       catch(RuntimeException e){
           System.out.println(e);
        }
    }

}
