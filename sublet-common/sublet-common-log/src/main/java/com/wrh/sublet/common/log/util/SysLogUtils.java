package com.wrh.sublet.common.log.util;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.wrh.sublet.common.log.enums.LogTypeEnum;
import com.wrh.sublet.common.web.utils.BufferedRequestWrapper;
import com.wrh.sublet.user.api.entity.SysLog;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

/**
 * 系统日志工具类
 *
 * @author wrh
 * @date 2021/10/13
 */
@Slf4j
@UtilityClass
public class SysLogUtils {

    public SysLog getSysLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects
                .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        SysLog sysLog = new SysLog();
        sysLog.setCreateTime(System.currentTimeMillis());
        sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        sysLog.setBody(getRequestBody(request));
        sysLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        sysLog.setRemoteAddr(ServletUtil.getClientIP(request));
        sysLog.setClientId(getClientId(request));
        sysLog.setCreateBy(getUsername());
        sysLog.setMethod(request.getMethod());
        sysLog.setType(LogTypeEnum.NORMAL.getType());
        return sysLog;
    }

    /**
     * 获取客户端
     *
     * @return clientId
     */
    private String getClientId(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) authentication;
            return auth2Authentication.getOAuth2Request().getClientId();
        }
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            BasicAuthenticationConverter basicAuthenticationConverter = new BasicAuthenticationConverter();
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = basicAuthenticationConverter
                    .convert(request);
            if (usernamePasswordAuthenticationToken != null) {
                return usernamePasswordAuthenticationToken.getName();
            }
        }
        return null;
    }

    /**
     * 获取用户名称
     *
     * @return username
     */
    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }

    /**
     * 获取body参数
     *
     * @param request request
     * @return body
     * @throws IOException e
     */
    private String getRequestBody(HttpServletRequest request) {
        String body = "";
        try {
            BufferedRequestWrapper bodyWrapper = new BufferedRequestWrapper(request);
            body = new String(bodyWrapper.getBody());
        } catch (IOException e) {
            log.error("获取body参数失败");
        }
        return body;
    }
}
