package cn.geoary.fastspringboot.handle;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
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

    /**
     * 功能描述:
     * 〈环绕通知〉
     *
     * @param pjp 1
     * @return : java.lang.Object
     * @author : zhangc
     * @date : 2020/11/26 21:40
     */
    @Around("pointCut()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        log.info("环绕通知");
        Object[] objects = pjp.getArgs();
        String[] keys = ((CodeSignature) pjp.getSignature()).getParameterNames();
        log.info("获取的key是：{}", keys);
        log.info("请求参数是：{}", objects);
        for (int i = 0, j = objects.length; i < j; i++) {
            log.info("参数是：" + objects[i]);
        }
        return pjp.proceed(objects);
    }

    /**
     * 功能描述:
     * 〈前置通知〉
     *
     * @param jp 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/26 21:41
     */
    @Before("pointCut()")
    public void before(JoinPoint jp){
        log.info("前置通知");
        log.info("前置通知参数：{}", jp.getArgs());
    }

    /**
     * 功能描述:
     * 〈后置通知〉
     *
     * @param  jp 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/26 21:46
     */
    @After("pointCut()")
    public void after(JoinPoint jp){
        log.info("After-后置通知");
        log.info("After-后置通知参数：{}", jp.getArgs());
    }

    /**
     * 功能描述:
     * 〈返回后通知〉
     *
     * @param jp 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/26 21:48
     */
    @AfterReturning("pointCut()")
    public void afterReturning(JoinPoint jp){
        log.info("AfterReturning-返回后通知");
        log.info("AfterReturning-返回后通知参数：{}", jp.getArgs());
    }

    /**
     * 功能描述:
     * 〈异常通知〉
     *
     * @param jp 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/26 21:48
     */
    @AfterThrowing("pointCut()")
    public void afterThrowing(JoinPoint jp){
        log.info("异常通知");
        log.info("异常通知参数：{}", jp.getArgs());
    }


}
