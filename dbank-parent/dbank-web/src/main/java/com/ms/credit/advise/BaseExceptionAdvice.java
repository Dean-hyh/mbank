package com.ms.credit.advise;

import com.ms.credit.exception.DbankException;
import com.ms.credit.results.DbankExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @version 1.0
 * @Author Dean
 * @Date 2019/10/28 14:08
 * 自定义全局异常捕获处理类--控制器
 */
@Slf4j
@ControllerAdvice
public class BaseExceptionAdvice {

    /**
     * 参数：自定义的异常捕获类
     * @param dbankException
     * @return
     */
    @ExceptionHandler(DbankException.class)
    public ResponseEntity<DbankExceptionResult> handlerLyException(DbankException dbankException){
        log.error(dbankException.getMessage());
        return ResponseEntity.status(dbankException.getStatus()).body(new DbankExceptionResult(dbankException));
    }
}
