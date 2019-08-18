package com.bsnstrip.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.bsnstrip.pojo.TReimburseImg;

public interface ReimburseImgService {
	void saveReimburseIMG(MultipartFile[] rbimg, Integer rbId, HttpServletRequest request) ;
	
	List<TReimburseImg> selectImgByRbid(Integer rbid);
}
