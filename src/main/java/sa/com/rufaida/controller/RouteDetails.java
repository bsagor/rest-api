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

import sa.com.rufaida.domain.Route;
import sa.com.rufaida.service.Database;

@Controller
public class RouteDetails {

	@RequestMapping("/rufaida/GetRoute")
    @ResponseBody
	 public HashMap<String, Object> GetRoute()
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Route> routeList = new ArrayList<Route>();

        String sql = " select T_DRUG_ROUTE_CODE , T_LANG1_NAME  , T_LANG2_NAME ," +
                 " to_char(T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ," +
                 " T_ENTRY_USER  ,to_char(T_UPD_DATE,'dd/mm/yyyy') T_UPD_DATE ,T_UPD_USER  " +
                 " FROM   T30002";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Route route = new Route();
                     route.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     route.setENTRY_USER(resultSet.getString("T_ENTRY_USER"));                
                     route.setDRUG_ROUTE_CODE(resultSet.getString("T_DRUG_ROUTE_CODE"));
                     route.setLANG1_NAME(resultSet.getString("T_LANG1_NAME"));
                     route.setLANG2_NAME(resultSet.getString("T_LANG2_NAME"));
                     route.setUPD_DATE(resultSet.getString("T_UPD_DATE"));
                     route.setUPD_USER(resultSet.getString("T_UPD_USER"));

                     routeList.add(route);
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
         
         if(!routeList.isEmpty()){
        	 plr.put("data", routeList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
