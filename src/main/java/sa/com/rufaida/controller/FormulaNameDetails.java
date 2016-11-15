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

import sa.com.rufaida.domain.FormulaName;
import sa.com.rufaida.service.Database;

@Controller
public class FormulaNameDetails {

	@RequestMapping("/rufaida/GetFormulaName")
    @ResponseBody
	 public HashMap<String, Object> GetFormulaName()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<FormulaName> formulaNameList = new ArrayList<FormulaName>();

        String sql = " select T_FRMLRY_CODE , T_LANG2_NAME  , T_LANG1_NAME  , T_SHRT_LANG1_NAME , T_SHRT_LANG2_NAME , " +
         " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
         " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
         " FROM   T30027";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 FormulaName formulaName = new FormulaName();
                     formulaName.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     formulaName.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     formulaName.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     formulaName.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     formulaName.setFRMLRY_CODE(resultSet.getString("T_FRMLRY_CODE"));
                     formulaName.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     formulaName.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     formulaName.setSHRT_LANG1_NAME(resultSet.getString("T_SHRT_LANG1_NAME"));
                     formulaName.setSHRT_LANG2_NAME(resultSet.getString("T_SHRT_LANG2_NAME"));

                     formulaNameList.add(formulaName);
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
         
         if(!formulaNameList.isEmpty()){
        	 plr.put("data", formulaNameList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
