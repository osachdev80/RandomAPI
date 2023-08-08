package randomactivity.client;

// ExternalApiClient.java
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import randomactivity.model.RandomActivity;

@Component
public class ExternalApiClient {

    private final String externalApiUrl = "https://www.boredapi.com/api/activity";

    public ResponseEntity<RandomActivity> getRandomActivity() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(externalApiUrl, RandomActivity.class);
    }
}
