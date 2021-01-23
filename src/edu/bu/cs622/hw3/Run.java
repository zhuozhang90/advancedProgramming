package edu.bu.cs622.hw3;

import java.io.IOException;
import java.util.List;

public class Run {
		
	// generated file paths from file merge
	private static String activFitFileMerged;
	private static String activityFileMerged;
	private static String batterySensorFileMerged;
	private static String bluetoothFileMerged;
	private static String lightSensorFileMerged;
	private static String heartRateFileMerged;
	private static String screenUsageFileMerged;
	
	private static Sensor activFitSensor;
	private static Sensor activitySensor;
	private static Sensor batterySensor;
	private static Sensor bluetoothSensor;
	private static Sensor lightSensor;
	private static Sensor heartRateSensor;
	private static Sensor screenUsageSensor;
	
	public static void setUpSensors() throws IOException {
		
		// merge files and list of all files from directory
		List<String> files = FileMerge.listFiles(Constants.DATA_PATH);
		
		// get list of files in each category
		List<String> activFitFiles = FileMerge.separateFileList(files, Constants.ACTIVFIT_SENSOR);
		List<String> activityFiles = FileMerge.separateFileList(files, Constants.ACTIVITY_SENSOR);
		List<String> batterySensorFiles = FileMerge.separateFileList(files,Constants. BATTERY_SENSOR);
		List<String> bluetoothFiles = FileMerge.separateFileList(files, Constants.BLUETOOTH_SENSOR);
		List<String> lightSensorFiles = FileMerge.separateFileList(files, Constants.LIGHT_SENSOR);
		List<String> heartRateFiles = FileMerge.separateFileList(files, Constants.HEART_RATE_SENSOR);
		List<String> screenUsageFiles = FileMerge.separateFileList(files, Constants.SCREEN_USAGE_SENSOR);
		
		// merge all files
		activFitFileMerged = FileMerge.mergeFiles(activFitFiles, Constants.ACTIVFIT_FILE_PATH);
		activityFileMerged = FileMerge.mergeFiles(activityFiles, Constants.ACTIVITY_FILE_PATH);
		batterySensorFileMerged = FileMerge.mergeFiles(batterySensorFiles, Constants.BATTERY_SENSOR_FILE_PATH);
		bluetoothFileMerged = FileMerge.mergeFiles(bluetoothFiles, Constants.BLUETOOTH_FILE_PATH);
		lightSensorFileMerged = FileMerge.mergeFiles(lightSensorFiles, Constants.LIGHT_SENSOR_FILE_PATH);
		heartRateFileMerged = FileMerge.mergeFiles(heartRateFiles, Constants.HEART_RATE_SENSOR_FILE_PATH);
		screenUsageFileMerged = FileMerge.mergeFiles(screenUsageFiles, Constants.SCREEN_USAGE_SENSOR_FILE_PATH);
		
		// construct Sensors
		// add sensor names, file paths and memories to the sensors
		activFitSensor = new Sensor(Constants.ACTIVFIT_SENSOR, activFitFileMerged);
		activitySensor = new Sensor(Constants.ACTIVITY_SENSOR, activityFileMerged);
		batterySensor = new Sensor(Constants.BATTERY_SENSOR, batterySensorFileMerged);
		bluetoothSensor = new Sensor(Constants.BLUETOOTH_SENSOR, bluetoothFileMerged);
		lightSensor = new Sensor(Constants.LIGHT_SENSOR, lightSensorFileMerged);
		heartRateSensor = new Sensor(Constants.HEART_RATE_SENSOR, heartRateFileMerged);
		screenUsageSensor = new Sensor(Constants.SCREEN_USAGE_SENSOR, screenUsageFileMerged);
	}
	
	private static void reportSearchHistory() {
		
		activFitSensor.printSearchHistory();
		activitySensor.printSearchHistory();
		batterySensor.printSearchHistory();
		bluetoothSensor.printSearchHistory();
		lightSensor.printSearchHistory();
		heartRateSensor.printSearchHistory();
		screenUsageSensor.printSearchHistory();
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// merge files and construct Sensors
		setUpSensors();
						
		// test searching files
		// adding sleep() to make sure each entry is saved. see read.me at "known issues"
		activFitSensor.regexSearch("test");
		Thread.sleep(1);
		activFitSensor.regexSearch("test");
		Thread.sleep(1);
		activFitSensor.regexSearch("test2");
		Thread.sleep(1);
		activFitSensor.regexSearch("test3");
		Thread.sleep(1);
		
		activitySensor.regexSearch("test");
		Thread.sleep(1);
		activitySensor.regexSearch("test1");
		Thread.sleep(1);
		activitySensor.regexSearch("test2");
		Thread.sleep(1);
		
		batterySensor.regexSearch("test");
		Thread.sleep(1);
		batterySensor.regexSearch("test1");
		Thread.sleep(1);
		
		bluetoothSensor.regexSearch("test");
		Thread.sleep(1);
		bluetoothSensor.regexSearch("test1");
		Thread.sleep(1);
		bluetoothSensor.regexSearch("test1");
		Thread.sleep(1);
		bluetoothSensor.regexSearch("test1");
		Thread.sleep(1);
		
		lightSensor.regexSearch("test");
		Thread.sleep(1);
		lightSensor.regexSearch("test1");
		Thread.sleep(1);
		
		heartRateSensor.regexSearch("test");
		Thread.sleep(1);
		
		screenUsageSensor.regexSearch("test");
		
		// report search history
		reportSearchHistory();

	}
}
