import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
	private ByteArrayInputStream inContent;
	ArrayList<WorkshopPaper> testarr = new ArrayList<WorkshopPaper>();
	
	Scanner in = new Scanner(System.in);
	
	String title, review;
	int score;
  
	//Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
	@Before 
	public void setup(){
		title = "\nwater";
		score = 4;
		System.setOut(new PrintStream (outContent));
	}
	
	
  //Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
	@Test
	public void test_AddPaper() {    
		WorkshopReviewSystem.AllPapers = testarr;
		inContent = new ByteArrayInputStream(title.getBytes());
		System.setIn(inContent);
		try{
			WorkshopReviewSystem.AddPaper(in);
		}catch (Exception e){
			fail();
		}
		
	}

//	//Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
//	@Test
//	public void test_AddReview_toExistsPaper(){
//		WorkshopReview wr = new WorkshopReview();
//		WorkshopReviewSystem.wr(score,review)//unfinished
//		WorkshopPaper wp = AllPapers.get(x-1);
//		wp.addReview(wr);
//		
//		workshopreviewsystem.AddReview(in);//unfinished
//		java.io.InputStream stdin = System.in;
//		try
//		{
//			System.setIn(new WorkshopReviewSystem(WorkshopReview.wr()));//unfinished
//		}
//		catch(Exception e){
//			System.out.println("Comfirmation");
//		}
//	}
//	
//	@Test
//	public void test_AddReview_toNonExistsPaper(){
//		
//		
//	}
}