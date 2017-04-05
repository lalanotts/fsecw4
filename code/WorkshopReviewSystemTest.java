import static org.junit.Assert.*;

import java.io.*;
import java.util.ArrayList;

import org.junit.Test;

import org.junit.Before;
import org.junit.After;

public class WorkshopReviewSystemTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ByteArrayInputStream inContent;
	
	@Before
	public void setUpStreams(){
		System.setOut(new PrintStream(outContent));
	}
	
	//Date Created: 05-04-17; Authors: Luou WEN, Yanting SHEN
	//Passed - 5/4/17 15:53
	@Test
	public void testPrintPaperOverviewWithPapers() {
		WorkshopReviewSystem.AllPapers = new ArrayList<WorkshopPaper>();
		
		WorkshopPaper p1 = new WorkshopPaper("Paper 1 is great");
		p1.addReview(new WorkshopReview(4,"This paper is pretty good."));
		p1.addReview(new WorkshopReview(3,"This paper is good for the workshop."));
		p1.addReview(new WorkshopReview(2, "This paper is pretty mediocre."));
		
		WorkshopReviewSystem.AllPapers.add(p1);
		
		WorkshopPaper p2 = new WorkshopPaper("Paper 2 is my best work");
		p2.addReview(new WorkshopReview(2,"This can hardly be his best work"));
		p2.addReview(new WorkshopReview(1,"Ive read better articles in Hello Magazine"));
		p2.addReview(new WorkshopReview(1,"So painful to read."));
		
		WorkshopReviewSystem.AllPapers.add(p2);
		
		WorkshopReviewSystem.PrintPaperOverview();
		
		String expectedOut = "1) Paper 1 is great - 3.0\r\n";
		expectedOut += "2) Paper 2 is my best work - 1.3333334\r\n";
		
		assertEquals(expectedOut, outContent.toString());
	}
	
	//Date Created: 05-04-17; Authors: Luou WEN, Yanting SHEN
	//Failed - No exception caught when no papers - 5/4/17 15:53 - BUG #
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
	
	@After
	public void cleanUp(){
		//clean up Streams
		System.setOut(System.out);
		System.setIn(System.in);
	}

}
