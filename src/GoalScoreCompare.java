import java.util.Comparator;

public class GoalScoreCompare implements Comparator<SportsClub> {

	@Override
	public int compare(SportsClub sportsClub1, SportsClub sportsClub2) {
		int score01 = ((FootballClub) sportsClub1).getNumOfGoalsScored();
		int score02 = ((FootballClub) sportsClub2).getNumOfGoalsScored();

		return Integer.compare(score02, score01);
	}
}
