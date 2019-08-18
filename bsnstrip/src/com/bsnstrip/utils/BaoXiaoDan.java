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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.bsnstrip.pojo.TEmployee;
import com.bsnstrip.pojo.TReimburse;
import com.bsnstrip.pojo.TReimburseDetail;
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

public class BaoXiaoDan {
	
	public static String getTable(HttpServletRequest request, TReimburse reimburse, List<TReimburseDetail> rbDetails, TEmployee employee) {
		 
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
		
		String rbtype = reimburse.getRbtype().equals("0")?"出差报销":"日常报销";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String applyDate = format.format(reimburse.getApplydate());
		
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
            PdfPCell cell11 = new PdfPCell(new Paragraph("费用报销单",FontChinese24));
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
            PdfPCell cell21 = new PdfPCell(new Paragraph("报销概要",FontChinese16));
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
            PdfPCell cell311 = new PdfPCell(new Paragraph(employee.getEmpname(),FontChinese11Normal));
            PdfPCell cell32 = new PdfPCell(new Paragraph("工号：",FontChinese11Bold));
            PdfPCell cell321 = new PdfPCell(new Paragraph(reimburse.getUserid().toString(),FontChinese11Normal));
            PdfPCell cell33 = new PdfPCell(new Paragraph("日期：",FontChinese11Bold));
            PdfPCell cell331 = new PdfPCell(new Paragraph(applyDate,FontChinese11Normal));
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
            PdfPTable table4 = new PdfPTable(4);
            int width4[] = {12,48,12,28};
            table4.setWidths(width4); 
            PdfPCell cell41 = new PdfPCell(new Paragraph("报销类型：",FontChinese11Bold));
            PdfPCell cell411 = new PdfPCell(new Paragraph(rbtype,FontChinese11Normal));
            PdfPCell cell42 = new PdfPCell(new Paragraph("报销金额：",FontChinese11Bold));
            PdfPCell cell421 = new PdfPCell(new Paragraph(NumberToCN.number2CNMontrayUnit(new BigDecimal(reimburse.getRbfee())),FontChinese11Normal));
            cell41.setBorder(0);
            cell411.setBorder(0);
            cell42.setBorder(0);
            cell421.setBorder(0);
            table4.addCell(cell41);
            table4.addCell(cell411);
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
            PdfPCell cell51 = new PdfPCell(new Paragraph("报销说明：",FontChinese11Bold));
            PdfPCell cell511 = new PdfPCell(new Paragraph( reimburse.getRbcontent(),FontChinese11Normal));
            cell51.setBorder(0);
            cell511.setBorder(0);
            table5.addCell(cell51);
            table5.addCell(cell511);
            document.add(table5);
            //加入空行
            Paragraph blankRow51 = new Paragraph(18f, " ", FontChinese18); 
            document.add(blankRow51);
 
            //table6
            PdfPTable table6 = new PdfPTable(2);
            table6.getDefaultCell().setBorder(0);
            table6.setWidths(width21); 
            PdfPCell cell61 = new PdfPCell(new Paragraph("报销明细",FontChinese16));
            cell61.setBorder(0);
            table6.addCell(image21);
            table6.addCell(cell61); 
            document.add(table6);
            //加入空行
            Paragraph blankRow4 = new Paragraph(18f, " ", FontChinese16); 
            document.add(blankRow4);
 
            //table7
            PdfPTable table7 = new PdfPTable(4);
            BaseColor lightGrey = new BaseColor(0xCC,0xCC,0xCC);
            int width7[] = {20,18,13,20};
//            ,14,15
            table7.setWidths(width7); 
            PdfPCell cell71 = new PdfPCell(new Paragraph("报销项目",FontChinese11Bold));
            PdfPCell cell72 = new PdfPCell(new Paragraph("数量",FontChinese11Bold));
            PdfPCell cell73 = new PdfPCell(new Paragraph("单价",FontChinese11Bold));
            PdfPCell cell74 = new PdfPCell(new Paragraph("项目总额",FontChinese11Bold));
            //表格高度
            cell71.setFixedHeight(25);
            cell72.setFixedHeight(25);
            cell73.setFixedHeight(25);
            cell74.setFixedHeight(25);
            //水平居中
            cell71.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell72.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell73.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell74.setHorizontalAlignment(Element.ALIGN_CENTER);
            //垂直居中
            cell71.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell72.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell73.setVerticalAlignment(Element.ALIGN_MIDDLE);
            cell74.setVerticalAlignment(Element.ALIGN_MIDDLE);
            //边框颜色
            cell71.setBorderColor(lightGrey);
            cell72.setBorderColor(lightGrey);
            cell73.setBorderColor(lightGrey);
            cell74.setBorderColor(lightGrey);
            //去掉左右边框
            cell71.disableBorderSide(8);
            cell72.disableBorderSide(4);
            cell72.disableBorderSide(8);
            cell73.disableBorderSide(4);
            cell73.disableBorderSide(8);
            cell74.disableBorderSide(4);
            table7.addCell(cell71);
            table7.addCell(cell72);
            table7.addCell(cell73);
            table7.addCell(cell74);
            document.add(table7);
 
            for (TReimburseDetail rbDetail : rbDetails) {
            	Integer rbdnum = rbDetail.getRbdnum();
            	Integer rbdfee = rbDetail.getRbdfee();
            	//table8
                PdfPTable table8 = new PdfPTable(4);
                int width8[] = {20,18,13,20};
                table8.setWidths(width8); 
                PdfPCell cell81 = new PdfPCell(new Paragraph(rbDetail.getRbditem(),FontChinese11Normal));
                PdfPCell cell82 = null;
                if(rbdnum != null && rbdnum != 0) {
                	cell82 = new PdfPCell(new Paragraph(rbdnum.toString(),FontChinese11Normal));
                }else {
                	cell82 = new PdfPCell(new Paragraph(" ",FontChinese11Normal));
                }
                PdfPCell cell83 = null;
                if(rbdfee != null && rbdfee != 0) {
                	cell83 = new PdfPCell(new Paragraph(rbdfee.toString(),FontChinese11Normal));
                }else {
                	cell83 = new PdfPCell(new Paragraph(" ",FontChinese11Normal));
                }
                PdfPCell cell84 = new PdfPCell(new Paragraph(rbDetail.getRbdcount().toString(),FontChinese11Normal));
                //表格高度
                cell81.setFixedHeight(25);
                cell82.setFixedHeight(25);
                cell83.setFixedHeight(25);
                cell84.setFixedHeight(25);
                //水平居中
                cell81.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell82.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell83.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell84.setHorizontalAlignment(Element.ALIGN_CENTER);
                //垂直居中
                cell81.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell82.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell83.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell84.setVerticalAlignment(Element.ALIGN_MIDDLE);
                //边框颜色
                cell81.setBorderColor(lightGrey);
                cell82.setBorderColor(lightGrey);
                cell83.setBorderColor(lightGrey);
                cell84.setBorderColor(lightGrey);
                //去掉左右边框
                cell81.disableBorderSide(8);
                cell82.disableBorderSide(4);
                cell82.disableBorderSide(8);
                cell83.disableBorderSide(4);
                cell83.disableBorderSide(8);
                cell84.disableBorderSide(4);
                table8.addCell(cell81);
                table8.addCell(cell82);
                table8.addCell(cell83);
                table8.addCell(cell84);
                document.add(table8);
			}
                    
              //加入空行
              Paragraph blankRow5 = new Paragraph(18f, " ", FontChinese18); 
              document.add(blankRow5);
 
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
        		
        		TEmployee manager_emp = employeeService.findEmployeeByEmployeeId(manager_user.getEmployeeid());
        		TEmployee leader_emp = employeeService.findEmployeeByEmployeeId(leader_user.getEmployeeid());
        		TEmployee counter_emp = employeeService.findEmployeeByEmployeeId(counter_user.getEmployeeid());
              
              PdfPTable table9 = new PdfPTable(6);
              int width9[] = {15,15,13,17,10,30};
              table9.setWidths(width9);
              PdfPCell cell91 = new PdfPCell(new Paragraph("部门领导签名：",FontChinese11Bold));
              PdfPCell cell911 = new PdfPCell(new Paragraph(manager_emp.getEmpname(),FontChinese11));
              PdfPCell cell92 = new PdfPCell(new Paragraph("总经理签名：",FontChinese11Bold));
              PdfPCell cell921 = new PdfPCell(new Paragraph(leader_emp.getEmpname(),FontChinese11));
              PdfPCell cell93 = new PdfPCell(new Paragraph("财务签名：",FontChinese11Bold));
              PdfPCell cell931 = new PdfPCell(new Paragraph(counter_emp.getEmpname(),FontChinese11));
              cell91.setHorizontalAlignment(Element.ALIGN_LEFT);
              cell91.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cell911.setHorizontalAlignment(Element.ALIGN_LEFT);
              cell911.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cell92.setHorizontalAlignment(Element.ALIGN_LEFT);
              cell92.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cell921.setHorizontalAlignment(Element.ALIGN_LEFT);
              cell921.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cell93.setHorizontalAlignment(Element.ALIGN_LEFT);
              cell93.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cell931.setHorizontalAlignment(Element.ALIGN_LEFT);
              cell931.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cell91.setBorder(0);
              cell911.setBorder(0);
              cell92.setBorder(0);
              cell921.setBorder(0);
              cell93.setBorder(0);
              cell931.setBorder(0);
              table9.addCell(cell91);
              table9.addCell(cell911);
              table9.addCell(cell92); 
              table9.addCell(cell921);
              table9.addCell(cell93);
              table9.addCell(cell931);
              document.add(table9);
              
            //加入空行
              Paragraph blankRow91 = new Paragraph(18f, " ", FontChinese18); 
              document.add(blankRow91);
              
              
              PdfPTable table10 = new PdfPTable(2);
              int width10[] = {80,20};
              table10.setWidths(width10);
              PdfPCell cell100 = new PdfPCell(new Paragraph(" ",FontChinese11Bold));
              PdfPCell cell101 = new PdfPCell(new Paragraph("申请人签名：",FontChinese12));
              cell101.setHorizontalAlignment(Element.ALIGN_RIGHT);
              cell101.setVerticalAlignment(Element.ALIGN_MIDDLE);
              cell100.setBorder(0);
              cell101.setBorder(0);
              table10.addCell(cell101);
              table10.addCell(cell100);
              document.add(table10);
 
             document.close();
 
        } catch (Exception ex) 
        {
          ex.printStackTrace();
        }
		return newFilename;
    }
}
