package com.wrh.sublet.common.web.exception;

import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.common.core.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wrh
 * @date 2021/10/13
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     */
    @ExceptionHandler(value = BizException.class)
    public R bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("发生业务异常！原因是：{}", e.getMessage());
        return R.failed(e.getCode(), e.getMessage());
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    public R exceptionHandler(Exception e) {
        log.error("未知异常！原因是:", e);
        return R.failed(e.getMessage());
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R methodArgumentNotValidExceptionHandler(Exception e) {
        String collect = ((MethodArgumentNotValidException) e).getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        return R.failed(collect);
    }


    /**
     * token is expired
     */
    @ExceptionHandler(value = InvalidTokenException.class)
    public ResponseEntity InvalidTokenExceptionHandler(Exception e) {
        log.error("token is expired");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("token is expired");
    }


    /**
     * 账号密码错误异常
     */
    @ExceptionHandler(value = InvalidGrantException.class)
    public R invalidGrantExceptionHandler(Exception e) {
        return R.failed("用户名或密码错误!");
    }

}
