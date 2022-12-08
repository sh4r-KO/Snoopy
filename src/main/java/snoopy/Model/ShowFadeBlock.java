package snoopy.Model;

public class ShowFadeBlock extends Entity {

    public Board board;

    private Board MVT;
    
    private Snoopy noop;



    public ShowFadeBlock( int i, int j,Board b, Snoopy noop) {
        super(i, j);
        this.board = b;
        this.noop = noop;
        /*
        for(int i=0; i<12; i++){
            for(int j=0; j<22; j++){
                if(board.board[i][j]==5){
                    this.X = i;
                    this.Y = j;
                    break;
                 }
            }
        }
         */
    }


    public void fade() {
        System.out.println("fade "+toString());
        boolean disappear = false;
        if(noop.getX() -1 ==  X  && noop.getY() == Y){
            board.board[X][Y] = 0;
            disappear = true;
        } if (noop.getX() +1 ==  X  && noop.getY() == Y){
            board.board[X][Y] = 0;
            disappear = true;
        } if(noop.getX()  ==  X && noop.getY()-1 == Y){
            board.board[X][Y] = 0;
            disappear = true;
        } if(noop.getX()  ==  X && noop.getY()+1 == Y){
            board.board[X][Y] = 0;
            disappear = true;
        }
        if(disappear){
            System.out.println("Fade Block : block disappear fadblock x:"+X+" y:"+Y+"; noop.getX()"+noop.getX()+" noop.getY()"+noop.getY());
        }else{
            System.out.println("Fade Block : BLOCK DIDNT DISAPEAR x:"+X+" y:"+Y+"; noop.getX()"+noop.getX()+" noop.getY()"+noop.getY());

        }

    }
    /*
    public void fade() {
        System.out.println("fade"+toString());
        boolean disappear = false;
        if(board.board[noop.getX()][noop.getY()] == board.board[X - 1][Y]){
            board.board[X][Y] = 0;
            disappear = true;
        } if (board.board[noop.getX()][noop.getY()] == board.board[X + 1][Y]){
            board.board[X][Y] = 0;
            disappear = true;
        } if(board.board[noop.getX()][noop.getY()] == board.board[X][Y - 1]){
            board.board[X][Y] = 0;
            disappear = true;
        } if(board.board[noop.getX()][noop.getY()] == board.board[X][Y + 1]){
            board.board[X][Y] = 0;
            disappear = true;
        }
        if(disappear){
            System.out.println("Fade Block : block disappear fadblock x:"+X+" y:"+Y+"; noop.getX()"+noop.getX()+" noop.getY()"+noop.getY());
        }

    }
     */

    @Override
    public String toString() {
        return "x:"+this.X+" y:"+this.Y;
    }

}
