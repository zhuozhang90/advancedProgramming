package edu.bu.cs622.hw4;

import edu.bu.cs622.hw4.mysql.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.json.simple.parser.ParseException;
import org.ocpsoft.prettytime.nlp.PrettyTimeParser;

import edu.bu.cs622.hw4.mongodb.*;

public class Run {
	
	// create dbs and insert data
	public static void setUpDB() throws SQLException, IOException, ParseException, java.text.ParseException {
		RunMySQL.createAllTables();
		RunMySQL.insertAllData();
		RunMongoDB.insertAllData();
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws SQLException, IOException, ParseException, java.text.ParseException {
		
		// comment this out if dbs already set up
		setUpDB();
		
		Scanner  scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("What do you want to ask me about?");
			String inputStr = scanner.nextLine();
			
	//		String inputStr = "how many steps did i walk on june 09 2016"; 
			
			// get date from string
			List<Date> dates = new PrettyTimeParser().parse(inputStr);
			String strDate = null;
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    if (dates.size() > 0) strDate = formatter.format(dates.get(0));  
		    else {
		    	System.out.println("please include a date.");
		    	continue;
		    }
		    
	//	    System.out.println(strDate);
		    
		    // get user intent
		    // check if asked about running
		    if (ReadUserInput.getUserIntent(inputStr, "run")) {
		    	System.out.println("querying from MySQL: ");
				RunMySQL.getRunningData(strDate);
		    	System.out.println("querying from MongoDB: ");
				RunMongoDB.getRunningData(strDate);
				// check if asked about heartrate
		    } else if (ReadUserInput.getUserIntent(inputStr, "heart") ||
		    		ReadUserInput.getUserIntent(inputStr, "heartrate")) {
		    	System.out.println("querying from MySQL: ");
				RunMySQL.getHeartrateNotificationCount(strDate);
		    	System.out.println("querying from MongoDB: ");
				RunMongoDB.getHeartrateNotificationCount(strDate);
				// check if asked about step count
		    } else if (ReadUserInput.getUserIntent(inputStr, "step") ||
		    		ReadUserInput.getUserIntent(inputStr, "stepcount")) {
		    	System.out.println("querying from MySQL: ");
		    	RunMySQL.getTotalSteps(strDate);
		    	System.out.println("querying from MongoDB: ");
				RunMongoDB.getTotalSteps(strDate);
		    } else {
		    	System.out.println("Sorry, I did understand that. ");
		    }
		    
	    
		}
	
	}

}
