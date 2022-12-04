package snoopy.Model;

public class PushingBlock {
    private int X;
    private int Y;

    private Board board;
    private Snoopy noop;
    private ShowFadeBlock showFadeBlock;
    private TreadMillBlock treadMillBlock;




    public PushingBlock(Snoopy noop){
        //localisation du bloc
        for(int i=0; i<12; i++) {
            for (int j = 0; j < 22; j++) {
                if (board.board[i][j] == 5) {
                    this.X = X;
                    this.Y = Y;
                    break;
                }
            }
        }
    }

    public void pushingBlock(){
      if((board.board[noop.getX()][noop.getY()]== board.board[X-1][Y]) ){

      }
    }

    public void neirbourgh(){
        //ShowFadeBlock
        if((board.board[showFadeBlock.getX()][showFadeBlock.getY()] == board.board[X+1][Y]) && (board.board[noop.getX()][noop.getY()] == board.board[X-1][Y])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[showFadeBlock.getX()][showFadeBlock.getY()] == board.board[X-1][Y]) && (board.board[noop.getX()][noop.getY()] == board.board[X+1][Y])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[showFadeBlock.getX()][showFadeBlock.getY()] == board.board[X][Y+1]) && (board.board[noop.getX()][noop.getY()] == board.board[X][Y-1])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[showFadeBlock.getX()][showFadeBlock.getY()] == board.board[X][Y-1]) && (board.board[noop.getX()][noop.getY()] == board.board[X][Y+1])){
            board.board[X][Y] = board.board[X][Y];
        }
        //TreadMillBlock
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X+1][Y]) && (board.board[noop.getX()][noop.getY()] == board.board[X-1][Y])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X-1][Y]) && (board.board[noop.getX()][noop.getY()] == board.board[X+1][Y])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X][Y+1]) && (board.board[noop.getX()][noop.getY()] == board.board[X][Y-1])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X][Y-1]) && (board.board[noop.getX()][noop.getY()] == board.board[X][Y+1])){
            board.board[X][Y] = board.board[X][Y];
        }
        //TrappedBlock
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X+1][Y]) && (board.board[noop.getX()][noop.getY()] == board.board[X-1][Y])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X-1][Y]) && (board.board[noop.getX()][noop.getY()] == board.board[X+1][Y])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X][Y+1]) && (board.board[noop.getX()][noop.getY()] == board.board[X][Y-1])){
            board.board[X][Y] = board.board[X][Y];
        }
        if((board.board[treadMillBlock.getX()][treadMillBlock.getY()] == board.board[X][Y-1]) && (board.board[noop.getX()][noop.getY()] == board.board[X][Y+1])){
            board.board[X][Y] = board.board[X][Y];
        }
    }

    public void setX(int X) {this.X=X;}
    public void setY(int Y) {this.Y=Y;}
    public int getX() {return X;}
    public int getY() {return Y;}

    @Override
    public String toString() {
        String r = "x:"+this.X+" y:"+this.Y+"d:";
        return r;
    }
}

