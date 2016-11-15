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

import sa.com.rufaida.domain.FormulaNotes;
import sa.com.rufaida.service.Database;

@Controller
public class FormulaNotesDetails {

	@RequestMapping("/rufaida/GetFormulaNotes")
    @ResponseBody
	 public HashMap<String, Object> GetFormulaNotes()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<FormulaNotes> formulaNotesList = new ArrayList<FormulaNotes>();
        
        String sql = " select T_GEN_CODE , T_FORMULA_CODE , T_FORMULA_NOTES ," +
                 " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                 " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                 " FROM   T30026";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 FormulaNotes formulaNotes = new FormulaNotes();
                     formulaNotes.setGEN_CODE(resultSet.getString("T_GEN_CODE"));
                     formulaNotes.setFORMULA_CODE(resultSet.getString("T_FORMULA_CODE"));
                     formulaNotes.setFORMULA_NOTES(resultSet.getString("T_FORMULA_NOTES"));
                     formulaNotes.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     formulaNotes.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     formulaNotes.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     formulaNotes.setUPD_USER(resultSet.getString("T_UPD_USER"));

                     formulaNotesList.add(formulaNotes);
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
         
         if(!formulaNotesList.isEmpty()){
        	 plr.put("data", formulaNotesList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
