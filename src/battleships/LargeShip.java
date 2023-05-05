package battleships;

public class LargeShip extends Ship {

	public LargeShip(int x, int y, int dir, Grid grid) {
		super(x, y, 4, dir, grid);
		
	}
	public void place(Grid grid) {
		super.place("L");
	}

}
