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

import sa.com.rufaida.domain.DrugMaster;
import sa.com.rufaida.service.Database;

@Controller
public class DrugMasterDetails {

	@RequestMapping("/rufaida/GetDrugMaster")
    @ResponseBody
	 public HashMap<String, Object> GetDrugMaster()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DrugMaster> drugMasterList = new ArrayList<DrugMaster>();

        String sql = " select T_DRUG_MASTER_CODE , T_TRADE_CODE,T_STRENGTH,T_ROUTE_CODE ,T_DRUG_FORM_CODE,"+   
                    " T_BSE_UM  ,T_MOH_ITEM_CODE,T_ACTIVE_FLAG,T_MOH_PRICE,T_MOH_COST," +
                    " T_PACK_CODE , T_DRUG_SFORM_CODE, T_PHYS_STATE,T_REG_NO , T_UNITS  ,T_DRUG_SPCLTY_CODE, T_UPD_REASON  ,T_USER_IP,"+
                    " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                    " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                    " FROM   T30006";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DrugMaster drugMaster = new DrugMaster();
                     drugMaster.setT_DRUG_MASTER_CODE(resultSet.getString("T_DRUG_MASTER_CODE"));
                     drugMaster.setT_TRADE_CODE(resultSet.getString("T_TRADE_CODE"));
                     drugMaster.setT_STRENGTH(resultSet.getString("T_STRENGTH"));
                     drugMaster.setT_ROUTE_CODE(resultSet.getString("T_ROUTE_CODE"));
                     drugMaster.setT_DRUG_FORM_CODE(resultSet.getString("T_DRUG_FORM_CODE"));
                     drugMaster.setT_BSE_UM(resultSet.getString("T_BSE_UM"));
                     drugMaster.setT_MOH_ITEM_CODE(resultSet.getString("T_MOH_ITEM_CODE"));
                     drugMaster.setT_ACTIVE_FLAG(resultSet.getString("T_ACTIVE_FLAG"));
                     
                     drugMaster.setT_MOH_PRICE(resultSet.getDouble("T_MOH_PRICE"));
                     drugMaster.setT_MOH_COST(resultSet.getDouble("T_MOH_COST"));
                     
                     
                     drugMaster.setT_PACK_CODE(resultSet.getString("T_PACK_CODE"));
                     drugMaster.setT_DRUG_SFORM_CODE(resultSet.getString("T_DRUG_SFORM_CODE"));
                     drugMaster.setT_PHYS_STATE(resultSet.getString("T_PHYS_STATE"));
                     drugMaster.setT_REG_NO(resultSet.getString("T_REG_NO"));
                     drugMaster.setT_UNITS(resultSet.getInt("T_UNITS"));
                     drugMaster.setT_DRUG_SPCLTY_CODE(resultSet.getString("T_DRUG_SPCLTY_CODE"));
                     drugMaster.setT_UPD_REASON(resultSet.getString("T_UPD_REASON"));
                     drugMaster.setT_USER_IP(resultSet.getString("T_USER_IP"));
                     drugMaster.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     drugMaster.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     drugMaster.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     drugMaster.setUPD_USER(resultSet.getString("T_UPD_USER"));

                     drugMasterList.add(drugMaster);
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
         
         if(!drugMasterList.isEmpty()){
        	 plr.put("data", drugMasterList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
