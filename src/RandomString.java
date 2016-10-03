import org.apache.commons.lang3.RandomStringUtils;

public class RandomString {

	public static void main(String[] args) {
		int count = 6;
		System.out.println("Random String: " + RandomStringUtils.randomAlphanumeric(count));
	}
}
