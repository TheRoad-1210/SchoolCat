package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.entity.Cat;
import hitsz.deequoique.schoolcat.mapper.CatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author deequoique
 * cat相关控制层
 */
@RestController
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatMapper catMapper;
    @GetMapping("/home")
    public Result home(){
        List<Cat> catList = catMapper.findAll();
        return Result.success(catList);
    }
}
