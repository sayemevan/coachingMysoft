
package com.sayem.coachingMysoft.controller;

import com.sayem.coachingMysoft.repository.JasperReportRepository;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ReportController {
    
    @GetMapping("/reportView/{payid}")
    public void generateStudentPaymentReport(@PathVariable("payid") String payid, HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {

        String reportFileName = "studentpayment";
        
        JasperReportRepository jrdao = new JasperReportRepository();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("payid", payid);
            
            JasperPrint jasperReport = jrdao.getCompiledFile2(reportFileName, hmParams, request);
            
            response.setContentType("application/pdf");
            
            OutputStream out = response.getOutputStream();
            
            JasperExportManager.exportReportToPdfStream(jasperReport, out);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }
    
    @GetMapping("/reportTeacher/{tpayid}")
    public void generateDatePurchaseReport(@PathVariable("tpayid") String tpayid, HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {

        String reportFileName = "teacherpayment";
        
        JasperReportRepository jrdao = new JasperReportRepository();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("tpayid", tpayid);
            
            JasperPrint jasperReport = jrdao.getCompiledFile2(reportFileName, hmParams, request);
            
            response.setContentType("application/pdf");
            
            OutputStream out = response.getOutputStream();
            
            JasperExportManager.exportReportToPdfStream(jasperReport, out);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }
    
}
