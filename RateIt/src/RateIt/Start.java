package RateIt;

import java.sql.SQLException;
import java.util.ArrayList;

public class Start {
		public static void main(String[] args) throws SQLException {
			
			
			// pre processor
			ArrayList<String> castNames = Processor.getAllCast();
			for(int i=0; i< castNames.size();i++) {
				String cast = castNames.get(i);
				double rating = Processor.getCastRating(cast);
				Processor.setRating(cast,rating);
			}
			
			// Train the model
			
			
			// Prediction algorithm
			
			
			
		}
}
