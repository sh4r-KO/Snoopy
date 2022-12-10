package snoopy.Model;

public class PushingBlock extends Entity {

    private Board board;
    private Snoopy noop;
    private Direction direction;

    public PushingBlock( int i, int j,Board b, Snoopy noop, Direction d){
        //localisation du bloc
        super(i,j);
        this.board = b;
        this.noop = noop;
        //direction du bloc
        this.direction = d;
    }

    private boolean isPushedToTheRight(){
                if(noop.getX() == X && noop.getY()==Y-1  && board.getBoard()[X][Y+1].contains("0") && direction == noop.getDirection() && direction== Direction.E){//snoopy à gauche && rien à droite sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle a droite
                    if( Y == 20){return false;}

                    board.getBoard()[X][Y] = board.getBoard()[X][Y].replace("2E", "0");
                    board.getBoard()[X][Y+1] = board.getBoard()[X][Y+1].replace("0", "2E");

                    Y++;


                    return true;

                }
                return false;
    }
    private boolean isPushedToTheLeft(){
                if(noop.getX() == X && noop.getY()==Y+1 && board.getBoard()[X][Y-1].contains("0") && direction == noop.getDirection() && direction== Direction.O){//snoopy à droite && rien à gauche sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle a gauche
                    if(Y == 1){return false;}

                    board.getBoard()[X][Y] = board.getBoard()[X][Y].replace("2E", "0");
                    board.getBoard()[X][Y-1] = board.getBoard()[X][Y-1].replace("0", "2E");
                    Y--;


                    return true;

                }
                return false;
    }
    private boolean isPushedToTheTop(){
                if(noop.getX() == X+1 && noop.getY()==Y && board.getBoard()[X-1][Y].contains("0") && direction == noop.getDirection() && direction== Direction.N){//snoopy en bas && rien en haut sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle en haut
                    if(  X == 1){return false;}

                    board.getBoard()[X][Y] = board.getBoard()[X][Y].replace("2N", "0");
                    board.getBoard()[X-1][Y] = board.getBoard()[X-1][Y].replace("0", "2N");
                    X--;
                    return true;
                }
                return false;
    }
    private boolean isPushedToTheBottom(){
                if(noop.getX() == X-1 && noop.getY()==Y && board.getBoard()[X-1][Y].contains("0") && direction == noop.getDirection() && direction== Direction.S){//snoopy en haut && rien en bas sauf ptet la balle? non j'ai décidé que on pourrait pas push le bloc si ya la balle en bas
                    if(  X == 10){return false;}

                    board.getBoard()[X][Y] = board.getBoard()[X][Y].replace("2S", "0");
                    board.getBoard()[X-1][Y] = board.getBoard()[X-1][Y].replace("0", "2S");

                    X++;
                    return true;
                }
                return false;
    }

    public void Action(){
        //check if X,Y contains 2N,2S,2E,2O, if not throw illegal argument exception
        if( ! board.getBoard()[X][Y].contains("2N") && ! board.getBoard()[X][Y].contains("2S") && ! board.getBoard()[X][Y].contains("2E") && ! board.getBoard()[X][Y].contains("2O")){
            throw new IllegalArgumentException("PushingBlock Action() : X,Y doesn't contain 2N,2S,2E,2O on board given");
        } else if(direction == Direction.E){
            isPushedToTheRight();
            System.out.println("pushing block to the right "+toString());
        } else if(direction == Direction.O){
            isPushedToTheLeft();
            System.out.println("pushing block to the right "+toString());
        } else if(direction == Direction.N){
            isPushedToTheTop();
            System.out.println("pushing block to the right "+toString());
        } else if(direction == Direction.S){
            isPushedToTheBottom();
            System.out.println("pushing block to the right "+toString());
        }
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

