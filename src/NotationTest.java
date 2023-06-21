 
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotationTest {
	public String complexInfix = "3+(((5*7)-(((8/2)-1)*4))*6)";
	public String complexPostfix =  "357*82/1-4*-6*+";
	public String easyInfix = "5+4";
	public String easyPostfix = "54+";
	
	// REMIDER:  Don't forget to test an expression such as 54%
	
	public String intermediateInfix = "((3*(5+4))+2)";
	public String intermediatePostfix = "354+*2+";

	public String invalidPostfixExpression = "354+*-";
	public String invalidInfixExpression = "(3+5)*4)-2";
	
	public double evalComplexPostfix = 141.0;
	public double evalIntermediatePostfix = 29.0;
	public double evalEasyPostfix = 9.0;

	@Before	
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(complexInfix);
		assertEquals(complexPostfix, postfixResult);
	}
	
	@Test
	public void testIntermediateConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(intermediateInfix);
		assertEquals(intermediatePostfix, postfixResult);
	}
	
	@Test
	public void testEasyConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(easyInfix);
		assertEquals(easyPostfix, postfixResult);
	}
	
	@Test(expected = InvalidNotationFormatException.class)
	public void testInvalidInfixExpression() throws InvalidNotationFormatException {
	    String invalidInfixExpression = "((2+3)*4"; // Missing closing parenthesis
	    Notation.convertInfixToPostfix(invalidInfixExpression);
	}
	
	@Test
	public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostfixToInfix(complexPostfix);
		assertEquals(complexInfix, infixResult);
	}
	
	@Test
	public void testIntermediateConvertPostfixToInfix() throws InvalidNotationFormatException {
	    String infixResult = Notation.convertPostfixToInfix(intermediatePostfix);
	    assertEquals("((3*(5+4))+2)", infixResult);
	}
	
	@Test
	public void testEasyConvertPostfixToInfix() throws InvalidNotationFormatException {
	    String infixResult = Notation.convertPostfixToInfix(easyPostfix);
	    assertEquals("5+4", infixResult);
	}

	@Test
	public void testInvalidPostfixExpressionB() {
	    try {
	        Notation.convertPostfixToInfix(invalidPostfixExpression);
	        fail("Expected InvalidNotationFormatException to be thrown");
	    } catch (InvalidNotationFormatException e) {
	        assertTrue(e instanceof InvalidNotationFormatException);
	    }
	}
	
	@Test
	public void testComplexEvaluatePostfixExpression() {
		double result = Notation.evaluatePostfixExpression(complexPostfix);
		assertEquals(evalComplexPostfix, result, .001);
	}
	
	@Test
	public void testIntermediateEvaluatePostfixExpression() {
		double result = Notation.evaluatePostfixExpression(intermediatePostfix);
		assertEquals(evalIntermediatePostfix, result, .001);
	}
	
	@Test
	public void testEasyEvaluatePostfixExpression() {
		double result = Notation.evaluatePostfixExpression(easyPostfix);
		assertEquals(evalEasyPostfix, result, .001);
	}
	
	@Test
    public void testInvalidPostfixExpressionA() throws InvalidNotationFormatException {
        try {
            Notation.evaluatePostfixExpression(invalidPostfixExpression);
            fail("InvalidNotationFormatException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid postfix expression: insufficient operands", e.getMessage());
        }
    }
}
