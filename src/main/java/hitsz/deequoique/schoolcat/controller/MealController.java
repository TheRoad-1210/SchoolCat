package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.entity.dto.record.MealRecordDTO;
import hitsz.deequoique.schoolcat.entity.dto.record.MealRecordGetDTO;
import hitsz.deequoique.schoolcat.entity.Food;
import hitsz.deequoique.schoolcat.mapper.FoodMapper;
import hitsz.deequoique.schoolcat.mapper.MealMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author deequoique
 */
@Slf4j
@RestController
@RequestMapping("/meal")
@CrossOrigin
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
            log.info(String.valueOf(foods.size()));
        }
        MealRecordDTO mealRecordDTO = new MealRecordDTO(foods.get(0).getId(),
                meal.getCat(), meal.getUserId(),meal.getLocation());
        mealMapper.insert(mealRecordDTO);
        return Result.success();
    }
    @GetMapping("/get/category")
    public Result getCategory(){
        return Result.success(foodMapper.getCategoty());
    }
    @GetMapping("/get/brand")
    public Result getBrand(){
        return Result.success(foodMapper.getBrand());
    }
}
