import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import randomactivity.client.ExternalApiClient;
import randomactivity.model.RandomActivity;
import randomactivity.service.RandomActivityService;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RandomActivity.class)
@ComponentScan(basePackages = "randomactivity.controller")
@ContextConfiguration(classes = RandomActivityService.class)

public class RandomActivityTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExternalApiClient externalApiClient;

    @Test
    public void test_getActivityEndPoint() throws Exception {
        RandomActivity randomActivity = RandomActivity.builder()
                .activity("My Activity")
                .accessibility("Accessibilty")
                .key("Key")
                .participants(1)
                .price(2.99)
                .type("Type")
                .build();
        when(externalApiClient.getRandomActivity()).thenReturn(ResponseEntity.of(Optional.of(randomActivity)));
        mockMvc.perform(MockMvcRequestBuilders.get("/randomActivities"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.activity").value("My Activity"))
                .andExpect(jsonPath("$.accessibility").value("Accessibilty"))
                .andExpect(jsonPath("$.key").value("Key"));


    }
}
