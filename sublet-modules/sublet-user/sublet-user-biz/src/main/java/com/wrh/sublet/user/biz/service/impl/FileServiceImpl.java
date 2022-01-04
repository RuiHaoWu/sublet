package com.wrh.sublet.user.biz.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.aliyun.oss.OSSClient;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.user.api.entity.TrackFile;
import com.wrh.sublet.user.biz.config.OssProperties;
import com.wrh.sublet.user.biz.mapper.TrackFileMapper;
import com.wrh.sublet.user.biz.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件管理
 *
 * @author wrh
 * @date 2021/11/11
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl extends ServiceImpl<TrackFileMapper, TrackFile> implements FileService {

    private final OSSClient ossClient;

    private final OssProperties ossProperties;

    @Override
    public String uploadFile(MultipartFile file) {

        String fileName = IdUtil.simpleUUID() + StrUtil.DOT + FileUtil.extName(file.getOriginalFilename());

        // 在名字前面加个/时间/
        fileName = addDataPrefix(fileName);

        String url = ossProperties.getHost() + fileName;

        try {
            ossClient.putObject(ossProperties.getBucketName(), fileName, file.getInputStream());
            //文件管理数据记录,收集管理追踪文件
            fileLog(file, fileName, url);
            return url;

        } catch (Exception e) {
            log.error("上传失败", e);
            throw new BizException("上传失败");
        }
    }

    @Override
    public Boolean deleteFile(Integer id) {
        TrackFile trackFile = this.getById(id);
        ossClient.deleteObject(trackFile.getBucketName(),trackFile.getFileName());
        return removeById(trackFile);
    }


    /**
     * 文件管理数据记录,收集管理追踪文件
     *
     * @param file     上传文件格式
     * @param fileName 文件名
     * @param url      路径
     */
    private void fileLog(MultipartFile file, String fileName, String url) {
        TrackFile trackFile = new TrackFile();
        trackFile.setFileName(fileName);
        trackFile.setUrl(url);
        trackFile.setFileSize(file.getSize());
        trackFile.setType(FileUtil.extName(file.getOriginalFilename()));
        trackFile.setBucketName(ossProperties.getBucketName());
        this.save(trackFile);
    }

    /**
     * 生成日期前缀
     *
     * @return url
     */
    private String addDataPrefix(String fileName) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date());
        return date + StrUtil.SLASH + fileName;
    }
}
