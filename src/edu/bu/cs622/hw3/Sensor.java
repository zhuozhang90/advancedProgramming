package edu.bu.cs622.hw3;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;

public class Sensor {
	
	// a class to help incorporate memory in searching 
	// without having to pass in extra params
	
	private String sensorName;
	private String filePath;
	private Memory memory;

	// constructor
	public Sensor() { };
	
	public Sensor(String sensorName, String filePath) {
		this.sensorName = sensorName;
		this.filePath = filePath;
		this.memory = new Memory();
	}
	
	// getters and setters
	
	public String getSensorName() {
		return sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}
	
	// non-static search function to include timestamp 
	public void regexSearch(String keyword) throws IOException {
		this.memory.addToSearchHistory(keyword);
		FileSearch.regexSearch(this.filePath, keyword);
	}
	
	// wrapper for Memory methods
	
	public HashMap<Timestamp, String> getSearchHistory() {
		return this.getMemory().getSearchHistory();
	}
	
	public void addToSearchHistory(String keyword) {
		this.getMemory().addToSearchHistory(keyword);
	}
	
	public int getSensorSearchFrequency() {
		return this.getMemory().getSensorSearchFrequency();
	}
	
	public void printSearchHistory() {
		System.out.println("\nSensor: " + this.sensorName);
		this.getMemory().printSearchHistory();
	}


}
