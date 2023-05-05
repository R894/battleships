package battleships;

public class SmallShip extends Ship {

	public SmallShip(int x, int y, int dir, Grid grid) {
		super(x, y, 2, dir, grid);
	}
	
	public void place(Grid grid) {
		super.place("S");
	}

}
