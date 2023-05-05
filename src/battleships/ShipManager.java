package battleships;

import java.util.ArrayList;

public class ShipManager {
	
	ArrayList<Ship> ships;
	Grid grid;
	
	public ShipManager(Grid grid) {
		
		ships = new ArrayList<>();
		this.grid = grid;
	}
	
	public boolean isAllDead() {
		
		for(Ship ship : ships) {
			if(ship.alive()) {
				return false;
			}
		}
		return true;
	}
	
	public void generateShips() {
		
		for(int i=0; i<3; i++) {
			addSmall(getRandomCoordinate(),getRandomCoordinate(), getRandomDirection());
		}
		addMedium(getRandomCoordinate(),getRandomCoordinate(), getRandomDirection());
		addLarge(getRandomCoordinate(),getRandomCoordinate(), getRandomDirection());
	}
	
	public void addSmall(int x, int y, int dir) {
		
		SmallShip ship = new SmallShip(x,y, dir, grid);
		ships.add(ship);
		ship.place(grid);
	}
	
	public void addMedium(int x, int y, int dir) {
		
		MediumShip ship = new MediumShip(x,y,dir, grid);
		ships.add(ship);
		ship.place(grid);
	}
	
	public void addLarge(int x, int y, int dir) {
		
		LargeShip ship = new LargeShip(x,y,dir, grid);
		ships.add(ship);
		ship.place(grid);
	}
	
	public void printPos() {
		
		for(Ship ship : ships) {
			ship.printPos();
		}
	}
	
	public boolean shoot(int x, int y) {
		
		for(Ship ship : ships) {
			if(ship.checkHit(x, y)) {
				grid.printGrid();
				System.out.println("Hit!");
				ship.checkHealth();
				return true;
			}
		}
		grid.printGrid();
		return false;
	}
	
	private int getRandomCoordinate() {
		
	    return (int) ((Math.random() * (grid.getSize()-1)));
	}
	
	private int getRandomDirection() {
		
		double randomNum = Math.random();
		if(randomNum< 0.6){
			return 0;
		}
		return 1;
	}
	
}
