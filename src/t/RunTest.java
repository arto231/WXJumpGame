package t;

public class RunTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str="hello";
		String str2=str;
		System.out.println(" 1  "+str2);
		System.out.println("  2  "+str==str2);
		System.err.println("  3   "+str==str2);

	}

}
