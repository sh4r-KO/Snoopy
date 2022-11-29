package snoopy.Model;

public class Level {
    private int score;
    private int timeLeft;
    private int levelNumber;

    public Level(int number){
        this.levelNumber = number;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getScore() {
        return score;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    @Override
    public String toString() {
        return "Level{" +
                "score=" + score +
                ", timeLeft=" + timeLeft +
                ", levelNumber=" + levelNumber +
                '}';
    }
}
