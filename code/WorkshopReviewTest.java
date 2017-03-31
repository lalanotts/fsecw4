import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
//import org.junit.After;

public class WorkshopReviewTest {
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	WorkshopReview Treview = new WorkshopReview();
	int input1;
    String input2;
    
	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	@Test
	public void test_Default() {
		WorkshopReview reviewobject = new WorkshopReview();
		reviewobject.WorkshopReview();
		assertEquals(Treview, reviewobject.WorkshopReview());
		//fail("Not yet implemented");
	}

	//Date Created: 31-03-17; Authors: Chaoqun ZHANG, Junsong YANG
	//--unfinished
	@Test
	public void test_Main(){
		WorkshopReview View = Treview.WorkshopReview(input1, input2);
		assertEquals(Treview, reviewobject.WorkshopReview());
		// test: contain a reasonable minimum amount of text.
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
