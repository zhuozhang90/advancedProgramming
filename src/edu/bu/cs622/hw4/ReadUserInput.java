package edu.bu.cs622.hw4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.ocpsoft.prettytime.nlp.PrettyTimeParser;
import edu.stanford.nlp.simple.*;


public class ReadUserInput {
	
	public static String readInputDate(String inputStr) {
		// get date from user input
		List<Date> dates = new PrettyTimeParser().parse(inputStr);
	    System.out.println(dates);
	    // format date into given format to match format used in dbs
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = formatter.format(dates.get(0)); 
	    
	    return strDate;
	}
	
	public static boolean getUserIntent(String inputStr, String intent) {
		// get user intent by identifying keywords
		Document doc = new Document(inputStr);
        for (Sentence sent : doc.sentences()) {  
        	// tokenize words and lemmanize into original form
            if (sent.lemmas().contains(intent)) return true;
        }
        return false;
 	
	}

}
