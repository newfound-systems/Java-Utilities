import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;

public class FindLocale extends org.apache.commons.lang3.LocaleUtils {

	public static void main(String[] args) {

		List<Locale> localeList = LocaleUtils.languagesByCountry("IN");
		Locale[] locales = Locale.getAvailableLocales();

		for (Locale locale : localeList) {
			System.out.println("localeList size: " + localeList.size());
			System.out.println("locale: " + locale);
			System.out.println("langauge: " + locale.getLanguage());
			System.out.println("displayName: " + locale.getDisplayName() + " CtryLang: " + locale.getLanguage());

			for (String s : Locale.getISOLanguages()) {
				if (locale.getCountry().equals(s)) System.out.println("ISO Langauge: " + s);
			}
		}
	}
}
