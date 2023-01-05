package hitsz.deequoique.schoolcat.mapper;

import hitsz.deequoique.schoolcat.controller.dto.record.MealRecordDTO;
import hitsz.deequoique.schoolcat.entity.MealRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author deequoique
 */
@Mapper
public interface MealMapper {
    @Select("Select fc.id, ui.name as userName, c.name as category,b.name as brand, fc.time, fc.location, ui.image " +
            "from feed_cat fc " +
            "left join food f on f.id = fc.food_id " +
            "left join user_info ui on fc.user_id = ui.id " +
            "left join category c on f.category_id = c.id " +
            "left join brand b on f.brand_id = b.id " +
            "where fc.id = ${id}")
    List<MealRecord> record(int id);
    @Insert("INSERT INTO feed_cat(food_id,cat_id,user_id,location) values (#{food},#{cat},#{userId},#{location})")
    int insert(MealRecordDTO mealRecordDTO);

}
