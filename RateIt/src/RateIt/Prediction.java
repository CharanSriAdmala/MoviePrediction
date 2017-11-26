package RateIt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class Prediction {

	public static Map<String, Double> getAverageRating() throws SQLException {
		Map<String,Double> avg = null;
		ResultSet rs = null;
		
		/* run a query to get average ratings*/
		
		while(rs.next()) {
			avg.put(rs.getString("role"),rs.getDouble("rating"));
		}		
		return avg; 
		
	}
		
	
	
}
