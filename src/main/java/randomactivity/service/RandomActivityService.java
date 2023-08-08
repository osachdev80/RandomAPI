package randomactivity.service;

// RandomActivityService.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import randomactivity.client.ExternalApiClient;
import randomactivity.model.RandomActivity;

@Service
public class RandomActivityService {

    private final ExternalApiClient externalApiClient;

    @Autowired
    public RandomActivityService(ExternalApiClient externalApiClient) {
        this.externalApiClient = externalApiClient;
    }

    public ResponseEntity<RandomActivity> getRandomActivity() {
        ResponseEntity<RandomActivity> response = externalApiClient.getRandomActivity();
        if (response.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.ok(response.getBody());
        } else {
            return ResponseEntity.status(response.getStatusCode()).body(null);
        }
    }
}
