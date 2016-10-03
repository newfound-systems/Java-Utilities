import java.util.List;
import java.util.Set;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class RemoveDupListElements {

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
		return ImmutableSet.copyOf(Iterables.filter(request, Predicates.not(Predicates.isNull())))
				.asList();
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
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> request = Lists.newArrayList("abc", "def", "abc", "ghi");
		System.out.println("Before Dup Remove: " + request);
		System.out.println("After Dup Remove: " + removeDuplicate(request));

		Set<String> set = Sets.newHashSet(request);
		System.out.println("Set values: " + set + " List: " + Lists.newArrayList(set));

		List<Student> students = Lists.newArrayList();
		students.add(new Student("1", "abc", 19, "male"));
		students.add(new Student("2", "def", 18, "male"));
		students.add(new Student("1", "xyz", 19, "male"));

		Set<Student> studentSet = Sets.newHashSet(students);
		System.out.println("Set values: " + studentSet + " size: " + studentSet.size());
		// System.out.println("List: " + Lists.newArrayList(studentSet));
	}
}
