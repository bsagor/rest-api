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

import sa.com.rufaida.domain.Documentation;
import sa.com.rufaida.service.Database;

@Controller
public class DocumentationDetails {

	@RequestMapping("/rufaida/GetDocumentation")
    @ResponseBody
	 public HashMap<String, Object> GetDocumentation()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Documentation> documentationList = new ArrayList<Documentation>();
        String sql = " select T_DOCUM_CODE , T_LANG2_NAME  , T_LANG1_NAME , T_DOCUM_COMM ," +
                     " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                     " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                     " FROM   T30029";
        
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Documentation documentation = new Documentation();
                     documentation.setDOCUM_CODE(resultSet.getString("T_DOCUM_CODE"));
                     documentation.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     documentation.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     documentation.setDOCUM_COMM(resultSet.getString("T_DOCUM_COMM"));
                     documentation.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     documentation.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));
                     documentation.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     documentation.setUPD_USER(resultSet.getString("T_UPD_USER"));

                 documentationList.add(documentation);
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
         
         if(!documentationList.isEmpty()){
        	 plr.put("data", documentationList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
