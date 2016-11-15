package sa.com.rufaida.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sa.com.rufaida.domain.Severity;
import sa.com.rufaida.service.Database;

@Controller
public class SeverityDetails {

	@RequestMapping("/rufaida/GetSeverity")
    @ResponseBody
	 public HashMap<String, Object> GetSeverity()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Severity> severityList = new ArrayList<Severity>();
		 
        String sql = " select T_SEVERITY_CODE , T_LANG2_NAME  , T_LANG1_NAME  , T_SEVERITY_COMM ,"+
         " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ,"+
         " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  "+
         " FROM   T30031";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Severity severity = new Severity();
                     severity.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     severity.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     severity.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     severity.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     severity.setSEVERITY_CODE(resultSet.getString("T_SEVERITY_CODE"));                
                     severity.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     severity.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));              
                     severity.setSEVERITY_COMM(resultSet.getString("T_SEVERITY_COMM"));          
                     severityList.add(severity);
    			 }
             }else{
            	 System.out.println("not found");
             }
             
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
         
         if(!severityList.isEmpty()){
        	 plr.put("data", severityList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
