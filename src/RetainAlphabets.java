import com.google.common.base.CharMatcher;

public class RetainAlphabets {

	public static String extract(String str) {
		return CharMatcher.JAVA_LETTER.retainFrom(str);
	}

	public static void main(String[] args) {
		String input = "ABC COMPENY CO., LTD.LLc_AWB_8888885843_1447661108242_8933";
		input = input.replace('.', '_');
		String result = CharMatcher.inRange('A', 'Z').or(CharMatcher.inRange('0', '9'))
				.or(CharMatcher.inRange('a', 'z')).or(CharMatcher.is(' ')).or(CharMatcher.is('_')).retainFrom(input)
				.replace(' ', '_');

		System.out.println("Result: " + result);
		System.out.println("Result: " + extract(input));
	}
}
