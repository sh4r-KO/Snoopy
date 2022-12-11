package snoopy.Model;

public class TrappedBlock extends Entity {
    private Snoopy noop;
    private Board board;
    boolean triggered = false;

    public TrappedBlock(int x, int y, Board b, Snoopy noop) {
        super(x, y);
        this.noop = noop;
        board = b;
    }


    protected void Action() {
        //check if snoopy is on a trapped block
        if (X == noop.getX() && Y == noop.getY() && !triggered) {
            noop.loseLife(1);
            System.out.println("Snoopy is on a trapped block, x:"+X+" y:"+Y+" , PV left"+noop.getLife());
            board.getBoard()[X][Y] = board.getBoard()[X][Y].replace("3", "0");
            triggered = true;
        }
    }

    public boolean triggered() {
        return triggered;
    }
}
