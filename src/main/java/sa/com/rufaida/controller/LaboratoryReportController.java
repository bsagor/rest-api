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

import sa.com.rufaida.domain.LaboratoryReportEntity;
import sa.com.rufaida.service.Database;

@Controller
public class LaboratoryReportController {
	
	@RequestMapping("/rufaida/labReport")
    @ResponseBody
	 public HashMap<String, Object> labReport(String patNo, String ws_code, String fromDate, String toDate, String reqNo)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<LaboratoryReportEntity> laboratoryReportList = new ArrayList<LaboratoryReportEntity>();

        String sql =  
            "SELECT DISTINCT " + 
                "T13017.T_REQUEST_NO, T13015.T_PAT_NO, T02006.T_LANG2_NAME AS SEX, " + 
                "T_FIRST_LANG2_NAME ||' ' ||T_FATHER_LANG2_NAME ||' '|| T_GFATHER_LANG2_NAME ||' '|| T_FAMILY_LANG2_NAME T_PAT_NAME, " +  
                "TO_CHAR(T13015.T_REQUEST_DATE,'dd/mm/yyyy') T_REQUEST_DATE, T13004.T_LANG2_NAME LAB_NAME, T13004.T_WS_CODE, " + 
                "TO_CHAR(T13017.T_RECEIVED_DATE,'dd/mm/yyyy') T_RECEIVED_DATE, T13011.T_ANALYSIS_CODE, T13011.T_LANG2_NAME AS T_ANALYSIS, " + 
                "T13017.T_LAB_NO,T13004.T_LANG2_NAME AS LAB_LOCATION, T13015.T_STATUS_CODE, T13007.T_LANG2_NAME STATUS_NAME, " +
                "TRUNC(MONTHS_BETWEEN(SYSDATE, T03001.T_BIRTH_DATE )/12,0) YRS, " + 
                "TRUNC(MOD(MONTHS_BETWEEN(SYSDATE, T03001.T_BIRTH_DATE), 12), 0) MOS, " + 
                "TRUNC(SYSDATE-ADD_MONTHS(T03001.T_BIRTH_DATE, TRUNC(MONTHS_BETWEEN(SYSDATE, T03001.T_BIRTH_DATE)/12)*12 + TRUNC(MOD(MONTHS_BETWEEN(SYSDATE, T03001.T_BIRTH_DATE),12)))) DAYS " + 
            "FROM " + 
                "T13017, T13015, T13004, T03001, T13011, T13016, T13007, T02006 " + 
            "WHERE " + 
                "T13017.T_REQUEST_NO = T13015.T_REQUEST_NO " + 
            "AND " +
                "T03001.T_PAT_NO = T13015.T_PAT_NO " +  
            "AND " +
                "T13017.T_ANALYSIS_CODE = T13011.T_ANALYSIS_CODE " + 
            "AND " +
                "T13017.T_WS_CODE = T13011.T_WS_CODE " + 
            "AND " +
                "T13017.T_WS_CODE = T13004.T_WS_CODE " + 
            "AND " +
                "T13017.T_REQUEST_NO = T13016.T_REQUEST_NO " + 
            "AND " +
                "T13017.T_WS_CODE = T13016.T_WS_CODE " + 
            "AND " +
                "T13017.T_WS_CODE = T13016.T_WS_CODE " + 
            "AND " +
                "T13017.T_ANALYSIS_CODE = T13016.T_ANALYSIS_CODE " +  
            "AND " +
                "T13015.T_STATUS_CODE = T13007.T_STATUS_CODE(+) " +  
            "AND " +
                "T13015.T_REQUEST_DATE BETWEEN  TO_DATE(NVL('" + fromDate + "', '29-JUN-1987'), 'dd-mon-yyyy')  AND TO_DATE(NVL('" + toDate + "', '29-JUN-2187'), 'dd-mon-yyyy') " + 
            "AND " +
                "T13017.T_WS_CODE = NVL('" + ws_code + "', T13017.T_WS_CODE) " + 
            "AND " +
                "T03001.T_PAT_NO = '" + patNo + "' " +
            "AND " +
            	"T02006.T_SEX_CODE = T03001.T_GENDER " +
	        "AND " +
	        	"T13017.T_REQUEST_NO = NVL('" + reqNo + "', T13017.T_REQUEST_NO)";
        			
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 LaboratoryReportEntity laboratoryReportEntity = new LaboratoryReportEntity();
            		 laboratoryReportEntity.setRequest_no(resultSet.getString("T_REQUEST_NO"));
            		 laboratoryReportEntity.setPat_no(resultSet.getString("T_PAT_NO"));
            		 laboratoryReportEntity.setPat_name(resultSet.getString("T_PAT_NAME"));
            		 laboratoryReportEntity.setRequest_date(resultSet.getString("T_REQUEST_DATE"));
            		 laboratoryReportEntity.setLab_name(resultSet.getString("LAB_NAME"));
            		 laboratoryReportEntity.setWs_code(resultSet.getString("T_WS_CODE"));
            		 laboratoryReportEntity.setReceived_date(resultSet.getString("T_RECEIVED_DATE"));
            		 laboratoryReportEntity.setAnalysis_code(resultSet.getString("T_ANALYSIS_CODE"));
            		 laboratoryReportEntity.setAnalysis(resultSet.getString("T_ANALYSIS"));
            		 laboratoryReportEntity.setLab_no(resultSet.getString("T_LAB_NO"));
            		 laboratoryReportEntity.setLab_location(resultSet.getString("LAB_LOCATION"));
            		 laboratoryReportEntity.setStatus_code(resultSet.getString("T_STATUS_CODE"));
            		 laboratoryReportEntity.setStatus_name(resultSet.getString("STATUS_NAME"));
            		 laboratoryReportEntity.setYrs(resultSet.getString("YRS"));
            		 laboratoryReportEntity.setMos(resultSet.getString("MOS"));
            		 laboratoryReportEntity.setDays(resultSet.getString("DAYS"));
            		 laboratoryReportEntity.setSex(resultSet.getString("SEX"));
            		 
            		 
            		 
            		 /*String value = resultSet.getString("T_ARRIVAL_STATUS");
            		 if(String.valueOf(value).equals("null")){
            			 value = "NOT ARRIVED";
            		 } else {
            			 value = "ARRIVED";
            		 }
            		 laboratoryReportEntity.setArrival_status(value);*/
            		 
            		 laboratoryReportList.add(laboratoryReportEntity);
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
         
         if(laboratoryReportList != null){
        	 plr.put("data", laboratoryReportList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
}
