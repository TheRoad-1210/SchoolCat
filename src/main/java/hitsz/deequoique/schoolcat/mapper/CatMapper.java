package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.controller.dto.CatHomeDTO;
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
    @Select("SELECT id, name, txt, picture from cat;")
    List<CatHomeDTO> findHome();
    @Select("SELECT * from cat where id=#{id};")
    Cat find(String id);
}
