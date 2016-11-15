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
import sa.com.rufaida.domain.DrugHistoryOut;
import sa.com.rufaida.domain.InPatPrescription;
import sa.com.rufaida.domain.NursingPatient;
import sa.com.rufaida.domain.NursingStation;
import sa.com.rufaida.service.Database;

@Controller
public class PatPrescription {

	@RequestMapping("/rufaida/GetNursingStation")
    @ResponseBody
	 public HashMap<String, Object> GetNursingStation(String empCode)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<NursingStation> nusingStationList = new ArrayList<NursingStation>();
		
		String sql = " select distinct t_ward_no ipm_nursing_station_code , t_lang2_name hdm_loc_dscrptn " +
                " from T02042,T05005 " +
                " where T02042.t_loc_code =  t_ward_no " +
                " and t_pat_no is not null ";
             /*   " and t_ward_no   in(select t_ward_no   from   T05029 "+
                " where  T05029.t_ward_emp_code='"+empCode+"') " ; */
         
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 NursingStation nursingStation = new NursingStation();                
                     nursingStation.setNursing_station_code(resultSet.getString("ipm_nursing_station_code"));
                     nursingStation.setHdm_loc_dscrptn(resultSet.getString("hdm_loc_dscrptn"));

                    nusingStationList.add(nursingStation);
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
         
