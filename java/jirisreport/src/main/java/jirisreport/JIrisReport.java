package jirisreport;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class JIrisReport {

	public static void main(String[] args) {

		generateStaticToPDFFile(
				"C:\\Users\\yurim\\Documents\\jirisreport\\jirisreport\\src\\main\\resources\\sampledata.jrxml",
				"C:\\java\\teste.pdf", "jdbc:IRIS://127.0.0.1:59856/irisapp", "_SYSTEM", "SYS");
	}

	public static void generateStaticToPDFFile(String reportFile, String outFile, String jdbcUrl, String dbUser,
			String dbPassword) {

		try {
			Connection conn = ConnectionFactory.getConnection(jdbcUrl, dbUser, dbPassword);
			JasperReport jasper = JasperCompileManager.compileReport(reportFile);
			JasperPrint print = JasperFillManager.fillReport(jasper, null, conn);
			JasperExportManager.exportReportToPdfFile(print, outFile);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Boolean generateToPDFFile(String reportFile, String outFile, String jdbcUrl, String jsonParameters,
			String dbUser, String dbPassword) {

		Boolean result = true;

		try {
			@SuppressWarnings("unchecked")
			HashMap<String, Object> parameters = new ObjectMapper().readValue(jsonParameters, HashMap.class);

			Connection conn = ConnectionFactory.getConnection(jdbcUrl, dbUser, dbPassword);
			JasperReport jasper = JasperCompileManager.compileReport(reportFile);
			JasperPrint print = JasperFillManager.fillReport(jasper, parameters, conn);
			JasperExportManager.exportReportToPdfFile(print, outFile);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}

	public Boolean generateToWordFile(String reportFile, String outFile, String jdbcUrl, String jsonParameters,
			String dbUser, String dbPassword) {

		Boolean result = true;

		try {
			@SuppressWarnings("unchecked")
			HashMap<String, Object> parameters = new ObjectMapper().readValue(jsonParameters, HashMap.class);

			Connection conn = ConnectionFactory.getConnection(jdbcUrl, dbUser, dbPassword);
			JasperReport jasper = JasperCompileManager.compileReport(reportFile);
			JasperPrint print = JasperFillManager.fillReport(jasper, parameters, conn);

			JRDocxExporter exporter = new JRDocxExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			File exportReportFile = new File(outFile);
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
			exporter.exportReport();

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}
	
	public Boolean generateToExcelFile(String reportFile, String outFile, String jdbcUrl, String jsonParameters,
			String dbUser, String dbPassword) {

		Boolean result = true;

		try {
			@SuppressWarnings("unchecked")
			HashMap<String, Object> parameters = new ObjectMapper().readValue(jsonParameters, HashMap.class);

			Connection conn = ConnectionFactory.getConnection(jdbcUrl, dbUser, dbPassword);
			JasperReport jasper = JasperCompileManager.compileReport(reportFile);
			JasperPrint print = JasperFillManager.fillReport(jasper, parameters, conn);

			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			File exportReportFile = new File(outFile);
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
			exporter.exportReport();

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}
	
	public Boolean generateToHtmlFile(String reportFile, String outFile, String jdbcUrl, String jsonParameters,
			String dbUser, String dbPassword) {

		Boolean result = true;

		try {
			@SuppressWarnings("unchecked")
			HashMap<String, Object> parameters = new ObjectMapper().readValue(jsonParameters, HashMap.class);

			Connection conn = ConnectionFactory.getConnection(jdbcUrl, dbUser, dbPassword);
			JasperReport jasper = JasperCompileManager.compileReport(reportFile);
			JasperPrint print = JasperFillManager.fillReport(jasper, parameters, conn);
			JasperExportManager.exportReportToHtmlFile(print, outFile);
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}

}
