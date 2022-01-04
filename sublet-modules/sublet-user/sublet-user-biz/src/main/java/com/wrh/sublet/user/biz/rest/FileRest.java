package com.wrh.sublet.user.biz.rest;

import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.common.web.base.BaseController;
import com.wrh.sublet.user.biz.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author wrh
 * @date 2021/11/10
 */
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
@Api(value = "file", tags = "文件管理")
public class FileRest implements BaseController {

    private final FileService fileService;

    @PostMapping("/upload")
    @ApiOperation(value = "文件上传")
    public R uploadFile(@RequestParam("file") MultipartFile file) {
        return R.ok(fileService.uploadFile(file));
    }


    @DeleteMapping("/{id}")
    @SysLog(value = "删除文件")
    @ApiOperation(value = "文件删除")
    @PreAuthorize("hasAuthority('file_del')")
    public R deleteFile(@PathVariable Integer id) {
        return R.ok(fileService.deleteFile(id));
    }

}
