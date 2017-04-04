
public class WorkshopReview {
	private int RScore;
	private String RReview;
	private static String[] ROutputs = new String[]{"*","**","***","****","*****"};
	
	public void WorkShopReview() {
		RScore = 0;
		RReview = "No Review";
	}
	
	public void WorkShopReview(int rScore, String rReview) throws Exception {
		RScore = rScore;
		if (RScore > 5 && RScore < 1){
			Exception e = new Exception("Score is bewteen 1 and 5");
			throw e;
		}
		RReview = rReview;
		
		if (RReview.length() < 5){
			Exception revExcep = new Exception("Minimum amount of text is 5");
			throw revExcep;
			
		}
	}
	public int getRScore() {
		return RScore;
	}
	public void setRScore(int rScore) {
		RScore = rScore;
	}
	public String getRReview() {
		return RReview;
	}
	public void setRReview(String rReview) {
		RReview = rReview;
	}

	@Override
	public String toString() {
		return "Score = " + ROutputs[RScore] + "\n Review: " + RReview + "\n";
	}
	
	
	
}
