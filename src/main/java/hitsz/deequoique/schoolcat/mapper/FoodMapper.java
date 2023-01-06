package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.entity.Food;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author deequoique
 */
@Mapper
public interface FoodMapper {
    /**
     * 用种类和品牌找食物id
     * @param category  食物种类
     * @param brand     食物品牌
     * @return          食物id
     */
    @Select("SELECT id, category_id as category, brand_id as brand from food " +
            "where food.category_id = #{category} && brand_id = #{brand}")
    List<Food> find(int category, int brand);
    @Insert("INSERT INTO food( category_id, brand_id) values (#{category},#{brand})")
    int insert(Food food);
}
