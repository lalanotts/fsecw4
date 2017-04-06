import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class WorkshopReviewSystemTestPart1 {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private ByteArrayInputStream inContent1, inContent2, inContent3;
	ArrayList<WorkshopPaper> testarr = new ArrayList<WorkshopPaper>();
	Scanner in = new Scanner(System.in);
	
	
	String title1, title2, title3, review;
	int score;
  
	//Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
	@Before 
	public void setup(){
		title1 = "water";
		title2 = "liquid";
		title3 = "a";		
		review = "fantastic";
		score = 4;
		//System.setOut(new PrintStream (outContent));
	}
	
	
  //Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
	@Test
	public void test_AddPaper(){   
		
		WorkshopReviewSystem.AllPapers = testarr;
		inContent1 = new ByteArrayInputStream(title1.getBytes());
		System.setIn(inContent1);
		
		try{
		
			WorkshopReviewSystem.AddPaper(in);
		}catch (Exception e){
//			if (e.getClass()==Exception.class){
//				return;
//			}
			System.err.println(e.toString());
			fail();
		}
		System.out.println(WorkshopReviewSystem.AllPapers.get(0).getPTitle());
		assertEquals(WorkshopReviewSystem.AllPapers.get(0).getPTitle(), title1);
		//fail();

	}

	//Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
//	@Test
//	public void test_AddReview_toExistsPaper() throws IOException {
//		WorkshopReviewSystem.AllPapers = testarr;
//		
//		WorkshopReviewSystem.AllPapers.add(new WorkshopPaper(title2));
//		
////		WorkshopPaper wp = WorkshopReviewSystem.AllPapers.get(0);
////		
////		inContent1 = new ByteArrayInputStream(review.getBytes());
////		inContent2 = new ByteArrayInputStream("4".getBytes());
//		inContent3 = new ByteArrayInputStream("1".getBytes());
//		
//		System.setIn(inContent3);
////		System.setIn(inContent2);
////		System.setIn(inContent1);
//		
//		try{
//			WorkshopReviewSystem.AddReview(in);
//		}catch(Exception e){
//			
//			if (e.getClass()==Exception.class){
//				return;
//			}
////			System.err.println(e.toString());
//		}
//		fail();
//
//	}
//	

	@After
	public void cleanUp(){
		System.setOut(System.out);
		System.setIn(System.in);
	}
}