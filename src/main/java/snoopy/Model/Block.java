package snoopy.Model;

public class Block {
    private int xBlock;
    private int yBlock;

    public Block(int x, int y){
        this.xBlock = x;
        this.yBlock = y;
    };

    public int getxBlock() {
        return xBlock;
    }

    public int getyBlock() {
        return yBlock;
    }

    public void setxBlock(int xBlock) {
        this.xBlock = xBlock;
    }

    public void setyBlock(int yBlock) {
        this.yBlock = yBlock;
    }

    public void push(){}
    public void cross(){}
    public void break(){}
}
