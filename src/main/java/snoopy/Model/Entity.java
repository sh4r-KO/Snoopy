package snoopy.Model;

public abstract class Entity {
    int X;
    int Y;
    public Entity(int x, int y) {
        this.X = x;
        this.Y = y;
    }
    public int getX() {
        return X;
    }
    public void setX(int x) {
        this.X = x;
    }
    public int getY() {
        return Y;
    }
    public void setY(int y) {
        this.Y = y;
    }
    protected abstract void Action();
}
