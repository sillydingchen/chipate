package chipate.basic;

public class Register {
	
	private int size;
	private int mask;
	private int value;
	
	private Register(int size) {
		this.size = size;
		this.mask = (1 << size) - 1;
	};
	
	public static Register register8() {
		return new Register(8);
	}
	
	public static Register register16() {
		return new Register(16);
	}
	
	public int getSize() {
		return this.size;
	}

	public void store(int value) {
		this.value = value & mask;
	}
	
	public int load() {
		return this.value;
	}
	
	public String dump(NumericBase NumericBase) {
		switch (NumericBase) {
		case HEX:
			return "0x" + Integer.toHexString(load());
		case DEC:
			return Integer.toString(load());
		}
		return null;
	}
	
	int getMask() {
		return this.mask;
	}
	
	public enum NumericBase {
		DEC, HEX
	}
}
