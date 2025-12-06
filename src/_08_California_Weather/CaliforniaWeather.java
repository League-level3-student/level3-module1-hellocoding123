package _08_California_Weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
    
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Search weather conditions in cities");
	JButton button2 = new JButton("Search cities with weather conditions");
	JButton button3 = new JButton("Search cities based on temperature range");
	
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	
    void start() {
        
        
        // All city keys have the first letter capitalized of each word
        
    	
    	frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		
        //1
        
        //2
       
        
        //3
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			String cityName = Utilities.capitalizeWords(JOptionPane.showInputDialog(null, "What city?"));
	        WeatherData datum = weatherData.get(cityName);
	        
	        if( datum == null ) {
	            System.out.println("Unable to find weather data for: " + cityName);
	        } else {
	            System.out.println(cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
	        }
		}
		
		if(e.getSource() == button2) {
			 String weather = Utilities.capitalizeWords(JOptionPane.showInputDialog(null, "Specific weather conditions?"));
		        String cities = "";
		        
		        for(String city : weatherData.keySet()){
		            if(weatherData.get(city).weatherSummary.equals(weather)) {
		            	cities = cities + city + ", ";
		            }
		        }
		        
		        if(cities.equals("")) {
		        	System.out.println("No city found with weather");
		        }
		        else {
		        	System.out.println(cities);
		        }
		}
		
		if(e.getSource() == button3) {
			String cities = "";
	        
	        int minTemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Input minimum temperature"));
	        int maxTemp = Integer.parseInt(JOptionPane.showInputDialog(null, "Input maximum temperature"));
	        
	        for(String city : weatherData.keySet()){
	            if(weatherData.get(city).temperatureF >= minTemp && weatherData.get(city).temperatureF <= maxTemp) {
	            	cities = cities + city + ", ";
	            }
	        }
	        
	        if(cities.equals("")) {
	        	System.out.println("No city found in temperature range");
	        }
	        else {
	        	System.out.println(cities);
	        }
		}
	}
    
}
