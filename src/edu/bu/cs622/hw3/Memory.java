package edu.bu.cs622.hw3;

import java.sql.Timestamp;
import java.util.HashMap;

public class Memory {
	// create memory to keep track of search criteria and frequency
		
	// private fields to keep track of records
	private HashMap<Timestamp, String> searchHistory;
    
    // Constructor
    public Memory() { searchHistory = new HashMap<>(); }

    // getters and setters
   
	public HashMap<Timestamp, String> getSearchHistory() {
		return searchHistory;
	}

	public void setSearchHistory(HashMap<Timestamp, String> searchHistory) {
		this.searchHistory = searchHistory;
	}
    
	// returns frequency of searches in sensor
	int getSensorSearchFrequency() {
		return searchHistory.size();
	}
   
	// called when regexSearch() is executed
	// adds current time and search keyword to memory
	void addToSearchHistory(String keyword) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.searchHistory.put(timestamp, keyword);
	}
	
	// prints frequency and timestamps for each memory
	void printSearchHistory() {
		System.out.println("frequency: " + this.getSensorSearchFrequency());
		this.searchHistory.forEach((k, v) -> {
			System.out.println(k + "\t" + v);
		});
	}
	
	
}
