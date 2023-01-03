package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.entity.Activity;
import hitsz.deequoique.schoolcat.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author deequoique
 */
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
}
