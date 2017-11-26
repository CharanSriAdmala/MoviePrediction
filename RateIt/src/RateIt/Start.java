package RateIt;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Start {
		public static void main(String[] args) throws SQLException {
			
			
			// pre processor
			ArrayList<String> castNames = Processor.getAllCast();
			for(int i=0; i< castNames.size();i++) {
				String cast = castNames.get(i);
				double rating = Processor.getCastRating(cast);
				Processor.setRating(cast,rating);
			}
			
			// Training
			ArrayList<Integer> weights = new ArrayList<Integer>();
			
			
			
			
			
			
			
			
			
			//Input
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the name of the movie:");
			String movie = sc.next();
			System.out.println("Enter the name of Actor1");
			String actor1 = sc.next();
			System.out.println("Enter the name of Actor2");
			String actor2 = sc.next();
			System.out.println("Enter the name of Actor3");
			String actor3 = sc.next();
			System.out.println("Enter the name of Director");
			String director = sc.next();
			
			
			// Prediction algorithm
			Map<String,Double> averageRating = Prediction.getAverageRating();
			
			/* some math calculation to calculate rating by 
			 * adjusting the weights with influence factors
			 */
			
		}

		
}
