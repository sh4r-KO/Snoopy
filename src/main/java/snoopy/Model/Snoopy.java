package snoopy.Model;

public class Snoopy {
    private int X;
    private int Y;
    private Board snoopyBoard ;



    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    enum Direction {
        NORD,
        SUD,
        OUEST,
        EST;
    }

    public Snoopy(int X, int Y, Direction d) {
        this.X = X;
        this.Y = Y;
        this.snoopyBoard = new Board();
    }

    public Snoopy(){
        //localisation Snoopy
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 22; j++) {
                if (snoopyBoard!= null && snoopyBoard.board[i][j] == 8) {
                    snoopyBoard.setNoop(new Snoopy(i, j, Snoopy.Direction.NORD));
                    break;
                }
            }
        }
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    //set
    public void moveUp() {
        if(snoopyBoard != null) {
            if(snoopyBoard.getNoop().getX() > 1){
                int tmp=snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()];
                snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()] = snoopyBoard.board[snoopyBoard.getNoop().getX()-1][snoopyBoard.getNoop().getY()];
                snoopyBoard.board[snoopyBoard.getNoop().getX()-1][snoopyBoard.getNoop().getY()] = tmp;
                snoopyBoard.getNoop().setX(snoopyBoard.getNoop().getX()-1);
            }
            snoopyBoard.fade();
            //x = x - 1;
            snoopyBoard.MVT();
            System.out.println("up pressed");
        }
    }

    public void moveDown() {
        if (snoopyBoard.getNoop().getX() < 10){
            int tmp = snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()];
            snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()] = snoopyBoard.board[snoopyBoard.getNoop().getX() + 1][snoopyBoard.getNoop().getY()];
            snoopyBoard.board[snoopyBoard.getNoop().getX() + 1][snoopyBoard.getNoop().getY()] = tmp;
            snoopyBoard.getNoop().setX(snoopyBoard.getNoop().getX()+1);
        }
        snoopyBoard.fade();
        //x = x+1
        System.out.println("down pressed");
        snoopyBoard.MVT();
    }

    public void moveRight() {
        if(snoopyBoard.getNoop().getY() < 20) {
            int tmp = snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()];
            snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()] = snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY() + 1];
            snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY() + 1] = tmp;
            snoopyBoard.getNoop().setY(snoopyBoard.getNoop().getY()+1);
        }
        snoopyBoard.fade();
        System.out.println("Right pressed");
        snoopyBoard.MVT();
        //y =y +1
    }

    public void moveLeft() {
        if(snoopyBoard.getNoop().getY() > 1){
            int tmp=snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()];
            snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()] = snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()-1];
            snoopyBoard.board[snoopyBoard.getNoop().getX()][snoopyBoard.getNoop().getY()-1] = tmp;
            snoopyBoard.getNoop().setY(snoopyBoard.getNoop().getY()-1);
        }
        snoopyBoard.fade();
        System.out.println("left pressed");
        snoopyBoard.MVT();
        //y = y-1;
    }
    
    @Override
    public String toString() {
        String r = "x:" + this.X + " y:" + this.Y + "d:";
        return r;
    }



}
