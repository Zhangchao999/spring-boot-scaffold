package cn.geoary.fastspringboot.handle;

import cn.geoary.fastspringboot.util.AOPUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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
     * 〈mapper切点 测试〉
     *
     * @return : void
     * @author : zhangc
     * @date : 2020/11/30 13:43
     */
    @Pointcut("execution(* cn.geoary.fastspringboot.mapper..*.*(..))")
    public void pointMapper() {

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
    public void before(JoinPoint jp) {
        log.info("前置通知");
        log.info("前置通知参数：{}", jp.getArgs());
    }

    /**
     * 功能描述:
     * 〈后置通知〉
     *
     * @param jp 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/26 21:46
     */
    @After("pointCut()")
    public void after(JoinPoint jp) {
        log.info("After-后置通知");
        log.info("After-后置通知参数：{}", jp.getArgs());
    }

    /**
     * 功能描述:
     * 〈返回后通知〉
     *
     * @param jp 切点
     * @param rvt 返回结果
     * @return : void
     * @author : zhangc
     * @date : 2020/11/26 21:48
     */
    @AfterReturning(pointcut = "pointCut()", returning = "rvt")
    public void afterReturning(JoinPoint jp, Object rvt) {
        log.info("AfterReturning-返回后通知");
        log.info("AfterReturning-返回后通知参数：{}", jp.getArgs());
        log.info("AfterReturning-返回结果是{}", rvt);
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
    public void afterThrowing(JoinPoint jp) {
        log.info("异常通知");
        log.info("异常通知参数：{}", jp.getArgs());
    }

    /**
     * 功能描述:
     * 〈mapper〉
     *
     * @param jp 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/30 13:57
     */
    @Before("pointMapper()")
    public void beforeMapper(JoinPoint jp) {
        String className = jp.getSignature().getDeclaringTypeName();
        String methodname = jp.getSignature().getName();
        log.info("执行类:方法：" + className + ":" + methodname);
    }

    /**
     * 功能描述:
     * 〈前置校验检查参数是否符合规范〉
     *
     * @param jp 1
     * @return : void
     * @author : zhangc
     * @date : 2020/11/30 14:59
     */
    @Before("pointCut()")
    public void beforeMapperTest(JoinPoint jp) throws Exception {
        String className = jp.getSignature().getDeclaringTypeName();
        String methodname = jp.getSignature().getName();
        log.info("执行类:方法：" + className + ":" + methodname);
        Object[] args = jp.getArgs();
        String[] argNames = ((MethodSignature) jp.getSignature()).getParameterNames();
        HashMap paramMap = AOPUtil.mergeArray(argNames, args);
        // 前置校验中发现参数有问题，则在不进入方法的前提下抛出异常
        // 其实校验也可以放到环绕通知中实现 @Around
        if (paramMap.containsKey("str") && "test".equals(paramMap.get("str"))) {
            log.error("发现异常，参数str值不可为test");
            throw new Exception("参数str值不可为test");
        }
    }
}
