import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;

import org.junit.Test;

import org.junit.Before;
import org.junit.After;

public class WorkshopReviewSystemTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ByteArrayInputStream inContent;
	ArrayList<WorkshopPaper> testPapers = new ArrayList<WorkshopPaper>();
	
	@Before
	public void setup(){
		//Set up streams
		System.setOut(new PrintStream(outContent));
		
		//Set up papers
		WorkshopPaper p1 = new WorkshopPaper("Paper 1 is great");
		p1.addReview(new WorkshopReview(4,"This paper is pretty good."));
		p1.addReview(new WorkshopReview(3,"This paper is good for the workshop."));
		p1.addReview(new WorkshopReview(2, "This paper is pretty mediocre."));
		
		testPapers.add(p1);
		
		WorkshopPaper p2 = new WorkshopPaper("Paper 2 is my best work");
		p2.addReview(new WorkshopReview(2,"This can hardly be his best work"));
		p2.addReview(new WorkshopReview(1,"Ive read better articles in Hello Magazine"));
		p2.addReview(new WorkshopReview(1,"So painful to read."));
		
		testPapers.add(p2);
	}
	
	//Date Created: 05-04-17; Authors: Luou WEN, Yanting SHEN
	//Passed - 5/4/17 15:53
	@Test
	public void testPrintPaperOverviewWithPapers() {
		WorkshopReviewSystem.AllPapers = testPapers;
		
		WorkshopReviewSystem.PrintPaperOverview();
		
		String expectedOut = "1) Paper 1 is great - 3.0\r\n";
		expectedOut += "2) Paper 2 is my best work - 1.3333334\r\n";
		
		assertEquals(expectedOut, outContent.toString());
	}
	
	//Date Created: 05-04-17; Authors: Luou WEN, Yanting SHEN
	//BUG #1 - No exception caught when no papers - 5/4/17 15:53
	@Test
	public void testPrintPaperOverviewNoPaper() {
		WorkshopReviewSystem.AllPapers = new ArrayList<WorkshopPaper>();
		try{
			WorkshopReviewSystem.PrintPaperOverview();
		} catch (Exception e){
			if (e.getClass()==Exception.class){
				assertEquals("No papers were found.\r\n", outContent.toString());
				return;
			}
		}
		fail();
	}
	
	//Date Created: 05-04-17; Authors: Luou WEN, Yanting SHEN	
	//BUG #2 - For input paperID = 1, the output showed the details of paper2 not the paper1 - 05/04/17 16:24
	@Test
	
	public void testPrintAPaper(){
		
		WorkshopReviewSystem.AllPapers = testPapers;
		
		int paperID = 1;
		WorkshopReviewSystem.PrintAPaper(paperID);
		
		String expectedOutput = "";
		expectedOutput = "\nPaper 1 - Average Score = ***\n\n"; 
		expectedOutput += "Review 1:\n" + "Score = ****\n" + "This paper is pretty good.\n\n";
		expectedOutput += "Review 2:\n" + "Score = ***\n" + "This paper is good for the workshop.\n\n";
		expectedOutput += "Review 3:\n" + "Score = **\n" + "This paper is pretty mediocre.\n\n";		
		assertEquals(expectedOutput, outContent.toString());
		
	}
	
	//Date Created: 05-04-17; Authors: Luou WEN, Yanting SHEN	
	//BUG #3 - No error created - 05/04/17 16:24
	@Test
	public void testNoPrintAPaper(){
		WorkshopReviewSystem.AllPapers = new ArrayList<WorkshopPaper>();
		try{
			int paperID = 5;
			WorkshopReviewSystem.PrintAPaper(paperID);
		}  catch (Exception e){
			if (e.getClass()==Exception.class){
				return;
			}
		}
		fail();
	}
	
	@After
	public void cleanUp(){
		//clean up Streams
		System.setOut(System.out);
		System.setIn(System.in);
	}

}