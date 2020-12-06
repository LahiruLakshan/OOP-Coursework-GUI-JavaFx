import javafx.application.Application;

import java.io.IOException;
import java.util.Scanner;


public class Main {
	private static final LeagueManager leagueManager = new PremierLeagueManager();
	final static Scanner USER_INPUT = new Scanner(System.in);
	private static boolean validationCheck;
	private static boolean decisionCheck;
	private static String clubName;
	private static String clubLocation;
	private static int clubMembers;
	private static String date;
	private static String stadiumName;
	private static String homeTeamName;
	private static String awayTeamName;
	private static int homeTeamScore;
	private static int awayTeamScore;
	private static int score;
	private static String endDecision;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//leagueManager.dataLoadInFile("premierLeagueClubsList.txt");
		System.out.println("******************************************************** Welcome To Premier League Championship Manager ********************************************************");

		do {
			try{
				Scanner input = new Scanner(System.in);
				System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: Menu Options ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\n");
				System.out.println("\t\t1. Create a new football club and add it in the premier league. ");
				System.out.println("\t\t2. Relegate an existing three club from the premier league.");
				System.out.println("\t\t3. Delete a club from the premier league.");
				System.out.println("\t\t4. Display the various statistics for a selected club.");
				System.out.println("\t\t5. Display the Premier League Table.");
				System.out.println("\t\t6. Add a played match.");
				System.out.println("\t\t7. Open a Graphical User Interface.");
				System.out.println("\t\t8. Exit the Programme.");
				System.out.print("Select the number you want(1 to 7) : ");
				String select = input.next();

				switch (select) {

					case "1":
						System.out.println("\n------------------------------------------------------ Adding a new football club to the Premier League -----------------------------------------------------");
						addANewFootballClub();
						break;

					case "2":
						System.out.println("\n-------------------------------------------------- Relegate of clubs from the tournament --------------------------------------------------");
						leagueManager.relegateTheClubs();
						break;

					case "3":
						System.out.println("\n-------------------------------------------------- Delete a club from the league --------------------------------------------------");
						deleteClub();
						break;

					case "4":
						System.out.println("\n-------------------------------------------------- Details of a selected club --------------------------------------------------");
						selectedClubDetails();
						break;

					case "5":
						System.out.println("\n-------------------------------------------------- Premier League Table --------------------------------------------------");
						leagueManager.displayPremierLeagueTable();
						break;

					case "6":
						System.out.println("\n-------------------------------------------------- Details of a match played --------------------------------------------------");
						matchDetails();
						break;

					case "7":
						Application.launch(PremierLeagueGUIFX.class);
						leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
						System.exit(0);
						break;

					case "8":
						leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
						System.out.println("\n************************************************************* End the Programme *************************************************************");
						decisionCheck = true;
						break;

					default:
						System.out.println("Invalid Input!");
				}
			}finally {
				do {
					Scanner input = new Scanner(System.in);
					System.out.print("\n\tE - Exit the Programme\n\tC - Continue the programme\nChoose the decision you want : ");
					endDecision = input.nextLine();
					if (endDecision.equalsIgnoreCase("e")) {
						leagueManager.dataSaveToFile("premierLeagueClubsList.txt");
						System.out.println("\n******************************************************** End the Programme ********************************************************");
						decisionCheck = true;
					} else if (endDecision.equalsIgnoreCase("c")) {
						decisionCheck = false;
					} else {
						System.out.println("~ I can't understand your choose!");
					}
				}while (!(endDecision.equalsIgnoreCase("e") || endDecision.equalsIgnoreCase("c")));
			}

		}while (!decisionCheck);
	}



