package Obj;

public record MatchResults() {

    static int score;
    static String verdict;

    public MatchResults() {
        if (score < 0 || score > 100){
            throw new IllegalArgumentException("The score is out of scope!");
        }
    }
}
