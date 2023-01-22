package hitsz.deequoique.schoolcat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author deequoique
 */
@Data
@AllArgsConstructor
@TableName("user")
public class User {
    private String id;
    private String code;
    private String name;
    private String image;
}
