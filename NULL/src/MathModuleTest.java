


import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;


public class MathModuleTest {

	@Test
	public void test1() throws Exception {
	int myAnswer = MathModule.myMultiply(4, 2);
	assertEquals(myAnswer,8);
	
	}
	private int input1, input2, input3;
	
	@Before
	public void setup(){
	      input1 = 3;
	      input2 = 6;
	      input3 = 2000000000;
	}
	@Test
	public void testError() {
		int myanswer = 0;
		try {
		myanswer = MathModule.myMultiply(input1,input2);
		} catch (Exception e) {
		if (e.getClass()==Exception.class) {
		return; //it passed
		}
		}
		fail();
		}
	@Test
	public void testError1() {
		int myanswer = 0;
		try {
		myanswer = MathModule.myMultiply(input2,input3);
		} catch (Exception e) {
		if (e.getClass()==Exception.class) {
		return; //it passed
		}
		}
		fail();
		}
}
