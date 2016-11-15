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

import sa.com.rufaida.domain.Profile;
import sa.com.rufaida.service.Database;

@Controller
public class ProfileDetails {

	@RequestMapping("/rufaida/GetAllProfile")
    @ResponseBody
	 public HashMap<String, Object> GetAllProfile(String maxDate)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<Profile> profileList = new ArrayList<Profile>();
        String sql = null;
        if(maxDate == "")
            {
                sql = " select ID,NAME,ADDRESS,EMAIL,PHONE,to_char(t_entry_date,'yyyy-mm-dd HH24:MI:SS') as t_entry_date,to_char(t_last_upd_date,'yyyy-mm-dd HH24:MI:SS') as t_last_upd_date from test_hossain";
            }else{
                sql = " select ID,NAME,ADDRESS,EMAIL,PHONE,to_char(t_entry_date,'yyyy-mm-dd HH24:MI:SS') as t_entry_date,to_char(t_last_upd_date,'yyyy-mm-dd HH24:MI:SS') as t_last_upd_date from test_hossain " +
                " where to_char(t_entry_date,'yyyy-mm-dd HH24:MI:SS') > '" + maxDate + "'";
            }
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Profile profile = new Profile();
                     profile.setID(resultSet.getString("ID"));
                     profile.setNAME(resultSet.getString("NAME"));
                     profile.setEMAIL(resultSet.getString("EMAIL"));
                     profile.setPHONE(resultSet.getString("PHONE"));
                     profile.setT_entry_date(resultSet.getString("t_entry_date"));
                     profile.setT_last_upd_date(resultSet.getString("t_last_upd_date"));

                     profileList.add(profile);
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
         
         if(!profileList.isEmpty()){
        	 plr.put("data", profileList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
}
