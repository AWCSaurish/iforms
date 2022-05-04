
public class FloatTest {
	
	public static String getDecimalNumber(String number) {
		Double d=Double.parseDouble(number);
		return String.format("%.5f", d);
	}
	
	public static void main(String[] args) {
		System.out.println(getDecimalNumber("10u"));
	}
}
