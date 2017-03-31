import static org.junit.Assert.*;

import org.junit.Test;

public class WorkshopPaperTest {
	
	//Date Created: 31-03-17; Authors: Luou WEN, Yanting SHEN
	//Failed - not implemented - 31/3/17 21:00
	//Passed - 31/3/17
	@Test
	public void testWPDefaultConstructor() {
		WorkshopPaper testPaper = new WorkshopPaper();
		assertEquals("New Paper", testPaper.PTitle);
		assertNull(testPaper.PReviews[0]);
		assertNull(testPaper.PReviews[1]);
		assertNull(testPaper.PReviews[2]);
	}
	
	//Date Created: 31-03-17; Authors: Luou WEN, Yanting SHEN
	//Failed - not implemented - 31/3/17 21:00
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
	//Failed - not implemented - 31/3/17 21:00
	@Test
	public void testWPMainConstructorNormalInput(){
		WorkshopPaper testPaper = new WorkshopPaper("Paper Title");
		assertEquals("Paper Title", testPaper.PTitle);
		assertNull(testPaper.PReviews[0]);
		assertNull(testPaper.PReviews[1]);
		assertNull(testPaper.PReviews[2]);
	}
	

	//Date Created: 31-03-17; Authors: Luou WEN, Yanting SHEN
	//Failed - not implemented - 31/3/17 21:00
	@Test
	public void testgetPTitle(){
		WorkshopPaper testPaper = new WorkshopPaper("Title");
		String testPTitle = testPaper.getPTitle();
		assertEquals("Title", testPTitle);
	}
	
	//Date Created: 31-03-17 19:13; Authors: Luou WEN, Yanting SHEN]
	//--test not implemented
	@Test
	public void testsetPTitle(){
		fail();
	}
	
	//Date Created: 31-03-17 18:54; Authors: Luou WEN, Yanting SHEN
	//Failed - not implemented - 31/3/17 21:00
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
	//Failed - not implemented - 31/3/17 21:00
	//-- Not sure if correct -- SHEN
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
	//Failed - not implemented - 31/3/17 21:00
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
	//Failed - not implemented - 31/3/17 21:00
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
	//Failed - not implemented - 31/3/17 21:00
	@Test
	public void testgetAverageScoreOutputCorrect(){
		WorkshopPaper testPaper = new WorkshopPaper();
		WorkshopReview[] testReviews = new WorkshopReview[3];
		float testVar = 0.0F;
		for (int i = 0; i < 3; i++){
			testReviews[i].setRScore(i+1);
			testPaper.addReview(testReviews[i]);
		}
		testVar = testPaper.getAverageScore();
		assertEquals(2.0, testVar, 0.0002);
	}
	
	//Date Created: 31-03-17 20:35; Authors: Luou WEN, Yanting SHEN
	//Failed - not implemented - 31/3/17 21:00
	@Test
	public void testtoString(){
		WorkshopPaper testPaper = new WorkshopPaper();
		WorkshopReview[] testReviews = new WorkshopReview[3];
		String testOutput = "";
		String expectedOutput = "Average Score = **\n\nReview 1:\nReview 1 contents\nReview 2:\nReview 2 contents\nReview 3:\nReview 3 contents\n";
		for (int i = 0; i < 3; i++){
			testReviews[i].setRScore(i+1);
			testReviews[i].setRReview("Review " + (i+1) + " contents");
			testPaper.addReview(testReviews[i]);
		}
		testOutput = testPaper.toString();
		assertEquals(expectedOutput, testOutput);
	}
}
