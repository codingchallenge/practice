package amazon.practise.stack;

import java.util.Map;
import java.util.HashMap;

public class InfixToPostFix {

	public static String infixToPostFix(String[] expression){
		Map<String,Integer> priority = new HashMap<String,Integer>();
		priority.put("+",1);
		priority.put("-", 1);
		priority.put("*", 2);
		priority.put("/", 2);
		
		// open and close brackets
		String open = "(";
		String close = ")";
		
		
		Stack<String> operands = new Stack<String>();
		Stack<String> operators = new Stack<String>();
		for (int i = 0; i< expression.length; i++){
			if (expression[i].equals("(")){
				operators.push(expression[i]);
			} else if (expression[i].equals(")")){
				while (!operators.isEmpty() && !operators.peek().equals("(")){
					popAndPushOparands(operators, operands);
				}
				operators.pop();
			}else if (priority.containsKey(expression[i])){
				while (!operators.isEmpty() && priority.containsKey(operators.peek()) && priority.get(operators.peek()) >= priority.get(expression[i])){
					popAndPushOparands(operators, operands);
				}
				operators.push(expression[i]);
			} else {
				operands.push(expression[i]);
			}
		}
		
		while (!operators.isEmpty()){
			popAndPushOparands(operators, operands);
		}
		
		return operands.peek();
		
	}
	
	public static void popAndPushOparands(Stack<String> operators, Stack<String> operands){
		String operator = operators.pop();
		String operand1 = operands.pop();
		String operand2 = operands.pop();
		if (operand1 == null || operand2 == null){
			throw new RuntimeException(" Invalid Expression");
		} else {
			
			String calc = calculateValue(operand2,operand1, operator);
			operands.push(calc);
		}
	}
	public static String calculateValue(String op1, String op2 , String operator){
		float op1Float = Float.parseFloat(op1);
		float op2Float = Float.parseFloat(op2);
		float result = 0;
		switch(operator){
			case "+" :
				result = op1Float + op2Float;
				break;
			case "-" :
				result = op1Float - op2Float;
				break;
			case "*" :
				result = op1Float * op2Float;
				break;
			case "/" :
				result = op1Float/op2Float;
				break;
			default:
				return null;
				
		}
		
		return Float.toString(result);
	}
	
	public static void main(String[] args){
		String[] array = {"2", "+" , "3","-","4"};
		String result = InfixToPostFix.infixToPostFix(array);
		System.out.println(result);
		
		String[] arrayTwo = { "(" ,"1", "+","3",")" ,"*","4"};
		System.out.println(InfixToPostFix.infixToPostFix(arrayTwo));
	}
}
