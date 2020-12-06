import java.util.Comparator;

public class DateCompare implements Comparator<SportsClub> {
	@Override
	public int compare(SportsClub club1, SportsClub club2) {
		String localDate1 = ((FootballClub) club1).getMatchDate();
		String localDate2 = ((FootballClub) club2).getMatchDate();

		return localDate1.compareTo(localDate2);

	}
}
