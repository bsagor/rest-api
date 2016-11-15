package sa.com.rufaida.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sa.com.rufaida.domain.LoginEntity;
import sa.com.rufaida.domain.Patient;
import sa.com.rufaida.service.Database;

@Controller
public class Login {

	@RequestMapping("/rufaida/IsValidUser")
    @ResponseBody
	 public HashMap<String, Object> IsValidUser(String T_LOGIN_NAME, String T_PWD)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		String sql = "SELECT T01009.T_EMP_CODE, T01009.T_LOGIN_NAME, T35001.T_DOC_CODE FROM T01009, T35001 WHERE T01009.T_EMP_CODE = T35001.T_USER_CODE AND T01009.T_LOGIN_NAME = '" +
                T_LOGIN_NAME + "' AND T01009.T_PWD = '" + T_PWD + "' and T01009.T_ROLE_CODE='0235' and T01009.T_ACTIVE_FLAG='1')";   
         
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 plr.put("data", "Success");
             }else{
            	 plr.put("data", "Failure");
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
         
        
         
         return plr;
     }
	
	
	
	@RequestMapping("/rufaida/LoginValidate")
    @ResponseBody
	 public HashMap<String, Object> LoginValidate(String T_LOGIN_NAME, String T_PWD)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		LoginEntity lg = new LoginEntity();

        String sql = "SELECT T01009.T_LOGIN_NAME," +
           " T01009.T_USER_NAME,T35001.t_doc_code, T01009.T_PWD, T01009.T_SITE_CODE, T01009.T_EMP_CODE, " +
           " T01009.T_ROLE_CODE,T01009.T_USER_LANG FROM T01009,T35001 " +
           " WHERE T_LOGIN_NAME='" + T_LOGIN_NAME + "' AND T_PWD='" + T_PWD + "' and T01009.T_EMP_CODE=T35001.T_USER_CODE" +
            " AND T01009.T_ROLE_CODE='0235' AND t01009.t_active_flag='1'";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 lg.setEmp_code(resultSet.getString("T_EMP_CODE"));
                     lg.setDoc_code(resultSet.getString("t_doc_code"));
                     lg.setEmp_name(resultSet.getString("T_USER_NAME"));
                     lg.setLogin_name(resultSet.getString("T_LOGIN_NAME"));
                     lg.setLogin_pass(resultSet.getString("T_PWD"));
                     lg.setRole_code(resultSet.getString("T_ROLE_CODE"));
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
         
         if(lg!=null){
        	 plr.put("data", lg);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	@RequestMapping("/rufaida/PatLoginValidate")
    @ResponseBody
	 public HashMap<String, Object> PatLoginValidate(String T_PAT_NO, String T_MOBILE_NO, String UserType)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		Patient patient = new Patient();

        String sql = "SELECT T03001.T_PAT_NO ,T_MOBILE_NO  ,T03001.T_FIRST_LANG2_NAME || ' ' || T03001.T_FATHER_LANG2_NAME || ' ' || T03001.T_GFATHER_LANG2_NAME T_PAT_NAME"
        		+ " from T03001 where T03001.T_PAT_NO ='" + T_PAT_NO + "' AND T_MOBILE_NO ='" + T_MOBILE_NO + "'";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 patient.setT_PAT_NO(resultSet.getString("T_PAT_NO"));
                     patient.setT_MOBILE_NO(resultSet.getString("T_MOBILE_NO"));
                     patient.setT_PAT_NAME(resultSet.getString("T_PAT_NAME"));
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
         
         if(patient!=null){
        	 plr.put("data", patient);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	
	
	
	
	
	 
}
