import java.util.ArrayList;

public class Athlete {
    private int id;
    private int age;
    private String name;
    private static int athletesCount = 0;
    private ArrayList<Record> gameRecords;

    public Athlete(int age, String name) {
        this.id = ++athletesCount;
        this.age = age;
        this.name = name;
        this.gameRecords = new ArrayList<>();
    }

    public void addRecord(Record record) {
        this.gameRecords.add(record);
    }

    public void getSymptomSummary() {
        System.out.println("\nDisplaying the symptoms summary for the last 5 games");
        for (Record record : gameRecords) {
            System.out.println("----------------------------------------------------");
            System.out.println("Game " + (gameRecords.indexOf(record) + 1));
            System.out.println("------");
            System.out.println("Total number of symptoms: " + record.getSymptomsCount());
            System.out.println("Symptoms severity score: " + record.getSeverityScore());
            System.out.println("Overall Rating: " + record.getOverallRating());
        }
    }

    public void getRiskIndicator() {
        Record gameOne = gameRecords.get(gameRecords.size() - 1);
        Record gameTwo = gameRecords.get(gameRecords.size() - 2);
        System.out.print("\nRisk Status: ");
        int severityScoreDifference = Math.abs(gameOne.getSeverityScore() - gameTwo.getSeverityScore());
        int symptomsCountDifference = Math.abs(gameOne.getSymptomsCount() - gameTwo.getSymptomsCount());
        if (symptomsCountDifference < 3 && severityScoreDifference < 10) {
            System.out.println("\u001B[32m" + "Green" + "\u001B[0m" + "\n\n");
        } else if (symptomsCountDifference < 3 && severityScoreDifference >= 10) {
            System.out.println("\u001B[33m" + "Yellow" + "\u001B[0m" + "\n\n");
        } else if (symptomsCountDifference >= 3 || severityScoreDifference >= 15) {
            System.out.println("\u001B[31m" + "Red" + "\u001B[0m" + "\n");
        }
    }
}
