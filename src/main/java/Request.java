import entities.Weather;
import entities.WeatherList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {
    public static final RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        registerSensor("123");
    }

    private static void registerSensor(String sensorName){
        final String URL = "http://localhost:8080/sensors/registration";
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "sensor10");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        String response = restTemplate.postForObject(URL, request, String.class);
        System.out.println(response);
    }
}
