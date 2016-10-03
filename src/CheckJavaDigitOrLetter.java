import com.google.common.base.CharMatcher;

public class CheckJavaDigitOrLetter {

	public static void main(String[] args) {
		String input = "H*el.lo,}-12";
		CharMatcher matcher = CharMatcher.JAVA_LETTER_OR_DIGIT;
		String result = matcher.retainFrom(input);
		System.out.println("Result input: " + input + " result: " + result);
	}
}
