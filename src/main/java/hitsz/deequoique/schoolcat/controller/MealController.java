package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.controller.dto.record.MealRecordDTO;
import hitsz.deequoique.schoolcat.controller.dto.record.MealRecordGetDTO;
import hitsz.deequoique.schoolcat.entity.Food;
import hitsz.deequoique.schoolcat.mapper.FoodMapper;
import hitsz.deequoique.schoolcat.mapper.MealMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author deequoique
 */
@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealMapper mealMapper;
    @Autowired
    private FoodMapper foodMapper;
    @GetMapping("/record")
    public Result record(@RequestParam("id") int id){
        return Result.success(mealMapper.record(id));
    }
    @PostMapping("/post")
    public Result post(@RequestBody MealRecordGetDTO meal){
        List<Food> foods = foodMapper.find(meal.getCategory(),meal.getBrand());
        if (foods.isEmpty()){
            foodMapper.insert(new Food(meal.getBrand(), meal.getCategory()));
            foods = foodMapper.find(meal.getCategory(),meal.getBrand());
        }
        mealMapper.insert(new MealRecordDTO(foods.get(0).getId(),
                meal.getCat(), meal.getUserId(),meal.getLocation()));
        return Result.success();
    }
}
