package snoopy.Model;

public class PushingBlock {
    private int X;
    private int Y;


    public void setX(int X) {
        this.X=X;
    }
    public void setY(int Y) {
        this.Y=Y;
    }
    enum Direction {
        NORD,
        SUD,
        OUEST,
        EST;
    }

    public PushingBlock(int X,int Y, PushingBlock.Direction d){
        this.X = X;
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
        String r = "x:"+this.X+" y:"+this.Y+"d:";
        return r;
    }
}
}
