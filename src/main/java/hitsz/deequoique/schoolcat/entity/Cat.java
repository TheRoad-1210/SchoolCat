package hitsz.deequoique.schoolcat.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author deequoique
 */
@Data
public class Cat {
     private BigDecimal id;
     private String name;
     private boolean sex;
     private String kind;
     private boolean breed;
     private byte[] picture;
     private String txt;
     private int status;

}
