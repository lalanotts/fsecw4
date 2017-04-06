import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Test;

public class WorkshopReviewSystemTestMain {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ByteArrayInputStream inContent;
	
	@Test
	public void test_main_O() {
		
		inContent = new ByteArrayInputStream("O".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
		}catch(Exception e){
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\n" + WorkshopReviewSystem.PrintPaperOverview() + "What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\n", outContent.toString());
		
		
	}
	
	@Test
	public void test_main_P() {
		
		inContent = new ByteArrayInputStream("P".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
			
			inContent = new ByteArrayInputStream("lalala".getBytes());
			System.setIn(inContent);
			
			inContent = new ByteArrayInputStream("P".getBytes());
			System.setIn(inContent);
		}catch(Exception e){
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit", outContent.toString());
		
		
	}
	
	
	
	@After
	public void cleanup(){
		System.setOut(System.out);
		System.setIn(System.in);
	}

}
