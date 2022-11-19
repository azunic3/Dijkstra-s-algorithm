package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * unit tests for relevant methods of ExpressionEvaluator class
 **/
class ExpressionEvaluatorTest {
    /**
     * testing all required arithmetic operators on a simple and more complex expressions:
     **/

    @Test
    void testevaluate1 (){
        double expected = 3;
        double result = ExpressionEvaluator.evaluate("( ( 4 / 4 ) + 2 )");
        assertEquals(expected, result);
    }

    @Test
    void testevaluate2 (){
        double expected = 170;
        double result = ExpressionEvaluator.evaluate("( ( 9 - 4 ) * ( 2 * ( 8 + 9 ) ) )");
        assertEquals(expected, result);
    }
    @Test
    void testevaluate3 (){
        String expected = " ";
        assertThrows(RuntimeException.class, ()->ExpressionEvaluator.evaluate(expected), "An empty parameter");
    }

    @Test
    void testevaluate4 (){
        double expected = -27;
        double result = ExpressionEvaluator.evaluate("( ( ( 2 / 2 ) + 2 ) - ( 5 * 6 ) )");
        assertEquals(expected, result);
    }

    @Test
    void testevaluate5 (){
        double expected = 0;
        double result = ExpressionEvaluator.evaluate("( ( ( 3 / 2 ) * 3 ) - ( 9 / 2 ) )");
        assertEquals(expected, result);
    }

    @Test
    void testevaluate6 (){
        String expected = "{ ( 5 * 5 ) ";
        assertThrows(RuntimeException.class, ()->ExpressionEvaluator.evaluate(expected), "Invalid expression");
    }
     @Test
     void testevaluete7(){
        double expected = 10;
        double result = ExpressionEvaluator.evaluate("( 6 + sqrt ( 16 ) )");
        assertEquals(expected, result);
     }
    @Test
    void testevaluete8(){

        assertThrows(RuntimeException.class, ()->ExpressionEvaluator.evaluate("( 1 + + 2 )"), "Invalid expression");

    }
    /**
     * testing auxiliary method parsedString
     * it is expected that method will split string sent as a parameter into separated expressions
     **/
    @Test void testparsedString (){
        String[] expected = new String[] {"(", "7", "-", "4", ")"};
        String[] result = ExpressionEvaluator.parsedString("( 7 - 4 )");
        assertArrayEquals(expected, result);
    }
}
