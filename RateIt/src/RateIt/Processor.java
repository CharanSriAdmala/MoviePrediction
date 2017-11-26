package RateIt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Processor {

	public static ArrayList<String> getAllCast() throws SQLException {
		ArrayList<String> cast = null;
		ResultSet rs = null;
		
		/* run a query to get cast names*/
		while(rs.next()) {
			cast.add(rs.getString("Cname"));
		}
		
		return cast; 
	}
	
	public static double getCastRating(String castName) throws SQLException{
		Map<Integer,Double> movieRatings = null;
		Map<Integer,Integer> yearCount = null;
		ResultSet rs = null;
		ArrayList<Integer> years= null;
		/* run query to get movie ratings of this particular cast*/
		int numberOfMappings =0;
		while(rs.next()) {
			
			int year = rs.getInt("year");
			double rating = rs.getDouble("rating");
			if(movieRatings.containsKey(year)) {
				double value = movieRatings.get(year);
				int count = yearCount.get(year);
				movieRatings.replace(year, value+rating);
				yearCount.replace(year,count+1);
			}
			else {
				movieRatings.put(year,rating);
				yearCount.put(year,1);
				
			}
			numberOfMappings++;
		}
		int counter = numberOfMappings;
		int curr_year = 2020;
		double ratingTotal = 0.0;
		while(curr_year!= 1900) {
			if(movieRatings.containsKey(curr_year)) {
				ratingTotal = ratingTotal + counter*yearCount.get(curr_year)*movieRatings.get(curr_year);
				counter = counter - yearCount.get(curr_year);
			}
			
			curr_year--;
		}
		double finalRating = ratingTotal/counter;
		
		return finalRating;
	}

	public static void setRating(String cast, double rating) {
		
		/* query to set rating of the cast */
		
	}
	
	
}
