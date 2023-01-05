package hitsz.deequoique.schoolcat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author deequoique
 */
@Data
public class MealRecord {
    int id;
    String userName;
    String category;
    String brand;
    Timestamp time;
    String location;
    byte[] image;

}
