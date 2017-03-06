package hu.bme.mit.train.system;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

import java.util.Date;

public class TrainSystem {

	private Table<String, String, String> tachographTable = HashBasedTable.create();
	private TrainController controller = new TrainControllerImpl();
	private TrainSensor sensor = new TrainSensorImpl(controller);
	private TrainUser user = new TrainUserImpl(controller);

	public TrainSystem() {

		tachographTable.put("Date","101", new Date().toString());
		tachographTable.put("JoystickPosition", "102",
                Integer.toString(user.getJoystickPosition()));
        tachographTable.put("ReferenceSpeed","103",
                Integer.toString(controller.getReferenceSpeed()));
	}

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}

}
