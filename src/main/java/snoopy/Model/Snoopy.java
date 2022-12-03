package snoopy.Model;

public class Snoopy {
    private int X;
    private int Y;
    private static Board snoopyBoard ;
    enum Direction {NORD, SUD, OUEST, EST}
    private Direction d;

    public Snoopy(Board b) {//deleted 3 parameters, 2 of tehm because we actually find them while going through the matrix and the last one is set by defalut to left(direction)

        if (b == null || b.getBoard() == null || b.getBoard().length == 0) {
            throw new IllegalArgumentException("snoopy.Model.Snoopy.Snoopy(Board b) : b or b.getBoard() is null or b.getBoard() empty");
        }

        snoopyBoard = b;//pas forcement dans la boucle
        for (int i = 0; i<12; i++){
            for (int j = 0; j<22; j++){
                if(snoopyBoard.getBoard()[i][j]==8){
                    this.X = i;
                    this.Y = j;
                    System.out.println("Snoopy() : "+i+","+j);
                }

            }
        }
        this.d = Direction.OUEST;
    }


    public void moveUp() {
        if (snoopyBoard != null) {
            if (X > 1) {
                int tmp = snoopyBoard.getBoard()[X][Y];
                snoopyBoard.board[X][Y] = snoopyBoard.board[X - 1][Y];
                snoopyBoard.board[X - 1][Y] = tmp;
                X = X-1;
            }
            //snoopyBoard.fade();
            //x = x - 1;
            snoopyBoard.MVT();
            System.out.println("up pressed");

        }
    }
    public void moveDown(){
        if(snoopyBoard != null) {
            if (X < 10) {
                int tmp = snoopyBoard.board[X][Y];
                snoopyBoard.board[X][Y] = snoopyBoard.board[X + 1][Y];
                snoopyBoard.board[X + 1][Y] = tmp;
                setX(X + 1);
            }
            //snoopyBoard.fade();
            //x = x+1
            System.out.println("down pressed");
            snoopyBoard.MVT();
        }
    }

    public void moveRight() {

        if(snoopyBoard != null) {
            if (Y < 20) {
                int tmp = snoopyBoard.board[X][Y];
                snoopyBoard.board[X][Y] = snoopyBoard.board[X][Y + 1];
                snoopyBoard.board[X][Y + 1] = tmp;
                setY(Y + 1);
            }
            //snoopyBoard.fade();
            System.out.println("right pressed");
            snoopyBoard.MVT();
        }
    }

    public void moveLeft() {
        if(snoopyBoard != null) {
            if (Y > 1) {
                int tmp = snoopyBoard.board[X][Y];
                snoopyBoard.board[X][Y] = snoopyBoard.board[X][Y - 1];
                snoopyBoard.board[X][Y - 1] = tmp;
                setY(Y - 1);
            }
            //snoopyBoard.fade();
            System.out.println("left pressed");
            snoopyBoard.MVT();
            //y = y-1;
        }
    }




    public void setX(int X) {
        this.X = X;
    }
    public void setY(int Y) {
        this.Y = Y;
    }
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }
    @Override
    public String toString() {
        String r = "x:" + this.X + " y:" + this.Y + "d:";
        return r;
    }

}

