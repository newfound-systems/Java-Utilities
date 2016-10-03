import java.util.EnumSet;

public class TestEnum {

	enum DeliveryDay {
		MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);

		private int id;

		DeliveryDay(int id) {
			this.id = id;
		}

		public int getValue() {
			return id;
		}
	}

	enum DeliverySlot {
		MORNING("M"), AFTERNOON("A"), EVENING("E");

		private String id;

		DeliverySlot(String id) {
			this.id = id;
		}

		public String getValue() {
			return id;
		}

		public String toString() {
			return this.id;
		}
	}

	enum SocialType {

		GOOGLE("GOOGLE"), TWITTER("TWITTER"), FACEBOOK("FACEBOOK"), LINKEDIN("LINKEDIN");

		private String id;

		SocialType(String id) {
			this.id = id;
		}

		public String getValue() {
			return id;
		}

		public String toString() {
			return this.id;
		}
	}

	public static void main(String[] args) {

		for (DeliveryDay status : DeliveryDay.values()) {
			System.out.println(status);
		}
		DeliveryDay day = DeliveryDay.SUN;

		switch (day) {
		case WED:
			System.out.println(day + " is peak Delivery Day");
			break;
		case SUN:
			System.out.println(day);
			System.out.println(day + " has no delivery");
			break;
		default:
			System.out.println(day);
			System.out.println(day + " delivery, but extra charges");
			break;
		}
		System.out.println("==================");
		System.out.println("Selected value: " + day.getValue() + " name: " + day.name());
		System.out.println("MON Value: " + DeliveryDay.MON.getValue());
		System.out.println("==================");
		for (DeliveryDay d : EnumSet.range(DeliveryDay.WED, DeliveryDay.FRI)) {
			System.out.println(d + " Value: " + d.getValue());
		}
		System.out.println("==================");
		for (DeliverySlot slot : DeliverySlot.values()) {
			System.out.println(slot + " Value: " + slot.getValue());
		}
		System.out.println("==================");
		for (SocialType social : SocialType.values()) {
			System.out.println(social + " Value: " + social.getValue());
		}
	}
}
