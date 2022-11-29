package snoopy.Model;

public class Score {
    private Level level;
    private int score;

    public Score(Level level){
        this.score = level.getTimeLeft() * 100;
    }
}
