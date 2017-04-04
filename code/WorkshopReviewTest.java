import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
import org.junit.After;

public class WorkshopReviewTest {
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	
	WorkshopReview review = new WorkshopReview();
	int int1;
	String str1 = "No Review", str2 = "great";
	
	
    
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
	        int Returnedscore = review.getRScore();
	        assertNotNull(Returnedscore);
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//--unfinished
	@Test
	public void test_SetScore(){ 
		int score = 4;
		try {
			review.setRScore(score); 
			} 
		catch(Exception e){
			if (score > 5 || score < 1){
				
				}
			else
				fail("error");
			}
			assertEquals(score, review.getRScore());

			
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	@Test
	public void test_GetReview(){
			String Returnreview = review.getRReview();
	        assertNotNull(Returnreview);
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//--unfinished
	@Test
	public void test_SetReview(){ 
		try {
			review.setRReview(str2); 
			} 
		catch(Exception e){
			if(e.getClass() == IllegalArgumentException.class) {
				return;
    		}
			else
				fail("error");
		}
			assertEquals(str2, review.getRReview());
			

	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	@Test
	public void test_toString(){
		String toString = review.toString();
	    assertTrue(toString.contains("Score = " + review.getRScore() + "\n Review: " + review.getRReview() + "\n"));
	}
}
