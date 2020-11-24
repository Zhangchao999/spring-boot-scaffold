package cn.geoary.fastspringboot.entity.boot;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ExResult {
    private String code;

    private String msg;

    public ExResult(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
