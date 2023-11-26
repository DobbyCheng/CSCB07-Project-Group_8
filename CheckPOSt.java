package checkPOSt;

public class CheckPOSt {
	
	double credit;
	int grade31, grade67, grade08, grade22, grade37, grade48;
	String adm;
	boolean completeCourses;
	
	public boolean checkvalid1(String c) {
		try {
			credit = Double.parseDouble(c);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	public void getCompleteCourses(boolean f) {
		completeCourses = f;
	}
	
	public String checkMinor() {
		if(completeCourses) return "Qualified for POSt!";
		else return "Not qualified for POSt";
	}
	
	public boolean checkvalid2(String g1, String g2, String g3,
			String g4, String g5, String g6, String s) {
		try {
			grade31 = Integer.parseInt(g1);
			grade67 = Integer.parseInt(g2);
			grade08 = Integer.parseInt(g3);
			grade22 = Integer.parseInt(g4);
			grade37 = Integer.parseInt(g5);
			grade48 = Integer.parseInt(g6);
			adm = s;
		}catch(Exception e){
			return false;
		}
		if(grade31 < 0 || grade31 > 100 || grade67 < 0 || grade67 > 100
				|| grade08 < 0 || grade08 > 100 || grade22 < 0 
				|| grade22 > 100 || grade37 < 0 || grade37 > 100
				|| grade48 < 0 || grade48 > 100) {
			return false;
		}
		return true;
	}
	
	public String checkSpecialist() {
		if(adm == "CS") {
			if(admCS()) return "Admitted to CS Specialist";
			else return "Not admitted to CS Specialist";
		}else if(adm == "MS") {
			if(admMS()) return "Qualified for POSt";
			else return "Not qualified for POSt";
		}else {
			if(admOther()) return "Qualified for POSt";
			else return "Not qualified for POSt";
		}
	}
	
	public String checkMajor() {
		if(adm == "CS") {
			if(admCS()) return "Not admitted to CS Major";
			else return "Admitted to CS Major";
		}else if(adm == "MS") {
			if(admMS()) return "Qualified for POSt";
			else return "Not qualified for POSt";
		}else {
			if(admOther()) return "Qualified for POSt";
			else return "Not qualified for POSt";
		}
	}
	
	public double convertGrade(int x) {
		if(x>=85) return 4.0;
		else if(x>=80) return 3.7;
		else if(x>=77) return 3.3;
		else if(x>=73) return 3.0;
		else if(x>=70) return 2.7;
		else if(x>=67) return 2.3;
		else if(x>=63) return 2.0;
		else if(x>=60) return 1.7;
		else if(x>=57) return 1.3;
		else if(x>=53) return 1.0;
		else if(x>=50) return 0.7;
		else return 0.0;
	}
	
	public boolean admCS() {
		if(credit < 4.0) return false;
		double sum = convertGrade(grade31) + convertGrade(grade67) + 
				convertGrade(grade08) + convertGrade(grade22) +
				convertGrade(grade37) + convertGrade(grade48);
		double pointAverage = (double)sum / 6.0;
		System.out.println(pointAverage);
		if(pointAverage < 2.5) {
			return false;
		}
		if(grade48 < 73) {
			return false;
		}
		int num = 0;
		if(grade67 >= 60) ++num;
		if(grade22 >= 60) ++num;
		if(grade37 >= 60) ++num;
		return num >= 2;
	}
	
	public boolean admMS() {
		return credit >= 4.0;
	}
	
	public boolean admOther() {
		return credit >= 4.0 && grade67 >= 80 && grade31 >= 80;
	}
}
