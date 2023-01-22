package hitsz.deequoique.schoolcat.controller;

import hitsz.deequoique.schoolcat.common.Constants;
import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.controller.dto.UserDTO;
import hitsz.deequoique.schoolcat.entity.User;
import hitsz.deequoique.schoolcat.mapper.UserMapper;
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
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public Result save(@RequestBody User user){
       return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserDTO user){
        for (User users:index()){
            if(users.getId().equals(user.getId())){
                return Result.error(Constants.CODE_400,"已有该账号");
            }
        }

        userMapper.insert(new User(user.getId(), user.getPassword(), user.getName(),user.getImage()));
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody UserDTO userDTO){
        for (User user:index()){
            if (user.getId().equals(userDTO.getId())){
                if(Objects.equals(user.getCode(), userDTO.getPassword())){
                    return Result.success();
                }
                else {
                    return Result.error(Constants.CODE_403,"密码错误");
                }
            }
        }
        return Result.error(Constants.CODE_500,"没有该用户");
    }

    @GetMapping("/")
    public List<User> index(){
        return userMapper.findAll();
    }
}
