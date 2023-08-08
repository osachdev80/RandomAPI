package randomactivity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RandomActivity {

    private String activity;
    private String type;
    private int participants;
    private double price;
    private String key;
    private String accessibility;
}
