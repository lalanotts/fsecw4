
public class WorkshopReview {
	private int RScore;
	private String RReview;
	public static String[] ROutputs = new String[]{"*","**","***","****","*****"};
	//private static String[] ROutputs = new String[]{"*","**","***","****","*****"};
	//temporarily changed to public for testing
	
	public WorkshopReview() {
		RScore = 0;
		RReview = "No Review";
	}
	
	public WorkshopReview(int rScore, String rReview) throws Exception{
		if (rReview.length() >= 5){
			RScore = rScore;
			RReview = rReview;
		}else
			throw new Exception();
	}
	public int getRScore() {
		return RScore;
	}
	public void setRScore(int rScore) throws Exception{
		if (rScore >= 1 && rScore <= 5){
			RScore = rScore;
		}else
			throw new Exception();
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
