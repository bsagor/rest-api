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

import sa.com.rufaida.domain.RadiologyOrder;
import sa.com.rufaida.domain.RadiologyReport;
import sa.com.rufaida.service.Database;

@Controller
public class PatRadioLogyOrder {

	@RequestMapping("/rufaida/GetPatRadiologyOrder")
    @ResponseBody
	 public HashMap<String, Object> GetPatRadiologyOrder(String PAT_NO)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<RadiologyOrder> rgOrderList = new ArrayList<RadiologyOrder>();
        String sql = "SELECT  to_char(T11011.T_ORDER_DATE,'dd/mm/yyyy')  as T_ORDER_DATE,T11011.T_ORDER_NO as T_ORDER_NO," +
                     " T02029.T_NAME_GIVEN ||'' ||T02029.T_NAME_FATHER||'' ||T02029.T_NAME_GFATHER|| ''||T02029.T_NAME_FAMILY as T_DOCTOR_NAME,"+
                     " T11100.T_LANG2_NAME|| ''||T11001.t_proc_dscrptn_lang2 as T_PROCDURE_NAME  "+                     
                     " FROM 	T03001,T11011,T02029,T11100,t11012,t11001"+
                   "  where T03001.T_PAT_NO = '" + PAT_NO + "' " +
                   " and T11011.T_PAT_NO = T03001.T_PAT_NO "+
                   "  and T02029.t_emp_no = t11011.t_request_doc "+
                  "   AND t11001.t_proc_code = t11012.t_proc_code "+
                   "  and T11011.T_ORDER_NO = T11012.T_ORDER_NO "+
                   " and T11100.T_MAIN_PROC_CODE = t11001.T_MAIN_PROC_CODE";
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 RadiologyOrder rd = new RadiologyOrder();
                     rd.setT_ORDER_DATE(resultSet.getString("T_ORDER_DATE"));
                     rd.setT_ORDER_NO(resultSet.getString("T_ORDER_NO"));
                     rd.setT_DOCTOR_NAME(resultSet.getString("T_DOCTOR_NAME"));
                     rd.setT_ORDER_PROC(resultSet.getString("T_PROCDURE_NAME"));
                     rgOrderList.add(rd);
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
         
