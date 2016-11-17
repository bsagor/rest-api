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

import sa.com.rufaida.domain.DoctorAppointmentEntity;
import sa.com.rufaida.service.Database;

@Controller
public class DoctorAppointmentController {
	
	@RequestMapping("/rufaida/doctorAppointment")
    @ResponseBody
	 public HashMap<String, Object> doctorLogin(String date, String doc_code)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DoctorAppointmentEntity> doctorAppointmentList = new ArrayList<DoctorAppointmentEntity>();

        String sql = "SELECT " +
        				"T07003.T_APPT_DATE, T07003.T_APPT_TIME, T03001.T_PAT_NO, T03001.T_FIRST_LANG2_NAME || ' ' " +
        				"|| T03001.T_FATHER_LANG2_NAME || ' ' || T03001.T_GFATHER_LANG2_NAME T_PAT_NAME, " +
        				"T07001.T_CLINIC_NAME_LANG2, T07003.T_CLINIC_DOC_CODE, T07003.T_ARRIVAL_STATUS " +
        			"FROM " + 
        				"T07003, T03001, T07001 " + 
        			"WHERE " + 
        				"T_APPT_DATE = '" + date + "' " + // date formate: 6-DEC-2015
        			"AND " + 
        				"T07003.T_PAT_NO = t03001.T_PAT_NO " + 
        			"AND " +
        				"T07003.T_CLINIC_CODE = T07001.T_CLINIC_CODE " +   
        			"AND " +
        				"T07003.T_CLINIC_DOC_CODE = '" + doc_code + "' ";
        			
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DoctorAppointmentEntity doctorAppointmentEntity = new DoctorAppointmentEntity();
            		 doctorAppointmentEntity.setAppt_date(resultSet.getString("T_APPT_DATE"));
            		 doctorAppointmentEntity.setAppt_time(resultSet.getString("T_APPT_TIME"));
            		 doctorAppointmentEntity.setPat_no(resultSet.getString("T_PAT_NO"));
            		 doctorAppointmentEntity.setPat_name(resultSet.getString("T_PAT_NAME"));
            		 doctorAppointmentEntity.setClinic_name_lang2(resultSet.getString("T_CLINIC_NAME_LANG2"));
            		 doctorAppointmentEntity.setClinic_doc_code(resultSet.getString("T_CLINIC_DOC_CODE"));
            		 String value = resultSet.getString("T_ARRIVAL_STATUS");
            		 if(String.valueOf(value).equals("null")){
            			 value = "NOT ARRIVED";
            		 } else {
            			 value = "ARRIVED";
            		 }
            		 doctorAppointmentEntity.setArrival_status(value);
            		 
            		 doctorAppointmentList.add(doctorAppointmentEntity);
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
         
         if(doctorAppointmentList != null){
        	 plr.put("data", doctorAppointmentList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
}
