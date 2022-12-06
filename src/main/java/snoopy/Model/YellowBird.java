package snoopy.Model;

public class YellowBird {
    private int x;
    private int y;
    private Board board;
    private Snoopy noop;
    private boolean birdIsPickedUp;

    public YellowBird(int x, int y, Board board, Snoopy noop) {
        this.x = x;
        this.y = y;
        this.board = board;
        this.noop = noop;
        this.birdIsPickedUp = false;
    }

    public void yellowBird() {
       if (x == noop.getX() && y == noop.getY()) {
           birdIsPickedUp = true;
            System.out.println("Snoopy is on a yellow bird, x:"+x+" y:"+y+" , PV left"+noop.getPV());
        }
    }

}
