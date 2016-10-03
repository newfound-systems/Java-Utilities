import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CamelCaseString {
	
	/**
	 * Format String to Upper and lower e.g. [THIS IS a test] would be = [This Is A Test]
	 * 
	 * @param String
	 * @return String
	 */
	public static String formatCamelString(String str) {
		StringBuffer sb = new StringBuffer();
		Matcher m = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(str);
		while (m.find()) {
			m.appendReplacement(sb, m.group(1).toUpperCase() + m.group(2).toLowerCase());
		}
		return m.appendTail(sb).toString();
	}

	public static void main(String[] args) {
		System.out.println("" + formatCamelString("THis is a sentence"));
	}
}
