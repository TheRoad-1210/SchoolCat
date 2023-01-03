package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.entity.Cat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author deequoique
 * Cat与数据库连接
 */
@Mapper
public interface CatMapper {
    @Select("SELECT cat_id as id, cat_name as name,cat_sex as sex,cat_describe as catDescribe,\n" +
            " cat_kind as kind,cat_status as status,cat_breed as breed, cat_picture as picture\n" +
            " from cat;")
    List<Cat> findAll();
}
