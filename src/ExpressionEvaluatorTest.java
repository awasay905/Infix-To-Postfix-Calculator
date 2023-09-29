import static org.junit.Assert.*;
import org.junit.Test;

public class ExpressionEvaluatorTest {

    @Test
    public void testInfixToPostfix() {
        assertEquals("2 3 4 1 - * +", ExpressionEvaluator.infixToPostfix("2 + 3 * ( 4 - 1 )"));
        assertEquals("5 3 2 + *", ExpressionEvaluator.infixToPostfix("5 * ( 3 + 2 )"));
        assertEquals("12 4 /", ExpressionEvaluator.infixToPostfix("12 / 4"));
        assertEquals("1 2 + 3 4 + /", ExpressionEvaluator.infixToPostfix("( 1 + 2 ) / ( 3 + 4 )"));
        // Add more test cases for infix to postfix conversion
    }

    @Test
    public void testPostfixToAnswer() {
        assertEquals(11.0, ExpressionEvaluator.postfixToAnswer("2 3 4 1 - * +"), 0.001);
        assertEquals(25.0, ExpressionEvaluator.postfixToAnswer("5 3 2 + *"), 0.001);
        assertEquals(3.0, ExpressionEvaluator.postfixToAnswer("12 4 /"), 0.001);
        assertEquals(3/7.0, ExpressionEvaluator.postfixToAnswer("1 2 + 3 4 + /"), 0.001);
        // Add more test cases for postfix evaluation
    }

    // Add more test methods to cover additional scenarios

}
