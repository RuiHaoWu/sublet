package com.wrh.sublet.common.web.utils;

import io.micrometer.core.instrument.util.IOUtils;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


/**
 * 请求体缓存 因为request只能给读取一次
 *
 * @author wrh
 * @date 2021/11/18
 */
@Slf4j
public class BufferedRequestWrapper extends HttpServletRequestWrapper {

    private byte[] bodyBuffer;

    public BufferedRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);

        String bodyStr = getBodyString(request);
        bodyBuffer = bodyStr.getBytes(Charset.defaultCharset());
    }

    @Override
    public ServletInputStream getInputStream() {
        final ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bodyBuffer);
        return new ServletInputStream() {


            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() {
                return byteInputStream.read();
            }

        };
    }


    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(getInputStream(), StandardCharsets.UTF_8));
    }

    public byte[] getBody() {
        return bodyBuffer;
    }


    private String getBodyString(final HttpServletRequest request) throws IOException {
        String contentType = request.getContentType();
        String bodyString = "";
        if (StringUtils.isNotBlank(contentType) && contentType.contains(MediaType.MULTIPART_FORM_DATA_VALUE)) {
            return bodyString;
        } else {
            return IOUtils.toString(request.getInputStream());
        }
    }
}
