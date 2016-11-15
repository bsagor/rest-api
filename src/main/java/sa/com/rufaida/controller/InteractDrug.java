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
import sa.com.rufaida.domain.Drug;
import sa.com.rufaida.service.Database;

@Controller
public class InteractDrug {

	@RequestMapping("/rufaida/GetInteractDrug")
    @ResponseBody
	 public HashMap<String, Object> GetInteractDrug(String genCode)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		 List<Drug> drugList = new ArrayList<Drug>();
		String sql = " SELECT T30004.T_GEN_CODE,T30041.T_GEN_GEN_DDI,"+
	 	        " (SELECT T30004.t_lang2_name as genName2 FROM T30004 "+
		 	    "    WHERE T30004.T_GEN_CODE =T30041.T_GEN_GEN_DDI) as drug_name,"+
		 	    "    t_gen_gen_ddi_desc as drug_name1 "+
			    "    FROM  T30004,T30041"+
	  	        " WHERE  T30041.T_GEN_CODE = T30004.T_GEN_CODE"+
               "  AND    T30041.T_GEN_CODE = '" + genCode + "' " +
		       " ORDER BY  drug_name ASC" ;    
         
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Drug drug = new Drug();
                     drug.setGEN_CODE(resultSet.getString("T_GEN_GEN_DDI"));
                     drug.setGEN_NAME(resultSet.getString("drug_name"));

                     drugList.add(drug);
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
         
         if(!drugList.isEmpty()){
        	 plr.put("data", drugList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
