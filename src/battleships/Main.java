package battleships;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Grid grid = new Grid(10);
		ShipManager manager = new ShipManager(grid);
		
		manager.generateShips();
		grid.clear();
		grid.printGrid();
		//manager.printPos();
		int guesses = 0;
		
		while(true) {
			try{
				System.out.println("Select x coordinate");
				int x = Integer.valueOf(scanner.nextLine());
				System.out.println("Select y coordinate");
				int y = Integer.valueOf(scanner.nextLine());
				if(manager.shoot(x, y)) {
					//grid.printGrid();
				}else {
					//grid.printGrid();
					System.out.println("Miss");
				}
				guesses++;
				if(manager.isAllDead()) {
					System.out.println("You won! it took you " + guesses + " guesses");
					break;
				}
			}catch(Exception e) {
				scanner.close();
				break;
			}	
		}
	}

}
