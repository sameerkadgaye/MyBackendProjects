/**
 * 
 */
package com.practice.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 * @author palash.kharwade
 *
 */

@SuppressWarnings("deprecation")
public class ExportReport {
	
//	public void generateBlankReport(Map<String, Object> parameters, HttpServletResponse response, Connection conn)throws IOException {
//		//String sourceFileName = "D:\\Project-Workspace\\MIS-Project\\MES\\src\\main\\webapp\\WEB-INF\\report\\CommonBlankReport.jrxml";
//		Path filePath = Paths.get("./src/main/resources/static/Reports/CommonBlankReport.jrxml");
//
//		String sourceFileName = filePath.toString();
//		System.out.println(sourceFileName);
//
//		System.err.println("---------------------------Common Blank Report----------------------------------------");
//
//		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(null);
//		try {
//			JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
//			System.out.println("Filling report...");
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, datasource);
//			System.out.println("jasper print....." + jasperPrint.getPages().size());
//			int pages = jasperPrint.getPages().size();// report1
//			System.out.println("Filling pages..." + pages);
//
//			byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
//			response.reset();
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("application/pdf");
//			response.setHeader("Cache-Control", "no-store");
//			response.setHeader("Cache-Control", "private");
//			response.setHeader("Pragma", "no-store");
//			response.setContentLength(pdfReport.length);
//			
//			System.out.println("-------------------------pdfReport.length=" + pdfReport.length);
//			
//			response.getOutputStream().write(pdfReport);
//			response.getOutputStream().flush();
//			response.getOutputStream().close();
//		} catch (JRException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void generateCommonReport(String jrxmlName, String type, Map<String, Object> parameters,
//			HttpServletResponse response, Connection conn) throws IOException {
//		System.out.println("--------------------under export report---------------------");
//
//		System.out.println("List of user : " + conn);
//		Path filePath = Paths.get("./src/main/resources/static/Reports/" + jrxmlName);
//
//		String sourceFileName = filePath.toString();
//		System.out.println(sourceFileName);
//		try {
//			JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
//			System.out.println("Filling report...");
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
//			System.out.println("jasper print....." + jasperPrint.getPages().size());
//			int pages = jasperPrint.getPages().size();// report1
////			int pages = 2;// report1
//			System.out.println("-------------Filling pages------------------" + pages);
//			
//			if (pages == 0) {
//				generateBlankReport(parameters, response, conn);
//			} else {
//				if (type.equals("pdf")) {
//					JasperExportManager.exportReportToPdf(jasperPrint);
//					byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
//					System.out.println("--------------pdfReport====" + pdfReport.toString());
//					response.reset();
//					response.setCharacterEncoding("UTF-8");
//					response.setContentType("application/pdf");
//					response.setHeader("Access-Control-Allow-Origin", "*");
//					response.setHeader("Cache-Control", "no-store");
//					response.setHeader("Cache-Control", "private");
//					response.setHeader("Pragma", "no-store");
//					response.setContentLength(pdfReport.length);
//
//					System.out.println("---------pdfReport.length------------" + pdfReport.length);
//					
//					response.getOutputStream().write(pdfReport);
//					response.getOutputStream().flush();
//					response.getOutputStream().close();
//				} else if (type.equals("rtf")) {
//					JRRtfExporter exporterRTF = new JRRtfExporter();
//					exporterRTF.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//					exporterRTF.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
//					// exporterRTF.setParameter(JRExporterParameter.OUTPUT_STREAM,outputStream);
//					response.setCharacterEncoding("UTF-8");
//					response.setContentType("application/rtf");
//					response.setHeader("Cache-Control", "no-store");
//					response.setHeader("Cache-Control", "private");
//					response.setHeader("Pragma", "no-store");
//					exporterRTF.exportReport();
//				} else if (type.equals("excel")) {
//					JRXlsExporter exporter = new JRXlsExporter();
//					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//					ByteArrayOutputStream os = new ByteArrayOutputStream();
//					exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//					exporter.exportReport();
//					response.setContentType("application/vnd.ms-excel");
//					response.setHeader("Content-Disposition", "private");
//					response.getOutputStream().write(os.toByteArray());
//					response.flushBuffer();
//				} else if (type.equals("html")) {
//					JRExporter<?, ?, ?, ?> exporter = new JRXhtmlExporter();
//					exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
//					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//					exporter.setParameter(JRExporterParameter.OUTPUT_WRITER, response.getWriter());
//					response.setCharacterEncoding("UTF-8");
//					response.setContentType("text/html; charset=UTF-8");
//					response.setHeader("Cache-Control", "no-store");
//					response.setHeader("Cache-Control", "private");
//					response.setHeader("Pragma", "no-store");
//					exporter.exportReport();
//				}
//			}
//			// JasperExportManager.exportReportToPdfFile(jasperPrint,"report.pdf" );
//		} catch (JRException e) {
//			generateBlankReport(parameters, response, conn);
//		}
//	}
	
	public void generatePRCReport(String jrxmlName,Map<String, Object> parameters, String type,HttpServletResponse response, Connection conn)throws IOException {
//		ReadServerSetting.getValue();
//	    System.out.println("path.." + ReadServerSetting.reportPath);
		Path filePath = Paths.get("./src/main/resources/static/Reports/" + jrxmlName);
		String sourceFileName = filePath.toString();

	    System.out.println("Path====="+sourceFileName);
		try {
			   //JRProperties.setProperty( JRQueryExecuterFactory.QUERY_EXECUTER_FACTORY_PREFIX+"plsql","com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
			 
			   JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);

			   System.out.println("jasperReport=="+jasperReport);
			   //jasperReport.setProperty( "net.sf.jasperreports.query.executer.factory.plsql","com.jaspersoft.jrx.query.PlSqlQueryExecuterFactory");
			 
			   JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			   System.out.println("jasperPrint=="+jasperPrint);
			   
			   int pages = jasperPrint.getPages().size();
			   System.out.println("pages length=="+pages);
			   if(pages == 0){
				   generateBlankReport(parameters, response, conn);
			   }else{
				   System.out.println("Print");
				   if (type.equals("pdf")) {
					byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
					System.out.println("--------------pdfReport====" + pdfReport.toString());
					response.reset();
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/pdf");
					response.setHeader("Access-Control-Allow-Origin", "*");
					response.setHeader("Cache-Control", "no-store");
					response.setHeader("Cache-Control", "private");
					response.setHeader("Pragma", "no-store");
					response.setContentLength(pdfReport.length);
					response.getOutputStream().write(pdfReport);
					response.getOutputStream().flush();
					response.getOutputStream().close();
				   }
			   }
			   //System.gc();
			}
			catch (Exception ex) {
				generateBlankReport(parameters, response, conn);
			   ex.printStackTrace();
			}
	}
	
	public void generateBlankReport(Map<String, Object> parameters,HttpServletResponse response,Connection conn) throws IOException{
//		String sourceFileName = ReadServerSetting.reportPath + "/CommonBlankReport.jrxml";
		////////System.out.println(sourceFileName);
		
		
		Path filePath = Paths.get("./src/main/resources/static/Reports/CommonBlankReport.jrxml");
		String sourceFileName = filePath.toString();
		System.out.println("Path===="+sourceFileName);
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(sourceFileName);
			System.out.println("Filling report...");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
			System.out.println("jasper print....."+jasperPrint.getPages().size());
			
			int pages = jasperPrint.getPages().size();
			System.out.println("Filling pages..."+pages);
			
			byte[] pdfReport = JasperExportManager.exportReportToPdf(jasperPrint);
				response.reset();
				response.setCharacterEncoding("UTF-8");
				response.setContentType("application/pdf");
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Cache-Control", "no-store");
				response.setHeader("Cache-Control", "private");
				response.setHeader("Pragma", "no-store");
				response.setContentLength(pdfReport.length);
			    
				System.out.println("pdfReport.length..."+pdfReport.length);
				
				response.getOutputStream().write(pdfReport);
				response.getOutputStream().flush();
				response.getOutputStream().close();
				System.gc();
		}catch(JRException e){
			e.printStackTrace();
		}
	}
}
