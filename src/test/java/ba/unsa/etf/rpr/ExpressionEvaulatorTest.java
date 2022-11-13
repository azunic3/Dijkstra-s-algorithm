package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * contains unit tests for relavant parts of ExpressionEvaluator class
 */
 class ExpressionEvaluatorTest {
    @Test void testparsedString (){
        String[] expected = new String[] {"(", "2", "+", "2", ")"};
        String[] result = ExpressionEvaluator.parsedString("( 2 + 2 )");
        assertEquals(expected, result);
    }

    @Test void testvalue (){
        double expected = 4;
        double result = ExpressionEvaluator.value("+", 2, 2);
        assertEquals(expected, result);

    }
    //checking operators +  and * on a simple expression

    @Test void testevaluate1 (){
        double expected = 12;
        double result = ExpressionEvaluator.evaluate("( ( 2 + 2 ) * 3 )");
        assertEquals(expected, result);

    }

    //checking operators -  and / on a simple expression
    @Test void testevaluate2 (){
        double expected = 3;
        double result = ExpressionEvaluator.evaluate("( ( 20 - 5 ) / 5 )");
        assertEquals(expected, result);

    }
//da li se podrazumijeva da je validna operacija??? npr, treba li prov. da li je izraz podijeljen sa 0 i sl?
    //treba li pr validaciju u parsed?
    //d li treba pr da li se sastoji od okej elemenata??

    //checking all operators on a more complex expression
    @Test void testevaluate3 (){
        double expected = 6.6;
        double result = ExpressionEvaluator.evaluate("( ( ( 40 - 5 * 2 ) + 3 ) / 5 )");
        assertEquals(expected, result);

    }

    //testing if an expression is valid
    @Test void testexception (){
        double expected = 20;
        double result = ExpressionEvaluator.evaluate("( 1 + 2 * 8 + 3 )");
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ExpressionEvaluator.validate("2 + 2 & 3");
            }
        }, "Invalid operands and/or operators!");

    }

    //testing different combinations with an operand in a denominator
    @Test void testevaluate5 (){
        double expected = 2.25;
        double result = ExpressionEvaluator.evaluate("( 9 / ( 2 * 2 ) )");
        assertEquals(expected, result);
        //KAKO PR AKO JE String[] return type
    }
    //testing different combinations with operands in a numerator and a denominator
    @Test void testevaluate6 (){
        double expected = 9;
        double result = ExpressionEvaluator.evaluate("( ( 9 * 4 ) / ( 2 * 2 ) )");
        assertEquals(expected, result);

    }

}
