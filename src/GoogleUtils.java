import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class GoogleUtils {

	/**
	 * Split string based on delim token
	 * 
	 * @param s
	 * @param delim
	 * @return
	 */
	public static List<String> split(String s, String delim) {
		return Lists.newArrayList(Splitter.on(delim).split(s));
	}

	/**
	 * Retain characters as per CharSet
	 * 
	 * @param reqCharSet
	 * @param input
	 * @return
	 */
	public static String retainOnlyAsPerCharSet(String reqCharSet, String input) {
		if (input == null) {
			return "";
		}
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

	/**
	 * Checks string as per Encoding
	 * 
	 * @param text
	 * @return
	 */
	public static boolean isEncodedAsPerCharSet(String reqCharSet, String text) {
		Charset charset = Charset.forName(reqCharSet);
		String checked = new String(text.getBytes(charset), charset);

		return !checked.equals(text);
	}

	/**
	 * Extra only numbers
	 * 
	 * @param str
	 * @return
	 */
	public static String extractNumbers(String str) {
		return CharMatcher.DIGIT.retainFrom(str);
	}

	/**
	 * Retain specfic characters from Company Name String
	 * 
	 * @param input
	 * @return
	 */
	public static String retainSpecificCharsFromString(String input) {
		input = input.replace('.', '_');
		String result = CharMatcher.inRange('A', 'Z').or(CharMatcher.inRange('0', '9'))
				.or(CharMatcher.inRange('a', 'z')).or(CharMatcher.is(' ')).or(CharMatcher.is('_')).retainFrom(input)
				.replace(' ', '_');
		return result;
	}

	/**
	 * Check if String has any alphabets
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNumber(String string) {
		char[] c = string.toCharArray();
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isDigit(c[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Extract numbers only from string
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> getNumbersOnly(String str) {
		List<String> list = Lists.newArrayList();
		String num = null;
		String regex = "(\\d+)";
		Matcher matcher = Pattern.compile(regex).matcher(str);
		while (matcher.find()) {
			num = matcher.group();
			list.add(CharMatcher.inRange('0', '9').retainFrom(num + ""));
		}
		return list;
	}

	/**
	 * Method extracts only digits from String stripping non-digits
	 * 
	 * @param s
	 * @return
	 */
	public static String getDigitsOnly(String s) {
		if (s == null) {
			return s;
		}
		return CharMatcher.inRange('0', '9').retainFrom(s);
	}

	// //////////////////////// Generics - Start
	/**
	 * Partition
	 * 
	 * @param bigList
	 * @param splitSize
	 * @return
	 */
	public static <T> List<List<T>> getPartition(List<T> bigList, int splitSize) {
		return Lists.partition(bigList, splitSize);
	}

	/**
	 * Remove Duplicates from Generic List Using Guava
	 * 
	 * @param request
	 * @return
	 */
	public static <T> List<T> removeDuplicateUsingGuava(List<T> request) {
		if (request == null) {
			return null;
		}
		return ImmutableSet.copyOf(Iterables.filter(request, Predicates.not(Predicates.isNull()))).asList();
	}

	/**
	 * Remove Duplicates from Generic List Using Native API
	 * 
	 * @param request
	 * @return
	 */
	public static <T> List<T> removeDuplicate(List<T> request) {
		if (request == null) {
			return null;
		}
		return Lists.newArrayList(Sets.newHashSet(request));
	}

	/**
	 * Remove any line feed from string
	 * 
	 * @param str
	 * @return
	 */
	public static String removeLineBreak(String str) {
		return CharMatcher.BREAKING_WHITESPACE.replaceFrom(str, " ");
	}

	/**
	 * Use Splitter to split string based on multiple delims
	 * 
	 * @param input
	 * @param delim
	 * @return
	 */
	@Deprecated
	public static Iterable<String> splitterByIterables(String input, String delims) {
		Iterable<String> splitStrings = Splitter.onPattern("[" + delims + "]+").trimResults().split(input);
		return splitStrings;
	}

	/**
	 * Use Splitter to split string based on multiple delims
	 * 
	 * @param input
	 * @param delim
	 * @return
	 */
	public static List<String> splitter(String input, String delims) {
		Iterable<String> splitStrings = Splitter.onPattern("[" + delims + "]+").trimResults().split(input);
		return Lists.newArrayList(splitStrings);
	}

	/**
	 * Split string by delims
	 * 
	 * @param input
	 * @param delims
	 * @return
	 */
	public static List<String> splitStringsAsList(String input, String delims) {
		return Lists.newArrayList(splitter(input, delims));
	}

	/**
	 * Filter List
	 * 
	 * @param inputList
	 * @param requestMatch
	 * @param invokeMethod
	 * @return
	 */
	@Deprecated
	public static <T> Iterable<T> predicateFilterList(List<T> inputList, final String requestMatch,
			final String invokeMethod) {
		Predicate<T> filtered = new Predicate<T>() {
			@Override
			public boolean apply(T input) {
				boolean ok = false;
				try {
					ok = BeanUtils.getProperty(input, invokeMethod).equalsIgnoreCase(requestMatch);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return ok;
			}
		};
		return Iterables.filter(inputList, filtered);
	}

	/**
	 * Predicate Collections2 Filter and Transform
	 * 
	 * @param strings
	 * @param regexPattern
	 * @return
	 */
	public static Collection<String> predicateFilter(Set<String> strings, String regexPattern) {
		Collection<String> filteredStrings = Collections2.filter(strings, Predicates.containsPattern(regexPattern));
		return filteredStrings;
	}
	
	/**
	 * Sort Map by Values in Ascending Order
	 * 
	 * @param theMap
	 * @return
	 */
	public static Map<String, String> mapSortedByValuesAscOrder(Map<String, String> theMap) {
		final Ordering<String> ordering = Ordering.natural().nullsLast().onResultOf(Functions.forMap(theMap, null));

		return ImmutableSortedMap.copyOf(theMap, ordering);
	}

	/**
	 * Sort Map by Values in Descending Order
	 * 
	 * @param theMap
	 * @return
	 */
	public static Map<String, String> mapSortedByValuesDescOrder(Map<String, String> theMap) {
		final Ordering<String> ordering = Ordering.natural().reverse().nullsLast()
				.onResultOf(Functions.forMap(theMap, null));

		return ImmutableSortedMap.copyOf(theMap, ordering);
	}
	
	/**
	 * Predicate (Filter) Map
	 * 
	 * @param map
	 * @param list
	 * @return
	 */
	public static Map<String, String> predicateMap(Map<String, String> map, List<String> list) {
		return mapSortedByValuesAscOrder(Maps.filterKeys(map, Predicates.in(list)));
	}

	// ////////////////////////Generics - End
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Split Sentence (split): " + GoogleUtils.split("This is a sentence", " "));

		System.out.println(
				"Split Sentence (splitStringAsList): " + GoogleUtils.splitStringsAsList("This is a sentence", " "));

		List<String> list = GoogleUtils.splitter("This;is, a^sentence", ",;^");
		for (String s : list) {
			System.out.println("Split Sentence (splitter): " + s);
		}
	}
}
