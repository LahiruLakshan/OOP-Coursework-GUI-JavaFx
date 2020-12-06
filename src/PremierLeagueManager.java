import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PremierLeagueManager implements LeagueManager{

	public static List<SportsClub> premierLeagueClubsList = new ArrayList<>();
	public static List<SportsClub> listOfMatches = new ArrayList<>();


	@Override
	public void addFootballClubToPremierLeague(SportsClub footballClub) {
		if (premierLeagueClubsList.size() < 20){
			premierLeagueClubsList.add(footballClub);
			System.out.println("* Data added successfully!");
			System.out.println("Number of registered clubs			   : " + premierLeagueClubsList.size());
			System.out.println("Remaining space for clubs registration : " + (20 - premierLeagueClubsList.size()));

			premierLeagueClubsList.sort(Collections.reverseOrder());
			for (SportsClub club:premierLeagueClubsList){
				SportsClub clubPosition = new FootballClub(premierLeagueClubsList.indexOf(club) + 1,club.getNameOfTheClub(),club.getLocation(),club.getNumOfMembers(),
						((FootballClub) club).getMatchDate(),((FootballClub) club).getNumOfPlayedMatches(),((FootballClub) club).getWon(),((FootballClub) club).getDrawn(),
						((FootballClub) club).getLost(), ((FootballClub) club).getNumOfGoalsScored(), ((FootballClub) club).getNumOfGoalsReceived(),
						((FootballClub) club).getNumOfGoalsDifference(), ((FootballClub) club).getNumOfPoints());
				premierLeagueClubsList.set(premierLeagueClubsList.indexOf(club),clubPosition);
			}
		}else {
			System.out.println("Can't create a club for the Premier League!");
		}
	}

	@Override
	public void relegateTheClubs() {
		if (premierLeagueClubsList.size() == 20){
			premierLeagueClubsList.sort(Collections.reverseOrder());

			String tableFormat = "║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
			System.out.format("╔═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗%n");
			System.out.format("║ Relegated Club Name       ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║%n");
			System.out.format("╠═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣%n");
			for (int index = 0; index < 3;index++){
				SportsClub lastTeam = premierLeagueClubsList.get(premierLeagueClubsList.size() -1);
				System.out.format(tableFormat, lastTeam.getNameOfTheClub(), lastTeam.getLocation(), ((FootballClub) lastTeam).getNumOfPlayedMatches(),
						((FootballClub) lastTeam).getWon(), ((FootballClub) lastTeam).getDrawn(), ((FootballClub) lastTeam).getLost(),
						((FootballClub) lastTeam).getNumOfGoalsScored(), ((FootballClub) lastTeam).getNumOfGoalsReceived(), ((FootballClub) lastTeam).getNumOfGoalsDifference(), ((FootballClub) lastTeam).getNumOfPoints());
				premierLeagueClubsList.remove(premierLeagueClubsList.size() - 1);
			}
			System.out.format("╚═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");

			System.out.println("\nNumber of registered clubs			   : " + premierLeagueClubsList.size());
			System.out.println("Remaining space for clubs registration : " + (20 - premierLeagueClubsList.size()));
		}else {
			System.out.println("\t~ There must be 20 teams in the league for Relegation.");
		}
	}

	@Override
	public void deleteAClub(String clubName) {
		String tableFormat = "║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
		System.out.format("╔═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗%n");
		System.out.format("║ Relegated Club Name       ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║%n");
		System.out.format("╠═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣%n");
		for (SportsClub club : premierLeagueClubsList){
			if (club.getNameOfTheClub().equalsIgnoreCase(clubName)){
				System.out.format(tableFormat, club.getNameOfTheClub(), club.getLocation(), ((FootballClub) club).getNumOfPlayedMatches(),
						((FootballClub) club).getWon(), ((FootballClub) club).getDrawn(), ((FootballClub) club).getLost(),
						((FootballClub) club).getNumOfGoalsScored(), ((FootballClub) club).getNumOfGoalsReceived(), ((FootballClub) club).getNumOfGoalsDifference(), ((FootballClub) club).getNumOfPoints());
				premierLeagueClubsList.remove(club);
				break;
			}
		}
		System.out.format("╚═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");
		System.out.println("* Data deleted successfully!");
		System.out.println("\nNumber of registered clubs			   : " + premierLeagueClubsList.size());
		System.out.println("Remaining space for clubs registration : " + (20 - premierLeagueClubsList.size()));

	}

	@Override
	public void displayVariousStatistics(String clubName) {
		System.out.println("----------------------------------------------- " + clubName + " Club Details -----------------------------------------------\n");
		String tableFormat = "║ %-8s ║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
		System.out.format("╔══════════╦═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗%n");
		System.out.format("║ Position ║ Club Name                 ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║%n");
		System.out.format("╠══════════╬═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣%n");						//https://coolsymbol.com/  <- for symbols

		boolean check = false;
		premierLeagueClubsList.sort(Collections.reverseOrder());
		for (SportsClub sportsClub: premierLeagueClubsList) {
			if (sportsClub.getNameOfTheClub().equalsIgnoreCase(clubName)){
				String GF = ((FootballClub) sportsClub).getNumOfGoalsDifference() > 0 ? "+"+((FootballClub) sportsClub).getNumOfGoalsDifference(): String.valueOf(((FootballClub) sportsClub).getNumOfGoalsDifference());
				check = ((FootballClub) sportsClub).getNumOfPlayedMatches() > 0;
				System.out.format(tableFormat,((FootballClub) sportsClub).getPosition(), sportsClub.getNameOfTheClub(), sportsClub.getLocation(), ((FootballClub) sportsClub).getNumOfPlayedMatches(),
						((FootballClub) sportsClub).getWon(), ((FootballClub) sportsClub).getDrawn(), ((FootballClub) sportsClub).getLost(),
						((FootballClub) sportsClub).getNumOfGoalsScored(), ((FootballClub) sportsClub).getNumOfGoalsReceived(), GF, ((FootballClub) sportsClub).getNumOfPoints());
			}
		}
		System.out.format("╚══════════╩═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");
		int count = 0;
		int homeTeamScore;
		int awayTeamScore;
		String homeTeamResult;
		String awayTeamResult;
		if (check){
			System.out.println("----------------------------------------------- Matches played by "+clubName+" Club -----------------------------------------------\n");
			String matchFormat = "║   %-6s ║ %-10s ║ %-25s ║ %-25s ║ %-7s ║ %-25s ║%n";
			System.out.format("╔══════════╦════════════╦═══════════════════════════╦═══════════════════════════╦═════════╦═══════════════════════════╗%n");
			System.out.format("║ Match No ║ Date       ║ Stadium                   ║ Home Team                 ║ Result  ║ Away Team                 ║%n");
			System.out.format("╠══════════╬════════════╬═══════════════════════════╬═══════════════════════════╬═════════╬═══════════════════════════╣%n");						//https://coolsymbol.com/  <- for symbols
			for (SportsClub sportsClub : listOfMatches){
				if (sportsClub.getNameOfTheClub().equalsIgnoreCase(clubName) || ((FootballClub) sportsClub).getOtherTeamName().equalsIgnoreCase(clubName)){
					count++;
					homeTeamScore = ((FootballClub) sportsClub).getNumOfGoalsScored();
					awayTeamScore = ((FootballClub) sportsClub).getNumOfGoalsReceived();
					if (homeTeamScore > awayTeamScore) {
						homeTeamResult = " (WON)";
						awayTeamResult = " (LOST)";
					} else if (homeTeamScore == awayTeamScore) {
						homeTeamResult = " (DRAWN)";
						awayTeamResult = " (DRAWN)";
					} else {
						homeTeamResult = " (LOST)";
						awayTeamResult = " (WON)";
					}

					System.out.format(matchFormat, count, ((FootballClub) sportsClub).getMatchDate(), ((FootballClub) sportsClub).getStadium(), sportsClub.getNameOfTheClub() + homeTeamResult, String.format("%02d", homeTeamScore) + " : " + String.format("%02d", awayTeamScore), ((FootballClub) sportsClub).getOtherTeamName() + awayTeamResult);

				}
			}
			System.out.format("╚══════════╩════════════╩═══════════════════════════╩═══════════════════════════╩═════════╩═══════════════════════════╝%n");
		}
	}

	@Override
	public void displayPremierLeagueTable() {

		String tableFormat = "║ %-8s ║ %-25s ║ %-15s ║ %-6s ║ %-3s ║ %-5s ║ %-4s ║ %-4s ║ %-4s ║ %-4s ║ %-6s ║%n";
		System.out.format("╔══════════╦═══════════════════════════╦═════════════════╦════════╦═════╦═══════╦══════╦══════╦══════╦══════╦════════╗ GF = \"Goals For\"%n");
		System.out.format("║ Position ║ Club Name                 ║ Location        ║ Played ║ Won ║ Drawn ║ Lost ║ GF   ║ GA   ║ GD   ║ Points ║ GA = \"Goals Against\"%n");
		System.out.format("╠══════════╬═══════════════════════════╬═════════════════╬════════╬═════╬═══════╬══════╬══════╬══════╬══════╬════════╣ GD = \"Goals Difference\"%n");						//https://coolsymbol.com/  <- for symbols

		premierLeagueClubsList.sort(Collections.reverseOrder());
		for (SportsClub sportsClub: premierLeagueClubsList) {
			String GF = ((FootballClub) sportsClub).getNumOfGoalsDifference() > 0 ? "+"+((FootballClub) sportsClub).getNumOfGoalsDifference(): String.valueOf(((FootballClub) sportsClub).getNumOfGoalsDifference());

			System.out.format(tableFormat,((FootballClub) sportsClub).getPosition(),sportsClub.getNameOfTheClub(),sportsClub.getLocation(),
					((FootballClub) sportsClub).getNumOfPlayedMatches(),((FootballClub) sportsClub).getWon(),((FootballClub) sportsClub).getDrawn(),((FootballClub) sportsClub).getLost(),
					((FootballClub) sportsClub).getNumOfGoalsScored(),((FootballClub) sportsClub).getNumOfGoalsReceived(),GF,((FootballClub) sportsClub).getNumOfPoints() );
		}
		System.out.format("╚══════════╩═══════════════════════════╩═════════════════╩════════╩═════╩═══════╩══════╩══════╩══════╩══════╩════════╝%n");

		int homeTeamScore;
		int awayTeamScore;
		String homeTeamResult;
		String awayTeamResult;
		listOfMatches.sort(new DateCompare());

		System.out.println("----------------------------------------------- Details of all matches played -----------------------------------------------\n");
		String matchFormat = "║   %-6s ║ %-10s ║ %-25s ║ %-25s ║ %-7s ║ %-25s ║%n";
		System.out.format("╔══════════╦════════════╦═══════════════════════════╦═══════════════════════════╦═════════╦═══════════════════════════╗%n");
		System.out.format("║ Match No ║ Date       ║ Stadium                   ║ Home Team                 ║ Result  ║ Away Team                 ║%n");
		System.out.format("╠══════════╬════════════╬═══════════════════════════╬═══════════════════════════╬═════════╬═══════════════════════════╣%n");						//https://coolsymbol.com/  <- for symbols
		for (SportsClub sportsClub : listOfMatches){
			homeTeamScore = ((FootballClub) sportsClub).getNumOfGoalsScored();
			awayTeamScore = ((FootballClub) sportsClub).getNumOfGoalsReceived();
			if (homeTeamScore > awayTeamScore) {
				homeTeamResult = " (WON)";
				awayTeamResult = " (LOST)";
			} else if (homeTeamScore == awayTeamScore) {
				homeTeamResult = " (DRAWN)";
				awayTeamResult = " (DRAWN)";
			} else {
				homeTeamResult = " (LOST)";
				awayTeamResult = " (WON)";
			}

			System.out.format(matchFormat, listOfMatches.indexOf(sportsClub) + 1, ((FootballClub) sportsClub).getMatchDate(), ((FootballClub) sportsClub).getStadium(), sportsClub.getNameOfTheClub() + homeTeamResult, String.format("%02d", homeTeamScore) + " : " + String.format("%02d", awayTeamScore), ((FootballClub) sportsClub).getOtherTeamName() + awayTeamResult);

		}

		System.out.format("╚══════════╩════════════╩═══════════════════════════╩═══════════════════════════╩═════════╩═══════════════════════════╝%n");
	}

	@Override
	public void addPlayedMatchDetails(String date, String stadium, String homeTeamName, int homeTeamScore, String awayTeamName, int awayTeamScore) {
		SportsClub clubUpdate;

		for (SportsClub sportsClub:premierLeagueClubsList){
			if (sportsClub.getNameOfTheClub().equalsIgnoreCase(homeTeamName) || sportsClub.getNameOfTheClub().equalsIgnoreCase(awayTeamName)){
				int match = ((FootballClub) sportsClub).getNumOfPlayedMatches() + 1;
				int won = ((FootballClub) sportsClub).getWon();
				int drawn = ((FootballClub) sportsClub).getDrawn();
				int lost = ((FootballClub) sportsClub).getLost();
				int points = ((FootballClub) sportsClub).getNumOfPoints();

				if (sportsClub.getNameOfTheClub().contains(homeTeamName)){
					int goalsScore = ((FootballClub) sportsClub).getNumOfGoalsScored() + homeTeamScore;
					int goalsReceived = ((FootballClub) sportsClub).getNumOfGoalsReceived() + awayTeamScore;
					int goalsDifference = goalsScore - goalsReceived;
					if (homeTeamScore > awayTeamScore) {
						won += 1;
						points += 3;
					} else if (homeTeamScore == awayTeamScore) {
						drawn += 1;
						points += 1;
					} else {
						lost += 1;
					}
					clubUpdate = new FootballClub(premierLeagueClubsList.indexOf(sportsClub),homeTeamName,sportsClub.getLocation(),sportsClub.getNumOfMembers(),date,match,won,drawn,lost,goalsScore,goalsReceived,goalsDifference,points);
					premierLeagueClubsList.set(premierLeagueClubsList.indexOf(sportsClub),clubUpdate);
				}else if (sportsClub.getNameOfTheClub().contains(awayTeamName)){
					int goalsScore = ((FootballClub) sportsClub).getNumOfGoalsScored() + awayTeamScore;
					int goalsReceived = ((FootballClub) sportsClub).getNumOfGoalsReceived() + homeTeamScore;
					int goalsDifference = goalsScore - goalsReceived;

					if (awayTeamScore > homeTeamScore) {
						won += 1;
						points += 3;
					} else if (homeTeamScore == awayTeamScore) {
						drawn += 1;
						points += 1;
					} else {
						lost += 1;
					}
					clubUpdate = new FootballClub(premierLeagueClubsList.indexOf(sportsClub),awayTeamName,sportsClub.getLocation(),sportsClub.getNumOfMembers(),date,match,won,drawn,lost,goalsScore,goalsReceived,goalsDifference,points);
					premierLeagueClubsList.set(premierLeagueClubsList.indexOf(sportsClub),clubUpdate);
				}
				//premierLeagueClubsList.set(premierLeagueClubsList.indexOf(sportsClub),clubUpdate);
			}
		}
		clubUpdate = new FootballClub(date,stadium,homeTeamName,homeTeamScore,awayTeamName,awayTeamScore);
		listOfMatches.add(clubUpdate);
		System.out.println(clubUpdate.toString());

		premierLeagueClubsList.sort(Collections.reverseOrder());
		for (SportsClub club:premierLeagueClubsList){
			SportsClub clubPosition = new FootballClub(premierLeagueClubsList.indexOf(club) + 1,club.getNameOfTheClub(), club.getLocation(),club.getNumOfMembers(),((FootballClub) club).getMatchDate(),((FootballClub) club).getNumOfPlayedMatches(), ((FootballClub) club).getWon(),((FootballClub) club).getDrawn(), ((FootballClub) club).getLost(), ((FootballClub) club).getNumOfGoalsScored(), ((FootballClub) club).getNumOfGoalsReceived(), ((FootballClub) club).getNumOfGoalsDifference(), ((FootballClub) club).getNumOfPoints());
			premierLeagueClubsList.set(premierLeagueClubsList.indexOf(club),clubPosition);

		}

	}
	@Override
	public void dataSaveToFile(String fileName) throws IOException {
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream outputStream = new ObjectOutputStream(file);
		outputStream.writeObject(premierLeagueClubsList);
		outputStream.writeObject(listOfMatches);

		outputStream.flush();
		outputStream.close();
		file.close();
		System.out.println("Data saving is successful!");
	}

	@Override
	public void dataLoadInFile(String fileName) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		premierLeagueClubsList = (ArrayList) ois.readObject();
		listOfMatches = (ArrayList) ois.readObject();

		System.out.println("Data loaded successful!");
		ois.close();
		fis.close();
	}
}
