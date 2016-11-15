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

import sa.com.rufaida.domain.UnitMeasurement;
import sa.com.rufaida.service.Database;

@Controller
public class UnitMeasurementDetails {

	@RequestMapping("/rufaida/GetUnitMeasurement")
    @ResponseBody
	 public HashMap<String, Object> GetUnitMeasurement()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<UnitMeasurement> unitMeasurementList = new ArrayList<UnitMeasurement>();

       String sql = " select T_UM , T_LANG1_NAME , T_LANG2_NAME ," +
                 " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                 " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                 " FROM   T30036";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 UnitMeasurement unitMeasurement = new UnitMeasurement();
                     unitMeasurement.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     unitMeasurement.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     unitMeasurement.setUM(resultSet.getString("T_UM"));
                     unitMeasurement.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     unitMeasurement.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     unitMeasurement.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     unitMeasurement.setUPD_USER(resultSet.getString("T_UPD_USER"));

                     unitMeasurementList.add(unitMeasurement);
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
         
         if(!unitMeasurementList.isEmpty()){
        	 plr.put("data", unitMeasurementList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
