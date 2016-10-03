import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;

public class JodaFormatter {

	static final String DATE_FORMAT = "dd/MM/yyyy";

	public static void main(String[] args) {
		String input = "13/03/2016";
		DateTime now = new DateTime();
		DateTime creationDt = DateTime.parse(input, DateTimeFormat.forPattern(DATE_FORMAT));
		int elapsedDays = Days.daysBetween(creationDt.withTimeAtStartOfDay(), now.withTimeAtStartOfDay()).getDays();

		System.out.println(
				"Request: " + input + " now: " + now + " creadtionDt: " + creationDt + " elapsedDays: " + elapsedDays);
	}
}
