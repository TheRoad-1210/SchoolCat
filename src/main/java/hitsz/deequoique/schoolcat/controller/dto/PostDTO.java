package hitsz.deequoique.schoolcat.controller.dto;

import lombok.Data;

/**
 * @author deequoique
 */
@Data
public class PostDTO {
    private String userId;
    private String title;
    private String txt;
    private String image;
    private String address;
    private Integer catId;
}
