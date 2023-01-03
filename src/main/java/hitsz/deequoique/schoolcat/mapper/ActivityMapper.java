package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author deequoique
 */
@Mapper
public interface ActivityMapper {
    @Select("SELECT user_id as userId, activity_id as activityId, activity_title as title, activity_image as image,\n" +
            "activity_txt as txt,activity_time as activityTime,activity_address as address from activity;")
    List<Activity> findAll();

    @Select("SELECT a.user_id as userId, activity_id as activityId, activity_title as title, activity_image as image,\n" +
            "activity_txt as txt,activity_time as activityTime,activity_address as address, user_name as userName, user_image as userImage\n" +
            "from activity as a\n" +
            "LEFT JOIN user_info as u\n" +
            "ON a.user_id = u.user_id;")
    List<Activity> findHome();
}
