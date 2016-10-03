public class YetAnotherEnum {

	interface SeasonInt {
		String seasonDuration();
	}

	private enum Season implements SeasonInt {
		WINTER(88, "DEC - FEB"), SPRING(92, "MAR - JUN"), SUMMER(91, "JUN - AUG"), FALL(90, "SEP - NOV");

		private int days;

		private String months;

		Season(int days, String months) {
			this.days = days;
			this.months = months;
		}

		@Override
		public String seasonDuration() {
			return this + " -> " + this.days + "days,   " + this.months + " months";
		}
	}

	public static void main(String[] args) {
		System.out.println("Explicit Season Duration-->" + Season.FALL.seasonDuration());
		System.out.println("---Iterate all seasons...");
			
		for (Season season : Season.values()) {
			System.out.println(season.seasonDuration());
		}
	}
}
