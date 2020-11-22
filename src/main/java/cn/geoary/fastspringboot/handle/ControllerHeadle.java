package cn.geoary.fastspringboot.handle;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 功能描述:
 * 〈aop切面〉
 *
 * @author : zhangc
 * @date : 2020/11/20 14:49
 */
@Aspect
@Component
@Slf4j
public class ControllerHeadle {

    /**
     * 功能描述:
     * 〈controller层切点〉
     *
     * @author : zhangc
     * @date : 2020/11/20 14:48
     */
    @Pointcut("execution(* cn.geoary.fastspringboot.controller..*.*(..))")
    public void pointCut() {

    }


}
