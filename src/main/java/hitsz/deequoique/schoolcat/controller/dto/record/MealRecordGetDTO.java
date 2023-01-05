package hitsz.deequoique.schoolcat.controller.dto.record;

import lombok.Data;

/**
 * @author deequoique
 */
@Data
public class MealRecordGetDTO {
    private int category;
    private int brand;
    private int cat;
    private int userId;
    private String location;
}
