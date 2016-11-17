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
import sa.com.rufaida.service.Database;

@Controller
public class LoginController {
	
	@RequestMapping("/rufaida/doctorLogin")
    @ResponseBody
	 public HashMap<String, Object> doctorLogin(String username, String password)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DoctorLoginEntity> doctorLoginEntityList = new ArrayList<DoctorLoginEntity>();

        String sql = "SELECT " +
        				"T01009.T_LOGIN_NAME, T01009.T_PWD, T02039.T_DOC_CODE, T02039.T_SPCLTY_CODE, " +
        				"T02029.T_EMP_QUALIF, T01009.T_EMP_CODE , T01009.T_ROLE_CODE, T01009.T_USER_NAME, " +
        				"T02039.T_DESIGNATION , T02041.T_LANG2_NAME, T02029.T_EMP_SEX " +
        			"FROM " + 
        				"T02039, T01009,T02041, T02029 " + 
        			"WHERE " + 
        				"T02039.T_EMP_CODE = T01009.T_EMP_CODE " + 
        			"AND " + 
        				"T02041.T_DESIGN_CODE = T02039.T_DESIGNATION " + 
        			"AND " +
        				"T02029.T_EMP_NO = T02039.T_DOC_CODE " +   
        			"AND " +
        				"T_LOGIN_NAME = '" + username + "' " +
        			"AND " + 
        				"T_PWD = '" + password + "' " + 
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
            		 doctorLoginEntity.setLogin_name(resultSet.getString("T_LOGIN_NAME"));
            		 doctorLoginEntity.setPwd(resultSet.getString("T_PWD"));
            		 doctorLoginEntity.setDoc_code(resultSet.getString("T_DOC_CODE"));
            		 doctorLoginEntity.setSpclty_code(resultSet.getString("T_SPCLTY_CODE"));
            		 doctorLoginEntity.setEmp_qualif(resultSet.getString("T_EMP_QUALIF"));
            		 doctorLoginEntity.setEmp_code(resultSet.getString("T_EMP_CODE"));
            		 doctorLoginEntity.setRole_code(resultSet.getString("T_ROLE_CODE"));
            		 doctorLoginEntity.setUser_name(resultSet.getString("T_USER_NAME"));
            		 doctorLoginEntity.setDesignation(resultSet.getString("T_DESIGNATION"));
            		 doctorLoginEntity.setDesignation_lang2_name(resultSet.getString("T_LANG2_NAME"));
            		 doctorLoginEntity.setEmp_sex(resultSet.getString("T_EMP_SEX"));
            		 
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
}
