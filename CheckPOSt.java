package checkPOSt;

import java.util.Scanner;

public class CheckPOSt {
	
	static Scanner input = new Scanner(System.in);
	
	public CheckPOSt() {}
	
	public void printResult(boolean res) {
		System.out.println(res?"Qualified for POSt!":"Not qualified for POSt");
	}
	
	public String admissionCategory() {
		System.out.println("Admission category (CS/Math/Stats/Other):");
		String s = input.next();
		return s;
	}
	
	public void admCS() {
		System.out.println("Grade point average across the following five "
					+ "courses: CSC/MAT A67, CSC A48, MAT A22, MAT A31, MAT A37:");
		double pointAverage = input.nextDouble();
		if(pointAverage < 2.5) {
			System.out.println("Not admitted to CS Major/Specialist");
			return;
		}
		System.out.println("Is your grade in CSC A48 at least B? (Yes/No)");
		String s = input.next();
		if(s.equals("No")) {
			System.out.println("Not admitted to CS Major/Specialist");
			return;
		}
		System.out.println("Is your grade in two of CSC/MAT A67, MAT A22, "
				+ "MAT A37 at least C- ? (Yes/No)");
		s = input.next();
		if(s.equals("Yes")) {
			System.out.println("Admitted to CS Major/Specialist!");
		}else {
			System.out.println("Not admitted to CS Major/Specialist");
		}
	}
	
	public boolean completeCourses() {
		System.out.println("Have you completed CSC/MAT A67, CSC A48, "
				+ "MAT A22, MAT A37? (Yes/No)");
		String s = input.next();
		return s.equals("Yes");
	}
	
	public void admMS() {
		printResult(completeCourses());
	}
	
	public void admOther() {
		if(!completeCourses()) {
			printResult(false);
			return;
		}
		System.out.println("Do you get at least an A- in both CSC/MAT A67 "
				+ "and MAT A31 the first time that you complete "
				+ "those courses? (Yes/No)");
		String s = input.next();
		printResult(s.equals("Yes"));
	}
	
	public void checkMajor() {
		String adm = admissionCategory();
		if(adm.equals("CS")) {
			admCS();
		}else if(adm.equals("Other")) {
			admOther();
		}else{
			admMS();
		}
	}
	
	public void checkMinor() {
		System.out.println("Have you taken all required A-level CSC "
				+ "and MAT courses (CSCA08, CSCA48, and one of "
				+ "CSCA67/MATA67, MATA22/A23, MATA30/A31/A32)?(Yes/No):");
		String s = input.next();
		printResult(s.equals("Yes"));
	}
	
}
