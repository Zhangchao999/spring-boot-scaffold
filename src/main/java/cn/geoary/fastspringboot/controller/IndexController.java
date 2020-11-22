package cn.geoary.fastspringboot.controller;

import cn.geoary.fastspringboot.entity.boot.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexController extends BaseController {

    @RequestMapping("/index")
    public BaseResult index(String str) {
        log.info("请求参数是：{}", str);
        return setSuccess("参数是：" + str);
    }
}
