/*
	Class: CMSC 204
	CRN: 40541
	Instructor: Professor Gary C. Thai
	Project: 2
	Due Date: 6/20/23
	Programmer: Abidara Mesfin
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Notation {
	// Map to store operator precedence
	public static final Map<Character, Integer> operatorPrecedence;

	static {
		operatorPrecedence = new HashMap<>();
		operatorPrecedence.put('+', 1);
		operatorPrecedence.put('-', 1);
		operatorPrecedence.put('*', 2);
		operatorPrecedence.put('/', 2);
		operatorPrecedence.put('%', 2);
		operatorPrecedence.put('^', 3);
	}

	/**
	 * Converts an infix expression to postfix notation.
	 * 
	 * @param infix the infix expression to convert
	 * @return the postfix expression
	 * @throws InvalidNotationFormatException if the infix expression is invalid or
	 *                                        contains mismatched parentheses
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		StringBuilder postfix = new StringBuilder();
		Deque<Character> stack = new ArrayDeque<>();
		int openParenCount = 0;
		int closeParenCount = 0;

		for (char ch : infix.toCharArray()) {
			if (ch == ' ') {
				continue;
			} else if (Character.isDigit(ch)) {
				postfix.append(ch);
			} else if (ch == '(') {
				stack.push(ch);
				openParenCount++;
			} else if (isOperator(ch)) {
				while (!stack.isEmpty() && stack.peek() != '(' && hasHigherPrecedence(stack.peek(), ch)) {
					postfix.append(stack.pop());
				}
				stack.push(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
					closeParenCount++;
				} else {
					throw new InvalidNotationFormatException("Invalid infix expression: mismatched parentheses");
				}
			}
		}

		while (!stack.isEmpty()) {
			if (stack.peek() == '(') {
				throw new InvalidNotationFormatException("Invalid infix expression: mismatched parentheses");
			}
			postfix.append(stack.pop());
		}

		if (openParenCount != closeParenCount) {
			throw new InvalidNotationFormatException("Invalid infix expression: mismatched parentheses");
		}

		return postfix.toString();
	}

	/**
	 * Converts a postfix expression to infix notation.
	 * 
	 * @param postfix the postfix expression to convert
	 * @return the infix expression
	 * @throws InvalidNotationFormatException if the postfix expression is invalid
	 *                                        or contains insufficient operands or
	 *                                        operators
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if (Character.isWhitespace(ch)) {
				continue; // Skip whitespace
			}

			if (Character.isLetterOrDigit(ch)) {
				stack.push(String.valueOf(ch));
			} else {
				if (stack.size() < 2) {
					throw new InvalidNotationFormatException("Invalid postfix expression: insufficient operands");
				}

				String operand2 = stack.pop();
				String operand1 = stack.pop();
				String result = "(" + operand1 + ch + operand2 + ")";
				stack.push(result);
			}
		}

		if (stack.size() != 1) {
			throw new InvalidNotationFormatException("Invalid postfix expression: insufficient operators");
		}

		String infixResult = stack.pop();
		return infixResult.substring(1, infixResult.length() - 1);
	}

	/**
	 * Evaluates a postfix expression and returns the result.
	 * 
	 * @param postfix the postfix expression to evaluate
	 * @return the result of the evaluation
	 * @throws IllegalArgumentException if the postfix expression is invalid or
	 *                                  contains insufficient operands or too many
	 *                                  operands
	 */
	public static double evaluatePostfixExpression(String postfix) {
		Deque<Double> stack = new ArrayDeque<>();

		for (char ch : postfix.toCharArray()) {
			if (ch == ' ') {
				continue;
			} else if (Character.isDigit(ch)) {
				stack.push(Double.parseDouble(String.valueOf(ch)));
			} else if (isOperator(ch)) {
				if (stack.size() < 2) {
					throw new IllegalArgumentException("Invalid postfix expression: insufficient operands");
				}
				double rightOperand = stack.pop();
				double leftOperand = stack.pop();
				double result = performOperation(leftOperand, rightOperand, ch);
				stack.push(result);
			}
		}

		if (stack.size() != 1) {
			throw new IllegalArgumentException("Invalid postfix expression: too many operands");
		}

		return stack.pop();
	}

	/**
	 * Checks if a character is an operator.
	 * 
	 * @param ch the character to check
	 * @return true if the character is an operator, false otherwise
	 */
	public static boolean isOperator(char ch) {
		return operatorPrecedence.containsKey(ch);
	}

	/**
	 * Checks if an operator has higher precedence than another operator.
	 * 
	 * @param op1 the first operator
	 * @param op2 the second operator
	 * @return true if op1 has higher or equal precedence than op2, false otherwise
	 * @throws IllegalArgumentException if either operator is invalid
	 */
	private static boolean hasHigherPrecedence(char op1, char op2) {
		Integer precedence1 = operatorPrecedence.get(op1);
		Integer precedence2 = operatorPrecedence.get(op2);

		// Handle cases when operator precedence is not found in the map
		if (precedence1 == null || precedence2 == null) {
			throw new IllegalArgumentException("Invalid operator: " + op1 + " or " + op2);
		}

		return precedence1 >= precedence2;
	}

	/**
	 * Performs an arithmetic operation on two operands with the given operator.
	 * 
	 * @param leftOperand  the left operand
	 * @param rightOperand the right operand
	 * @param operator     the operator
	 * @return the result of the operation
	 * @throws IllegalArgumentException if the operator is invalid
	 */
	private static double performOperation(double leftOperand, double rightOperand, char operator) {
		switch (operator) {
		case '+':
			return leftOperand + rightOperand;
		case '-':
			return leftOperand - rightOperand;
		case '*':
			return leftOperand * rightOperand;
		case '/':
			return leftOperand / rightOperand;
		case '%':
			return leftOperand % rightOperand;
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}
}