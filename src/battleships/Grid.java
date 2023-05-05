package battleships;

public class Grid {
	
	private String[][] grid;
	public Grid(int size) {
		grid = new String[size][size];
		initializeGrid();
	}
	
	private void initializeGrid() {
		for(int i=0; i<grid.length; i++) {
			for(int col =0; col<grid[i].length; col++) {
				grid[i][col] = "-";
			}
		}
	}
	
	public void place(int x,int y, String text) {
		grid[y][x] = text;
		
	}
	
	public void removeTile(int x, int y) {
		grid[y][x] = "-";
	}
	
	public String getTile(int x, int y) {
		return grid[y][x];
	}
	public int getSize() {
		return grid.length;
	}
	
	public void printGrid() {
		for(int i=0; i<grid.length; i++) {
			for(int col =0; col<grid[i].length; col++) {
				 
				 System.out.print(grid[i][col]);
			}
			System.out.println();
		}
	}
	
	public void clear() {
		initializeGrid();
	}
}
