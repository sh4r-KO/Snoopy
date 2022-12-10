package snoopy.Model;

public class YellowBird extends Entity{
    private Board board;
    private Snoopy noop;
    private boolean birdIsPickedUp;

    public YellowBird(int x, int y, Board board, Snoopy noop) {
        super(x,y);
        this.board = board;
        this.noop = noop;
        this.birdIsPickedUp = false;
    }

    public void yellowBird() {
       if (X == noop.getX() && Y == noop.getY()) {
           birdIsPickedUp = true;
            System.out.println("Snoopy is on a yellow bird, x:"+X+" y:"+Y+" , PV left"+noop.getPV());
        }
    }

    public boolean isBirdIsPickedUp() {
        return birdIsPickedUp;
    }
    public void setBirdIsPickedUp(boolean birdIsPickedUp) {
        this.birdIsPickedUp = birdIsPickedUp;
    }
    protected void Action() {
    }
}
