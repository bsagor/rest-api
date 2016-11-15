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

import sa.com.rufaida.domain.Clinic;
import sa.com.rufaida.service.Database;

@Controller
public class ClinicDetails {

	@RequestMapping("/rufaida/GetClinic")
    @ResponseBody
	 public HashMap<String, Object> GetClinic()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		String sql = " select T_CLINIC_CODE , T_CLINIC_NAME_LANG1  , T_CLINIC_NAME_LANG2 , T_CLINIC_DOC_CODE ," +
                " T_CLINIC_SPCLTY_CODE , T_ACTIVE_FLAG , T_CLINIC_HOSP_CODE " +
                " FROM T07001 order by T_CLINIC_NAME_LANG2";     
         
		List<Clinic> clinicList = new ArrayList<Clinic>();
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Clinic clinic = new Clinic();
                     clinic.setCLINIC_CODE(resultSet.getString("T_CLINIC_CODE"));
                     clinic.setCLINIC_NAME_LANG1(resultSet.getString("T_CLINIC_NAME_LANG1"));
                     clinic.setCLINIC_NAME_LANG2(resultSet.getString("T_CLINIC_NAME_LANG2"));
                     clinic.setCLINIC_DOC_CODE(resultSet.getString("T_CLINIC_DOC_CODE"));
                     clinic.setCLINIC_SPCLTY_CODE(resultSet.getString("T_CLINIC_SPCLTY_CODE"));
                     clinic.setACTIVE_FLAG(resultSet.getString("T_ACTIVE_FLAG"));
                     clinic.setCLINIC_HOSP_CODE(resultSet.getString("T_CLINIC_HOSP_CODE"));
                     clinicList.add(clinic);
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
         
         if(!clinicList.isEmpty()){
        	 plr.put("data", clinicList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
