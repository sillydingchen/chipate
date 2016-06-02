package chipate.basic;

public interface Register {
	public int getSize();
	public void store(int value);
	public int load();
	public String dump(NumericBase NumericBase);
	
	enum NumericBase {
		DEC, HEX
	}
}
