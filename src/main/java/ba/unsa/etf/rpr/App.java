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
       //kad bih znala deklarisat

       catch(RuntimeException e){
           System.out.println(e);
        }
        System.out.println("result");
       //ne moze bit greska ako hoces da pushah zato
    }
//nije se tamo promijenilo jer nisam push, commit je samo za lokalno da se mijenja
}
