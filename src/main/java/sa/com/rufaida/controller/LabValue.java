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

import sa.com.rufaida.domain.Clinic;
import sa.com.rufaida.domain.DdlValueEntity;
import sa.com.rufaida.domain.LabValueEntity;
import sa.com.rufaida.service.Database;

@Controller
public class LabValue {

	Connection connection = new Database().getConnection();
	PreparedStatement statement = null;
	
	
	
	@RequestMapping("/rufaida/GetLabValue")
    @ResponseBody
	public HashMap<String, Object> GetLabValue(String analyzer, String analysis, String ws,String resultType){
		
		HashMap<String, Object> plr = new HashMap<String, Object>();
        List<LabValueEntity> ap = new ArrayList<LabValueEntity>();
        
        
        String sql = null;
        if (resultType == "3")
        {
           sql =
          "select t_nr_from, t_nr_to, T02006.t_lang2_name gender_name,T_DAYS_FROM," +
          " T_DAYS_TO,T_YEAR_FROM,T_YEAR_TO    " +
          " from T13014,T02006" +
         "  where   T02006.t_sex_code(+) = T13014.T_GENDER " +
         "  and T13014.t_ws_code='" + ws + "' " +
          " and T13014.t_analysis_code='" + analysis + "' " +
         "  ORDER BY T02006.t_sex_code DESC,T_YEAR_FROM ASC";
        }
        else
        {
            sql =
           "select t_nr_from, t_nr_to, T02006.t_lang2_name gender_name,T_DAYS_FROM," +
           " T_DAYS_TO,T_YEAR_FROM,T_YEAR_TO    " +
           " from T13014,T02006" +
          "  where   T02006.t_sex_code(+)= T13014.T_GENDER " +
          " and T13014.t_analyzer_id='" + analyzer + "' and T13014.t_ws_code='" + ws + "' " +
           " and T13014.t_analysis_code='" + analysis + "' " +
          "  ORDER BY T02006.t_sex_code DESC,T_YEAR_FROM ASC";
        }
       
        
        /*===========================
         *Start Database operation
         *===========================
         */
        
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 LabValueEntity labValueEntity = new LabValueEntity();
                     // a.analyzer_name = v["analtzer_name"].ToString();
                     // a.ws_name = v["ws_name"].ToString();
                     // a.analysis_name = v["analysis_name"].ToString();
            		 labValueEntity.setGender_name(resultSet.getString("gender_name"));
            		 labValueEntity.setDays_from(resultSet.getString("T_DAYS_FROM"));
            		 labValueEntity.setDays_to(resultSet.getString("T_DAYS_TO"));
            		 labValueEntity.setYear_from(resultSet.getString("T_YEAR_FROM"));
            		 labValueEntity.setYear_to(resultSet.getString("T_YEAR_TO"));
            		 labValueEntity.setT_nr_from(resultSet.getString("t_nr_from"));
            		 labValueEntity.setT_nr_to(resultSet.getString("t_nr_to"));
                     // a.t_result_type = v["t_result_type"].ToString();
                     // a.result_name = v["result_name"].ToString();
                      ap.add(labValueEntity);
    			 }
             }else{
            	 System.out.println("not found");
             }
             
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {/*
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
		*/}
         
         
         /*===========================
          *End Database operation
          *===========================
          */
         
         //TODO  check list Data is Empty
         
         if(!ap.isEmpty()){
        	 plr.put("data", ap);
         }else{
        	 plr.put("data", "not found");
         }
         
        return plr;
    }
	
	
	@RequestMapping("/rufaida/GetAnalyzer")
    @ResponseBody
	public HashMap<String, Object> GetAnalyzer(){
		HashMap<String, Object> plr = new HashMap<String, Object>();
        List<DdlValueEntity> ap = new ArrayList<DdlValueEntity>();
        String sql ="select * from T13049 order by t_lang2_name";

        /*===========================
         *Start Database operation
         *===========================
         */
        
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DdlValueEntity a = new DdlValueEntity();
                     a.setName(resultSet.getString("t_lang2_name"));
                     a.setCode(resultSet.getString("t_analyzer_id"));
                     ap.add(a);
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
         
         
         /*===========================
          *End Database operation
          *===========================
          */
        
         //TODO  check list Data is Empty
         
         if(!ap.isEmpty()){
        	 plr.put("data", ap);
         }else{
        	 plr.put("data", "not found");
         }
         
        return plr;
        
    }
	
	
	
	
	
	
	
	
	
}
