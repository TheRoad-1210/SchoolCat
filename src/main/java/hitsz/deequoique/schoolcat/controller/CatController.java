package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.controller.dto.CatHomeDTO;
import hitsz.deequoique.schoolcat.entity.Cat;
import hitsz.deequoique.schoolcat.mapper.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author deequoique
 * cat相关控制层
 */
@RestController
@RequestMapping("/cat")
@CrossOrigin
public class CatController {
    @Autowired
    private CatMapper catMapper;
    @GetMapping("/home")
    public Result home(){
        List<CatHomeDTO> catList = catMapper.findHome();
        return Result.success(catList);
    }
    @GetMapping("/detail")
    public Result detail(@RequestParam("catId") String catId){
        Cat cat = catMapper.find(catId);
        return Result.success(cat);
    }
}
