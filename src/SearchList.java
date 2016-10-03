import java.util.List;
import com.google.common.collect.Lists;

public class SearchList {
	public static void main(String[] args) {
		List<Integer> items = Lists.newArrayList(1, 3, 2, 5, 7, 8, 5, 6, 9, 4);
		System.out.println(items.indexOf(9));
	}
}
