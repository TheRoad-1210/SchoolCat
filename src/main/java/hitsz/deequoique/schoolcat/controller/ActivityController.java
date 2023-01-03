package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.controller.dto.PostDTO;
import hitsz.deequoique.schoolcat.entity.Activity;
import hitsz.deequoique.schoolcat.mapper.ActivityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author deequoique
 */
@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityMapper activityMapper;
    @GetMapping("/home")
    public Result home(){
        List<Activity> activities = activityMapper.findHome();
        return Result.success(activities);
    }
    @PostMapping("/post")
    public Result post(@RequestBody PostDTO postDTO){
        if (activityMapper.post(postDTO)== 1){
            log.info("success");
            return Result.success();
        }
        return Result.error();
    }
}
