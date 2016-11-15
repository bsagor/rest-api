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

import sa.com.rufaida.domain.TradeDescription;
import sa.com.rufaida.service.Database;

@Controller
public class TradeDescriptionDetails {

	@RequestMapping("/rufaida/GetTradeDescription")
    @ResponseBody
	 public HashMap<String, Object> GetTradeDescription()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<TradeDescription> TradeDescriptionList = new ArrayList<TradeDescription>();

       String sql = " SELECT T30006.T_DRUG_MASTER_CODE as T_DRUG_MASTER_CODE, T30042.T_ITEM_CODE as T_ITEM_CODE," +
                    " T30042.T_ITEM_DSCRPTN as T_ITEM_DSCRPTN" +
                    " FROM T30006,T30042"+
                    " WHERE T30006.T_DRUG_MASTER_CODE = T30042.T_DRUG_MASTER_CODE ";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 TradeDescription tradeDes = new TradeDescription();
            		 tradeDes.setDRUG_MASTER_CODE(resultSet.getString("T_DRUG_MASTER_CODE"));
                     tradeDes.setITEM_CODE(resultSet.getString("T_ITEM_CODE"));
                     tradeDes.setITEM_DSCRPTN(resultSet.getString("T_ITEM_DSCRPTN"));

                     TradeDescriptionList.add(tradeDes);
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
         
         if(!TradeDescriptionList.isEmpty()){
        	 plr.put("data", TradeDescriptionList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
