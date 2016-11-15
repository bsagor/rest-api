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

import sa.com.rufaida.domain.Therap;
import sa.com.rufaida.service.Database;

@Controller
public class TherapDetails {

	@RequestMapping("/rufaida/GetTherapName")
    @ResponseBody
	 public HashMap<String, Object> GetTherapName()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Therap> therapNameList = new ArrayList<Therap>();

        String sql = " select T_ENTRY_USER, to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE,T_UPD_USER,"+
                    " to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE,T_DRUG_THERAP_CLS_CODE,T_LANG1_NAME,T_LANG2_NAME from t30003 ";

         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Therap therap = new Therap();
                     therap.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     therap.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     therap.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     therap.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     therap.setDRUG_THERAP_CLS_CODE(resultSet.getString("T_DRUG_THERAP_CLS_CODE"));
                     therap.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     therap.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     
                     therapNameList.add(therap);
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
         
         if(!therapNameList.isEmpty()){
        	 plr.put("data", therapNameList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
