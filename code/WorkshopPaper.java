
public class WorkshopPaper {
	//Changed all variables from private to public for testing -- WEN & SHEN
	public String PTitle;
	public WorkshopReview[] PReviews;
	public static String[] ROutputs = new String[]{"","*","**","***","****","*****"};

	public WorkshopPaper() {
		PTitle = "New Paper";
		PReviews = new WorkshopReview[3];
		PReviews[0] = null;
		PReviews[1] = null;
		PReviews[2] = null;
	}
	
	public WorkshopPaper(String pTitle) throws Exception {
		if(pTitle.length() != 0){
			PTitle = pTitle;
			PReviews = new WorkshopReview[3];
			PReviews[0] = null;
			PReviews[1] = null;
			PReviews[2] = null;
		}else
			throw new Exception();
	}

	public String getPTitle() {
		return PTitle;
	}

	public void setPTitle(String pTitle)  throws Exception {
		if(pTitle.length() != 0){
			PTitle = pTitle;
		}else
			throw new Exception();
	}
	
	public void addReview(WorkshopReview nReview) throws Exception{
		if(nReview != null){
			if (PReviews[0] == null)
				PReviews[0] = nReview;
			else {
				if (PReviews[1] == null)
					PReviews[1] = nReview;
				else {
					if (PReviews[2] == null)
						PReviews[2] = nReview;
					else 
						throw new Exception();
				}
			}
		}else
			throw new Exception();		
	}
	
	public float getAverageScore() throws Exception{
		float AvgScore = 0;
		int numReviews = 0;
		if (PReviews[0] != null){
			AvgScore += PReviews[0].getRScore();
			numReviews++;
		}
		if (PReviews[1] != null){
			AvgScore += PReviews[1].getRScore();
			numReviews++;
		}
		if (PReviews[2] != null){
			AvgScore += PReviews[2].getRScore();
			numReviews++;
		}
		if (numReviews == 0){
			throw new Exception();
		}
		AvgScore = AvgScore/numReviews; //what if numReviews = 0 - 31/3/17
		return AvgScore;
	}
	
	public String toString(){
		String myoutput = "";
		try {
			myoutput = "Average Score = " + ROutputs[Math.round(getAverageScore())] + "\n\n";
		} catch (Exception e) {} //ROutputs index[0~4] Math.round.out[1~5] - 31/3/17
		myoutput += "Review 1:\n" + PReviews[0].toString() + "\n";
		myoutput += "Review 2:\n" + PReviews[1].toString() + "\n";
		myoutput += "Review 3:\n" + PReviews[2].toString() + "\n";
		return myoutput;
	}
	
}
