package hitsz.deequoique.schoolcat.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author deequoique
 */
@Data
public class UserDTO {
    private BigDecimal userId;
    private String password;
    private String config;
}
