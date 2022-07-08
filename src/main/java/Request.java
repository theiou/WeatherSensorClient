import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Request {
    public static final RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        Random random = new Random();
        String sensorName = "new_sensor";
        registerSensor(sensorName);

        for (int i = 0; i < 1000; i++)
        sendWeather(random.nextDouble() * 100, random.nextBoolean(), sensorName);

    }

    private static void registerSensor(String sensorName){
        final String URL = "http://localhost:8080/sensors/registration";
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", sensorName);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend);
        String response = restTemplate.postForObject(URL, request, String.class);
        System.out.println(response);
    }

    private static void sendWeather(double value, Boolean raining, String sensorName){
        final String URL = "http://localhost:8080/weather/add";

        Map<String, Object> jsonToSend = new HashMap<>();
        jsonToSend.put("value", value);
        jsonToSend.put("raining", raining);
        jsonToSend.put("sensor", sensorName);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(jsonToSend);
        String response  = restTemplate.postForObject(URL, request, String.class);
        System.out.println(response);
    }
}
