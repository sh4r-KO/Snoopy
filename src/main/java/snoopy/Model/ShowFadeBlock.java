package snoopy.Model;

public class ShowFadeBlock {
    private int X;
    private int Y;

    public Board board;

    private Board MVT;
    
    private Snoopy noop;



    public ShowFadeBlock( int i, int j,Board b, Snoopy noop) {
        this.board = b;
        this.noop = noop;
        this.X = i;
        this.Y = j;
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

    public void setX(int X) {
        this.X=X;
    }
    public void setY(int Y) {
        this.Y=Y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }


    @Override
    public String toString() {
        return "x:"+this.X+" y:"+this.Y;
    }

}
