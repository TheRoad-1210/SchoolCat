package hitsz.deequoique.schoolcat.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author deequoique
 */
@Data
public class CatHomeDTO {
    private BigDecimal id;
    private String name;
    private String picture;
    private String txt;
}
