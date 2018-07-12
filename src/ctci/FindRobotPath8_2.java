package ctci;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FindRobotPath8_2 {
	
	static List<Point> findPath(Boolean[][] grid){
		if(grid == null || grid.length ==0) return null;
		HashMap<Point, Boolean> cache = new HashMap<Point, Boolean>();
		ArrayList<Point> path = new ArrayList<Point>();
		if(findPath(grid, grid.length-1, grid[0].length-1, path, cache)) {
			return path;
		}
		else {
			return null;
		}
		
	}
	
	static Boolean findPath(Boolean[][] grid, int r, int c, ArrayList<Point> path, HashMap<Point,Boolean> cache){
		if(r < 0 || c<0 || !grid[r][c]) {
			return false;
		}
	
		Point p = new Point(r,c);
		if(cache.containsKey(p)) {
			return cache.get(p);
		}
		
		boolean success = false;
		
		if((r==0 && c==0) || findPath(grid, r, c-1, path, cache) || findPath(grid, r-1, c, path, cache)) {
			path.add(p);
			success = true;
		}
		cache.put(p, success); 
		return success;
		
	}

	public static void main(String[] args) { 

	    Random random = new Random(); 
	    int size = 10;
		Boolean[][] grid = new Boolean[size][size-3];
		for(int i=0; i< size; i++) {
			for(int j =0; j< size-3; j++) {
				if(i ==0 && j == 0 || i == size-1 && j ==size-3)
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
