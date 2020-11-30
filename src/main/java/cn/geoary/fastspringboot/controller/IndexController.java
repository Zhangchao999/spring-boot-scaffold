package cn.geoary.fastspringboot.controller;

import cn.geoary.fastspringboot.entity.boot.BaseResult;
import cn.geoary.fastspringboot.service.FSBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

@Slf4j
@RestController
public class IndexController extends BaseController {

    @Resource
    private FSBService fsbService;

    @RequestMapping("/index")
    public BaseResult index(String str, String str2) {
        log.info("index请求参数1是：{}", str);
        log.info("index请求参数2是：{}", str2);
        return setSuccess("index参数是：" + str+"  "+str2);
    }

    @RequestMapping("/indexHome")
    public ModelAndView indexHome(){
        return new ModelAndView("index/indexHome.html");
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
