package cn.geoary.fastspringboot.entity.boot;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BaseResult {
    private String code;

    private String msg;

    private Object data;

    private boolean serviceflag;
}
