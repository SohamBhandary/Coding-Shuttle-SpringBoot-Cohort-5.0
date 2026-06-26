package com.Soham.Module_9_Spring_AI.Tool;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class TravellingTool {


    @Tool(description = "Get the current weather of a city")
    public String getWeather(
            @ToolParam(description = "Name of the city") String city) {

        return switch (city.toLowerCase()) {

            case "delhi" ->
                    "Delhi: Sunny, 39°C, Humidity 32%, Wind 12 km/h";
            case "mumbai" ->
                    "Mumbai: Heavy Rain, 29°C, Humidity 91%, Wind 18 km/h";
            case "kolkata" ->
                    "Kolkata: Cloudy, 33°C, Humidity 78%, Wind 10 km/h";
            case "bangalore", "bengaluru" ->
                    "Bengaluru: Pleasant, 24°C, Light showers expected in the evening";
            case "chennai" ->
                    "Chennai: Hot and Humid, 35°C, Humidity 82%";

            default ->
                    "Sorry, I don't have weather information for " + city + ".";
        };
    }
}
