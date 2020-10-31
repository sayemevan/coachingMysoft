
package com.sayem.coachingMysoft.repository;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Repository;


/**
 *
 * @author ASUS
 */
@Repository
public class JasperReportRepository {
    
    public Connection getConnection() throws SQLException {
        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Please include Classpath Where your MySQL Driver is located");
            e.printStackTrace();
        }

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cm", "root", "123");

        if (conn != null) {
            System.out.println("Database Connected");
        } else {
            System.out.println(" connection Failed ");
        }

        return conn;

    }

    public JasperReport getCompiledFile(String fileName, HttpServletRequest request) throws JRException {
        System.out.println("path " + request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
        File reportFile = new File(request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
        // If compiled file is not found, then compile XML template
        if (!reportFile.exists()) {
            JasperCompileManager.compileReportToFile(request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jrxml"), request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
        }
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
        return jasperReport;
    }

    public void generateReportPDF(HttpServletResponse resp, Map parameters, JasperReport jasperReport, Connection conn) throws JRException, NamingException, SQLException, IOException {
        byte[] bytes = null;
        bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, conn);
        resp.reset();
        resp.resetBuffer();
        resp.setContentType("application/pdf");
        resp.setContentLength(bytes.length);
        ServletOutputStream ouputStream = resp.getOutputStream();
        ouputStream.write(bytes, 0, bytes.length);
        ouputStream.flush();
        ouputStream.close();
    }
    
     public JasperPrint getCompiledFile2(String fileName, HashMap<String, Object> hmParams, HttpServletRequest request) throws Exception {
        System.out.println("path " + request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper"));
        
        String path =  request.getSession().getServletContext().getRealPath("/report/" + fileName + ".jasper");
        
        return JasperFillManager.fillReport(path, hmParams, getConnection());
         
    }
    
}
