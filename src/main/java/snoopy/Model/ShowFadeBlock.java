package snoopy.Model;

public class ShowFadeBlock {
    private int X;
    private int Y;

    public Board board;

    private Board MVT;
    
    private Snoopy noop;

    public ShowFadeBlock(int X,int Y){this.X = X; this.Y = Y;}




    public ShowFadeBlock( Snoopy noop ){
        //localisation du bloc
        for(int i=0; i<12; i++){
            for(int j=0; j<22; j++){
                if(board.board[i][j]==5){
                    this.X = X;
                    this.Y = Y;
                    break;
                 }
            }
        }


    }


    public void fade() {
        if(board.board[noop.getX()][noop.getY()] == board.board[X - 1][Y]){
            board.board[X][Y] = 0;
        } if (board.board[noop.getX()][noop.getY()] == board.board[X + 1][Y]){
            board.board[X][Y] = 0;
        } if(board.board[noop.getX()][noop.getY()] == board.board[X][Y - 1]){
            board.board[X][Y] = 0;
        } if(board.board[noop.getX()][noop.getY()] == board.board[X][Y + 1]){
            board.board[X][Y] = 0;
        }
        System.out.println("Fade Block");
    }

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
        String r = "x:"+this.X+" y:"+this.Y+"d:";
        return r;
    }

}
