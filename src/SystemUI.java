import java.util.ArrayList;
import java.util.Scanner;

public class SystemUI {
    public static int NUMBER_OF_GAMES = 5;
    public static SCAT scat = new SCAT();
    public static String[] questions = {
            "Headache", "Pressure in head", "Neck pain",
            "Nausea or vomiting", "Dizziness", "Blurred vision",
            "Balance problems", "Sensitivity to light", "Sensitivity to noise",
            "Feeling slowed down", "Feeling like in a fog", "Don't feel right",
            "Difficulty concentrating", "Difficulty remembering", "Fatigue or low energy",
            "Confusion", "Drowsiness", "Trouble falling asleep",
            "More emotional", "Irritability", "Sadness", "Nervous or anxious"
    };

    public static void main(String[] args) {
        Athlete athlete = new Athlete(35, "Usain Bolt");
        scat.addAthlete(athlete);
        Scanner scan = new Scanner(System.in);
        do {
            displayMenu();
            System.out.print("Your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 0; i < NUMBER_OF_GAMES; i++) {
                        System.out.println("\nGame " + (i + 1) + "\n------");
                        Record record = new Record();
                        ArrayList<Integer> gameScores = new ArrayList<>();

                        // Read Scores for each symptom
                        for (String question : questions) {
                            System.out.print(
                                    "Please enter your " + question +
                                            " [none (0), mild (1-2), moderate(3-4), severe(5-6)]: "
                            );
                            int score = scan.nextInt();

                            // validation for symptom score input
                            while (score < 0 || score > 6) {
                                System.out.println("Symptom value must be between 0 and 6.");
                                System.out.println("Please enter your " + question +
                                        " [none (0), mild (1-2), moderate(3-4), severe(5-6)]: ");
                                score = scan.nextInt();
                            }

                            gameScores.add(score);
                        }

                        // store scores in a record
                        record.setScores(gameScores);

                        // add record to athlete
                        athlete.addRecord(record);
                    }
                    break;
                case 2:
                    athlete.getSymptomSummary();
                    break;
                case 3:
                    athlete.getRiskIndicator();
                    break;
                case 4:
                    System.out.println("Exciting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        } while (true);
    }

    static void displayMenu() {
        System.out.println("Welcome to Sport Concussion Assessment System");
        System.out.println("=============================================");
        System.out.println("Please select one of the following options");
        System.out.println("1. Enter Symptoms");
        System.out.println("2. Display Symptoms Summary");
        System.out.println("3. Am I at Risk?");
        System.out.println("4. Exit");
    }
}