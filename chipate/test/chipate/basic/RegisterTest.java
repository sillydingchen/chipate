package chipate.basic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import chipate.basic.Register.NumericBase;

public class RegisterTest {

	@Test
	public void testCreate() {
		Register r8 = Register.register8();
		assertEquals(8, r8.getSize());
		assertEquals(0xff, r8.getMask());
		
		Register r16 = Register.register16();
		assertEquals(16, r16.getSize());
		assertEquals(0xffff, r16.getMask());
	}
	
	@Test
	public void testStoreAndLoad() {
		Register r8 = Register.register8();
		r8.store(20);
		assertEquals(20, r8.load());
		
		// Over 8 bits
		r8.store(256);
		assertEquals(0, r8.load());
		
		Register r16 = Register.register16();
		r16.store(256);
		assertEquals(256, r16.load());
		
		// Over 16 bits
		r16.store(65536);
		assertEquals(0, r16.load());
	}
	
	@Test
	public void testDump() {
		Register r8 = Register.register8();
		r8.store(16);
		
		assertTrue(r8.dump(NumericBase.DEC).contains("16"));
		assertTrue(r8.dump(NumericBase.HEX).contains("0x10"));
		
		r8.store(255);
		
		assertTrue(r8.dump(NumericBase.DEC).contains("255"));
		assertTrue(r8.dump(NumericBase.HEX).contains("0xff"));
	}
}
