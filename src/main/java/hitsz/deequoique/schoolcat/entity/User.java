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

}
