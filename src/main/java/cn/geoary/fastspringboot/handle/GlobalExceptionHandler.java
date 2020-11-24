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
        return new ExResult(exception.getCode(), exception.getMsg());
    }

    /**
     * 功能描述:
     * 〈异常 handle〉
     *
     * @param exception 1
     * @return : cn.geoary.fastspringboot.entity.boot.ExResult
     * @author : zhangc
     * @date : 2020/11/24 9:50
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ExResult handleTypeException(Exception exception) {
        logger.error("Exception异常，{}", exception.getMessage());
        return new ExResult(ControllerConstant.RESULT_CODE_5001, exception.getMessage());
    }
}
