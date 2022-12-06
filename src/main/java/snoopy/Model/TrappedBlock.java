package snoopy.Model;

public class TrappedBlock {
    private int x;
    private int y;
    private Snoopy noop;

    public TrappedBlock(int x, int y, Snoopy noop) {
        this.x = x;
        this.y = y;
        this.noop = noop;
    }

    public void trappedBlock() {
        //check if snoopy is on a trapped block
        if (x == noop.getX() && y == noop.getY()) {
            noop.LoseLife(1);
            System.out.println("Snoopy is on a trapped block, x:"+x+" y:"+y+" , PV left"+noop.getPV());
        }
    }

}
