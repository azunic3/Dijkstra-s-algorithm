package ba.unsa.etf.rpr;
import java.lang.String;

/**
 * @version 1.7
 * @author Azra Žunić
 * regular main method
 **/
public class App {
    public static void main(String[] args)  {

       /* int first=0;
       int second=0;
        String s = " ";
        for(String s1:s){
    if (s1.equals("(")) first++;
    if(s1.equals(")")) second++;
        }
if(first!=second) throw new RuntimeException("Zagrade");*/
       try{
           double result = ExpressionEvaluator.evaluate(args[0]);
           System.out.println(ExpressionEvaluator.evaluate((args[0])));
           System.out.println("Result: "+result);
        }

       catch(RuntimeException e){
           System.out.println(e);
        }
    }

}
