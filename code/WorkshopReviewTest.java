import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
import org.junit.After;

public class WorkshopReviewTest {
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	
	WorkshopReview review = new WorkshopReview();
	int int1;
	String str1 = "No Review", str2;
	
	
    
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
    //Junsong -- finished -- default score and review were tested
	@Test
	public void test_Default() {
		review.WorkShopReview();
		int dScore = review.getRScore();
		assertEquals(dScore, 0);
		
		String dReview = review.getRReview();
		assertEquals(dReview, str1);
	}

	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//--unfinished
	@Test
	public void test_Main() throws Exception{
		review.WorkShopReview(4, "Fantastic");
		String rReview = review.getRReview();
		int rScore = review.getRScore();
		assertEquals(4, rScore);
		assertEquals(rReview, "Fantastic");
		
		try{
			review.WorkShopReview(6, "Fanstastic");
		}catch (Exception e){
			System.err.println("scoreRangeException: " + e.getMessage());
		}//test score range
		
		try{
			review.WorkShopReview(4, "word");
		}catch (Exception revExcep){
			System.err.println("ReviewRangeException: " + revExcep.getMessage());
		}//test minimum amount of text
	}
	

	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	@Test
	public void test_GetSocore(){
	        int Returnedscore = WorkshopReview.getRScore("testint");
	        assertNotNull(Returnedscore);
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//--unfinished
	@Test
	public void test_SetScore(){
		int score = 0; 
		try {
			score = Treview.setRScore(rScore); 
			} 
		catch(Exception e){
			if (score > Integer.MIN_VALUE){
				return;
				}
			else
				fail("error");
			}
			assertEquals(50, score);

			
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	@Test
	public void test_GetReview(){
	        String Returnedreview = getRReview("testString");
	        assertNotNull(Returnedreview);
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//--unfinished
	@Test
	public void test_SetReview(){
		String review = great; 
		String input2;
		try {
			review = Treview.setRReview(input2); 
			} 
		catch(Exception e){
			if(e.getClass() == IllegalArgumentException.class) {
				return;
    		}
			else
				fail("error");
			
			
		}
			assertEquals(good, review);
			

	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	@Test
	public void test_toString(){
		String toString = Treview.toString();
	    assertTrue(toString.contains("Score = " + RScore + "\n Review: " + RReview + "\n"));
	}
}
