package hitsz.deequoique.schoolcat.controller.dto;

import hitsz.deequoique.schoolcat.common.CatStatus;
import hitsz.deequoique.schoolcat.common.Sex;
import hitsz.deequoique.schoolcat.entity.Cat;
import lombok.Data;

/**
 * @author deequoique
 */
@Data
public class CatDetailDTO {
    String id;
    String name;
    String sex;
    String kind;
    String breed;
    String picture;
    String txt;
    String status;

    public CatDetailDTO(Cat cat) {
        id = cat.getId();
        name = cat.getName();
        if(cat.isSex()){
            sex = "学长";
        }else {
            sex = "学姐";
        }
        kind = cat.getKind();
        if(cat.isBreed()){
            breed = "已绝育";
        }else {
            breed = "未绝育";
        }
        picture = cat.getPicture();
        txt = cat.getTxt();
        switch (cat.getStatus()){
            case (CatStatus.SCHOOL)->{
                status = "在校";
            }
            case (CatStatus.MISS)->{
                status = "走丢";
            }
            case (CatStatus.HOME)->{
                status = "有家啦";
            }
            case (CatStatus.DEAD)->{
                status = "喵星";
            }
            default -> {
                return;
            }
        }
    }
}