         if(!nusingStationList.isEmpty()){
        	 plr.put("data", nusingStationList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	
	@RequestMapping("/rufaida/GetNursingPatient")
    @ResponseBody
	 public HashMap<String, Object> GetNursingPatient(String SCR_NURSING_STATION_CODE,String emp_code)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<NursingPatient> nusingPatList = new ArrayList<NursingPatient>();
		
		String sql = "select 	LTRIM(LTRIM(RTRIM(NVL(T03001.T_FIRST_LANG2_NAME,' '),	' '), ' ')||' ', ' ') "+
			       " ||	LTRIM(LTRIM(RTRIM(NVL(T03001.T_FATHER_LANG2_NAME, ' '),	' '), ' ')||' ', ' ') "+
			       " || LTRIM(RTRIM(NVL(T03001.T_FAMILY_LANG2_NAME, '  '),	' '), ' ') PATIENT_NAME,"+
	               " t03001.t_pat_no	PAT_NO, t05003.T_LANG2_NAME ipm_code_description, t05005.T_BED_DSCRPTN ipm_bed_no," +
	               "  NVL(T03001.T_X_HOSP1_PAT_NO,NVL(T03001.T_X_HOSP2_PAT_NO,NVL(T03001.T_X_HOSP3_PAT_NO,NVL(T03001.T_X_HOSP4_PAT_NO ,"+
	               " NVL(T03001.T_X_HOSP5_PAT_NO,NVL(T03001.T_X_HOSP6_PAT_NO,T03001.T_X_RMC_CHRTNO)))))) chart_no"+
	               " FROM    T03001, T05005, T05003 "+
	               "  WHERE   T03001.T_PAT_NO = T05005.T_PAT_NO "+
	              " AND     T05003.t_room_no = T05005.t_room_no  "+
	               " AND     T05003.t_ward_no  = T05005.t_ward_no "+
	              "  and     T05005.t_ward_no = NVL('" + SCR_NURSING_STATION_CODE + "',T05005.t_ward_no) " +
	             // "  and   T05005.t_ward_no in( select t_ward_no  from   T05029 "+
	             // "  where  T05029.t_ward_emp_code =  TO_NUMBER(LTRIM(RTRIM('"+emp_code+"', ' '), ' ')) "+
	              //"    ) "+
	              "  order by T05005.t_ward_no,T05005.t_room_no,ipm_bed_no";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 NursingPatient nursingPat = new NursingPatient();
                     nursingPat.setPAT_NO(resultSet.getString("PAT_NO"));
                     nursingPat.setPATIENT_NAME(resultSet.getString("PATIENT_NAME"));
                     nursingPat.setIpm_code_description(resultSet.getString("ipm_code_description"));
                     nursingPat.setIpm_bed_no(resultSet.getString("ipm_bed_no"));
                     nursingPat.setChart_no(resultSet.getString("chart_no"));

                     nusingPatList.add(nursingPat);
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
         
         if(!nusingPatList.isEmpty()){
        	 plr.put("data", nusingPatList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	
	
	@RequestMapping("/rufaida/GetInPatPrescription")
    @ResponseBody
	 public HashMap<String, Object> GetInPatPrescription(String patNo)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<InPatPrescription> inPatPrescriptionList = new ArrayList<InPatPrescription>();
		
		String sql = "  select T30004.T_GEN_CODE,T30014.T_PAT_NO,T30014.T_EPISODE_NO,T30014.T_DRUG_INACTIVE_FLAG , " +
                " T30014.T_PAT_MEDICINE_SEQ ,T30004.T_LANG2_NAME GENERIC_DESC, "+
               "  T30001.T_LANG2_NAME MFORM_DESC,T30002.T_LANG2_NAME ROUTE_DESC, "+
               "  T30014.T_REQUEST_STRENGTH, to_char(T30014.T_ENTRY_DATE,'dd/mm/yyyy') T_ENTRY_DATE ,T30014.T_ENTRY_TIME  ," +
                " T30014.T_DOSE_TIME_DAILY  ,T30014.T_DOSE_DURATION , to_char(T_STOP_FRM,'dd/mm/yyyy') T_STOP_FRM ,T01009.T_USER_NAME AMEND_USER " +
               "  from T30014,T30004,T30001,T30002,T01009 "+
               "  where T30004.T_GEN_CODE = T30014.T_REQUEST_GCODE "+
               "  and T30001.T_DRUG_FORM_CODE = T30014.T_REQUEST_MFORM "+
               "  and T30002.T_DRUG_ROUTE_CODE = T30014.T_REQUEST_ROUTE "+
               "  and  T01009.T_EMP_CODE(+) = T30014.T_UPD_USER  "+
               "  and T30014.T_pat_no = '"+patNo+"' "+
               "  order by T_ENTRY_DATE desc,T30004.T_LANG2_NAME   desc" ; 
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 InPatPrescription inPatPresb = new InPatPrescription();
                     inPatPresb.setGEN_CODE(resultSet.getString("T_GEN_CODE"));
                     inPatPresb.setPAT_NO  (resultSet.getString("T_PAT_NO"));
                     inPatPresb.setEPISODE_NO(resultSet.getString("T_EPISODE_NO")); 
                     inPatPresb.setDRUG_INACTIVE_FLAG(resultSet.getString("T_DRUG_INACTIVE_FLAG"));
                     inPatPresb.setPAT_MEDICINE_SEQ(resultSet.getString("T_PAT_MEDICINE_SEQ"));
                     inPatPresb.setGENERIC_DESC(resultSet.getString("GENERIC_DESC"));
                     inPatPresb.setMFORM_DESC(resultSet.getString("MFORM_DESC"));
                     inPatPresb.setROUTE_DESC(resultSet.getString("ROUTE_DESC"));
                     inPatPresb.setREQUEST_STRENGTH(resultSet.getString("T_REQUEST_STRENGTH"));
                     inPatPresb.setENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     inPatPresb.setENTRY_TIME(resultSet.getString("T_ENTRY_TIME"));
                     inPatPresb.setFREQUENCY(resultSet.getString("T_DOSE_TIME_DAILY"));
                     inPatPresb.setDOSE_DURATION(resultSet.getString("T_DOSE_DURATION"));
                     inPatPresb.setSTOP_FRM(resultSet.getString("T_STOP_FRM"));
                     inPatPresb.setAMEND_USER(resultSet.getString("AMEND_USER"));
                     inPatPrescriptionList.add(inPatPresb);
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
         
         if(!inPatPrescriptionList.isEmpty()){
        	 plr.put("data", inPatPrescriptionList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	
	@RequestMapping("/rufaida/GetOutPatCurrentPrescribtion")
    @ResponseBody
	 public HashMap<String, Object> GetOutPatCurrentPrescribtion(String PAT_NO, String maxDate)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<DrugHistoryOut> outPatDrugHistList2 = new ArrayList<DrugHistoryOut>();
        String sql = null ;
        if (maxDate == "")
        {
            sql = " select t_item_code,t30023.t_pat_No,t30023.T_ORGN_DOC,LTRIM(LTRIM(RTRIM(NVL(T_NAME_GIVEN,' '), ' '), ' ')||' ', ' ')|| LTRIM(LTRIM(RTRIM( NVL(T_NAME_FATHER,' '),' '), ' ')||' ', ' ')" +
                " || LTRIM(RTRIM(NVL(T_NAME_FAMILY,' '), ' '), ' ')REQUEST_DOCTOR_NAME," +
               " t30023.T_OPD_REQ_ITEM ,t30023.T_REQUEST_STRENGTH, t30023.T_QTY,to_char(t30023.T_ENTRY_DATE,'dd/mm/yyyy')  DOSE_START_DATE ," +
               " t30023.T_ENTRY_TIME ,t30023.T_DOSE_UNIT ,t30023.T_DOSE_TIME_DAILY , t30023.T_DOSE_DURATION ," +
               " to_char(t30023.T_ENTRY_DATE,'yyyy-mm-dd HH24:MI:SS') T_ENTRY_DATE," +
               " to_char(t30023.T_UPD_DATE,'yyyy-mm-dd HH24:MI:SS') T_UPD_DATE," +
               " to_char(t30023.T_ISSUE_DATE,'yyyy-mm-dd') T_ISSUE_DATE" +
               " from t30023,T02029 " +
               " where t30023.t_pat_no ='" + PAT_NO + "' " +
                //" and t30023.T_DOC_CODE = nvl('" + DOC_NO + "',t30023.T_DOC_CODE)" +
               //" and (t30023.t_issue_date+t30023.T_DOSE_DURATION) > sysdate " +
               " and t30023.t_drug_inactive_flag is null" +
               " and T02029.T_EMP_NO   = t30023.T_ORGN_DOC " +
               " order by t30023.t_entry_date desc , t30023.t_entry_time desc";
        }
        else
        {

            sql = " select t_item_code,t30023.t_pat_No,t30023.T_ORGN_DOC,LTRIM(LTRIM(RTRIM(NVL(T_NAME_GIVEN,' '), ' '), ' ')||' ', ' ')|| LTRIM(LTRIM(RTRIM( NVL(T_NAME_FATHER,' '),' '), ' ')||' ', ' ')" +
                " || LTRIM(RTRIM(NVL(T_NAME_FAMILY,' '), ' '), ' ')REQUEST_DOCTOR_NAME," +
               " t30023.T_OPD_REQ_ITEM ,t30023.T_REQUEST_STRENGTH, t30023.T_QTY,to_char(t30023.T_ENTRY_DATE,'dd/mm/yyyy')  DOSE_START_DATE ," +
               " t30023.T_ENTRY_TIME ,t30023.T_DOSE_UNIT ,t30023.T_DOSE_TIME_DAILY , t30023.T_DOSE_DURATION ," +
               " to_char(t30023.T_ENTRY_DATE,'yyyy-mm-dd HH24:MI:SS') T_ENTRY_DATE," +
               " to_char(t30023.T_UPD_DATE,'yyyy-mm-dd HH24:MI:SS') T_UPD_DATE," +
               " to_char(t30023.T_ISSUE_DATE,'yyyy-mm-dd') T_ISSUE_DATE" +
               " from t30023,T02029 " +
               " where t30023.t_pat_no ='" + PAT_NO + "' " +
                //" and t30023.T_DOC_CODE = nvl('" + DOC_NO + "',t30023.T_DOC_CODE)" +
              // " and (t30023.t_issue_date+t30023.T_DOSE_DURATION) > sysdate " +
               " and t30023.t_drug_inactive_flag is null" +
               " and T02029.T_EMP_NO   = t30023.T_ORGN_DOC " +
               " and to_char(t30023.t_entry_date,'yyyy-mm-dd HH24:MI:SS') > '" + maxDate + "'"+
               " order by t30023.t_entry_date desc , t30023.t_entry_time desc";
        }
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 DrugHistoryOut drugHistory = new DrugHistoryOut();

                     drugHistory.setT_item_code(resultSet.getString("t_item_code"));
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
                     drugHistory.setT_ENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     drugHistory.setT_UPD_DATE(resultSet.getString("T_UPD_DATE"));
                     drugHistory.setT_ISSUE_DATE(resultSet.getString("T_ISSUE_DATE"));
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
