package edu.bu.cs622.hw4.mongodb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import edu.bu.cs622.hw4.entryObjects.RunningRecord;
import edu.bu.cs622.hw4.mysql.QueryDB;
import edu.bu.cs622.hw4.parseRecords.ParseActivFit;
import edu.bu.cs622.hw4.parseRecords.ParseActivity;
import edu.bu.cs622.hw4.parseRecords.ParseBattery;
import edu.bu.cs622.hw4.parseRecords.ParseBluetooth;
import edu.bu.cs622.hw4.parseRecords.ParseHeartRate;
import edu.bu.cs622.hw4.parseRecords.ParseLight;
import edu.bu.cs622.hw4.parseRecords.ParseScreen;

@SuppressWarnings("unused")
public class RunMongoDB {
	
	// insert data from all collections
	public static void insertAllData() throws IOException, ParseException, java.text.ParseException {
		CreateCollections.insertActivfitData(ParseActivFit.getActivfitData());
		System.out.println("activfit done");
		CreateCollections.insertActivityData(ParseActivity.getActivityData());
		System.out.println("activity done");
		CreateCollections.insertBatteryData(ParseBattery.getBatteryData());
		System.out.println("battery done");
		CreateCollections.insertHeartRateData(ParseHeartRate.getHeartRateData());
		System.out.println("heartrate done");
		CreateCollections.insertBluetoothData(ParseBluetooth.getBluetoothData());
		System.out.println("bluetooth done");
		CreateCollections.insertLightData(ParseLight.getLightData());
		System.out.println("light done");
		CreateCollections.insertScreenData(ParseScreen.getScreenData());
		System.out.println("screen done");
		System.out.println("all collections created and populated.");

	}
	
	// wrappers for Query methods
	public static void getHeartrateNotificationCount(String date) throws SQLException {
		System.out.println("You got " + QueryDB.getNotificationCount(date) + " heartrate notifications on " + date);	

	}
	
	public static void getTotalSteps(String date) throws SQLException {
		System.out.println("You had " + QueryDB.getTotalSteps(date) + " steps on " + date);

	}
	
	public static void getRunningData(String date) throws SQLException {
		ArrayList<RunningRecord> runningRecords = QueryDB.getRunningRecords(date);
		if (!runningRecords.isEmpty()) {
			runningRecords.forEach(System.out::println);
		} else {
			System.out.println("You didn't run that day.");
		}
	}

}
