package battleships;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Ship {
	private int x;
	private int y;
	private int size;
	private int dir;
	private int health;
	private Grid grid;
	private ArrayList<int[]> boardPos;
	
	public Ship(int x, int y, int size, int dir, Grid grid) {
		boardPos = new ArrayList<>();
		this.x = x;
		this.y = y;
		this.size = size;
		this.health = size;
		this.dir = dir;
		this.grid = grid;
		try {
			checkCoordinates();
		}catch(Exception e) {
			checkCoordinates();
		}
		
	}
	
	public boolean alive() {
		return health>0;
	}
	
	public boolean checkHit(int x, int y) {
		int[] pos = {x,y};
		for(int i=0; i<boardPos.size(); i++) {
			if(Arrays.equals(boardPos.get(i), pos)) {
				health--;
				boardPos.remove(i);
				grid.place(x, y, "X");
				return true;
			}
			
		}
		return false;
	}
	
	public int getHealth() {
		return health;
	}
	public void checkHealth() {
		if(getHealth() <= 0) {
			System.out.println("Ship down!");
		}
	}
	
	public void place(String symbol) {
		if(dir == 0) {
			int counter = 0;
			for(int i=0; i<size; i++) {
				
				if(x+counter>grid.getSize()) {
					x=0;
					counter=0;
				}
				int[] pos = {x+counter, y};
				grid.place(x+counter, y, symbol);
				boardPos.add(pos);
				counter++;
			}
		}else {
			int counter = 0;
			for(int i=0; i<size; i++) {
				
				if(y+counter>grid.getSize()) {
					y=0;
					counter=0;
				}
				int[] pos = {x, y+counter};
				grid.place(x, y+counter, symbol);
				boardPos.add(pos);
				counter++;
			}
		}
	
	}
	public void printPos() {
		for(int i = 0; i<boardPos.size(); i++) {
			System.out.print("("+boardPos.get(i)[0]+","+ boardPos.get(i)[1]+") ");
		}
	}
	
	private void checkCoordinates() {
		if(dir == 0) {
			if(y > grid.getSize()-1) {
				y=grid.getSize()-1;
			}
			
			if(y < 0) {
				y=0;
			}
			
			while(x+size > grid.getSize()) {
				x--;
			}
			
			for(int i=0; i<size; i++) {
				while(grid.getTile(x+i, y)!= "-") {
					x--;
				}
				if(x==0) {
					x=grid.getSize()-size;
				}
			}
			
		}else {
			while(y+size>grid.getSize()) {
				y--;
			}
			while(x>grid.getSize()-1) {
				x--;
			}
			for(int i=0; i<size; i++) {
				while(grid.getTile(x, y+i)!= "-") {
					y--;
					if(y<0) {
						y=grid.getSize()+size;
					}
				}
			}
			
		}
	}
}
