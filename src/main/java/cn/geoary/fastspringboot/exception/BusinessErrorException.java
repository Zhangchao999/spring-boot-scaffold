package cn.geoary.fastspringboot.exception;

import cn.geoary.fastspringboot.constant.BusinessMsgEnum;
import lombok.Data;

@Data
public class BusinessErrorException extends RuntimeException{

    private String code;

    private String msg;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum){
        this.code = businessMsgEnum.getCode();
        this.msg = businessMsgEnum.getMsg();
    }
}
