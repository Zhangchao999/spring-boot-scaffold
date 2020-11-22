package cn.geoary.fastspringboot.controller;

import cn.geoary.fastspringboot.constant.ControllerConstant;
import cn.geoary.fastspringboot.entity.boot.BaseResult;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:
 * 〈所有controller 都继承 BaseController 〉
 *
 * @author : zhangc
 * @date : 2020/11/20 14:51
 */
@RestController
public class BaseController {
    /**
     * 功能描述:
     * 〈返回成功〉
     *
     * @param data 返回对象
     * @return : cn.geoary.entity.boot.BaseResult
     * @author : zhangc
     * @date : 2020/11/19 14:35
     */
    public BaseResult setSuccess(Object data) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ControllerConstant.RESULT_CODE_SUCCESS);
        baseResult.setServiceflag(ControllerConstant.RESULT_SERVICEFLAG_SUCCESS);
        baseResult.setData(data);
        baseResult.setMsg("服务调用成功");
        return baseResult;
    }

    /**
     * 功能描述:
     * 〈返回失败〉
     *
     * @param message 错误信息
     * @return : cn.geoary.entity.boot.BaseResult
     * @author : zhangc
     * @date : 2020/11/19 14:36
     */
    public BaseResult setFail(String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(ControllerConstant.RESULT_CODE_ERROR);
        baseResult.setServiceflag(ControllerConstant.RESULT_SERVICEFLAG_FAIL);
        if (!StrUtil.isEmpty(message)) {
            baseResult.setMsg(message);
        } else {
            baseResult.setMsg("服务调用失败");
        }
        return baseResult;
    }
}
