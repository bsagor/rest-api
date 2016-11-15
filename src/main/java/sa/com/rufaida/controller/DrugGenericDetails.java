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

import sa.com.rufaida.domain.Generic;
import sa.com.rufaida.service.Database;

@Controller
public class DrugGenericDetails {

	@RequestMapping("/rufaida/GetGenericName")
    @ResponseBody
	 public HashMap<String, Object> GetGenericName()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Generic> genNameList = new ArrayList<Generic>();

        String sql = " Select T_ENTRY_USER, to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE,T_UPD_USER, to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE,"+
                    " T_GEN_CODE,T_LANG1_NAME,T_LANG2_NAME,T_DRUG_THERAP_CLS_CODE,T_ACTIVE_FLAG,T_CONTROL_DRUG,T_DRUG_USE from T30004  ";

         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Generic generic = new Generic();
                     generic.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     generic.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     generic.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     generic.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     generic.setGEN_CODE(resultSet.getString("T_GEN_CODE"));
                     generic.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     generic.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     generic.setDRUG_THERAP_CLS_CODE(resultSet.getString("T_DRUG_THERAP_CLS_CODE"));
                     generic.setACTIVE_FLAG(resultSet.getString("T_ACTIVE_FLAG"));
                     generic.setCONTROL_DRUG(resultSet.getString("T_CONTROL_DRUG"));
                     generic.setDRUG_USE(resultSet.getString("T_DRUG_USE"));

                     genNameList.add(generic);
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
         
         if(!genNameList.isEmpty()){
        	 plr.put("data", genNameList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
