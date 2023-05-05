package battleships;

public class MediumShip extends Ship {
	public MediumShip(int x, int y, int dir, Grid grid) {
		super(x, y, 3, dir, grid);
	}
	
	public void place(Grid grid) {
		super.place("M");
	}
}
