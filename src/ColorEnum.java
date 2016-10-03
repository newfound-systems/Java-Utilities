import java.util.stream.Stream;

public class ColorEnum {

	enum Color {
		RED, BLUE, YELLOW, GREEN, VOILET, PURPLE;
	}

	enum ColorNumber {
		RED(1), BLUE(2), YELLOW(3), GREEN(4), VOILET(5), PURPLE(6);

		int number = 0;

		private ColorNumber(int number) {
			this.number = number;
		}

		/**
		 * @return the number
		 */
		public int getNumber() {
			return number;
		}

		/**
		 * @param number
		 *            the number to set
		 */
		public void setNumber(int number) {
			this.number = number;
		}
	}

	public static void main(String[] args) {
		System.out.println(Color.BLUE);

		for (Color color : Color.values()) {
			System.out.println(color);
		}
		System.out.println("------------------- < Java 1.8");
		System.out.println("Color: " + ColorNumber.BLUE.name() + " Number: " + ColorNumber.BLUE.getNumber());
		for (ColorNumber color : ColorNumber.values()) {
			System.out.println(color + " Number: " + color.getNumber());
		}
		System.out.println("------------------- >= Java 1.8");
		/**
		 * Java 1.8
		 */
		Stream.of(Color.values()).forEach(System.out::println);
	}
}
