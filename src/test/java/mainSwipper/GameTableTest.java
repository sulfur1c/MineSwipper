package mainSwipper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTableTest {

	private GameTable gameTable;
	private int expectedWidth;
	private int expectedHeight;

	@Before 
	public void initializeGameTable() {
		
		expectedWidth = 3;
		expectedHeight = 3;
	
		gameTable = new GameTable(expectedWidth, expectedHeight);
	}
	
	@Test
	public void sizeTest() {
		
		int obtainedWidth = gameTable.getWidth();
		int obtainedHeight = gameTable.getHeight();
		
		Assert.assertEquals("Unexpected width", expectedWidth, obtainedWidth);
		Assert.assertEquals("Unexpected heith", expectedHeight, obtainedHeight);
	}
	
	@Test
	public void setAndGetCellTest(){
		
		gameTable.setCell(0, 0, new Cell(Symbol.BOMB));
		gameTable.setCell(1, 1, new Cell(Symbol.NO_BOMB));
		
		Assert.assertEquals("Unexpected cell content", Symbol.BOMB.toString(), gameTable.getCell(0,0).toString());
		Assert.assertEquals("Unexpected cell content", Symbol.NO_BOMB.toString(), gameTable.getCell(1,1).toString());
	}
	
	@Test
	public void findBombsTest(){
		
		List<Integer> expectedBombs = new ArrayList<Integer>();
		expectedBombs.add(0);
		expectedBombs.add(3);
		
		gameTable.setCell(0, 0, new Cell(Symbol.BOMB));
		gameTable.setCell(1, 1, new Cell(Symbol.NO_BOMB));
		gameTable.setCell(1, 0, new Cell(Symbol.BOMB));
		
		Assert.assertEquals("Bomb not found", expectedBombs, gameTable.findBombs());		
	}
	
	@Test
	public void findNeightborsTest(){
		
		List<Integer> bombs = new ArrayList<Integer>();
		List<Integer> expectedNeighbours = new ArrayList<Integer>();
		expectedNeighbours.add(1);
		expectedNeighbours.add(3);
		expectedNeighbours.add(4);
		
		gameTable.setCell(0, 0, new Cell(Symbol.BOMB));
		
		bombs = gameTable.findBombs();
		
		Assert.assertEquals("Bomb not found", expectedNeighbours, gameTable.findBombsNeightbors(bombs));	
	}
}
