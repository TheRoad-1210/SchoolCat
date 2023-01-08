package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.controller.dto.UserDTO;
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
    @Select("SELECT * from user")
    List<User> findAll();

    @Insert("INSERT INTO user VALUES (#{id},#{password},#{power})")
    int insert(User user);

    @Insert("INSERT INTO user_info(name,id,image) VALUE (#{name},#{id},#{image})")
    int add(UserDTO user);
}
