package randomactivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import randomactivity.model.RandomActivity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import randomactivity.service.RandomActivityService;

@RestController
public class RandomActivityController {

    private RandomActivityService randomActivityService;

    @Autowired
    public RandomActivityController (RandomActivityService randomActivityService) {
        this.randomActivityService = randomActivityService;
    }
    @GetMapping("/randomActivities")
    public ResponseEntity<RandomActivity> getRandomActivities() {
        return randomActivityService.getRandomActivity();

    }
}