         if(!rgOrderList.isEmpty()){
        	 plr.put("data", rgOrderList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	@RequestMapping("/rufaida/GetPatRadiologyOrderByMaxDate")
    @ResponseBody
	 public HashMap<String, Object> GetPatRadiologyOrderByMaxDate(String PAT_NO,String maxDate)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<RadiologyOrder> rgOrderList = new ArrayList<RadiologyOrder>();
        String sql = null ;
        if (maxDate == "")
        {
            sql = " SELECT  to_char(T11011.T_ORDER_DATE,'yyyy-mm-dd')  as T_ORDER_DATE,T11011.T_ORDER_NO as T_ORDER_NO,T03001.T_PAT_NO," +
                 " T02029.T_NAME_GIVEN ||'' ||T02029.T_NAME_FATHER||'' ||T02029.T_NAME_GFATHER|| ''||T02029.T_NAME_FAMILY as T_DOCTOR_NAME," +
                 " T11100.T_LANG2_NAME|| ''||T11001.t_proc_dscrptn_lang2 as T_PROCDURE_NAME , " +
                 " to_char(T11011.T_ENTRY_DATE,'yyyy-mm-dd HH24:MI:SS') T_ENTRY_DATE," +
                 " to_char(T11011.T_UPD_DATE,'yyyy-mm-dd HH24:MI:SS') T_UPD_DATE" +
                 " FROM 	T03001,T11011,T02029,T11100,t11012,t11001" +
                 " where T03001.T_PAT_NO = '" + PAT_NO + "' " +
                 " and T11011.T_PAT_NO = T03001.T_PAT_NO " +
                 "  and T02029.t_emp_no = t11011.t_request_doc " +
                 " AND t11001.t_proc_code = t11012.t_proc_code " +
                 "  and T11011.T_ORDER_NO = T11012.T_ORDER_NO " +
                 " and T11100.T_MAIN_PROC_CODE = t11001.T_MAIN_PROC_CODE" +
                  " ORDER BY T11011.T_ORDER_DATE ";
        }
        else
        {
            sql = " SELECT  to_char(T11011.T_ORDER_DATE,'yyyy-mm-dd')   as T_ORDER_DATE,T11011.T_ORDER_NO as T_ORDER_NO,T03001.T_PAT_NO," +
                  " T02029.T_NAME_GIVEN ||'' ||T02029.T_NAME_FATHER||'' ||T02029.T_NAME_GFATHER|| ''||T02029.T_NAME_FAMILY as T_DOCTOR_NAME," +
                  " T11100.T_LANG2_NAME|| ''||T11001.t_proc_dscrptn_lang2 as T_PROCDURE_NAME , " +
                  " to_char(T11011.T_ENTRY_DATE,'yyyy-mm-dd HH24:MI:SS') T_ENTRY_DATE," +
                  " to_char(T11011.T_UPD_DATE,'yyyy-mm-dd HH24:MI:SS') T_UPD_DATE" +
                  " FROM 	T03001,T11011,T02029,T11100,t11012,t11001" +
                  " where T03001.T_PAT_NO = '" + PAT_NO + "' " +
                  " and T11011.T_PAT_NO = T03001.T_PAT_NO " +
                  "  and T02029.t_emp_no = t11011.t_request_doc " +
                  " AND t11001.t_proc_code = t11012.t_proc_code " +
                  "  and T11011.T_ORDER_NO = T11012.T_ORDER_NO " +
                  " and T11100.T_MAIN_PROC_CODE = t11001.T_MAIN_PROC_CODE " +
                  " and to_char(T11100.t_entry_date,'yyyy-mm-dd HH24:MI:SS') > '" + maxDate + "'"+
                  " ORDER BY T11011.T_ORDER_DATE ";
        }
         
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 RadiologyOrder rd = new RadiologyOrder();
                     rd.setT_ORDER_DATE(resultSet.getString("T_ORDER_DATE"));
                     rd.setT_ORDER_NO(resultSet.getString("T_ORDER_NO"));
                     rd.setT_PAT_NO(resultSet.getString("T_PAT_NO"));
                     rd.setT_DOCTOR_NAME(resultSet.getString("T_DOCTOR_NAME"));
                     rd.setT_ORDER_PROC(resultSet.getString("T_PROCDURE_NAME"));
                     rd.setT_ENTRY_DATE(resultSet.getString("T_ENTRY_DATE"));
                     rd.setT_UPD_DATE(resultSet.getString("T_UPD_DATE"));
                     rgOrderList.add(rd);
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
         
         if(!rgOrderList.isEmpty()){
        	 plr.put("data", rgOrderList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	
	@RequestMapping("/rufaida/GetPatRadiologyOrderByDate")
    @ResponseBody
	 public HashMap<String, Object> GetPatRadiologyOrderByDate(String frmDate,String toDate,String userType,String patNo)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<RadiologyOrder> rgOrderList = new ArrayList<RadiologyOrder>();
        String sql = "";
        if (userType == "2")
            sql = "SELECT T11011.T_PAT_NO," +
                     " to_char(T11011.T_ORDER_DATE,'dd/mm/yyyy')  as T_ORDER_DATE,T11011.T_ORDER_NO as T_ORDER_NO," +
                     " T02029.T_NAME_GIVEN||'' ||T02029.T_NAME_FATHER||'' ||T02029.T_NAME_GFATHER|| ''||T02029.T_NAME_FAMILY as T_DOCTOR_NAME," +
                     " T11100.T_LANG2_NAME|| ''||T11001.t_proc_dscrptn_lang2 as T_PROCDURE_NAME  " +
                     " FROM T03001,T11011,T02029,T11100,t11012,t11001 " +
                   "  where  T11011.T_PAT_NO = T03001.T_PAT_NO " +
                   "  and T02029.t_emp_no = t11011.t_request_doc " +
                   "  AND t11001.t_proc_code = t11012.t_proc_code " +
                   "  and T11011.T_ORDER_NO = T11012.T_ORDER_NO " +
                   "  and T11100.T_MAIN_PROC_CODE = t11001.T_MAIN_PROC_CODE AND  T11011.T_PAT_NO ='" + patNo + "'" +
                   " AND T11011.T_ORDER_DATE BETWEEN  to_date('" + frmDate + "','dd/mm/yyyy')  AND to_date('" + toDate + "','dd/mm/yyyy')";
        else

            sql = "SELECT T11011.T_PAT_NO," +
                         " to_char(T11011.T_ORDER_DATE,'dd/mm/yyyy')  as T_ORDER_DATE,T11011.T_ORDER_NO as T_ORDER_NO," +
                         " T02029.T_NAME_GIVEN||'' ||T02029.T_NAME_FATHER||'' ||T02029.T_NAME_GFATHER|| ''||T02029.T_NAME_FAMILY as T_DOCTOR_NAME," +
                         " T11100.T_LANG2_NAME|| ''||T11001.t_proc_dscrptn_lang2 as T_PROCDURE_NAME  " +
                         " FROM T03001,T11011,T02029,T11100,t11012,t11001 " +
                       "  where  T11011.T_PAT_NO = T03001.T_PAT_NO " +
                       "  and T02029.t_emp_no = t11011.t_request_doc " +
                       "  AND t11001.t_proc_code = t11012.t_proc_code " +
                       "  and T11011.T_ORDER_NO = T11012.T_ORDER_NO " +
                       "  and T11100.T_MAIN_PROC_CODE = t11001.T_MAIN_PROC_CODE " +
                       " AND T11011.T_ORDER_DATE BETWEEN  to_date('" + frmDate + "','dd/mm/yyyy')  AND to_date('" + toDate + "','dd/mm/yyyy')";

		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 RadiologyOrder rd = new RadiologyOrder();
                     rd.setT_PAT_NO(resultSet.getString("T_PAT_NO"));
                     rd.setT_ORDER_DATE(resultSet.getString("T_ORDER_DATE"));
                     rd.setT_ORDER_NO(resultSet.getString("T_ORDER_NO"));
                     rd.setT_DOCTOR_NAME(resultSet.getString("T_DOCTOR_NAME"));
                     rd.setT_ORDER_PROC(resultSet.getString("T_PROCDURE_NAME"));
                     rgOrderList.add(rd);
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
         
         if(!rgOrderList.isEmpty()){
        	 plr.put("data", rgOrderList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	
	@RequestMapping("/rufaida/GetTempPatRadiologyOrder")
    @ResponseBody
	 public HashMap<String, Object> GetTempPatRadiologyOrder(String PAT_NO)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<RadiologyOrder> rgOrderList = new ArrayList<RadiologyOrder>();
        String sql = "SELECT  to_char(T11011.T_ORDER_DATE,'dd/mm/yyyy')  as T_ORDER_DATE,T11011.T_ORDER_NO as T_ORDER_NO," +
                     " T02029.T_NAME_GIVEN ||'' ||T02029.T_NAME_FATHER||'' ||T02029.T_NAME_GFATHER|| ''||T02029.T_NAME_FAMILY as T_DOCTOR_NAME," +
                     " T11100.T_LANG2_NAME|| ''||T11001.t_proc_dscrptn_lang2 as T_PROCDURE_NAME  " +
                     " FROM T03003,T11011,T02029,T11100,t11012,t11001" +
                   "  where T03003.T_TMP_PAT_NO = '" + PAT_NO + "' " +
                   " and T11011.T_PAT_NO = T03003.T_TMP_PAT_NO " +
                   "  and T02029.t_emp_no = t11011.t_request_doc " +
                  "   AND t11001.t_proc_code = t11012.t_proc_code " +
                   "  and T11011.T_ORDER_NO = T11012.T_ORDER_NO " +
                   " and T11100.T_MAIN_PROC_CODE = t11001.T_MAIN_PROC_CODE";
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 RadiologyOrder rd = new RadiologyOrder();
                     rd.setT_ORDER_DATE(resultSet.getString("T_ORDER_DATE"));
                     rd.setT_ORDER_NO(resultSet.getString("T_ORDER_NO"));
                     rd.setT_DOCTOR_NAME(resultSet.getString("T_DOCTOR_NAME"));
                     rd.setT_ORDER_PROC(resultSet.getString("T_PROCDURE_NAME"));
                     rgOrderList.add(rd);
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
         
         if(!rgOrderList.isEmpty()){
        	 plr.put("data", rgOrderList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	@RequestMapping("/rufaida/GetPatRadiologyReport")
    @ResponseBody
	 public HashMap<String, Object> GetPatRadiologyReport(String PAT_NO, String ASS_NO)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		List<RadiologyReport> rgReportList = new ArrayList<RadiologyReport>();
        String sql = " SELECT T_PAT_NO,T_ASS_NO,T_REP_TYPE, T_FILE_SEQ,T_REPORT FROM T11021 "+
                     " WHERE T_PAT_NO = NVL('"+PAT_NO+"',T_PAT_NO) AND "+
                    " T_ASS_NO = NVL('"+ASS_NO+"',T_ASS_NO )" ;
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 RadiologyReport rp = new RadiologyReport();
                     rp.setT_PAT_NO(resultSet.getString("T_PAT_NO"));
                     rp.setT_ASS_NO(resultSet.getString("T_ASS_NO"));
                     rp.setT_FILE_SEQ(resultSet.getString("T_FILE_SEQ"));
                     rp.setT_REP_TYPE(resultSet.getString("T_REP_TYPE"));
                     rp.setT_REPORT(resultSet.getString("T_REPORT"));
                     rgReportList.add(rp);
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
         
         if(!rgReportList.isEmpty()){
        	 plr.put("data", rgReportList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	@RequestMapping("/rufaida/GetPatRadiologyReport2")
    @ResponseBody
	 public HashMap<String, Object> GetPatRadiologyReport2(String PAT_NO, String ASS_NO,String PROC_CODE)
     {
		HashMap<String, Object> plr = new HashMap<String, Object>();
		 List<RadiologyReport> rgReportList = new ArrayList<RadiologyReport>();
         String sql = " SELECT ALL T02029.T_NAME_GIVEN  || ' '|| T02029.T_NAME_FATHER  || ' '|| T02029.T_NAME_GFATHER  DOC_NAME,"+
         " t11001.T_PROC_DSCRPTN_LANG2 T_PROC_DSCRPTN_LANG2 , T11001.T_PROC_CODE , T11021.T_PAT_NO   , " +
         " T11021.T_ASS_NO ,  T11021.T_REP_TYPE  ,"+
         " DECODE (upper(T11021.T_REP_TYPE), 'PR','Preliminary Report', 'UP','Updated Report',   'FN','Final Report') REP_TYPE,"+
         " T11021.t_entry_user, T11021.T_FINDING REMARKS , T11021.T_FILE_SEQ  ,  T11021.T_REPORT  , T11021.T_ORDER_NO  ,"+
         " V11123.T_PROC_CODE ,  V11123.T_INDICATION, V11123.T_PROC_NOTES," +
         " TO_CHAR(V11123.T_ORDER_DATE,'DD/MM/YYYY') || '    ' || V11123.T_ORDER_TIME  ORDER_DATE_TIME"+
         " FROM T11021,t11001,V11123,T02029 "+
         " WHERE  T02029.T_EMP_NO =V11123.T_REQUEST_DOC and "+
        "  T11001.t_proc_code = V11123.t_proc_code and "+          
         " t11021.t_order_no = V11123.t_order_no and "+
         " T11021.T_PAT_NO =  '"+PAT_NO+"' AND "+
         " T11021.T_ASS_NO = NVL('"+ASS_NO+"',T11021.T_ASS_NO ) AND "+
        "  NVL(T11021.T_PROCEDURE,'1') = NVL('"+PROC_CODE+"',NVL(T11021.T_PROCEDURE,'1'))";
		Connection connection = new Database().getConnection();
		PreparedStatement statement = null;
         try {
        	 statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
             
             if(resultSet!=null){
            	 while (resultSet.next()) {
            		 RadiologyReport rp = new RadiologyReport();
                     rp.setT_PAT_NO(resultSet.getString("T_PAT_NO"));
                     rp.setT_ASS_NO(resultSet.getString("T_ASS_NO"));
                     rp.setT_FILE_SEQ(resultSet.getString("T_FILE_SEQ"));
                     rp.setT_REP_TYPE(resultSet.getString("REP_TYPE"));
                     rp.setT_REPORT(resultSet.getString("T_REPORT"));               
                     rp.setT_ORDER_NO(resultSet.getString("T_ORDER_NO"));
                     rp.setT_DOC_NAME(resultSet.getString("DOC_NAME"));  
                     rp.setT_PROC_CODE(resultSet.getString("T_PROC_CODE"));  
                     rp.setT_PROC_DSCRPTN_LANG2(resultSet.getString("T_PROC_DSCRPTN_LANG2"));
                     rp.setT_PROC_NOTES(resultSet.getString("T_PROC_NOTES"));         
                     rp.setT_INDICATION(resultSet.getString("T_INDICATION"));        
                     rp.setORDER_DATE_TIME(resultSet.getString("ORDER_DATE_TIME"));            
                     rp.setT_FINDING(resultSet.getString("REMARKS"));             

                     rgReportList.add(rp);
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
         
         if(!rgReportList.isEmpty()){
        	 plr.put("data", rgReportList);
         }else{
        	 plr.put("data", "not found");
         }
         
         return plr;
     }
	
	
	
	
	
	 
}
