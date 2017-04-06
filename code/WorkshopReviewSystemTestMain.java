import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Test;

public class WorkshopReviewSystemTestMain {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ByteArrayInputStream inContent;
	
	
	//Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
	//Passed - 06/04/17 13:00
	@Test
	public void test_main_Overview() {
		
		inContent = new ByteArrayInputStream("O".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
		}catch(Exception e){
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n1) Paper 1 is great - 3.0\n2) Paper 2 is my best work - 1.3333334\n3) a - 1.0\n\r\nWhat do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n", outContent.toString());
		
		
	}
	
	
	//Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
	//Passed - 06/04/17 13:00
	@Test
	public void test_main_AddPaper() {
		
		inContent = new ByteArrayInputStream("P\nlalala".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
			
//			inContent = new ByteArrayInputStream("lalala".getBytes());
//			System.setIn(inContent);
		}catch(Exception e){
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\nWhat is the title of the paper?\r\n[Paper added]\r\nWhat do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n", outContent.toString());
		
		
	}
	
	//Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
	//Passed - 06/04/17 13:00
	@Test
	public void test_main_AddReview() {
		
		inContent = new ByteArrayInputStream("R\n1\n4\nlalala\n".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
			
		}catch(Exception e){
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\nWhich paper do you want to add a review to?\r\nWhat score do you give it?\r\nPlease enter your review:\r\n[Review added to Paper 1]\r\nWhat do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n", outContent.toString());
		
		
	}

	
    //Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
	//Passed - 06/04/17 13:00
	//input a paper that non-exists to test if this method throw err message when user tries to add review to a non-exists paper
	@Test
	public void test_main_AddReviewToPaperThatNonExist() {
		
		inContent = new ByteArrayInputStream("R\n8\n4\nlalala\n".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
			
		}catch(Exception e){
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\nWhich paper do you want to add a review to?\r\nWhat score do you give it?\r\nPlease enter your review:\r\nSomething went wrong: java.lang.IndexOutOfBoundsException: Index: 7, Size: 3\n\r\nWhat do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n", outContent.toString());
		
		
	}
	
	
	//Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
	//Passed - 06/04/17 13:00
	
	@Test
	public void test_main_PrintAPaper() {
		
		inContent = new ByteArrayInputStream("3".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
			
		}catch(Exception e){
			System.err.println(e.toString());
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n\nPaper 3 - Average Score = **\n\nReview 1:\nScore = **\n Review: b\n\nReview 2:\nScore = **\n Review: b\n\nReview 3:\nScore = **\n Review: b\n\nWhat do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n", outContent.toString());
		
		
	}
	
	
	    //Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
		//Passed - 06/04/17 13:00
		//input a paper that non-exists to test if this method throw err message
		@Test
		public void test_main_PrintAPaperThatNonExists() {
			
			inContent = new ByteArrayInputStream("5".getBytes());
			System.setIn(inContent);
			System.setOut(new PrintStream(outContent));
			
			try{
				WorkshopReviewSystem.main(null);
				
			}catch(Exception e){
				fail("paper non-exists");
			}
			
			assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\nSomething went wrong: java.lang.IndexOutOfBoundsException: Index: 4, Size: 3\n\r\nWhat do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n", outContent.toString());
			
			
		}
	
	
	//Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
	//Passed - 06/04/17 13:00
	@Test
	public void test_main_Exit() {
		
		inContent = new ByteArrayInputStream("X\n".getBytes());
		System.setIn(inContent);
		System.setOut(new PrintStream(outContent));
		
		try{
			WorkshopReviewSystem.main(null);
			
		}catch(Exception e){
			System.err.println(e.toString());
			fail();
		}
		
		assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\nGoodbye!\r\n", outContent.toString());
		
		
	}
		
	
	//Date Created: 05-04-17; Authors: Junsong Yang, Yanting SHEN	
	//Passed - 06/04/17 13:00
	//input a paper that non-exists to test if this method throw err message when user tries to add review to a non-exists paper
		@Test
		public void test_main_InputCommandThatNonexists() {
			
			inContent = new ByteArrayInputStream("AAA".getBytes());
			System.setIn(inContent);
			System.setOut(new PrintStream(outContent));
			
			try{
				WorkshopReviewSystem.main(null);
				
			}catch(Exception e){
				fail();
			}
			
			assertEquals("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\nSomething went wrong: java.lang.NumberFormatException: For input string: \"AAA\"\n\r\nWhat do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\r\n", outContent.toString());
			
			
		}
	
	@After
	public void cleanup(){
		System.setOut(System.out);
		System.setIn(System.in);
	}

}
