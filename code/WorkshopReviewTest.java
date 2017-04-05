import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
import org.junit.After;

public class WorkshopReviewTest {
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	WorkshopReview review;
	int int1;
	String str1, str2, str3;
	
	@Before
	public void setupForwsReviewTest(){
	review = new WorkshopReview();
	
	str1 = "No Review";
	str2 = "great";
	str3= "word";
	}
	
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
    //Junsong -- finished -- default score and review were tested
	@Test
	
	
	public void test_Default() {
		review = new WorkshopReview();
		int dScore = review.getRScore();
		assertEquals(dScore, 0);
		
		String dReview = review.getRReview();
		assertEquals(dReview, str1);
	}

	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//--unfinished
	@Test
	public void test_Main_isScore_isReview(){
		review = new WorkshopReview(4, "great");
		assertNotNull(review.getRScore());
		assertNotNull(review.getRReview());
	}

	@Test
	public void test_Main_ReviewErrorThrown(){
		try{
			review = new WorkshopReview(4, "word");
		}catch (Exception revExcep){
			return;
		}//test minimum amount of text
		//minimum is 5
		fail();
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
	public void test_SetScore_OutOfRange(){ 
		int score = 6;
		try {
			review.setRScore(score); 
			} 
		catch(Exception e){
			return;
			}
		fail();
	}

	@Test
	public void test_SetScore_InRange(){ 
		int score = 4;
		try {
			review.setRScore(score); 
			} 
		catch(Exception e){
			fail();
			}
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
			review.setRReview(str3); 
			} 
		catch(Exception e){
			return;
		}
		fail();
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	@Test
	public void test_toString(){
		String toString = review.toString();
	    assertTrue(toString.contains("Score = " + WorkshopReview.ROutputs[review.getRScore()] + "\n Review: " + review.getRReview() + "\n"));
	}
}
