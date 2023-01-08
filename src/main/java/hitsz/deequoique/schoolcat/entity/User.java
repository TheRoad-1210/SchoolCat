package hitsz.deequoique.schoolcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author deequoique
 */
@Data
@AllArgsConstructor
public class User {
    private String id;
    private String password;
    private Boolean power;
    private String name;
    private String image;

    public User(String id, String password, Boolean power) {
        this.id = id;
        this.password = password;
        this.power = power;
    }
}
