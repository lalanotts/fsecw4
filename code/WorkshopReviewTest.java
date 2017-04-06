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
	//Passed - 31/3/2017
	@Test
	public void test_Default() {
		review = new WorkshopReview();
		int dScore = review.getRScore();
		assertEquals(dScore, 0);
		
		String dReview = review.getRReview();
		assertEquals(dReview, str1);
	}

	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//How would you know if the strings entered were correct if you only checked if they were not null??
	//Finished writing test -- Luou Wen 6/4/2017 
	//Passed 6/4/2017
	@Test
	public void test_Main_isScore_isReview(){
		try{
			review = new WorkshopReview(4, "great");
		}catch(Exception e){
		}
//		assertNotNull(review.getRScore()); 
//		assertNotNull(review.getRReview());
		
		int dScore = review.getRScore();
		assertEquals(dScore, 4);
		
		String dReview = review.getRReview();
		assertEquals(dReview, str2);
	}

	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//test error thrown when below minimum amount of text (5 characters)
	//Failed - No exception thrown for text too short - 6/4/2017
	@Test
	public void test_Main_ReviewErrorThrown(){
		try{
			review = new WorkshopReview(4, "word");
		}catch(Exception e){
			if (e.getClass()==Exception.class){
				return;
			}
		}
		fail();
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//Passed - 6/4/2017
	@Test
	public void test_GetScore(){
	    int Returnedscore = review.getRScore();
	    assertNotNull(Returnedscore);
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG, Luou WEN
	//Added different out of range variables -- L WEN
	//Failed - no exception caught - 6/4/2017
	@Test
	public void test_SetScore_OutofRange(){
		Boolean errThrown1 = false;
		Boolean errThrown2 = false;
		Boolean errThrown3 = false;
		int score = 6;
		try {
			review.setRScore(score); 
		}catch(Exception e){
			if (e.getClass()==Exception.class){
				errThrown1 = true;
			}
		}
		
		score = -1;
		try {
			review.setRScore(score); 
		}catch(Exception e){
			if (e.getClass()==Exception.class){
				errThrown2 = true;
			}
		}
		
		score = -4;
		try {
			review.setRScore(score); 
		}catch(Exception e){
			if (e.getClass()==Exception.class){
				errThrown3 = true;
			}
		}
		
		if(errThrown1 && errThrown2 && errThrown3){
			return;
		}
		fail();
	}

	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//Finished writing test -- Luou Wen 6/4/2017
	//Passed - 6/4/2017
	@Test
	public void test_SetScore_InRange(){ 
		int score = 1;
		try {
			review.setRScore(score); 
		}catch(Exception e){
		}
		assertEquals(1, review.getRScore());
	}
	
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//Passed - 6/4/2017
	@Test
	public void test_GetReview(){
			String Returnreview = review.getRReview();
	        assertNotNull(Returnreview);
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//Finished writing -- WEN 6/4/2017
	//Failed - no exception caught - 6/4/2017
	@Test
	public void test_SetReviewErrorThrown(){ 
		try {
			review.setRReview(str3); 
		}catch(Exception e){
			if (e.getClass()==Exception.class){
				return;
			}
		}
		fail();
	}
	
	//Date Created: 06-04-17; Author: Luou WEN
	//Passed - 6/4/2017
	@Test
	public void test_SetReview(){ 
		review.setRReview(str2);
		assertEquals("great", review.getRReview());
	}
	
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//Passed - 6/4/2017
	@Test
	public void test_toString(){
		String toString = review.toString();
	    assertTrue(toString.contains("Score = " + WorkshopReview.ROutputs[review.getRScore()] + "\n Review: " + review.getRReview() + "\n"));
	}
}
