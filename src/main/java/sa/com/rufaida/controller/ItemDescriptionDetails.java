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

import sa.com.rufaida.domain.ItemDescription;
import sa.com.rufaida.service.Database;

@Controller
public class ItemDescriptionDetails {

	@RequestMapping("/rufaida/GetItemDescription")
    @ResponseBody
	 public HashMap<String, Object> GetItemDescription()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<ItemDescription> itemDescriptionList = new ArrayList<ItemDescription>();

        String sql = " Select T_BSE_UM, T_BSE_UNIT_COST_AVG, T_DRUG_CODE, T_ITEM_CODE , T_ITEM_DSCRPTN ,"+
                        " T_ITEM_DSCRPTN_SNDX , T_LAST_LOT_NO , T_LEAD_TIME , T_MAIN_STK_LOC_CODE , T_VENDOR_CODE ,"+
                        " T_IOS_NUMBER , T_PROD_CAT_MCODE , T_PROD_CAT_SCODE , T_PROD_CLASS_CODE , T_PHYSICAL_STATE ,"+
                        " T_MANUFACTURER_CODE , T_MARKUP_QTY , T_ITEM_ACTIVE_FLAG , T_EXPIRY_DATE_FLAG ,"+
                        " T_MON_NONMOH_FLAG , T_ITEM_DSCRPTN_ARB , T_MOH_ITEM_CODE , T_DRUG_MASTER_CODE , T_OLD_BSE ,"+
                        " T_ACTIVE_FLAG , T_BUS_CNTR_PRICE , "+
                    " T_ENTRY_USER, to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE, T_UPD_USER,"+
                    " to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE "+
                    " from T30042 ";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 ItemDescription itemDescription = new ItemDescription();
                     itemDescription.setBSE_UM(resultSet.getString("T_BSE_UM"));
                     itemDescription.setBSE_UNIT_COST_AVG(resultSet.getInt("T_BSE_UNIT_COST_AVG"));
                     itemDescription.setDRUG_CODE(resultSet.getString("T_DRUG_CODE"));
                     itemDescription.setITEM_CODE(resultSet.getString("T_ITEM_CODE"));

                     itemDescription.setITEM_DSCRPTN(resultSet.getString("T_ITEM_DSCRPTN"));
                     itemDescription.setITEM_DSCRPTN_SNDX(resultSet.getString("T_ITEM_DSCRPTN_SNDX"));
                     itemDescription.setLAST_LOT_NO(resultSet.getInt("T_LAST_LOT_NO"));
                     itemDescription.setLEAD_TIME(resultSet.getInt("T_LEAD_TIME"));

                     itemDescription.setMAIN_STK_LOC_CODE(resultSet.getString("T_MAIN_STK_LOC_CODE"));

                     itemDescription.setVENDOR_CODE(resultSet.getString("T_VENDOR_CODE"));
                     itemDescription.setIOS_NUMBER(resultSet.getString("T_IOS_NUMBER"));

                     itemDescription.setPROD_CAT_MCODE(resultSet.getString("T_PROD_CAT_MCODE"));
                     itemDescription.setPROD_CAT_SCODE(resultSet.getString("T_PROD_CAT_SCODE"));
                     itemDescription.setPROD_CLASS_CODE(resultSet.getString("T_PROD_CLASS_CODE"));
                     itemDescription.setPHYSICAL_STATE(resultSet.getString("T_PHYSICAL_STATE"));

                     itemDescription.setMANUFACTURER_CODE(resultSet.getString("T_MANUFACTURER_CODE"));
                     itemDescription.setMARKUP_QTY(resultSet.getInt("T_MARKUP_QTY"));
                     
                     itemDescription.setITEM_ACTIVE_FLAG(resultSet.getString("T_ITEM_ACTIVE_FLAG"));
                     itemDescription.setEXPIRY_DATE_FLAG(resultSet.getString("T_EXPIRY_DATE_FLAG"));
                     itemDescription.setMON_NONMOH_FLAG(resultSet.getString("T_MON_NONMOH_FLAG"));
                     itemDescription.setITEM_DSCRPTN_ARB(resultSet.getString("T_ITEM_DSCRPTN_ARB"));
                     
                     itemDescription.setMOH_ITEM_CODE(resultSet.getString("T_MOH_ITEM_CODE"));
                     itemDescription.setDRUG_MASTER_CODE(resultSet.getString("T_DRUG_MASTER_CODE"));
                     itemDescription.setOLD_BSE(resultSet.getString("T_OLD_BSE"));
                     itemDescription.setACTIVE_FLAG(resultSet.getString("T_ACTIVE_FLAG"));

                     itemDescription.setBUS_CNTR_PRICE(resultSet.getInt("T_BUS_CNTR_PRICE"));

                     itemDescription.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     itemDescription.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     itemDescription.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     itemDescription.setUPD_USER(resultSet.getString("T_UPD_USER"));

                     itemDescriptionList.add(itemDescription);
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
         
         if(!itemDescriptionList.isEmpty()){
        	 plr.put("data", itemDescriptionList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
