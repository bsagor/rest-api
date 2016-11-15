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

import sa.com.rufaida.domain.Nationlity;
import sa.com.rufaida.service.Database;

@Controller
public class NationalityDetails {

	@RequestMapping("/rufaida/GetNatiolities")
    @ResponseBody
	 public HashMap<String, Object> GetNatiolities()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Nationlity> natiolityList = new ArrayList<Nationlity>();

        String sql="select T_ENTRY_USER, to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE,T_UPD_USER,"+
                    " to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE,T_NTNLTY_CODE,T_LANG1_NAME,T_LANG2_NAME,T_X_LANG1_NAME_SHRT from t02003 order by T_LANG2_NAME ";

         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Nationlity natiolity = new Nationlity();
                     natiolity.setUPD_USER(resultSet.getString("T_UPD_USER"));
                     natiolity.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     natiolity.setNTNLTY_CODE(resultSet.getString("T_NTNLTY_CODE"));
                     natiolity.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));                
                     natiolity.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     natiolity.setX_LANG1_NAME_SHRT(resultSet.getString("T_X_LANG1_NAME_SHRT"));
                     natiolity.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     natiolity.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));


                     natiolityList.add(natiolity);
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
         
         if(!natiolityList.isEmpty()){
        	 plr.put("data", natiolityList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
