package edu.web.yjt_backend.exception;

import edu.web.yjt_backend.common.BaseRespone;
import edu.web.yjt_backend.common.ErrorCode;
import edu.web.yjt_backend.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler{
    @ExceptionHandler(BusinessException.class)
    public BaseRespone businessExceptionHandler(BusinessException e){
        log.error("businessException:"+e.getMessage(),e);
        return ResultUtils.error(e.getCode(), e.getMessage(), e.getDescription());
    }

    //捕获全局系统异常，然后自定义状态信息，过滤后端关键信息
    @ExceptionHandler(RuntimeException.class)
    public BaseRespone runtimeException(RuntimeException e){
        log.error("runtimeException",e);
        return ResultUtils.error(ErrorCode.SYSTEM_ERROR,e.getMessage(),"");
    }
}