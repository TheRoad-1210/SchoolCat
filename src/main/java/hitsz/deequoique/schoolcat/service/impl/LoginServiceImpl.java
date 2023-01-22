package hitsz.deequoique.schoolcat.service.impl;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.entity.User;
import hitsz.deequoique.schoolcat.entity.dto.LoginUserDTO;
import hitsz.deequoique.schoolcat.service.LoginService;
import hitsz.deequoique.schoolcat.utils.JwtUtil;
import hitsz.deequoique.schoolcat.utils.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static hitsz.deequoique.schoolcat.common.Constants.CODE_403;

/**
 * @author deequoique
 * @description 登陆
 * @date 2023/1/22 17:19
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;


    @Override
    public Result login(User user) {

        //通过UsernamePasswordAuthenticationToken获取用户名和密码
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(user.getId(),user.getCode());

        //AuthenticationManager委托机制对authenticationToken 进行用户认证
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //如果认证没有通过，给出对应的提示
        if (Objects.isNull(authenticate)){
            return Result.error(CODE_403,"密码错误");
        }

        //如果认证通过，使用user生成jwt  jwt存入ResponseResult 返回

        //如果认证通过，拿到这个当前登录用户信息
        LoginUserDTO loginUser = (LoginUserDTO) authenticate.getPrincipal();

        //获取当前用户的userid
        String userid = loginUser.getUser().getId();

        String jwt = JwtUtil.createJWT(userid);
        Map<String, String> map = new HashMap<>();
        map.put("token",jwt);

        //把完整的用户信息存入redis  userid为key   用户信息为value
        redisCache.setCacheObject("login:"+userid,loginUser);

        return Result.success(map);
    }

    @Override
    public Result logout() {
        //从SecurityContextHolder中的该用户的令牌
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        //解密解出
        LoginUserDTO loginUser = (LoginUserDTO) authentication.getPrincipal();
        String userid = loginUser.getUser().getId();

        //根据userid找到redis对应值进行删除
        redisCache.deleteObject("login:"+userid);
        return Result.success();
    }

}
