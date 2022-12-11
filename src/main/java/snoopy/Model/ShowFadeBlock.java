package snoopy.Model;

public class ShowFadeBlock extends Entity {

    private boolean disappeared;
    public Board board;
    private Board MVT;
    private Snoopy noop;

    public ShowFadeBlock( int i, int j,Board b, Snoopy noop) {
        super(i, j);
        this.board = b;
        this.noop = noop;
        this.disappeared = false;
    }

    protected void Action() {
        System.out.println("fade "+toString());

        if((noop.getX() -1 ==  X  && noop.getY() == Y) || (noop.getX() +1 ==  X  && noop.getY() == Y) || (noop.getX()  ==  X && noop.getY()-1 == Y) || (noop.getX()  ==  X && noop.getY()+1 == Y)){
            board.getBoard()[X][Y] = board.getBoard()[X][Y].replace("5", "0");
            disappeared = true;

        }

    }

    @Override
    public String toString() {
        return "x:"+this.X+" y:"+this.Y;
    }
}