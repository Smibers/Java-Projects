package romanCalc;

import java.util.Scanner;

public class RomanCalculator {
	public static Scanner kbInput = new Scanner(System.in);

	public static String doMath(char operator, int firstNum, int secondNum) {
		/*
		 * This method will perform the arithmetic indicated by the operator (+ -* /),
		 * invoke convertToRoman to convert answer to Roman number, then return answer *
		 */
		int x = 0;
		switch (operator) {
		case '*':x= firstNum * secondNum;
			break;
		case '/':x=firstNum / secondNum;
			break;
		case '+':x=firstNum + secondNum;
			break;
		case '-':x=firstNum - secondNum;
			break;
		}
		return convertToRoman(x);
		

		
	}

	public static char getOperator() {
		/*
		 * Modify this method so when the user enters an invalid operator the program
		 * will complain and ask the user to enter again
		 */
		char op = 0;
		int x=0; 
		while(x!=1) {
		
		System.out.println("please choose an operator: +, - , * , or /");
		op =kbInput.nextLine().charAt(0);
		if(op == '*' || op == '/' || op == '+' || op == '-' ) {
			
			x=1;
		}
		else {
			
			System.out.println("not a valid operator");
			x=0;
		}
		
		}
		return op;
	}

	public static int getOperands() {
		/*
		 * This routine should prompt the user to enter Roman number. convertFromRoman
		 * needs to be invoked to convert the Roman number to an integer. If the input
		 * is invalid (-1 returned from convertFromRoman) then complain and prompt the
		 * user again.
		 */
		System.out.println("please enter a roman number");
		String roman = kbInput.nextLine();
		return convertFromRoman(roman);
	}

	public static int convertFromRoman(String romanNum) {
		/*
		 * This method will convert Roman number to integer return -1 when input is
		 * invalid
		 *
		 */

	int roman = 0;
	for(int i=0;i<romanNum.length();i++){
		switch(romanNum.toUpperCase().charAt(i)) {
		case 'I':roman +=1;
		break;
		case 'V': roman+=5;
		break;
		case 'X': roman +=10;
		break;
		case 'L' : roman +=50;
		break;
		case 'C' :roman += 100;
		break;
		case 'D' :roman +=500;
		break;
		case 'M':roman +=1000;
		break;
		}
	}
	return roman;
	}

	public static String convertToRoman(int num) {
		/*
		 * This method will convert integer to Roman number
		 */
		String str="";
		while (num >= 1000) {
	            str += "M";
	            num -= 1000;        }
	        while (num >= 500) {
	            str += "D";
	            num -= 500;
	        }
	        while (num >= 100) {
	            str += "C";
	            num -= 100;
	        }

	   
	        while (num >= 50) {
	            str += "L";
	            num -= 50;
	        }

	        while (num >= 10) {
	            str += "X";
	            num -= 10;
	        }

	        while (num >= 5) {
	            str += "V";
	            num -= 5;
	        }

	        while (num >= 1) {
	            str += "I";
	            num -= 1;
	        }
	        return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result;
		do {

			result = doMath(getOperator(), getOperands(), getOperands());

			System.out.println(result);
			System.out.println("do you want to continue? y/n");
		} while (kbInput.nextLine().charAt(0) == 'y');
		System.out.println("Have a nice day!");
	}

}