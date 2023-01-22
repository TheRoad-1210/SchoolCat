package hitsz.deequoique.schoolcat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import hitsz.deequoique.schoolcat.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author deequoique
 * user与数据库连接类
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * from user")
    List<User> findAll();

}
