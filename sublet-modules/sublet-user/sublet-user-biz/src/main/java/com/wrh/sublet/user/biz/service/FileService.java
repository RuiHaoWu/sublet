package com.wrh.sublet.user.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wrh.sublet.user.api.entity.TrackFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wrh
 * @date 2021/11/11
 */
public interface FileService extends IService<TrackFile> {

    /**
     * 上传文件
     *
     * @param file file
     * @return 图片地址
     */
    String uploadFile(MultipartFile file);

    /**
     * 删除文件
     *
     * @param id 文件id
     * @return 操作结果
     */
    Boolean deleteFile(Integer id);
}
