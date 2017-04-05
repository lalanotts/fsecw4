import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.omg.CORBA.portable.InputStream;

public class WorkshopReviewSystemTestPart1 {
	
	private static ArrayList<WorkshopPaper> testarr;
	Scanner in = new Scanner(System.in);
	
	String title, review;
	int score;
	int x;
  
	//Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
	@Before 
	public void setup(){
		title = "water";
		score = 4;
		x = in.nextInt();
		}
	
  //Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
	@Test
	public void test_AddPaper() {    
		
		try {
			testarr.add(new WorkshopPaper(title));	//unfinished		
		} 
        catch(Exception e) {
			fail();
		}   
		
	}

	//Date Created: 05-04-17; Authors: Junsong Yang, Chaoqun Zhang
	@Test
	public void test_AddReview(){
		WorkshopReview wr = new WorkshopReview();
		WorkshopReviewSystem.wr(score,review)//unfinished
		WorkshopPaper wp = AllPapers.get(x-1);
		wp.addReview(wr);
		
		workshopreviewsystem.AddReview(in);//unfinished
		java.io.InputStream stdin = System.in;
		try
		{
			System.setIn(new WorkshopReviewSystem(WorkshopReview.wr()));//unfinished
		}
		catch(Exception e){
			System.out.println("Comfirmation");
		}
	}
}