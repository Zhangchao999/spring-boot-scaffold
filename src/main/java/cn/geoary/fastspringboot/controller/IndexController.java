package cn.geoary.fastspringboot.controller;

import cn.geoary.fastspringboot.constant.BusinessMsgEnum;
import cn.geoary.fastspringboot.entity.boot.BaseResult;
import cn.geoary.fastspringboot.exception.BusinessErrorException;
import cn.geoary.fastspringboot.service.FSBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@Slf4j
@RestController
public class IndexController extends BaseController {

    @Resource
    private FSBService fsbService;

    @RequestMapping("/index")
    public BaseResult index(String str) {
        log.info("请求参数是：{}", str);
        return setSuccess("参数是：" + str);
    }

    @RequestMapping("/exception")
    public BaseResult exception() throws Exception {
        // throw new BusinessErrorException(BusinessMsgEnum.BUSINESS_TIMEOUT_EXCEPTION);
        // throw new Exception("异常。。。");
        HashMap tmpMap = new HashMap();
        tmpMap.put("id", "100001");
        tmpMap.put("name", "测试回滚");
        tmpMap.put("status", "3");
        HashMap fsMap = fsbService.rollbackTest(tmpMap);
        return setSuccess(fsMap);
    }
}
