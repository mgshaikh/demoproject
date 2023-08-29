package org.learn;


import java.util.ArrayList;
import java.util.List;



/* Implementation of Observer design pattern for a WeatherStation for temperature state  with a list of observers*/
public class ObserverDemo {

	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		weatherStation.addObserver(new TemperatureObserver());
        weatherStation.addObserver(new TemperatureObserver());
		weatherStation.setTemperature(20);
		weatherStation.setTemperature(30);
		weatherStation.setTemperature(40);
		weatherStation.setTemperature(50);
	}
}

/* WeatherStation is the subject that will notify the observers */
class WeatherStation extends Subject {
	private int temperature;

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
		notifyObservers();
	}
}

/* TemperatureObserver is an observer that will be notified by the subject */
class TemperatureObserver implements Observer {
	@Override
	public void update(Subject subject) {
		System.out.println("Temperature updated to " + ((WeatherStation) subject).getTemperature());
	}
}

/* Subject is the base class for all subjects */
abstract class Subject {
	private List<Observer> observers = new ArrayList<>();

	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
}

/* Observer is the base class for all observers */
interface Observer {
	public void update(Subject subject);
}