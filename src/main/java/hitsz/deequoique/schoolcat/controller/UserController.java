package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Constants;
import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.entity.dto.LoginUserDTO;
import hitsz.deequoique.schoolcat.entity.User;
import hitsz.deequoique.schoolcat.mapper.UserMapper;
import hitsz.deequoique.schoolcat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author deequoique
 * user相关控制层
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@ResponseBody
public class UserController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public Result save(@RequestBody User user){
       return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        for (User users:index()){
            if(users.getId().equals(user.getId())){
                return Result.error(Constants.CODE_400,"已有该账号");
            }
        }

        userMapper.insert(new User(user.getId(), user.getCode(), user.getName(),user.getImage()));
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return loginService.login(user);
    }

    @PostMapping("/logout")
    public Result logout(){
        return loginService.logout();
    }

    @GetMapping("/")
    public List<User> index(){
        return userMapper.findAll();
    }
}
