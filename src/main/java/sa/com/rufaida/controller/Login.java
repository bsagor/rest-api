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

import sa.com.rufaida.domain.DoctorLoginEntity;
import sa.com.rufaida.domain.Patient;
import sa.com.rufaida.service.Database;

@Controller
public class Login {
	
	@RequestMapping("/rufaida/doctorLogin")
    @ResponseBody
	 public HashMap<String, Object> doctorLogin(String username, String password)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DoctorLoginEntity> doctorLoginEntityList = new ArrayList<DoctorLoginEntity>();

        String sql = "SELECT " +
        				"T01009.T_LOGIN_NAME, T35001.T_DOC_CODE, T01009.T_PWD, T01009.T_ROLE_CODE, T01009.T_EMP_CODE, T35001.T_USER_CODE " +
        			"FROM " + 
        				"T01009,T35001 " + 
        			"WHERE " + 
        				"T_LOGIN_NAME='" + username + "' " + 
        			"AND " + 
        				"T_PWD='" + password + "' " + 
        			"AND " +
        				"T01009.T_EMP_CODE = T35001.T_USER_CODE " +    
        			"AND " + 
        				"T01009.T_ACTIVE_FLAG = '1'";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DoctorLoginEntity doctorLoginEntity = new DoctorLoginEntity();
            		 doctorLoginEntity.setDoc_code(resultSet.getString("T_DOC_CODE"));
            		 doctorLoginEntity.setEmp_code(resultSet.getString("T_EMP_CODE"));
            		 doctorLoginEntity.setLogin_name(resultSet.getString("T_LOGIN_NAME"));
            		 doctorLoginEntity.setPwd(resultSet.getString("T_PWD"));
            		 doctorLoginEntity.setRole_code(resultSet.getString("T_ROLE_CODE"));
            		 doctorLoginEntity.setUser_code(resultSet.getString("T_USER_CODE"));
            		 
            		 doctorLoginEntityList.add(doctorLoginEntity);
    			 }
             }else{
            	 System.out.println("not found");
             }
             
			
		} catch (SQLException e) {
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
         
         if(doctorLoginEntityList != null){
        	 plr.put("data", doctorLoginEntityList);
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
