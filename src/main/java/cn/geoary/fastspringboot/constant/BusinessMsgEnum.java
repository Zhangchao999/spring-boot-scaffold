package cn.geoary.fastspringboot.constant;

import lombok.Data;

/**
 * 功能描述:
 * 〈异常类〉
 *
 * @author : zhangc
 * @date : 2020/11/23 15:51
 */
public enum BusinessMsgEnum {
    /**
     * 功能描述:
     * 〈空指针异常〉
     *
     * @author : zhangc
     * @date : 2020/11/23 16:11
     */
    BUSINESS_NULLPOINT_EXCEPTION("7001", "空指针异常"),

    /**
     * 功能描述:
     * 〈调用超时〉
     *
     * @author : zhangc
     * @date : 2020/11/23 16:13
     */
    BUSINESS_TIMEOUT_EXCEPTION("8001", "调用超时");

    private String code;

    private String msg;

    BusinessMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
