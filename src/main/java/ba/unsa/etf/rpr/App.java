package ba.unsa.etf.rpr;
import java.lang.String;

/**
 * @version 1.7
 * @author Azra Žunić
 * regular main method
 **/
public class App {
    public static void main(String[] args)  {

       try{
           double result = ExpressionEvaluator.evaluate(args[0]);
           System.out.println(ExpressionEvaluator.evaluate((args[0])));
           //printing result is not required
           //System.out.println("Result: " + result);
        }
       catch(RuntimeException e){
           System.out.println(e);
        }
    }

}
