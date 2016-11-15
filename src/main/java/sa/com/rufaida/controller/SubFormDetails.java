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

import sa.com.rufaida.domain.SubForm;
import sa.com.rufaida.service.Database;

@Controller
public class SubFormDetails {

	@RequestMapping("/rufaida/GetSubForm")
    @ResponseBody
	 public HashMap<String, Object> GetSubForm()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<SubForm> subFormList = new ArrayList<SubForm>();

        String sql = " select T_ENTRY_USER, to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE,T_UPD_USER,"+
                    " to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE,T_DRUG_FORM_SCODE,T_LANG1_NAME,T_LANG2_NAME,T_DRUG_FORM_CODE from t30037 ";

         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 SubForm subForm = new SubForm();
                     subForm.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     subForm.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     subForm.setDRUG_FORM_SCODE(resultSet.getString("T_DRUG_FORM_SCODE"));
                     subForm.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     subForm.setDRUG_FORM_CODE(resultSet.getString("T_DRUG_FORM_CODE"));
                     subForm.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     subForm.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     subForm.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     

                     subFormList.add(subForm);
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
         
         if(!subFormList.isEmpty()){
        	 plr.put("data", subFormList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
