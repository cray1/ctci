package ctci;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindRobotPath8_2 {
	
	static List<Point> findPath(Boolean[][] grid){
		if(grid == null || grid.length ==0) return null;
		return findPath(grid, grid.length-1, grid[0].length-1, new ArrayList<Point>());
		
	}
	
	static List<Point> findPath(Boolean[][] grid, int r, int c, List<Point> path){
		if(r < 0 || c<0 || !grid[r][c]) {
			return null;
		}
		Boolean isAtOrigin = (r==0 && c==0);
		if(isAtOrigin || findPath(grid, r, c-1, path) != null || findPath(grid, r-1, c, path) != null) {
			path.add(new Point(r,c));
			return path;
		}
		else {
			return null;	
			
		}
		
	}

	public static void main(String[] args) { 

	    Random random = new Random(); 
	    int size = 5;
		Boolean[][] grid = new Boolean[size][size];
		for(int i=0; i< size; i++) {
			for(int j =0; j< size; j++) {
				if(i ==0 && j == 0 || i == size-1 && j ==size-1)
					grid[i][j] = true;
				else
					grid[i][j] = random.nextBoolean();
			
				System.out.print("["+(grid[i][j]?"o":"x") +"] ");
			}
			System.out.print("\n");
			
		}
		
		
		List<Point> path = findPath(grid);
		if(path != null) {
			for(Point p: path) {
				if(p.getX() == size-1 && p.getY()==size-1)
					System.out.print("("+ (int)p.getX() +"," + (int)p.getY() +")");
				else
					System.out.print("("+ (int)p.getX() +"," + (int)p.getY() +")-->");
			}
		}
		else {
			System.out.print("\n is null path");
		}
		
		
	}
	
	

}
