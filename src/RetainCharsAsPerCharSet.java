import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;

public class RetainCharsAsPerCharSet {

	public static String retainOnlyAsPerCharSet(String reqCharSet, String input) {
		Charset charset = Charset.forName(reqCharSet);
		final CharsetEncoder encoder = charset.newEncoder();

		Predicate<Character> inRange = new Predicate<Character>() {
			@Override
			public boolean apply(Character c) {
				return encoder.canEncode(c);
			}
		};
		return CharMatcher.forPredicate(inRange).retainFrom(input);
	}

	public static void main(String[] args) {
		String input = "helloã�¯";
		System.out.println(RetainCharsAsPerCharSet.retainOnlyAsPerCharSet("cp437", input));
	}
}
