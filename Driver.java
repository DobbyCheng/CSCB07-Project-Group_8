package checkPOSt;

public class Driver {
	public static void main(String[] args) {
		CheckPOSt x = new CheckPOSt();
		x.checkvalid1("4.0");
		x.checkvalid2("100", "100", "100", "100", "66", "73", "CS");
		System.out.println(x.checkSpecialist());
	}
}
