package hitsz.deequoique.schoolcat.service;

import hitsz.deequoique.schoolcat.common.Result;
import hitsz.deequoique.schoolcat.entity.User;

/**
 * @author deequoique
 * @description 登陆接口
 * @date 2023/1/22 17:10
 */
public interface LoginService {
    Result login(User user);
    Result logout();
}
