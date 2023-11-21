package checkPOSt;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Credits completed:");
		double credits = input.nextDouble();
		if(credits < 4.0) {
			System.out.println("Not qualified for POSt");
			input.close();
			return;
		}
		
		System.out.println("Specialist/Major/Minor:");
		String s = input.next();
		CheckPOSt ch = new CheckPOSt();
		if(s.equals("Minor")) ch.checkMinor();
		else ch.checkMajor();
		input.close();
	}
}
