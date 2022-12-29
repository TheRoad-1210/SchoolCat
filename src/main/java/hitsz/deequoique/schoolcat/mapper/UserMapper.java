package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author deequoique
 * user与数据库连接类
 */
@Mapper
public interface UserMapper {
    @Select("SELECT user_id as id, user_code as password, user_status as status from user")
    List<User> findAll();

    @Insert("INSERT INTO user VALUES (#{id},#{password},#{status})")
    int insert(User user);
}
