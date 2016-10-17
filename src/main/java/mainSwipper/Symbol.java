package mainSwipper;

public enum Symbol {

	BOMB("*"), NO_BOMB(".");
	
	final String printable;
	
	private Symbol(final String printable){
		this.printable = printable;
	}
	
	public String toString(){
		return this.printable;
	}
}
