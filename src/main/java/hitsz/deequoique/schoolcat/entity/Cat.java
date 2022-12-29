package hitsz.deequoique.schoolcat.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Blob;

/**
 * @author deequoique
 */
@Data
public class Cat {
     private BigDecimal id;
     private String name;
     private boolean sex;
     private Integer kind;
     private boolean breed;
     private Blob picture;
     private String describe;
}
