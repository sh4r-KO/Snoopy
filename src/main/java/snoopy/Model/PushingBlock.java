package snoopy.Model;

public class PushingBlock extends Entity {

    private Board board;
    private Snoopy noop;

    public PushingBlock( int i, int j,Board b, Snoopy noop){
        //localisation du bloc
        super(i,j);
        this.board = b;
        this.noop = noop;
    }

    public boolean isPushedToTheRight(){
                if(noop.getX() == X && noop.getY()==Y-1  && board.getBoard()[X][Y+1] == 0 ){//snoopy à gauche && rien à droite sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle a droite
                    if( Y == 20){return false;}

                    board.getBoard()[X][Y] = 0;
                    board.getBoard()[X][Y+1] = 2;
                    Y++;
                    System.out.println("pushing block to the right "+toString());

                    return true;

                }
                return false;
    }
    public boolean isPushedToTheLeft(){
                if(noop.getX() == X && noop.getY()==Y+1 && board.getBoard()[X][Y-1] == 0){//snoopy à droite && rien à gauche sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle a gauche
                    if(Y == 1){return false;}

                    board.getBoard()[X][Y] = 0;
                    board.getBoard()[X][Y-1] = 2;
                    Y--;
                    System.out.println("pushing block to the left "+toString());

                    return true;

                }
                return false;
    }
    public boolean isPushedToTheTop(){
                if(noop.getX() == X+1 && noop.getY()==Y && board.getBoard()[X-1][Y] == 0 ){//snoopy en bas && rien en haut sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle en haut
                    if(  X == 1){return false;}

                    board.getBoard()[X][Y] = 0;
                    board.getBoard()[X-1][Y] = 2;
                    X--;
                    System.out.println("pushing block to the top "+toString());
                    return true;

                }
                return false;
    }
    public boolean isPushedToTheBottom(){
                if(noop.getX() == X-1 && noop.getY()==Y && board.getBoard()[X+1][Y] == 0){//snoopy en haut && rien en bas sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle en bas
                    if(  X == 10){return false;}

                    board.getBoard()[X][Y] = 0;
                    board.getBoard()[X+1][Y] = 2;
                    X++;
                    System.out.println("pushing block to the bottom "+toString());

                    return true;

                }
                return false;
    }


    /*

    public void pushingBlock(){
      if((board.board[noop.getX()][noop.getY()]== board.board[X-1][Y]) ){

      }
    }

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



    public void setX(int X) {this.X=X;}
    public void setY(int Y) {this.Y=Y;}
    public int getX() {return X;}
    public int getY() {return Y;}

     */

    @Override
    public String toString() {
        String r = "x:"+this.X+" y:"+this.Y;
        return r;
    }
}

