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

import sa.com.rufaida.domain.AdmitDoc;
import sa.com.rufaida.domain.Clinic;
import sa.com.rufaida.domain.DischargeSummary;
import sa.com.rufaida.domain.Episode;
import sa.com.rufaida.service.Database;

@Controller
public class PatDischargeSummary {

	@RequestMapping("/rufaida/GetEpisode")
    @ResponseBody
	 public HashMap<String, Object> GetEpisode(String PAT_NO, String ADMIT_DATE)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();

		List<Episode> episodeList = new ArrayList<Episode>();

        String sql = " SELECT ALL TO_CHAR(T05010.T_ADMIT_DATE, 'DD/MM/YYYY') T_ADMIT_DATE," +
                        " T05010.T_EPISODE_NO  FROM T05010  WHERE T05010.T_PAT_NO = '" + PAT_NO + "'" +
                        " AND T05010.T_ADMIT_DATE = NVL('" + ADMIT_DATE + "', T_ADMIT_DATE) ";
                     
		
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 Episode episode = new Episode();
                     episode.setEPISODE_NO(resultSet.getString("T_EPISODE_NO"));
                     episode.setADMIT_DATE(resultSet.getString("T_ADMIT_DATE"));
                     episodeList.add(episode);
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
         
         if(!episodeList.isEmpty()){
        	 plr.put("data", episodeList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	 
	
	@RequestMapping("/rufaida/GetAdmitDoc")
    @ResponseBody
	public HashMap<String, Object> GetAdmitDoc(String PAT_NO, String EPISODE_NO){
        List<AdmitDoc> admitDocList = new ArrayList<AdmitDoc>();
        HashMap<String, Object> plr = new HashMap<String, Object>();

        String sql = "  select T05010.T_PAT_NO,T05010.T_ADMIT_DOC_CODE ,LTRIM(LTRIM(RTRIM(NVL(T02029.T_NAME_GIVEN,' '),' '), ' ')||' ', ' ') || LTRIM(LTRIM(RTRIM( NVL(T02029.T_NAME_FATHER,' '),' '), ' ')||' ', ' ')"+
            " || LTRIM(RTRIM(  NVL(T02029.T_NAME_FAMILY, ' '), ' '), ' ') DOC_NAME "+
	            "  from   T05010,T02029 "+
            "  where  T05010.T_PAT_NO = '" + PAT_NO + "'  and T02029.T_EMP_NO = T05010.T_ADMIT_DOC_CODE " +
            "  and    T05010.T_EPISODE_NO = '" + EPISODE_NO + "' ";

        
        
        Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 AdmitDoc admitDoc = new AdmitDoc();
                     admitDoc.setPAT_NO(resultSet.getString("T_PAT_NO"));
                     admitDoc.setADMIT_DOC_CODE(resultSet.getString("T_ADMIT_DOC_CODE"));
                     admitDoc.setDOC_NAME(resultSet.getString("DOC_NAME"));
                     admitDocList.add(admitDoc);
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
        
         if(!admitDocList.isEmpty()){
        	 plr.put("data", admitDocList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
    }
	
	
	
	@RequestMapping("/rufaida/GetPatDischargeSummary")
    @ResponseBody
	public HashMap<String, Object> GetPatDischargeSummary(String PAT_NO, String EPISODE_NO, String maxDate)
    {
        List<DischargeSummary> dischargeSummaryList = new ArrayList<DischargeSummary>();
        HashMap<String, Object> plr = new HashMap<String, Object>();
        
    String sql = null ;
    if (maxDate == "")
    {
         sql = "   select T05017.T_PAT_NO ,T03001.T_FIRST_LANG2_NAME||' '||T03001.T_FATHER_LANG2_NAME||' '|| T03001.T_GFATHER_LANG2_NAME||' '||T03001.T_FAMILY_LANG2_NAME  PAT_NAME," +
                   " (TRUNC(MONTHS_BETWEEN(sysdate, T03001.t_birth_date) / 12, 0)||'.'||	TRUNC(MOD(MONTHS_BETWEEN(sysdate,T03001.t_birth_date), 12), 0)) AGE," +
                   " T02006.T_LANG2_NAME  DESC_SEX ,T02007.T_LANG2_NAME  MRS,T02042.t_lang2_name  ward_name," +
                   " T02029.T_NAME_GIVEN  ||' '||T02029.T_NAME_FATHER ||' '||T02029.T_NAME_FAMILY   DOC_NAME," +
                   " T05017.T_ADMIT_DOC, T05017.T_DEPT_CODE,  T05017.T_WARD_NO,T05017.T_EPISODE_NO , to_char( T05017.T_ADMIT_DATE,'yyyy-mm-dd') T_ADMIT_DATE , " +
                   " to_char(T05017.T_DISCHARGE_DATE,'yyyy-mm-dd') T_DISCHARGE_DATE, T05017.T_BRIEF_HSTRY , T05017.T_PHY_EXAM,  T05017.T_LAB_INFO,  T05017.T_LAB_INFO_DUE ," +
                   " T05017.T_MAIN_PROBLEM,  T05017.T_OTHER_PROBLEM ,   T05017.T_MGMNT_PROC, T05017.T_PAT_HEALTH , T05017.T_DISCHARGE_STATUS," +
                   " T05017.T_RECOMMEND, T05017.T_TRT_DOC,  T05017.T_SPCLTY_CODE,T05010.T_DISCH_WARD_NO,T05010.T_DISCH_ROOM_NO," +
                   " T05010.T_DISCH_BED_NO,T05010.T_ADMIT_TIME  , T05010.T_DISCHARGE_TIME,T05010.T_DISCHARGE_DEST " +
                  ",to_char(T05017.T_ENTRY_DATE,'yyyy-mm-dd HH24:MI:SS') T_ENTRY_DATE," +
                  " to_char(T05017.T_UPD_DATE,'yyyy-mm-dd HH24:MI:SS') T_UPD_DATE" +
                   " FROM T05017, T05010  ,T03001  ,T02006  ,T02007  ,T02042 ,T02029" +
                   " WHERE T05017.T_PAT_NO =  '" + PAT_NO + "' " +
                   " AND T05017.T_EPISODE_NO  = nvl('" + EPISODE_NO + "', T05017.T_EPISODE_NO)" +
                   " AND T05017.T_PAT_NO = T05010.T_PAT_NO " +
                   " AND T05017.T_EPISODE_NO = T05010.T_EPISODE_NO " +
                   " and T05017.T_PAT_NO = T03001.T_PAT_NO " +
                   " and T02006.T_SEX_CODE = T03001.T_GENDER " +
                   " and T02007.T_MRTL_STATUS_CODE = T03001.T_MRTL_STATUS " +
                   " and T05010.T_DISCH_WARD_NO = T02042.T_LOC_CODE(+) " +
                   " and T02029.T_EMP_NO = T05017.T_TRT_DOC ";
    }
    else
    {
         sql = "   select T05017.T_PAT_NO ,T03001.T_FIRST_LANG2_NAME||' '||T03001.T_FATHER_LANG2_NAME||' '|| T03001.T_GFATHER_LANG2_NAME||' '||T03001.T_FAMILY_LANG2_NAME  PAT_NAME," +
                     " (TRUNC(MONTHS_BETWEEN(sysdate, T03001.t_birth_date) / 12, 0)||'.'||	TRUNC(MOD(MONTHS_BETWEEN(sysdate,T03001.t_birth_date), 12), 0)) AGE," +
                     " T02006.T_LANG2_NAME  DESC_SEX ,T02007.T_LANG2_NAME  MRS,T02042.t_lang2_name  ward_name," +
                     " T02029.T_NAME_GIVEN  ||' '||T02029.T_NAME_FATHER ||' '||T02029.T_NAME_FAMILY   DOC_NAME," +
                     " T05017.T_ADMIT_DOC, T05017.T_DEPT_CODE,  T05017.T_WARD_NO,T05017.T_EPISODE_NO , to_char( T05017.T_ADMIT_DATE,'yyyy-mm-dd') T_ADMIT_DATE , " +
                     " to_char(T05017.T_DISCHARGE_DATE,'yyyy-mm-dd') T_DISCHARGE_DATE, T05017.T_BRIEF_HSTRY , T05017.T_PHY_EXAM,  T05017.T_LAB_INFO,  T05017.T_LAB_INFO_DUE ," +
                     " T05017.T_MAIN_PROBLEM,  T05017.T_OTHER_PROBLEM ,   T05017.T_MGMNT_PROC, T05017.T_PAT_HEALTH , T05017.T_DISCHARGE_STATUS," +
                     " T05017.T_RECOMMEND, T05017.T_TRT_DOC,  T05017.T_SPCLTY_CODE,T05010.T_DISCH_WARD_NO,T05010.T_DISCH_ROOM_NO," +
                     " T05010.T_DISCH_BED_NO,T05010.T_ADMIT_TIME  , T05010.T_DISCHARGE_TIME,T05010.T_DISCHARGE_DEST " +
                    ",to_char(T05017.T_ENTRY_DATE,'yyyy-mm-dd HH24:MI:SS') T_ENTRY_DATE," +
                    " to_char(T05017.T_UPD_DATE,'yyyy-mm-dd HH24:MI:SS') T_UPD_DATE" +
                     " FROM T05017, T05010  ,T03001  ,T02006  ,T02007  ,T02042 ,T02029" +
                     " WHERE T05017.T_PAT_NO =  '" + PAT_NO + "' " +
                     " AND T05017.T_EPISODE_NO  = nvl('" + EPISODE_NO + "', T05017.T_EPISODE_NO)" +
                     " AND T05017.T_PAT_NO = T05010.T_PAT_NO " +
                     " AND T05017.T_EPISODE_NO = T05010.T_EPISODE_NO " +
                     " and T05017.T_PAT_NO = T03001.T_PAT_NO " +
                     " and T02006.T_SEX_CODE = T03001.T_GENDER " +
                     " and T02007.T_MRTL_STATUS_CODE = T03001.T_MRTL_STATUS " +
                     " and T05010.T_DISCH_WARD_NO = T02042.T_LOC_CODE(+) " +
                     " and T02029.T_EMP_NO = T05017.T_TRT_DOC "+
                     " and to_char(T05017.t_entry_date,'yyyy-mm-dd HH24:MI:SS') > '" + maxDate + "'";
    }         

    
    
		    Connection connection = new Database().getConnection();
			PreparedStatement statement = null;
		     try {
		    	 statement = connection.prepareStatement(sql);
		         ResultSet resultSet = statement.executeQuery();
		         
		         if(resultSet!=null){
		        	 while (resultSet.next()) {
		        		 DischargeSummary dischargeSummary = new DischargeSummary();
		                 dischargeSummary.setPAT_NO(resultSet.getString("T_PAT_NO"));
		                 dischargeSummary.setPAT_NAME(resultSet.getString("PAT_NAME"));
		                 dischargeSummary.setPAT_AGE(resultSet.getString("AGE"));
		                 dischargeSummary.setPAT_SEX(resultSet.getString("DESC_SEX"));
		                 dischargeSummary.setMRT_STATUS(resultSet.getString("MRS"));
		                 dischargeSummary.setDOC_NAME(resultSet.getString("DOC_NAME"));
		                 dischargeSummary.setADMIT_DOC_CODE(resultSet.getString("T_ADMIT_DOC"));
		                 dischargeSummary.setWARD_NAME(resultSet.getString("ward_name"));
		                 dischargeSummary.setEPISODE_NO(resultSet.getString("T_EPISODE_NO"));
		                 dischargeSummary.setADMIT_DATE(resultSet.getString("T_ADMIT_DATE"));
		                 dischargeSummary.setDISCHARGE_DATE(resultSet.getString("T_DISCHARGE_DATE"));
		                 dischargeSummary.setBRIEF_HSTRY(resultSet.getString("T_BRIEF_HSTRY"));
		                 dischargeSummary.setPHY_EXAM(resultSet.getString("T_PHY_EXAM"));
		                 dischargeSummary.setLAB_INFO(resultSet.getString("T_LAB_INFO"));
		                 dischargeSummary.setDISCH_BED_NO(resultSet.getString("T_DISCH_BED_NO"));
		                 dischargeSummary.setADMIT_TIME(resultSet.getString("T_ADMIT_TIME"));
		                 dischargeSummary.setDISCHARGE_TIME(resultSet.getString("T_DISCHARGE_TIME"));
		                 dischargeSummary.setMAIN_PROBLEM(resultSet.getString("T_MAIN_PROBLEM"));
		                 dischargeSummary.setOTHER_PROBLEM(resultSet.getString("T_PHY_EXAM"));
		                 dischargeSummary.setMGMNT_PROC(resultSet.getString("T_LAB_INFO"));
		                 dischargeSummary.setPAT_HEALTH(resultSet.getString("T_PAT_HEALTH"));
		                 dischargeSummary.setDISCHARGE_STATUS(resultSet.getString("T_DISCHARGE_STATUS"));
		                 dischargeSummary.setRECOMMEND(resultSet.getString("T_RECOMMEND"));

		                 dischargeSummary.setT_ENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
		                 dischargeSummary.setT_UPD_DATE(resultSet.getString("T_UPD_DATE"));

		                 dischargeSummaryList.add(dischargeSummary);
		                 
		                 
		                 
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
		    
		     if(!dischargeSummaryList.isEmpty()){
		    	 plr.put("data", dischargeSummaryList);
		     }else{
		    	 plr.put("data", "not found");
		     }
		     
		     return plr;
    }
	
	
	
	
	
	
	
	
}
