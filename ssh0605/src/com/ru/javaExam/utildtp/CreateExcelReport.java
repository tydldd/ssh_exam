/*
package com.ru.javaExam.utildtp;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.Region;

import com.topwalk.dtpser.alarmcentermd.bean.DataloggerBean;



public class CreateExcelReport {
	// // 创建新的Excel 工作簿
	// // 在Excel工作簿中建一工作表，其名为缺省值
	// // 如要新建一名为"效益指标"的工作表，其语句为：
	// // HSSFSheet sheet = workbook.createSheet("效益指标");
	// this.workbook = new HSSFWorkbook();
	// // 在索引0的位置创建行（最顶端的行）
	// this.hf = workbook.createFont();
	// }
	public String titleType = "";

	public String findBetweenlog(List list, String begindate, String enddate) {

		titleType = "数据库" + begindate + "到" + enddate + "报表导出数据列表";
		String headerTitle[] = { "任务名称 ", "等级", "主机名", "状态 ", "时间", "动作" };
		String count = this.createExcelByFile(headerTitle, list.size(), list);
		return count;
	}

	public String createExcelByFile(String[] title, int listSize, List list) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFFont hf = workbook.createFont();
		String outputFile = "";
		String getReportPath = StaticSession.filename_file;
		File alramlog = new File(StaticSession.filename_file);
		if(!alramlog.exists()){
			alramlog.mkdir();
		}
		int workbookCount = 1;
		int count = 0;// 用来计算数据条数
		List fileNameArray = new ArrayList();
		String report = "";
		int tempCount = 0;// 用来计算创建工作薄数
		count=list.size();
		List<String> fileName=new ArrayList<String>();
		String filename="";
		try {
			// String outputFile = "d:/文件" + this.getNowTime().replace(":", "")
			// + ".xls";
			String reportName = this.getNowTime();
//			outputFile = StaticSession.filename_file + reportName + ".xls";
//			System.out.println(outputFile);
			HSSFSheet sheet = workbook.createSheet();
			HSSFRow row = sheet.createRow(0);
			this.getHeadRow(workbook, sheet, row, hf, (short) 5);
			row = sheet.createRow((short) 1);
			// 在索引0的位置创建单元格（左上端）
			HSSFCell cell;
			// = row.createCell((short) 0);
			// 定义单元格为字符串类型
			// cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			// 设置cell编码解决中文高位字节截断
			// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			// 在单元格中输入一些内容

			sheet.setDefaultColumnWidth((short) 20); // 设定列宽度.
			int i = 0;
			// 创建表格表头
			if (title.length != 0) {
				for (int ii = 0; ii < title.length; ii++) {
					cell = row.createCell((short) i++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);

					cell.setCellValue(title[ii]);
					cell.setCellStyle(this.getTitleCellStyle(workbook, hf));
				}
			}
			// 下面是不断从数据库中读数据到sheet中
			// 创建行数 j=list.size();
			int ii = 0;
			int rownum = 1;
			StringBuffer requestXml = new StringBuffer();
			if (list.size() == 0) {
				workbookCount = 0;
			} else {
				Iterator iter = list.iterator();
				while (iter.hasNext()) {
					DataloggerBean info = (DataloggerBean) iter.next();
					if (count <= list.size() ) {
//						FileOutputStream fOut = new FileOutputStream(new File(
//								outputFile));
//						// 把相应的Excel 工作簿存盘
//						workbook.write(fOut);
//						fOut.flush();
						// 操作结束，关闭文件
//						fOut.close();
						reportName = this.getNowTime();
						outputFile = StaticSession.filename_file
								+ reportName + ".xls";
						workbook = new HSSFWorkbook();
						hf = workbook.createFont();
						rownum = 1;
						sheet = workbook.createSheet();
						row = sheet.createRow(0);
						this.getHeadRow(workbook, sheet, row, hf);
						row = sheet.createRow((short) 1);

						sheet.setDefaultColumnWidth((short) 20); // 设定列宽度.
						int j = 0;
						// 创建表格表头
						if (title.length != 0) {
							for (int jj = 0; jj < title.length; jj++) {
								cell = row.createCell((short) j++);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								cell.setEncoding(HSSFCell.ENCODING_UTF_16);

								cell.setCellValue(title[jj]);
								cell.setCellStyle(this.getTitleCellStyle(
										workbook, hf));
							}

						}
					}
					row = sheet.createRow((short) rownum + 1);
					cell = row.createCell((short) ii++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue(info.getTtaskid());
					cell.setCellStyle(this.getGenCellStyle(workbook));

					cell = row.createCell((short) ii++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue(info.getLevel());
					cell.setCellStyle(this.getGenCellStyle(workbook));

					cell = row.createCell((short) ii++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue(info.getUname());
					cell.setCellStyle(this.getGenCellStyle(workbook));

					cell = row.createCell((short) ii++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue(info.getStatus());
					cell.setCellStyle(this.getGenCellStyle(workbook));

					HSSFCellStyle cellStyle = workbook.createCellStyle();
					short df = workbook.createDataFormat().getFormat(
							"m/d/yy h:mm");
					cellStyle.setDataFormat(df);
					cell = row.createCell((short) ii++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					cell.setCellValue(info.getDatetime());
					cell.setCellStyle(cellStyle);

					cell = row.createCell((short) ii++);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					String str = info.getDescr();
					cell.setCellValue(str);
					cell.setCellStyle(this.getGenCellStyle(workbook));

					count++;
					ii = 0;
					rownum++;

				}
				tempCount = workbookCount + 1;
				fileNameArray.add(StaticSession.filename_file);
				FileOutputStream fOut = new FileOutputStream(new File(
						outputFile));
				// 把相应的Excel 工作簿存盘
				workbook.write(fOut);
				fOut.flush();
				// 操作结束，关闭文件
				fOut.close();
				if (workbookCount != 0) {
					reportName = this.getNowTime();

					String outPath = StaticSession.filename_fileold + "fileByConf" + reportName
							+ ".zip";
					filename=outPath;
					StaticSession.filename_filezip = outPath;
					// /log/temp/
					ZipUtil.zip(outPath, StaticSession.filename_file);
//					 create.zip(inPath, outPath);
				}
				File fi=new File(outputFile);
				fi.delete();
			}

		} catch (Exception e) {
		}
		return filename;
	}

	*/
