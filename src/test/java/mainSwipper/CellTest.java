package mainSwipper;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

	@Test
	public void cellHasBombTest() {
		Cell cell = new Cell(Symbol.BOMB);
		Assert.assertEquals("Expected a bomb", "*", cell.getValue());
	}
	
	@Test
	public void cellHasNoBombTest(){
		Cell cell = new Cell(Symbol.NO_BOMB);
		Assert.assertEquals("No bomb expected",".", cell.getValue());
	}
	
}
