package sa.com.rufaida.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sa.com.rufaida.domain.PatientLabResult;
import sa.com.rufaida.service.Database;

@RestController
public class LabResultDetails {

	@RequestMapping("/rufaida/GetPatLabRequestResult")
    @ResponseBody
	 public HashMap<String, Object> GetPatLabRequestResult(String ReqNo, String WSCode)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
             String sql = null;
             if (WSCode == "01")
             {

                 sql = " SELECT   distinct T03001.T_PAT_NO,T03001.T_FIRST_LANG2_NAME ||' ' ||T03001.T_FATHER_LANG2_NAME ||' '|| T03001.T_GFATHER_LANG2_NAME ||' '|| T03001.T_FAMILY_LANG2_NAME T_PAT_NAME,T13018.T_REQUEST_NO ,T13018.T_ANALYSIS_CODE,T13011.T_LANG2_NAME ANALYSIS_NAME, T13018.T_RESULT_VALUE,T13018.T_NOTES," +
   " DECODE((SELECT T13011.T_RESULT_TYPE FROM T13011 WHERE T13011.T_WS_CODE= T13016.T_WS_CODE AND T13011.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE)  " +
   ", '1', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'01') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE)  " +
   ", '2', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'01') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE AND T13014.T_GENDER = T03003.T_GENDER) " +
   ", '3', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'01') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE   " +
   " AND TO_NUMBER(NVL(TRUNC(MONTHS_BETWEEN(SYSDATE,T03003.T_BIRTH_DATE)/12,0),0) * 365) + TRUNC(SYSDATE)-(ADD_MONTHS(T03003.T_BIRTH_DATE,(TRUNC((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE))/12))*12+(MOD((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE)),12)))) " +
   " BETWEEN ((T_YEAR_FROM * 365 ) + T_DAYS_FROM) AND ((T_YEAR_TO * 365) + T_DAYS_TO)),'4',(SELECT T_NR_FROM ||'-'||T_NR_TO FROM T13014  " +
  "  WHERE T_WS_CODE= T13016.T_WS_CODE AND T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE  " +
   " AND TO_NUMBER(NVL(TRUNC(MONTHS_BETWEEN(SYSDATE,T03003.T_BIRTH_DATE)/12,0),0) * 365) + TRUNC(SYSDATE)-(ADD_MONTHS(T03003.T_BIRTH_DATE,(TRUNC((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE))/12))*12+(MOD((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE)),12))))   " +
  "  BETWEEN ((T_YEAR_FROM * 365 ) + T_DAYS_FROM) AND ((T_YEAR_TO * 365) + T_DAYS_TO) AND T_GENDER = T03003.T_GENDER),(SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'05') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE)  " +
  " )||' '||(SELECT T_UM FROM T13011 WHERE T_WS_CODE = T13016.T_WS_CODE AND T13011.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE) T_RANGE " +
 " FROM T13018,T13011,T13016,T03003,T03001,T13015 " +
 " where T13018.T_REQUEST_NO = '" + ReqNo + "' AND T13018.T_WS_CODE = '" + WSCode + "' " +
 " AND T13018.T_CLOSE_FLAG IS NOT NULL AND T13018.T_ANALYSIS_CODE =T13011.T_ANALYSIS_CODE " +
 " AND T13018.T_REQUEST_NO =T13016.T_REQUEST_NO AND T13018.T_WS_CODE = T13016.T_WS_CODE "+
 " AND T03001.t_PAT_NO = T13015.t_PAT_NO  AND T13018.T_REQUEST_NO  = T13015.T_REQUEST_NO";
             }
             else
             {
//                 sql = " SELECT   distinct T03001.T_PAT_NO,T03001.T_FIRST_LANG2_NAME ||' ' ||T03001.T_FATHER_LANG2_NAME ||' '|| T03001.T_GFATHER_LANG2_NAME ||' '|| T03001.T_FAMILY_LANG2_NAME T_PAT_NAME,T13018.T_REQUEST_NO ,T13018.T_ANALYSIS_CODE,T13011.T_LANG2_NAME ANALYSIS_NAME, T13018.T_RESULT_VALUE,T13018.T_NOTES," +
//" DECODE((SELECT T13011.T_RESULT_TYPE FROM T13011 WHERE T13011.T_WS_CODE= T13016.T_WS_CODE AND T13011.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE)  " +
//", '1', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE  T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE)  " +
//", '2', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE  T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE AND T13014.T_GENDER = T03003.T_GENDER) " +
//", '3', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE  T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE   " +
//" AND TO_NUMBER(NVL(TRUNC(MONTHS_BETWEEN(SYSDATE,T03003.T_BIRTH_DATE)/12,0),0) * 365) + TRUNC(SYSDATE)-(ADD_MONTHS(T03003.T_BIRTH_DATE,(TRUNC((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE))/12))*12+(MOD((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE)),12)))) " +
//" BETWEEN ((T_YEAR_FROM * 365 ) + T_DAYS_FROM) AND ((T_YEAR_TO * 365) + T_DAYS_TO)),'4',(SELECT T_NR_FROM ||'-'||T_NR_TO FROM T13014  " +
//"  WHERE T_WS_CODE= T13016.T_WS_CODE AND T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE  " +
//" AND TO_NUMBER(NVL(TRUNC(MONTHS_BETWEEN(SYSDATE,T03003.T_BIRTH_DATE)/12,0),0) * 365) + TRUNC(SYSDATE)-(ADD_MONTHS(T03003.T_BIRTH_DATE,(TRUNC((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE))/12))*12+(MOD((MONTHS_BETWEEN(TRUNC(SYSDATE),T03003.T_BIRTH_DATE)),12))))   " +
//"  BETWEEN ((T_YEAR_FROM * 365 ) + T_DAYS_FROM) AND ((T_YEAR_TO * 365) + T_DAYS_TO) AND T_GENDER = T03003.T_GENDER),(SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'05') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE)  " +
//" )||' '||(SELECT T_UM FROM T13011 WHERE T_WS_CODE = T13016.T_WS_CODE AND T13011.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE) T_RANGE " +
//" FROM T13018,T13011,T13016,T03003,T03001,T13015 " +
//" where T13018.T_REQUEST_NO = '" + ReqNo + "' AND T13018.T_WS_CODE = '" + WSCode + "' " +
//" AND T13018.T_CLOSE_FLAG IS NOT NULL AND T13018.T_ANALYSIS_CODE =T13011.T_ANALYSIS_CODE " +
//" AND T13018.T_REQUEST_NO =T13016.T_REQUEST_NO AND T13018.T_WS_CODE = T13016.T_WS_CODE " +
//" AND T03001.t_PAT_NO= T13015.t_PAT_NO  AND T13018.T_REQUEST_NO  = T13015.T_REQUEST_NO" ;

                 sql = "SELECT DISTINCT T13015.T_PAT_NO, T13015.T_REQUEST_NO,T13018.T_ANALYSIS_CODE, T13015.T_LAB_REF_NO REF_HOSP_NO " +
                     ", T13015.T_REQUEST_DATE, T13015.T_REQUEST_TIME, T13015.T_SPEC_NO " +
                     ", T13016.T_LAB_NO " +
                     ",(SELECT MAX(T13017.T_RECEIVED_DATE) FROM T13017 WHERE T13017.T_REQUEST_NO= '" + ReqNo + "' AND T13017.T_WS_CODE = '" + WSCode + "' AND T13017.T_SPECIMEN_CODE IS NOT NULL) T_RECEIVED_DATE  " +
                     ",(SELECT MAX(T13017.T_RECEIVED_TIME) FROM T13017 WHERE T13017.T_REQUEST_NO= '" + ReqNo + "' AND T13017.T_WS_CODE = '" + WSCode + "' AND T13017.T_SPECIMEN_CODE IS NOT NULL) T_RECEIVED_TIME " +
                     ",T13018.T_NOTES ,  NVL(T13018.T_UPD_DATE,T13018.T_ENTRY_DATE)T_UPD_DATE  " +
                     ", T03001.T_FIRST_LANG2_NAME || ' ' || T03001.T_FATHER_LANG2_NAME || ' ' || T03001.T_GFATHER_LANG2_NAME || ' ' || T03001.T_FAMILY_LANG2_NAME T_PAT_NAME, T03001.T_BIRTH_DATE " +
                     ", NVL((SELECT DISTINCT T13005.T_LANG2_NAME FROM T13005 WHERE T13005.T_SPECIMEN_CODE = (SELECT MAX(DISTINCT(T13017.T_SPECIMEN_CODE)) FROM T13017 WHERE T13017.T_REQUEST_NO= '" + ReqNo + "' AND T13017.T_WS_CODE = '" + WSCode + "' AND T13017.T_SPECIMEN_CODE IS NOT NULL)), '') T_SPECIMEN_NAME " +
                     ",  NVL((select T02006.T_LANG2_NAME  from T02006 WHERE  T03001.T_GENDER = T02006.T_SEX_CODE ),'') T_GENDER , NVL((SELECT DISTINCT T02003.T_LANG2_NAME FROM T02003 WHERE T03001.T_NTNLTY_CODE = T02003.T_NTNLTY_CODE), '') T_NATIONALITY " +
                     ",  nvl((SELECT T13077.T_LANG2_NAME from t13077 where   T13077.T_REFERRAL_CODE=T13015.T_REFERRAL_CODE),'')  T_LOCATION  , T13004.T_LANG2_NAME || ' Department' T_LOCATION_NAME " +
                     ", nvl((SELECT DISTINCT T13006.T_LANG2_NAME FROM T13006 WHERE T13006.T_RESULT_CODE = T13018.T_RESULT_VALUE ),T13018.T_RESULT_VALUE) T_RESULT_VALUE " +
                     ", (SELECT distinct T13011.T_LANG2_NAME FROM T13011  WHERE T13011.T_ANALYSIS_CODE =T13018.T_ANALYSIS_CODE AND T13011.T_WS_CODE = T13016.T_WS_CODE) T_ANALYSIS_NAME " +
                     ", DECODE((SELECT T13011.T_RESULT_TYPE FROM T13011 WHERE T13011.T_WS_CODE= T13016.T_WS_CODE AND T13011.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE) " +
                     ", '1', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'02') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE)  " +
                     ", '2', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'02') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE AND T13014.T_GENDER = T03001.T_GENDER) " +
                     ", '3', (SELECT T13014.T_NR_FROM ||'-'||T13014.T_NR_TO FROM T13014 WHERE T13014.T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'02') AND T13014.T_WS_CODE= T13016.T_WS_CODE AND T13014.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE " +
                     "AND TO_NUMBER(NVL(TRUNC(MONTHS_BETWEEN(SYSDATE,T03001.T_BIRTH_DATE)/12,0),0) * 365) + TRUNC(SYSDATE)-(ADD_MONTHS(T03001.T_BIRTH_DATE,(TRUNC((MONTHS_BETWEEN(TRUNC(SYSDATE),T03001.T_BIRTH_DATE))/12))*12+(MOD((MONTHS_BETWEEN(TRUNC(SYSDATE),T03001.T_BIRTH_DATE)),12)))) " +
                     "BETWEEN ((T_YEAR_FROM * 365 ) + T_DAYS_FROM) AND ((T_YEAR_TO * 365) + T_DAYS_TO)),'4',(SELECT T_NR_FROM ||'-'||T_NR_TO FROM T13014 " +
                     "WHERE T_ANALYZER_ID = NVL(T13018.T_ANALYZER_ID,'02') AND T_WS_CODE= T13016.T_WS_CODE AND T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE " +
                     "AND TO_NUMBER(NVL(TRUNC(MONTHS_BETWEEN(SYSDATE,T03001.T_BIRTH_DATE)/12,0),0) * 365) + TRUNC(SYSDATE)-(ADD_MONTHS(T03001.T_BIRTH_DATE,(TRUNC((MONTHS_BETWEEN(TRUNC(SYSDATE),T03001.T_BIRTH_DATE))/12))*12+(MOD((MONTHS_BETWEEN(TRUNC(SYSDATE),T03001.T_BIRTH_DATE)),12)))) " +
                     "BETWEEN ((T_YEAR_FROM * 365 ) + T_DAYS_FROM) AND ((T_YEAR_TO * 365) + T_DAYS_TO) AND T_GENDER = T03001.T_GENDER),'')||'  '||(SELECT T_UM FROM T13011 WHERE T_WS_CODE = T13016.T_WS_CODE AND T13011.T_ANALYSIS_CODE = T13018.T_ANALYSIS_CODE) T_RANGE " +
                     "FROM T13015, T13016  ,T13018, T03001, T13077,T13004  " +
                     "WHERE T13015.T_REQUEST_NO = T13016.T_REQUEST_NO " +
                     "AND T13016.T_REQUEST_NO = T13018.T_REQUEST_NO " +
                     "AND T13016.T_WS_CODE = T13018.T_WS_CODE  " +
                     "AND T03001.T_PAT_NO = T13015.T_PAT_NO  " +
                     // "AND T13015.T_REFERRAL_CODE = T13077.T_REFERRAL_CODE  " +
                     "AND T13016.T_WS_CODE = T13004.T_WS_CODE  " +
                     "AND T13015.T_REQUEST_NO = '" + ReqNo + "' " +
                     "AND T13016.T_WS_CODE = '" + WSCode + "' " +
                     "AND nvl(T13016.T_LAB_NO,'') IS NOT NULL " +
                     //"AND T13018.T_RESULT_VALUE IS NOT NULL " +
                     "AND T13018.T_CLOSE_FLAG IS NOT NULL " +
                     "ORDER BY T_RESULT_VALUE";
             }
         
         
         
         try {
        	 Connection connection = new Database().getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
    				 PatientLabResult patientLabResult = new PatientLabResult();
    				 patientLabResult.setPatNo(resultSet.getString("T_PAT_NO"));
    			     patientLabResult.setPatName(resultSet.getString("T_PAT_NAME"));
    			     patientLabResult.setRequestNo(resultSet.getString("T_REQUEST_NO"));
    			     patientLabResult.setAnalysisCode(resultSet.getString("T_ANALYSIS_CODE"));
    			     patientLabResult.setAnalysisName(resultSet.getString("ANALYSIS_NAME"));
    			     patientLabResult.setResult(resultSet.getString("T_RESULT_VALUE"));
    			     patientLabResult.setResultNotes(resultSet.getString("T_NOTES"));
    			     patientLabResult.setRange(resultSet.getString("T_RANGE"));
    			     plr.put("data", patientLabResult);
    			 }
             }else{
            	 plr.put("data", "not found");
             }
             
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return plr;
     }
	 
}