/**
	 * 数据的单元格样式
	 * 
	 * @return
	 *//*

	public HSSFCellStyle getGenCellStyle(HSSFWorkbook workbook) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT); // 单元格内容右对齐.
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 设置上下左右边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		return cellStyle;
	}

	*/
/**
	 * 创建单元格的标注
	 *//*

	public HSSFCellStyle getTitleCellStyle(HSSFWorkbook workbook, HSSFFont hf) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		hf.setFontHeight((short) 300);
		hf.setColor(HSSFFont.COLOR_NORMAL);
		hf.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 设置粗体.

		cellStyle.setFont(hf); // 粗体
		// cellStyle.setFillPattern(HSSFColor.YELLOW.index);
		// cellStyle.setFillBackgroundColor(HSSFColor.YELLOW.index);
		// // 设定单元个背景颜色
		// cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 单元格内容中间对齐
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 设置上下左右边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		return cellStyle;
	}

	*/
/**
	 * 返回报表头的样式
	 *//*

	public void getHeadRow(HSSFWorkbook workbook, HSSFSheet sheet, HSSFRow row,
			HSSFFont hf, short num) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFCell cell = row.createCell((short) 0);
		hf.setFontHeight((short) 1);
		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) num));
		cellStyle.setFont(hf);// 
		cellStyle.setAlignment((short) HSSFCellStyle.ALIGN_CENTER);
		cell.setCellStyle(cellStyle);
		cell.setEncoding((short) HSSFCell.ENCODING_UTF_16);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(titleType);
	}
	*/
/**
	 * 返回报表头的样式
	 *//*

	public void getHeadRow(HSSFWorkbook workbook, HSSFSheet sheet, HSSFRow row,
			HSSFFont hf) {
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		row = sheet.createRow((short) 0);
		HSSFCell cell = row.createCell((short) 0);
		hf.setFontHeight((short) 1);
		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 7));
		cellStyle.setFont(hf);// 
		cellStyle.setAlignment((short) HSSFCellStyle.ALIGN_CENTER);
		cell.setCellStyle(cellStyle);
		cell.setEncoding((short) HSSFCell.ENCODING_UTF_16);
		cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell.setCellValue(titleType);
	}
	*/
/**
	 * 定义时间类型的单元格
	 *//*

	public HSSFCellStyle getDateCellStyle(HSSFWorkbook workbook) {

		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT); // 单元格内容右对齐.
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);// 设置上下左右边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		return cellStyle;
	}

	*/
/**
	 * 定义获取当前时间
	 *//*

	public static String getNowTime() {
		SimpleDateFormat timeFormart = new SimpleDateFormat("yyMMddhhmmssS");
		String time = timeFormart.format(new Date(System.currentTimeMillis()));
		return time;
	}
}*/
