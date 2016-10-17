package mainSwipper;

public class Cell {
	
	private final Symbol symbol;
	
	Cell(final Symbol symbol){
		this.symbol = symbol;
	}

	public String getValue() {
		return this.symbol.toString();
	}
	
	@Override
	public String toString() {
		return getValue();
	}
}
