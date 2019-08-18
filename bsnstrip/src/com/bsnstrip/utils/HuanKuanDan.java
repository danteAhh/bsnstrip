package com.bsnstrip.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TLoan;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseDetail;
import com.bsnstrip.pojo.TRepay;
import com.bsnstrip.pojo.TUser;
import com.bsnstrip.service.EmployeeService;
import com.bsnstrip.service.UserService;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class HuanKuanDan {
	
	public static String getTable(HttpServletRequest request, TRepay repay, TEmployee employee) {
		 
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");		// 生成随机文件名
		String newFilename = uuid + "." + "pdf";
		
		String path = request.getSession().getServletContext().getRealPath("/resource/PDF");
		
		File folder = new File(path); // 创建目录

		if (!folder.exists() && !folder.isDirectory()) {
			folder.mkdirs();
			System.out.println("目录创建成功");
		} else {
			System.out.println("目录已存在");
		}
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String applyDate = format.format(repay.getApplydate());
		
        try 
        {
             Document document = new Document(PageSize.A4.rotate()); 
             PdfWriter.getInstance(document, new FileOutputStream(path+"/"+newFilename));
 
            //设置字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);   
            com.itextpdf.text.Font FontChinese24 = new com.itextpdf.text.Font(bfChinese, 24, com.itextpdf.text.Font.BOLD);
            com.itextpdf.text.Font FontChinese18 = new com.itextpdf.text.Font(bfChinese, 18, com.itextpdf.text.Font.BOLD); 
            com.itextpdf.text.Font FontChinese16 = new com.itextpdf.text.Font(bfChinese, 16, com.itextpdf.text.Font.BOLD);
            com.itextpdf.text.Font FontChinese12 = new com.itextpdf.text.Font(bfChinese, 12, com.itextpdf.text.Font.NORMAL);
            com.itextpdf.text.Font FontChinese11Bold = new com.itextpdf.text.Font(bfChinese, 11, com.itextpdf.text.Font.BOLD);
            com.itextpdf.text.Font FontChinese11 = new com.itextpdf.text.Font(bfChinese, 11, com.itextpdf.text.Font.ITALIC);
            com.itextpdf.text.Font FontChinese11Normal = new com.itextpdf.text.Font(bfChinese, 11, com.itextpdf.text.Font.NORMAL);
 
            String imgPath = request.getSession().getServletContext().getRealPath("/img/20190410215126.png");
            
            document.open();
            //table1
            PdfPTable table1 = new PdfPTable(3);
            PdfPCell cell11 = new PdfPCell(new Paragraph("还款单",FontChinese24));
            cell11.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell11.setBorder(0);
            String imagePath = imgPath;
            Image image1 = Image.getInstance(imagePath); 
 
            Image image2 = Image.getInstance(imagePath); 
            //设置每列宽度比例   
            int width11[] = {35,40,25};
            table1.setWidths(width11); 
            table1.getDefaultCell().setBorder(0);
            table1.addCell(image1);  
            table1.addCell(cell11);  
            table1.addCell(image2);
            document.add(table1);
            //加入空行
            Paragraph blankRow1 = new Paragraph(18f, " ", FontChinese18);
            document.add(blankRow1);
 
            //table2
            PdfPTable table2 = new PdfPTable(2);
            //设置每列宽度比例   
            int width21[] = {2,98};
            table2.setWidths(width21); 
            table2.getDefaultCell().setBorder(0);
            PdfPCell cell21 = new PdfPCell(new Paragraph("还款概要",FontChinese16));
            String imagePath2 = imgPath;
            Image image21 = Image.getInstance(imagePath2); 
            cell21.setBorder(0);
            table2.addCell(image21);
            table2.addCell(cell21); 
            document.add(table2);
            //加入空行
            Paragraph blankRow2 = new Paragraph(18f, " ", FontChinese18); 
            document.add(blankRow2);
 
            //table3
            PdfPTable table3 = new PdfPTable(6);
            int width3[] = {10,20,8,22,8,32};
            table3.setWidths(width3); 
            PdfPCell cell31 = new PdfPCell(new Paragraph("申请人：",FontChinese11Bold));
            PdfPCell cell311 = new PdfPCell(new Paragraph(employee.getEmpname(), FontChinese11Normal));
            PdfPCell cell32 = new PdfPCell(new Paragraph("工号：",FontChinese11Bold));
            PdfPCell cell321 = new PdfPCell(new Paragraph(repay.getUserid().toString(), FontChinese11Normal));
            PdfPCell cell33 = new PdfPCell(new Paragraph("日期：",FontChinese11Bold));
            PdfPCell cell331 = new PdfPCell(new Paragraph(applyDate, FontChinese11Normal));
//            cell311.setHorizontalAlignment(Element.ALIGN_LEFT);
//            cell321.setHorizontalAlignment(Element.ALIGN_LEFT);
//            cell331.setHorizontalAlignment(Element.ALIGN_LEFT);
//            cell311.setVerticalAlignment(Element.ALIGN_LEFT);
//            cell321.setVerticalAlignment(Element.ALIGN_LEFT);
//            cell331.setVerticalAlignment(Element.ALIGN_LEFT);
            cell31.setBorder(0);
            cell311.setBorder(0);
            cell32.setBorder(0);
            cell321.setBorder(0);
            cell33.setBorder(0);
            cell331.setBorder(0);
            table3.addCell(cell31);
            table3.addCell(cell311);
            table3.addCell(cell32);
            table3.addCell(cell321);
            table3.addCell(cell33);
            table3.addCell(cell331);
            document.add(table3);
            //加入空行
            Paragraph blankRow31 = new Paragraph(18f, " ", FontChinese11); 
            document.add(blankRow31);
 
            //table4
            PdfPTable table4 = new PdfPTable(2);
            int width4[] = {12,88};
            table4.setWidths(width4); 
            PdfPCell cell42 = new PdfPCell(new Paragraph("还款金额：",FontChinese11Bold));
            PdfPCell cell421 = new PdfPCell(new Paragraph(NumberToCN.number2CNMontrayUnit(new BigDecimal(repay.getRepayfee())),FontChinese11Normal));
            cell42.setBorder(0);
            cell421.setBorder(0);
            table4.addCell(cell42);
            table4.addCell(cell421);
            document.add(table4);
          //加入空行
            Paragraph blankRow41 = new Paragraph(18f, " ", FontChinese11); 
            document.add(blankRow41);
 
            //table5
            PdfPTable table5 = new PdfPTable(2);
            int width5[] = {12,88};
            table5.setWidths(width5); 
            PdfPCell cell51 = new PdfPCell(new Paragraph("还款说明：",FontChinese11Bold));
            PdfPCell cell511 = new PdfPCell(new Paragraph(repay.getRepaycontent(),FontChinese11Normal));
            cell511.setBorder(0);
            cell51.setBorder(0);
            table5.addCell(cell51);
            table5.addCell(cell511);
            document.add(table5);
            //加入空行
            Paragraph blankRow51 = new Paragraph(18f, " ", FontChinese18); 
            document.add(blankRow51);
 
            //table9
            // 获取Spring容器
      		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
      		// 通过spring容器获取bean
      		UserService userService = (UserService) context.getBean("userService");
      		EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
      		// 当前登录人在HttpSession,通过HttpServletRequest获取登录人
      		TUser user = (TUser)request.getSession().getAttribute("user");
      		// 通过当前任务人id查找部门领导
      		TUser manager_user = userService.findManagerByUserId(user.getUserid());
      		TUser leader_user = userService.getLeader();
      		TUser counter_user = userService.getCounter();
      		
      		TEmployee counter_emp = employeeService.findEmployeeByEmployeeId(counter_user.getEmployeeid());
            
            PdfPTable table9 = new PdfPTable(3);
            int width9[] = {15,45,40};
            table9.setWidths(width9);
            PdfPCell cell91 = new PdfPCell(new Paragraph("财务签名：",FontChinese11Bold));
            PdfPCell cell911 = new PdfPCell(new Paragraph(counter_emp.getEmpname(),FontChinese11));
            PdfPCell cell92 = new PdfPCell(new Paragraph("申请人签名：",FontChinese11Bold));
            cell91.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell91.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell911.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell911.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell92.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell92.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell91.setBorder(0);
            cell911.setBorder(0);
            cell92.setBorder(0);
            table9.addCell(cell91);
            table9.addCell(cell911);
            table9.addCell(cell92); 
            document.add(table9);
            
            
             document.close();
 
        } catch (Exception ex) 
        {
          ex.printStackTrace();
        }
		return newFilename;
    }
}
