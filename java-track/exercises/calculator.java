import java.util.Scanner;




public class calculator {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		double num1, num2, answer;
		
		
		System.out.println("Please enter a number: ");
		num1 = s.nextDouble();
		
		System.out.println("Please enter another number: ");
		num2 = s.nextDouble();
		
		answer = num1 + num2;
		
		System.out.println(answer);
	}

}
