
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
	
	public WorkshopReview(int rScore, String rReview) {
		RScore = rScore;
		RReview = rReview;
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
