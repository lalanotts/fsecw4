import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class WorkshopPaperTest {
	
	WorkshopReview[] testReviews = new WorkshopReview[3];
	
	@Before 
	public void setup(){
		for (int i = 0; i < 3; i++){
			testReviews[i] = new WorkshopReview();
			testReviews[i].setRScore(i+1);
			testReviews[i].setRReview("Review " + (i+1) + " contents");
		}	
	}
	//Date Created: 31-03-17; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Passed - 2/4/17 21:32
	@Test
	public void testWPDefaultConstructor() {
		WorkshopPaper testPaper = new WorkshopPaper();
		assertEquals("New Paper", testPaper.PTitle);
		assertNull(testPaper.PReviews[0]);
		assertNull(testPaper.PReviews[1]);
		assertNull(testPaper.PReviews[2]);
	}
	
	//Date Created: 31-03-17; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Failed - no error created - 2/4/17 21:32
	@Test
	public void testWPMainConstructorErrorCreated() {
		WorkshopPaper testPaper = null;
		try{
			testPaper = new WorkshopPaper("");
		} catch (Exception e){
			if (e.getClass()==Exception.class){
				assertNull(testPaper.PReviews[0]);
				assertNull(testPaper.PReviews[1]);
				assertNull(testPaper.PReviews[2]);
				return;
			}
		}
		fail();
	}
	

	//Date Created: 31-03-17; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Passed - 2/4/17 21:32
	@Test
	public void testWPMainConstructorNormalInput(){
		WorkshopPaper testPaper = new WorkshopPaper("Paper Title");
		assertEquals("Paper Title", testPaper.PTitle);
		assertNull(testPaper.PReviews[0]);
		assertNull(testPaper.PReviews[1]);
		assertNull(testPaper.PReviews[2]);
	}
	
// -- NOT SURE IF NEEDED
//	//Date Created: 31-03-17; Authors: Luou WEN, Yanting SHEN
//	//Failed - check association - 31/3/17 21:00
//	//Passed - 2/4/17 21:32
//	@Test
//	public void testgetPTitle(){
//		WorkshopPaper testPaper = new WorkshopPaper("Title");
//		String testPTitle = testPaper.getPTitle();
//		assertEquals("Title", testPTitle);
//	}
//	
//	//Date Created: 31-03-17 19:13; Authors: Luou WEN, Yanting SHEN]
//	//--test not implemented
//	@Test
//	public void testsetPTitle(){
//		fail();
//	}
	
	
	//Date Created: 31-03-17 18:54; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Failed - No error created - 2/4/17 21:32
	@Test
	public void testaddReviewNullErrorCreated(){
		WorkshopReview testReview = null;
		WorkshopPaper testPaper = new WorkshopPaper();
		try{
			testPaper.addReview(testReview);
		} catch (Exception e){
			if (e.getClass()==Exception.class){
				return;
			}
		}
		fail();
	}
	
	//Date Created: 31-03-17 19:30; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Passed - 2/4/17 21:32 
	@Test
	public void testaddReviewNormalInput(){
		WorkshopReview testReview = new WorkshopReview();
		WorkshopPaper testPaper = new WorkshopPaper();
		testPaper.addReview(testReview);
		assertNotNull(testPaper.PReviews[0]);
		testPaper.addReview(testReview);
		assertNotNull(testPaper.PReviews[1]);
		testPaper.addReview(testReview);
		assertNotNull(testPaper.PReviews[2]);
	}
	
	//Date Created: 31-03-17 19:17; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Failed - No error created - 2/4/17 21:32
	@Test
	public void testaddReviewOverLimitErrorCreated(){
		WorkshopReview testReview = new WorkshopReview();
		WorkshopPaper testPaper = new WorkshopPaper();
		for (int i = 0; i < 3; i++){
			testPaper.addReview(testReview);
		}
		try{
			testPaper.addReview(testReview);
		} catch (Exception e){
			if (e.getClass()==Exception.class){
				return;
			}
		}
		fail();
	}
		
	//Date Created: 31-03-17 19:45; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Failed - No error created - 2/4/17 21:32
	@Test
	public void testgetAverageScoreNoScore(){
		WorkshopPaper testPaper = new WorkshopPaper();
		try{
			testPaper.getAverageScore();
		} catch (Exception e){
			if (e.getClass()==Exception.class){
				return;
			}
		}
		fail();
	}
	
	//Date Created: 31-03-17 20:19; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Passed - code correctly implemented - 4/4/2017 - 16:17
	@Test
	public void testgetAverageScoreOutputCorrect(){
		WorkshopPaper testPaper = new WorkshopPaper();
		float testVar = 0.0F;
		for (int i = 0; i < 3; i++){
			testPaper.addReview(testReviews[i]);
		}
		testVar = testPaper.getAverageScore();
		assertEquals(2.0, testVar, 0.0002);
	}
	
	//Date Created: 31-03-17 20:35; Authors: Luou WEN, Yanting SHEN
	//Failed - check association - 31/3/17 21:00
	//Failed - Output did not match - 4/4/17 16:04
	@Test
	public void testtoString(){
		WorkshopPaper testPaper = new WorkshopPaper();
		String testOutput = "";
		String expectedOutput = "";
		expectedOutput = "Average Score = **\n\n"; //ROutputs index[0~4] Math.round.out[1~5] - 31/3/17
		expectedOutput += "Review 1:\n" + "Score = *\n" + "Review 1 contents\n";
		expectedOutput += "Review 2:\n" + "Score = **\n" + "Review 2 contents\n";
		expectedOutput += "Review 3:\n" + "Score = ***\n" + "Review 3 contents\n";
		for (int i = 0; i < 3; i++){
			testPaper.addReview(testReviews[i]);
		}
		testOutput = testPaper.toString();
		assertEquals(expectedOutput, testOutput);
	}
}
