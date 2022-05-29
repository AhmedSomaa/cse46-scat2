import java.util.ArrayList;

public class Record {
    private int id;
    ArrayList<Integer> scores;
    private int severityScore;
    private int symptomsCount;
    private static int recordsCount = 0;

    Record() {
        this.id = ++recordsCount;
        this.severityScore = 0;
        this.symptomsCount = 0;
        this.scores = new ArrayList<>();
    }

    public void setScores(ArrayList<Integer> gameScores) {
        this.scores = gameScores;
        for (int score: gameScores) {
            if (score > 0) {
                symptomsCount++;
                severityScore += score;
            }
        }
    }

    public int getSeverityScore() {
        return this.severityScore;
    }

    public int getSymptomsCount() {
        return this.symptomsCount;
    }

    public String getOverallRating() {
        String rating = "";
        if(this.symptomsCount < 3 && this.severityScore < 10) {
            rating = "No difference";
        } else if (this.symptomsCount < 3 && this.severityScore >= 10) {
            rating = "Unsure";
        } else if (this.symptomsCount >= 3 || this.severityScore >= 15) {
            rating = "Very different";
        }
        return rating;
    }
}
