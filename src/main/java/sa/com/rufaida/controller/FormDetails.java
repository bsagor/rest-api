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

import sa.com.rufaida.domain.Form;
import sa.com.rufaida.service.Database;

@Controller
public class FormDetails {

	@RequestMapping("/rufaida/GetForm")
    @ResponseBody
	 public HashMap<String, Object> GetForm()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Form> formList = new ArrayList<Form>();

        String sql = " select T_DRUG_FORM_CODE , T_LANG1_NAME  , T_LANG2_NAME ," +
                 " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                 " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                 " FROM   T30001";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Form form = new Form();
                     form.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     form.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     form.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     form.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     form.setDRUG_FORM_CODE(resultSet.getString("T_DRUG_FORM_CODE"));
                     form.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     form.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));

                     formList.add(form);
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
         
         if(!formList.isEmpty()){
        	 plr.put("data", formList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
