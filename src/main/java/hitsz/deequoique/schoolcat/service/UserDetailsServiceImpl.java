package hitsz.deequoique.schoolcat.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import hitsz.deequoique.schoolcat.entity.User;
import hitsz.deequoique.schoolcat.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author deequoique
 * @description 查询用户权限
 * @date 2023/1/22 15:47
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    /**
     *
     * @param username 用户id
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId,username);
        return null;
    }
}
