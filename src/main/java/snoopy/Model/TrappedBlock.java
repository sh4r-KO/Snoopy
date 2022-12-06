package snoopy.Model;

public class TrappedBlock {

    private int X;
    private int Y;

    private Board board;
    private Snoopy noop;
    public TrappedBlock( Snoopy noop ){
        //localisation du bloc
        for(int i=0; i<12; i++){
            for(int j=0; j<22; j++){
                if(board.board[i][j]==3){
                    this.X = X;
                    this.Y = Y;
                    break;
                }
            }
        }
    }

    public void setX(int X) {this.X=X;}
    public void setY(int Y) {this.Y=Y;}
    public int getX() {return X;}
    public int getY() {return Y;}

    @Override
    public String toString() {
        String r = "x:" + this.X + " y:" + this.Y + "d:";
        return r;
    }
}
