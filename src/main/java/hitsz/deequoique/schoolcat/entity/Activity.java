package hitsz.deequoique.schoolcat.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author deequoique
 */
@Data
public class Activity {
    private String userId;
    private String userName;
    private byte[] userImage;
    private String activityId;
    private String title;
    private String txt;
    private byte[] image;
    private Timestamp activityTime;
    private String address;
    private String catName;
}