//	public static void testRandom(){
//		SportsClub homeTeam;
//		SportsClub awayTeam;
//		boolean duplicateCheck;
//		Random rand = new Random();
//		int rankedArraySize =PremierLeagueManager.premierLeagueClubsList.size();
//		if ((rankedArraySize - 1)*rankedArraySize > PremierLeagueManager.listOfMatches.size()){
//			do {
//				homeTeam = PremierLeagueManager.premierLeagueClubsList.get(rand.nextInt(PremierLeagueManager.premierLeagueClubsList.size()));
//				awayTeam = PremierLeagueManager.premierLeagueClubsList.get(rand.nextInt(PremierLeagueManager.premierLeagueClubsList.size()));
//				duplicateCheck = matchDuplicateCheck(homeTeam.getNameOfTheClub(),  awayTeam.getNameOfTheClub());
//			} while (!duplicateCheck);
//			System.out.println(homeTeam.getNameOfTheClub() + " & " + awayTeam.getNameOfTheClub());
//			int homeRandScore = rand.nextInt(15);
//			int awayRandScore = rand.nextInt(15);
//			leagueManager.addPlayedMatchDetails("xxxx-xx-xx","xxx",homeTeam.getNameOfTheClub(),homeRandScore, awayTeam.getNameOfTheClub(),awayRandScore);
//			System.out.println("Rank List Size : " + rankedArraySize+"-->"+(rankedArraySize - 1)*2 + "\t Matches List : " + PremierLeagueManager.listOfMatches.size());
//		}else {
//			System.out.println("Season End!!");
//		}
//
//	}



	private static void addANewFootballClub() {

//		if (PremierLeagueManager.premierLeagueClubsList.size() < 20){
//			inputClubName();
//			inputClubLocation();
//			inputClubMembers();
//			SportsClub footballClub = new FootballClub(clubName,clubLocation,clubMembers);
//			leagueManager.addFootballClubToPremierLeague(footballClub);
//		}else {
//			System.out.println("\t~ Can't create a club for the Premier League! \n\t>> The 20 teams that must participate in the Premier League are complete.");
//		}

		SportsClub sportsClub1 = new FootballClub("Leicester City", "London", 32);
		SportsClub sportsClub2 = new FootballClub("Chelsea", "America", 23);
		SportsClub sportsClub3 = new FootballClub("Everton", "Mexico", 30);
		SportsClub sportsClub4 = new FootballClub("Manchester United", "Africa", 33);
		SportsClub sportsClub5 = new FootballClub("Aston Villa", "Russia", 31);
		SportsClub sportsClub6 = new FootballClub("Fulham", "France", 32);
		leagueManager.addFootballClubToPremierLeague(sportsClub1);
		leagueManager.addFootballClubToPremierLeague(sportsClub2);
		leagueManager.addFootballClubToPremierLeague(sportsClub3);
		leagueManager.addFootballClubToPremierLeague(sportsClub4);
		leagueManager.addFootballClubToPremierLeague(sportsClub5);
		leagueManager.addFootballClubToPremierLeague(sportsClub6);
	}

	private static void inputClubName() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("# Enter the name of the club          : ");
			clubName = input.nextLine();
			validationCheck = stringsChecker(clubName);
			if (validationCheck){
				for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
					if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
						System.out.println("\t>> This Club name is Already Register in League!");
						validationCheck = false;
						break;
					} else {
						validationCheck = true;
					}
				}
			}
		}while (!validationCheck);
	}

	private static void inputClubLocation() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("# Enter the name of the club location : ");
			clubLocation = input.nextLine();
			validationCheck = stringsChecker(clubLocation);
		}while (!validationCheck);
	}

	private static void inputClubMembers() {
		do {
			try{
				Scanner input = new Scanner(System.in);
				System.out.print("# Enter the Number of team members    : ");
				clubMembers = input.nextInt();
				validationCheck = (clubMembers >= 11);
				System.out.println(validationCheck ? "": "\t>> Each group must have 11 or more members!");
			}catch (RuntimeException e){
				System.out.println("\t~ Please enter integer input!");
				validationCheck = false;
			}
		}while (!validationCheck);
	}

	private static void deleteClub() {
		if (!PremierLeagueManager.premierLeagueClubsList.isEmpty()){
			do {
				Scanner input = new Scanner(System.in);
				System.out.print("# Enter the name of the club : ");
				clubName = input.nextLine();
				validationCheck = stringsChecker(clubName);
				if (validationCheck){
					for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
						if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
							leagueManager.deleteAClub(clubName);
							validationCheck = true;
							break;
						} else {
							validationCheck = false;
						}
					}
					if (!validationCheck){
						System.out.println("No club named \"" + clubName + "\"!");
					}
				}
			}while (!validationCheck);
		}else {
			System.out.println("No clubs to delete from the league.");
		}
	}
	private static void matchDetails(){

//		if (PremierLeagueManager.premierLeagueClubsList.size() >= 2){
//			inputMatchDate();
//			inputMatchVenue();
//			boolean duplicateCheck;
//			do{
//				homeTeamName = inputClubName("Home");
//				awayTeamName = inputClubName("Away");
//
//				duplicateCheck = matchDuplicateCheck(homeTeamName,awayTeamName);
//				if (!duplicateCheck){
//					System.out.println("\t~ The match between the "+homeTeamName+"(Home Team) and "+awayTeamName+"(Away Team) teams is already over.");
//				}
//			}while (!duplicateCheck);
//			homeTeamScore = inputScore("Home");
//			awayTeamScore = inputScore("Away");
//			leagueManager.addPlayedMatchDetails(date,stadiumName, homeTeamName, homeTeamScore, awayTeamName, awayTeamScore);
//
//		}else {
//			System.out.println("\t~ There must be at least 2 teams to play one match!");
//		}

		leagueManager.addPlayedMatchDetails("2020-04-09","Emirates Stadium, London","Manchester United",12,"Everton",6);

		leagueManager.addPlayedMatchDetails("2019-11-12","Emirates Stadium, London","Chelsea",8,"Manchester United",10);

		leagueManager.addPlayedMatchDetails("2019-09-29","Emirates Stadium, London","Manchester United",8,"Chelsea",8);

		leagueManager.addPlayedMatchDetails("2020-11-18","Emirates Stadium, London","Chelsea",8,"Leicester City",5);

		leagueManager.addPlayedMatchDetails("2020-03-14","Emirates Stadium, London","Aston Villa",14,"Leicester City",6);

		leagueManager.addPlayedMatchDetails("2019-01-02","Emirates Stadium, London","Aston Villa",3,"Manchester United",3);

		leagueManager.addPlayedMatchDetails("2019-12-30","Emirates Stadium, London","Leicester City",10,"Manchester United",3);

		leagueManager.addPlayedMatchDetails("2019-12-21","Emirates Stadium, London","Fulham",10,"Manchester United",10);

	}



	private static void inputMatchDate() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("# Enter the match date in the following format (YYYY-MM-DD) : ");
			date = input.nextLine();
			validationCheck = dateChecker(date);
		}while (!validationCheck);

	}

	private static void inputMatchVenue() {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("# Enter the name of the stadium : ");
			stadiumName = input.nextLine();
			validationCheck = stringsChecker(stadiumName);
		}while (!validationCheck);
	}

	private static String inputClubName(String team) {
		do {
			Scanner input = new Scanner(System.in);
			System.out.print("# Enter the name of the "+ team +" Team : ");
			clubName = input.nextLine();
			validationCheck = stringsChecker(clubName);
			if(validationCheck){
				for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
					if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
						validationCheck = true;
						break;
					} else {
						validationCheck = false;
					}
				}
				if (!validationCheck){
					System.out.println("\t~ There is no team in the league called \"" + clubName+"\"");
				}
				if (validationCheck && team.equalsIgnoreCase("Away") && homeTeamName.equalsIgnoreCase(clubName)){
					System.out.println("\t~ Please enter the name of the 2nd group again!\n\t* The names of the first team and the second team cannot be the same in a match.");
					validationCheck = false;
				}
			}
		}while (!validationCheck);
		return clubName;
	}

