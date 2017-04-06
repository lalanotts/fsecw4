import java.util.*;


public class WorkshopReviewSystem {
	//Changed all methods and variables to public for testing -- WEN & SHEN

	public static ArrayList<WorkshopPaper> AllPapers;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//////////////
		//example test data
		//////////////
		AllPapers = new ArrayList<WorkshopPaper>();
		
		WorkshopPaper p1 = new WorkshopPaper("Paper 1 is great");
		p1.addReview(new WorkshopReview(4,"This paper is pretty good."));
		p1.addReview(new WorkshopReview(3,"This paper is good for the workshop."));
		p1.addReview(new WorkshopReview(2, "This paper is pretty mediocre."));
		
		AllPapers.add(p1);
		
		WorkshopPaper p2 = new WorkshopPaper("Paper 2 is my best work");
		p2.addReview(new WorkshopReview(2,"This can hardly be his best work"));
		p2.addReview(new WorkshopReview(1,"Ive read better articles in Hello Magazine"));
		p2.addReview(new WorkshopReview(1,"So painful to read."));
		
		AllPapers.add(p2);
		
		WorkshopPaper p3 = new WorkshopPaper("a");
		p3.addReview(new WorkshopReview(1,"b"));
		p3.addReview(new WorkshopReview(1,"b"));
		p3.addReview(new WorkshopReview(1,"b"));
		AllPapers.add(p3);
		
		
		//PrintPaperOverview();
		//PrintAPaper(0);
		//PrintAPaper(1);
		
		System.out.println("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()){
			String s = in.next();
			try{
				if (s.equals("O")) {
					PrintPaperOverview();
				} else if (s.equals("P")){
					AddPaper(in);
				} else if (s.equals("R")) {
					AddReview(in);
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (Integer.parseInt(s) != -1 ) {
					PrintAPaper(Integer.parseInt(s)-1);
				} else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.toString() + "\n");
			}
			System.out.println("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit");
		}
		in.close();
		
	}
	


	public static void AddPaper(Scanner in) {
		System.out.println("What is the title of the paper?");
		in.nextLine(); // to remove read-in bug
		String title = in.nextLine();
		AllPapers.add(new WorkshopPaper(title));
		System.out.println("[Paper added]");
	}
	

	public static void AddReview(Scanner in) {
		System.out.println("Which paper do you want to add a review to?");
		int x = in.nextInt();
		System.out.println("What score do you give it?");
		int score = in.nextInt();
		System.out.println("Please enter your review:");
		in.nextLine(); //to remove read-in bug
		String review = in.nextLine();
		WorkshopPaper wp = AllPapers.get(x-1);
		wp.addReview(new WorkshopReview(score,review));
		System.out.println("[Review added to Paper " + x + "]");
	}
	
	
//	public static void PrintPaperOverview(){
//		for (int x = 0; x < AllPapers.size(); x++) {
//			WorkshopPaper wp = AllPapers.get(x);
//			System.out.println((x+1) + ") " + wp.getPTitle()+ " - " + wp.getAverageScore());
//		}
//	}
	
	public static String PrintPaperOverview(){
		String test = "";
		for (int x = 0; x < AllPapers.size(); x++) {
			WorkshopPaper wp = AllPapers.get(x);
			test +=  (x+1) + ") " + wp.getPTitle()+ " - " + wp.getAverageScore() + "\n";
		}
		System.out.println(test);
		return test;
	}
	
	public static void PrintAPaper(int paperID) {
		WorkshopPaper wp = AllPapers.get(paperID);
		System.out.print("\nPaper " + (paperID+1) + " - " + wp.toString());
	}

}
