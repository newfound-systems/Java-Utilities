import java.util.List;
import com.google.common.collect.Lists; // Requires Google Guava Collection Jar

public class ListPartitionExample {

	private static final int CHUNKS = 4;

	private static void displayChunks(List<String> o) {
		System.out.println(o);
	}

	public static void main(String[] args) {
		for (List<String> chunks : Lists.partition(
				Lists.newArrayList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"),
					CHUNKS)) {
			System.out.println("in Main: " + chunks);
			displayChunks(chunks);
		}
	}
}
