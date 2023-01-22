package hitsz.deequoique.schoolcat.entity.dto.record;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author deequoique
 */
@Data
@AllArgsConstructor

public class MealRecordDTO {
    private int food;
    private int cat;
    private String userId;
    private String location;

}
