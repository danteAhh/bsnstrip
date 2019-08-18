package com.bsnstrip.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bsnstrip.mapper.TReimburseImgMapper;
import com.bsnstrip.mapper.TReimburseMapper;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseImg;
import com.bsnstrip.pojo.TReimburseImgExample;
import com.bsnstrip.service.ReimburseImgService;

@Service
public class ReimburseImgServiceImpl implements ReimburseImgService {
	
	@Autowired
	private TReimburseImgMapper reimburseImgMapper;
	
	public void saveReimburseIMG(@RequestParam MultipartFile[] rbimg, Integer rbId, HttpServletRequest request) {		// 放到图片service里
		
		String path = request.getSession().getServletContext().getRealPath("/resource/reimburseIMG");		// 服务器路径
		File folder = new File(path);	// 创建目录
		
		if (!folder.exists() && !folder.isDirectory()) {
			folder.mkdirs();
		    System.out.println("目录创建成功");
		}else {
			System.out.println("目录已存在");
		}
		
		for (MultipartFile multipartFile : rbimg) {
			String filename = multipartFile.getOriginalFilename();
			
			System.out.println("服务器路径:"+path);
			String extension = FilenameUtils.getExtension(filename);
			String uuid = UUID.randomUUID().toString().replaceAll("-", "");		// 生成随机文件名
			String newFilename = uuid + "." + extension;
			
			File file = new File(path, newFilename);
			TReimburseImg rbi= new TReimburseImg();
			rbi.setRbimgpath(file.getPath());
			rbi.setRbid(rbId);
			
			reimburseImgMapper.insertSelective(rbi);
			
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<TReimburseImg> selectImgByRbid(Integer rbid) {
		
		TReimburseImgExample example = new TReimburseImgExample();
		TReimburseImgExample.Criteria criteria = example.createCriteria();
		criteria.andRbidEqualTo(rbid);
		List<TReimburseImg> rbImgs = reimburseImgMapper.selectByExample(example);
		
		return rbImgs;
	}
}
