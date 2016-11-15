package sa.com.rufaida.domain;

import java.io.Serializable;

public class RadiologyReport implements Serializable {

	private static final long serialVersionUID = 2440760568790413909L;
	
	public String T_PAT_NO;
    public String T_ORDER_NO;  
    public String T_DOC_NAME;
    public String T_ASS_NO;
    public String T_REP_TYPE;
    public String T_FILE_SEQ;
    public String T_REPORT;

    public String T_PROC_CODE;
    public String T_PROC_DSCRPTN_LANG2;
    public String T_PROC_NOTES;
   
    public String T_INDICATION;       
    public String ORDER_DATE_TIME; 
    public String T_FINDING;
	public String getT_PAT_NO() {
		return T_PAT_NO;
	}
	public void setT_PAT_NO(String t_PAT_NO) {
		T_PAT_NO = t_PAT_NO;
	}
	public String getT_ORDER_NO() {
		return T_ORDER_NO;
	}
	public void setT_ORDER_NO(String t_ORDER_NO) {
		T_ORDER_NO = t_ORDER_NO;
	}
	public String getT_DOC_NAME() {
		return T_DOC_NAME;
	}
	public void setT_DOC_NAME(String t_DOC_NAME) {
		T_DOC_NAME = t_DOC_NAME;
	}
	public String getT_ASS_NO() {
		return T_ASS_NO;
	}
	public void setT_ASS_NO(String t_ASS_NO) {
		T_ASS_NO = t_ASS_NO;
	}
	public String getT_REP_TYPE() {
		return T_REP_TYPE;
	}
	public void setT_REP_TYPE(String t_REP_TYPE) {
		T_REP_TYPE = t_REP_TYPE;
	}
	public String getT_FILE_SEQ() {
		return T_FILE_SEQ;
	}
	public void setT_FILE_SEQ(String t_FILE_SEQ) {
		T_FILE_SEQ = t_FILE_SEQ;
	}
	public String getT_REPORT() {
		return T_REPORT;
	}
	public void setT_REPORT(String t_REPORT) {
		T_REPORT = t_REPORT;
	}
	public String getT_PROC_CODE() {
		return T_PROC_CODE;
	}
	public void setT_PROC_CODE(String t_PROC_CODE) {
		T_PROC_CODE = t_PROC_CODE;
	}
	public String getT_PROC_DSCRPTN_LANG2() {
		return T_PROC_DSCRPTN_LANG2;
	}
	public void setT_PROC_DSCRPTN_LANG2(String t_PROC_DSCRPTN_LANG2) {
		T_PROC_DSCRPTN_LANG2 = t_PROC_DSCRPTN_LANG2;
	}
	public String getT_PROC_NOTES() {
		return T_PROC_NOTES;
	}
	public void setT_PROC_NOTES(String t_PROC_NOTES) {
		T_PROC_NOTES = t_PROC_NOTES;
	}
	public String getT_INDICATION() {
		return T_INDICATION;
	}
	public void setT_INDICATION(String t_INDICATION) {
		T_INDICATION = t_INDICATION;
	}
	public String getORDER_DATE_TIME() {
		return ORDER_DATE_TIME;
	}
	public void setORDER_DATE_TIME(String oRDER_DATE_TIME) {
		ORDER_DATE_TIME = oRDER_DATE_TIME;
	}
	public String getT_FINDING() {
		return T_FINDING;
	}
	public void setT_FINDING(String t_FINDING) {
		T_FINDING = t_FINDING;
	}
    
    
    
}
