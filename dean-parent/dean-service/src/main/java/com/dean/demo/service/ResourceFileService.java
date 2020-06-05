package com.dean.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/12/2 16:44
 */
public interface ResourceFileService {
    List<String> fileUpload(MultipartFile file);
}
