package hitsz.deequoique.schoolcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author deequoique
 */
@Data
@AllArgsConstructor
public class Food {
    private int id;
    private int brand;
    private int category;
    public Food(int brand, int category){
        this.brand = brand;
        this.category = category;
    }
}
