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
import sa.com.rufaida.domain.DrugHistory;
import sa.com.rufaida.domain.DrugHistoryOut;
import sa.com.rufaida.domain.PatAllergy;
import sa.com.rufaida.service.Database;

@Controller
public class InpatientDrugHistory {

	@RequestMapping("/rufaida/GetPatAllergy")
    @ResponseBody
    public HashMap<String, Object> GetPatAllergy(String PAT_NO)
    {
		
		HashMap<String, Object> plr = new HashMap<String, Object>();

        String sql =
           "select t06210.T_lang2_name T_DIET,(select t06210.T_lang2_name medication from t06210,t06209 " +
           " where t06209.t_allergy_medication = t06210.t_index_code "+
           " and t06209.t_pat_no = '"+PAT_NO+"' "+
           " and t06209.t_allergy_medication is not null "+
           " and t06209.t_entry_date =(select max(t_entry_date) from t06209 where t06209.t_pat_no='" + PAT_NO + "' and  t06209.t_allergy_medication is not null)) T_MEDICATION, " +
           " (select t_allergy_others  others from t06209"+
           " where t_pat_no ='"+PAT_NO+"' "+
           " and t_allergy_others is not null"+
           " and t06209.t_entry_date=(select max(t_entry_date) from t06209 where t_pat_no='" + PAT_NO + "' and t_allergy_others is not null)) T_OTHERS " +
           " from t06210,t06209 "+
           " where t06209.t_allergy_diet = t06210.t_index_code "+
           " and t06209.t_pat_no='" + PAT_NO + "' " +
           " and t06209.t_allergy_diet is not null "+
           " and t06209.t_entry_date = (select max(t_entry_date) from t06209 where t06209.t_pat_no='" + PAT_NO + "' and t06209.t_allergy_diet is not null)";

        
        Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
		PatAllergy patAlg = new PatAllergy();
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 patAlg.setT_DIET(resultSet.getString("T_DIET"));
                     patAlg.setT_MEDICATION(resultSet.getString("T_MEDICATION"));
                     patAlg.setT_OTHERS(resultSet.getString("T_OTHERS"));
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
         
         if(patAlg!=null){
        	 plr.put("data", patAlg);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
		
     }
	
	
	
	@RequestMapping("/rufaida/GetInPatDrugHistory")
    @ResponseBody
	public HashMap<String, Object> GetInPatDrugHistory(String PAT_NO, String DOC_NO){
		HashMap<String, Object> plr = new HashMap<String, Object>();
        List<DrugHistory> inPatDrugHistList = new ArrayList<DrugHistory>();
        String sql = "  SELECT T30004.T_GEN_CODE,T30014.T_PAT_NO , T30004.T_LANG2_NAME || ' ' ||T30014.T_REQUEST_STRENGTH || ' ' || T30002.T_LANG2_NAME || ' '|| T30001.T_LANG2_NAME IOS_DESC " +
                      ",T30009.T_LANG2_NAME  as DOSE_TIME_DAILY, T30010.T_LANG2_NAME DOSE_DURATION,to_char(T30014.T_ENTRY_DATE,'dd/mm/yyyy') DOSE_START_DATE " +
                     " ,T30014.T_ENTRY_TIME  DOSE_TIME, T30014.T_REQUEST_DOC "+
                     " ,ltrim(T_NAME_FAMILY ||', '||T_NAME_GIVEN) REQUEST_DOCTOR_NAME,T30014.T_REMARKS "+
                     " FROM T30014,T30009,T30010,T30002,T30004,T30001,T02029 "+
//                     " WHERE T30009.T_FREQUENCY_CODE   = T30014.T_DOSE_TIME_DAILY " + //T30014.T_FREQUENCY
                     " WHERE T30009.T_FREQUENCY_CODE   = T30014.T_FREQUENCY " + 
                     " and T30010.T_DOSE_DURATION_CODE = T30014.T_DOSE_DURATION "+
                     " and T30002.T_DRUG_ROUTE_CODE    = T30014.T_REQUEST_ROUTE  "+
                     " and T30004.T_GEN_CODE           = T30014.T_REQUEST_GCODE "+
                     " and T30001.T_DRUG_FORM_CODE     = T30014.T_REQUEST_MFORM "+
                     " and T02029.T_EMP_NO             = T30014.T_REQUEST_DOC "+
                     //" and T30014.T_REQUEST_DOC        ='"+DOC_NO+"' "+
                    "  and T30014.T_PAT_NO             ='" + PAT_NO + "' " +
                    "  and T30014.t_drug_inactive_flag is null " +
                    "  order by T30014.t_entry_date desc , T30014.t_entry_time desc";

        
        
        
		        Connection connection = new Database().getConnection();
				PreparedStatement statement = null;
		         try {
		        	 statement = connection.prepareStatement(sql);
		             ResultSet resultSet = statement.executeQuery();
		             
		             if(resultSet!=null){
		            	 while (resultSet.next()) {
		            		 DrugHistory drugHistory = new DrugHistory();
		                     drugHistory.setT_GEN_CODE(resultSet.getString("T_GEN_CODE"));
		                     drugHistory.setT_IOS_DESC(resultSet.getString("IOS_DESC"));
		                     drugHistory.setT_DOSE_TIME_DAILY(resultSet.getString("DOSE_TIME_DAILY"));
		                     drugHistory.setT_DOSE_DURATION  (resultSet.getString("DOSE_DURATION"));
		                     drugHistory.setT_DOSE_START_DATE(resultSet.getString("DOSE_START_DATE"));
		                     drugHistory.setT_DOSE_TIME(resultSet.getString("DOSE_TIME"));
		                     drugHistory.setT_REQUEST_DOC(resultSet.getString("T_REQUEST_DOC"));
		                     drugHistory.setT_DOCTOR_NAME(resultSet.getString("REQUEST_DOCTOR_NAME"));
		                     drugHistory.setT_REMARKS(resultSet.getString("T_REMARKS"));              
		                     inPatDrugHistList.add(drugHistory);
		                     
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
		         
		         if(inPatDrugHistList!=null){
		        	 plr.put("data", inPatDrugHistList);
		         }else{
		        	 plr.put("data", "not found");
		         }
		         
		         return plr;
    }
	
	
	
	
	@RequestMapping("/rufaida/GetOutPatDrugHistory")
    @ResponseBody
	public HashMap<String, Object> GetOutPatDrugHistory(String PAT_NO, String DOC_NO)
    {
		HashMap<String, Object> plr = new HashMap<String, Object>();
        List<DrugHistoryOut> outPatDrugHistList2 = new ArrayList<DrugHistoryOut>();
        String sql = " select t30023.t_pat_No,t30023.T_ORGN_DOC,ltrim(T_NAME_FAMILY ||', '||T_NAME_GIVEN) REQUEST_DOCTOR_NAME," +
               " t30023.T_OPD_REQ_ITEM ,t30023.T_REQUEST_STRENGTH, t30023.T_QTY,to_char(t30023.T_ENTRY_DATE,'dd/mm/yyyy')  DOSE_START_DATE ,"+
               " t30023.T_ENTRY_TIME ,t30023.T_DOSE_UNIT ,t30023.T_DOSE_TIME_DAILY , t30023.T_DOSE_DURATION " +
               " from t30023,T02029 "+
               " where t30023.t_pat_no ='" + PAT_NO + "' " +
               //" and t30023.T_ORGN_DOC = nvl('" + DOC_NO + "',t30023.T_ORGN_DOC)" +
               " and t30023.t_drug_inactive_flag is null"+
               " and T02029.T_EMP_NO   = t30023.T_ORGN_DOC " +
               " order by t30023.t_entry_date desc , t30023.t_entry_time desc";

        
        Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DrugHistoryOut drugHistory = new DrugHistoryOut();

                     drugHistory.setT_PAT_NO(resultSet.getString("t_pat_No"));
                     drugHistory.setT_OPT_REQ_ITEM(resultSet.getString("T_OPD_REQ_ITEM"));
                     drugHistory.setT_REQ_STRNGTH(resultSet.getString("T_REQUEST_STRENGTH"));
                     drugHistory.setT_QTY(resultSet.getString("T_QTY"));
                     drugHistory.setT_DOSE_UNIT(resultSet.getString("T_DOSE_UNIT"));
                     drugHistory.setT_DOSE_FREQUENCY(resultSet.getString("T_DOSE_TIME_DAILY"));
                     drugHistory.setT_DOSE_START_DATE(resultSet.getString("DOSE_START_DATE"));
                     drugHistory.setT_DOSE_DURATION(resultSet.getString("T_DOSE_DURATION"));
                     drugHistory.setT_REQUEST_DOC(resultSet.getString("T_ORGN_DOC"));
                     drugHistory.setT_DOCTOR_NAME(resultSet.getString("REQUEST_DOCTOR_NAME"));                 
                     outPatDrugHistList2.add(drugHistory);
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
         
         if(!outPatDrugHistList2.isEmpty()){
        	 plr.put("data", outPatDrugHistList2);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
        
        
        

    } 
	
	
	
	
	
	 
}
