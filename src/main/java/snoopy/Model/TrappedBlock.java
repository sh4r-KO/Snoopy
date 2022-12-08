package snoopy.Model;

public class TrappedBlock extends Entity {
    private Snoopy noop;

    public TrappedBlock(int x, int y, Snoopy noop) {
        super(x, y);
        this.noop = noop;
    }

    public void trappedBlock() {
        //check if snoopy is on a trapped block
        if (X == noop.getX() && Y == noop.getY()) {
            noop.LoseLife(1);
            System.out.println("Snoopy is on a trapped block, x:"+X+" y:"+Y+" , PV left"+noop.getPV());
        }
    }


}
