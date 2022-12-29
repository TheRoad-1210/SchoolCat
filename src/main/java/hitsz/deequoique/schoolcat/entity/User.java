package hitsz.deequoique.schoolcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author deequoique
 */
@Data
@AllArgsConstructor
public class User {
    private BigDecimal id;
    private String password;
    private Boolean status;

}
