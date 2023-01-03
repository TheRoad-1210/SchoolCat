package hitsz.deequoique.schoolcat.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author deequoique
 */
@Data
public class CatHomeDTO {
    private BigDecimal id;
    private String name;
    private byte[] picture;
    private String catDescribe;
}
