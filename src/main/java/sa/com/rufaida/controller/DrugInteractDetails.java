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

import sa.com.rufaida.domain.DrugInteraction;
import sa.com.rufaida.service.Database;

@Controller
public class DrugInteractDetails {

	@RequestMapping("/rufaida/GetDrugInteraction")
    @ResponseBody
	 public HashMap<String, Object> GetDrugInteraction()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DrugInteraction> drugInteractionList = new ArrayList<DrugInteraction>();

        String sql = " select T_GEN_CODE , T_SIGNIF_CODE  , T_ONSET_CODE , T_SEVERITY_CODE , T_DOCUM_CODE , T_GEN_GEN_DDI , T_DDI_COMM , T_GEN_DESC , T_GEN_GEN_DDI_DESC , T_PAGE_NO ," +
                 " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                 " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                 " FROM   T30041 where T_GEN_CODE is not null order by T_GEN_CODE";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DrugInteraction drugInteraction = new DrugInteraction();
                     drugInteraction.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     drugInteraction.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     drugInteraction.setGEN_CODE(resultSet.getString("T_GEN_CODE"));
                     drugInteraction.setSIGNIF_CODE(resultSet.getString("T_SIGNIF_CODE"));
                     drugInteraction.setONSET_CODE(resultSet.getString("T_ONSET_CODE"));
                     drugInteraction.setSEVERITY_CODE(resultSet.getString("T_SEVERITY_CODE"));
                     drugInteraction.setDOCUM_CODE(resultSet.getString("T_DOCUM_CODE"));
                     drugInteraction.setGEN_GEN_DDI(resultSet.getString("T_GEN_GEN_DDI"));
                     drugInteraction.setDDI_COMM(resultSet.getString("T_DDI_COMM"));
                     drugInteraction.setGEN_DESC(resultSet.getString("T_GEN_DESC"));
                     drugInteraction.setGEN_GEN_DDI_DESC(resultSet.getString("T_GEN_GEN_DDI_DESC"));
                     drugInteraction.setPAGE_NO(resultSet.getString("T_PAGE_NO"));
                     drugInteraction.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     drugInteraction.setUPD_USER(resultSet.getString("T_UPD_USER"));

                     drugInteractionList.add(drugInteraction);
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
         
         if(!drugInteractionList.isEmpty()){
        	 plr.put("data", drugInteractionList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