//	private static boolean leagueValidation(String team,String ID){
//		int homePlay = 0;
//		int awayPlay = 0;
//
//		for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
//			if (club.getNameOfTheClub().equalsIgnoreCase(team)) {
//				System.out.println("team in PL TABLE");
//				validationCheck = true;
//				break;
//			} else {
//				validationCheck = false;
//			}
//		}
//		if (!validationCheck){
//			System.out.println("\t~ There is no team in the league called \"" + team + "\"");
//		}
//		if (validationCheck) {
//			for (SportsClub sportsClub:PremierLeagueManager.listOfMatches){
//				if (sportsClub.getNameOfTheClub().equals(team) && ID.equals("home")){
//					homePlay++;
//					System.out.println("home++");
//				}else if (((FootballClub)sportsClub).getOtherTeamName().equals(team) && ID.equals("away")){
//					System.out.println("away++");
//					awayPlay++;
//				}
//			}
//			System.out.println(PremierLeagueManager.premierLeagueClubsList.size());
//			if (PremierLeagueManager.premierLeagueClubsList.size() -  1  <= homePlay || PremierLeagueManager.premierLeagueClubsList.size() - 1 <= awayPlay){
//				System.out.println("~ All "+ID+" matches are over.");
//				validationCheck = false;
//			}
//
//		}
//		return validationCheck;
//	}

	public static boolean matchDuplicateCheck(String homeTeam, String awayTeam) {
		if (!(homeTeam.equalsIgnoreCase(awayTeam))){
			for (SportsClub club:PremierLeagueManager.listOfMatches){
				if (club.getNameOfTheClub().equalsIgnoreCase(homeTeam) && ((FootballClub) club).getOtherTeamName().equalsIgnoreCase(awayTeam)){
					return false;
				}
			}
			return true;
		}else {
			return false;
		}
	}

	private static int inputScore(String teamScore) {

		do {
			try {
				Scanner input = new Scanner(System.in);
				System.out.print("# Enter the number of goal score in the "+teamScore+" team : ");
				score = input.nextInt();
				validationCheck = (score >= 0);
				if (!validationCheck){
					System.out.println("\t~ Please enter valid input!");
				}			}catch (RuntimeException e){
				System.out.println("\t~ Please enter integer input!");
				validationCheck = false;
			}

		}while (!validationCheck);
		return score;

	}

	private static void selectedClubDetails() {

		if (!PremierLeagueManager.premierLeagueClubsList.isEmpty()){
			do {
				Scanner input = new Scanner(System.in);
				System.out.print("1. Enter the name of the Team : ");
				clubName = input.nextLine();
				validationCheck = stringsChecker(clubName);
				for (SportsClub club : PremierLeagueManager.premierLeagueClubsList) {
					if (club.getNameOfTheClub().equalsIgnoreCase(clubName)) {
						validationCheck = true;
						break;
					} else {
						validationCheck = false;
					}
				}
				if (!validationCheck) {
					System.out.println("\t~ There is no team in the league called \"" + clubName + "\"");
				}
			} while (!validationCheck);
			leagueManager.displayVariousStatistics(clubName);
		}else {
			System.out.println("\t~ There are currently no teams in the Premier League");
		}
	}



	public static boolean stringsChecker(String value) {    //string checker

		if (!(value == null || value.trim().isEmpty())){		//https://www.programiz.com/java-programming/examples/string-empty-null
			if (value.matches("^[ A-Za-z]+$")){		//https://stackoverflow.com/questions/24191040/checking-to-see-if-a-string-is-letters-spaces-only/24191088
				return true;
			}else {
			System.out.println("\t~ Please enter a valid input!(Only Strings)");
				return false;
			}
		}else {
				System.out.println("\t~ Please enter an input!");
				return false;
		}
	}

	private static boolean dateChecker(String date) {		// date checker
		if (!(date == null || date.trim().isEmpty())){		//https://www.regexlib.com/Search.aspx?k=yyyy-mm
			if ((date.matches("^((((19[0-9][0-9])|(2[0-9][0-9][0-9]))([-])(0[13578]|10|12)([-])(0[1-9]|[12][0-9]|3[01]))|(((19[0-9][0-9])|(2[0-9][0-9][0-9]))([-])(0[469]|11)([-])([0][1-9]|[12][0-9]|30))|(((19[0-9][0-9])|(2[0-9][0-9][0-9]))([-])(02)([-])(0[1-9]|1[0-9]|2[0-8]))|(([02468][048]00)([-])(02)([-])(29))|(([13579][26]00)([-])(02)([-])(29))|(([0-9][0-9][0][48])([-])(02)([-])(29))|(([0-9][0-9][2468][048])([-])(02)([-])(29))|(([0-9][0-9][13579][26])([-])(02)([-])(29)))$"))){
				return true;
			}else {
				System.out.println("\t~ Date Error!");
				return false;
			}
		}else {
			System.out.println("\t~ Please enter valid time!");

					return false;
		}
	}
}
