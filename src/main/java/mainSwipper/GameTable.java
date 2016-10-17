package mainSwipper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameTable {
	
	private final int width;
	
	private final int height;
		
	private HashMap<Integer, Cell> positionCell;

	public GameTable(final int width, final int height) {
		
		this.width = width;
		this.height = height;
		this.positionCell = new HashMap<Integer, Cell>();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setCell(int i, int j, Cell cell) {
		int position = (i * width) + j;
		positionCell.put(position, cell);
	}

	public Cell getCell(int i, int j) {
		int position = (i * width) + j;
		return positionCell.get(position);
	}

	public List<Integer> findBombs() {
		List<Integer> bombs = new ArrayList<Integer>();
		bombs = positionCell.entrySet()
				.stream()
				.filter(p -> p.getValue().toString().equals(Symbol.BOMB.toString()))
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());		
		return bombs;
	}

	public List<Integer> findBombsNeightbors(List<Integer> bombs) {
		List<Integer> neighbours = new ArrayList<Integer>();
		for (Integer bomb : bombs) {
			Integer neighbour = null;
			if ( bomb >= this.width){
				neighbour = bomb - (this.width - 1);
				validNeightbour(neighbours, neighbour);
				neighbour ++;
				validNeightbour(neighbours, neighbour);
				neighbour ++;
				validNeightbour(neighbours, neighbour);
			}
			if ((bomb % this.width) > 0){
				neighbour = bomb -1;
				validNeightbour(neighbours, neighbour);
			}
			if ((bomb % this.width) < (this.width - 1)){
				neighbour = bomb +1;
				validNeightbour(neighbours, neighbour);
			}
			if ( bomb < (this.width * this.height) - this.width){
				neighbour = ((bomb/this.width) + this.width);
				validNeightbour(neighbours, neighbour);
				neighbour ++;
				validNeightbour(neighbours, neighbour);
				neighbour ++;
				validNeightbour(neighbours, neighbour);
			}
		}
		return neighbours;
	}

	private void validNeightbour(List<Integer> neighbours, Integer neighbour) {
		if (0 >= neighbour || neighbour <= (this.width * this.height)){
			neighbours.add(neighbour);
		}
	}	
	
	public List<Integer> findNeightbors(List<Integer> bombs) {
		List<Integer> neighbours = new ArrayList<Integer>();
		bombs.forEach(p -> {
			int bomb = (p -1) - this.width;
			addBomb();
			if (checkInsideTrue(bomb)){
				neighbours.add(bomb);
			}
			bomb ++;
		});
		neighbours.add(1);
		neighbours.add(3);
		neighbours.add(4);
		return neighbours;
	}
}
