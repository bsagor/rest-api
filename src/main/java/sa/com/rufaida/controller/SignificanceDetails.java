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

import sa.com.rufaida.domain.Significance;
import sa.com.rufaida.service.Database;

@Controller
public class SignificanceDetails {

	@RequestMapping("/rufaida/GetSignificance")
    @ResponseBody
	 public HashMap<String, Object> GetSignificance()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		 List<Significance> significanceList = new ArrayList<Significance>();

         String sql = " select T_SIGNIF_CODE , T_LANG2_NAME  , T_LANG1_NAME ," +
          " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
          " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
          " FROM   T30032";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Significance significance = new Significance();
                     significance.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     significance.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     significance.setSIGNIF_CODE(resultSet.getString("T_SIGNIF_CODE"));
                     significance.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     significance.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     significance.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     significance.setUPD_DATE(resultSet.getString("T_UPD_DATE"));

                     significanceList.add(significance);
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
         
         if(!significanceList.isEmpty()){
        	 plr.put("data", significanceList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
