package cn.geoary.fastspringboot.handle;

import cn.geoary.fastspringboot.constant.ControllerConstant;
import cn.geoary.fastspringboot.entity.boot.ExResult;
import cn.geoary.fastspringboot.exception.BusinessErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.reflect.UndeclaredThrowableException;

/**
 * 功能描述:
 * 〈全局异常捕获〉
 *
 * @author : zhangc
 * @date : 2020/11/24 9:48
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 功能描述:
     * 〈自定义异常 handle〉
     *
     * @param exception 1
     * @return : cn.geoary.fastspringboot.entity.boot.ExResult
     * @author : zhangc
     * @date : 2020/11/24 9:50
     */
    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExResult handleTypeNullPointException(BusinessErrorException exception) {
        logger.error("自定义异常，{}", exception.getMsg());
        return new ExResult(exception.getCode(), "异常信息：" + exception.getMsg());
    }

    /**
     * 功能描述:
     * 〈异常 handle
     * exception 是所有异常类的父类，即可以捕获除了 自定义异常 外的所有异常〉
     *
     * @param exception 1
     * @return : cn.geoary.fastspringboot.entity.boot.ExResult
     * @author : zhangc
     * @date : 2020/11/24 9:50
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExResult handleTypeException(Exception exception) {
        String msg = "";
        if(exception instanceof UndeclaredThrowableException){
            Throwable targetEx = ((UndeclaredThrowableException) exception).getUndeclaredThrowable();
            if (targetEx != null){
                msg = targetEx.getMessage();
            }
        }else {
            msg = exception.getMessage();
        }
        logger.error("Exception异常，{}", msg);
        return new ExResult(ControllerConstant.RESULT_CODE_5001, "异常信息：" + msg);
    }
}
