import java.util.List;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class CombineMultipleList {

	public static void main(String[] args) {

		List<Integer> first = Lists.newArrayList(1, 2, 3);
		List<Integer> second = Lists.newArrayList(4, 5);
		List<Integer> third = Lists.newArrayList();

		final Iterable<Integer> allInvoiceRecipients = Iterables.unmodifiableIterable(Iterables.concat(
				first,
					second,
					third));

		System.out.println(allInvoiceRecipients);
	}
}
