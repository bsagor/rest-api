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

import sa.com.rufaida.domain.Onset;
import sa.com.rufaida.service.Database;

@Controller
public class OnsetDetails {

	@RequestMapping("/rufaida/GetOnset")
    @ResponseBody
	 public HashMap<String, Object> GetOnset()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Onset> onsetList = new ArrayList<Onset>();

        String sql = " select T_ONSET_CODE , T_LANG2_NAME  , T_LANG1_NAME , T_ONSET_COMM ," +
                 " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                 " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                 " FROM   T30030";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Onset onset = new Onset();
                     onset.setONSET_CODE(resultSet.getString("T_ONSET_CODE"));
                     onset.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     onset.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     onset.setONSET_COMM(resultSet.getString("T_ONSET_COMM"));
                     onset.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     onset.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     onset.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     onset.setUPD_USER(resultSet.getString("T_UPD_USER"));

                     onsetList.add(onset);
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
         
         if(!onsetList.isEmpty()){
        	 plr.put("data", onsetList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
