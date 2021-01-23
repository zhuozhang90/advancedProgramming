package edu.bu.cs622.hw4.mysql;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import edu.bu.cs622.hw4.Constants;
import edu.bu.cs622.hw4.parseRecords.ParseActivFit;
import edu.bu.cs622.hw4.parseRecords.ParseActivity;
import edu.bu.cs622.hw4.parseRecords.ParseBattery;
import edu.bu.cs622.hw4.parseRecords.ParseBluetooth;
import edu.bu.cs622.hw4.parseRecords.ParseHeartRate;
import edu.bu.cs622.hw4.parseRecords.ParseLight;
import edu.bu.cs622.hw4.parseRecords.ParseScreen;
import edu.bu.cs622.hw4.entryObjects.RunningRecord;


public class RunMySQL {
	
	@SuppressWarnings("unused")
	// create all tables from given sql statements
	public static void createAllTables() throws SQLException {
		CreateTables.createTable(Constants.ACTIVFIT_SQL);
		CreateTables.createTable(Constants.ACTIVITY_SQL);
		CreateTables.createTable(Constants.BATTERY_SQL);
		CreateTables.createTable(Constants.HEARTRATE_SQL);
		CreateTables.createTable(Constants.BLUETOOTH_SQL);
		CreateTables.createTable(Constants.LIGHT_SQL);
		CreateTables.createTable(Constants.SCREEN_SQL);
	}
	
	// insert all data into table
	@SuppressWarnings("unused")
	public static void insertAllData() throws SQLException, IOException, org.json.simple.parser.ParseException, ParseException {
		CreateTables.insertActivfitData(ParseActivFit.getActivfitData());
		System.out.println("activfit done");
		CreateTables.insertActivityData(ParseActivity.getActivityData());
		System.out.println("activity done");
		CreateTables.insertBatteryData(ParseBattery.getBatteryData());
		System.out.println("battery done");
		CreateTables.insertHeartRateData(ParseHeartRate.getHeartRateData());
		System.out.println("heartrate done");
		CreateTables.insertBluetoothData(ParseBluetooth.getBluetoothData());
		System.out.println("bluetooth done");
		CreateTables.insertLightData(ParseLight.getLightData());
		System.out.println("light done");
		CreateTables.insertScreenData(ParseScreen.getScreenData());
		System.out.println("screen done");
		System.out.println("all collections created and populated.");
	}
	
	// wrappes for Query methods
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
