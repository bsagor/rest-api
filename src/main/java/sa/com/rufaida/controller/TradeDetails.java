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

import sa.com.rufaida.domain.Trade;
import sa.com.rufaida.service.Database;

@Controller
public class TradeDetails {

	@RequestMapping("/rufaida/GetTradeName")
    @ResponseBody
	 public HashMap<String, Object> GetTradeName()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		 List<Trade> TradeNameList = new ArrayList<Trade>();

         String sql = " Select T_ENTRY_USER, to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE,T_UPD_USER,"+
                     " to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE,"+
                     " T_GEN_CODE,T_TRADE_CODE,T_LANG1_NAME,T_LANG2_NAME,T_ACTIVE_FLAG,T_MANUF_CODE " +
                     " from T30005  where T_GEN_CODE is not null ";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Trade tarde = new Trade();
                     tarde.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     tarde.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     tarde.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     tarde.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     tarde.setGEN_CODE(resultSet.getString("T_GEN_CODE"));
                     tarde.setTRADE_CODE(resultSet.getString("T_TRADE_CODE"));
                     tarde.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     tarde.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));              
                     tarde.setACTIVE_FLAG(resultSet.getString("T_ACTIVE_FLAG"));
                     tarde.setMANUF_CODE(resultSet.getString("T_MANUF_CODE"));
                     
                     
                     TradeNameList.add(tarde);
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
         
         if(!TradeNameList.isEmpty()){
        	 plr.put("data", TradeNameList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
