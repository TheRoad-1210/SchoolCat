package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.controller.dto.PostDTO;
import hitsz.deequoique.schoolcat.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author deequoique
 */
@Mapper
public interface ActivityMapper {

    @Select("SELECT a.user_id as userId, a.id as activityId, title, a.image, a.txt, time as activityTime, address, u.name as userName, u.image as userImage, c.name as catName\n" +
            "from activity as a\n" +
            "LEFT JOIN user_info as u\n" +
            "ON a.user_id = u.id " +
            "LEFT JOIN cat c " +
            "ON cat_id = c.id")
    List<Activity> findHome();

    @Insert("INSERT INTO activity(user_id,title,txt,image,address,cat_id) \n" +
            "VALUES(#{userId},#{title},#{txt},#{image},#{address},#{catId})")
    int post(PostDTO postDTO);
}
