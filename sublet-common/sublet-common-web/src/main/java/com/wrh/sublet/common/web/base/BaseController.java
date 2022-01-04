package com.wrh.sublet.common.web.base;

import com.wrh.sublet.common.core.result.R;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author wrh
 * @date 2021/10/12
 */
public interface BaseController {

    /**
     * body参数校验处理
     * @param result
     * @param handler
     * @return
     */
    default R validate(BindingResult result, Supplier<Object> handler){
        if (null != result && result.hasErrors()) {
            List<String> list = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return R.failed(HttpStatus.BAD_REQUEST.value(), list.size() == 1 ? list.get(0) : (list.isEmpty() ? null : ""));
        } else {
            Object res = handler.get();
            return res instanceof R ? (R)res : R.ok(res);
        }
    }

}
