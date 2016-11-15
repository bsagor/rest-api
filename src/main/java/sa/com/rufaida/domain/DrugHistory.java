package sa.com.rufaida.domain;

import java.io.Serializable;

public class DrugHistory implements Serializable{

	private static final long serialVersionUID = 4206638949518190223L;
	
	public String T_GEN_CODE;
    public String T_PAT_NO;
    public String T_IOS_DESC;
    public String T_DOSE_TIME_DAILY;
    public String T_DOSE_DURATION;   
    public String T_DOSE_START_DATE;   
    public String T_DOSE_TIME;    
    public String T_REQUEST_DOC;        
    public String T_DOCTOR_NAME;
    public String T_REMARKS;
	public String getT_GEN_CODE() {
		return T_GEN_CODE;
	}
	public void setT_GEN_CODE(String t_GEN_CODE) {
		T_GEN_CODE = t_GEN_CODE;
	}
	public String getT_PAT_NO() {
		return T_PAT_NO;
	}
	public void setT_PAT_NO(String t_PAT_NO) {
		T_PAT_NO = t_PAT_NO;
	}
	public String getT_IOS_DESC() {
		return T_IOS_DESC;
	}
	public void setT_IOS_DESC(String t_IOS_DESC) {
		T_IOS_DESC = t_IOS_DESC;
	}
	public String getT_DOSE_TIME_DAILY() {
		return T_DOSE_TIME_DAILY;
	}
	public void setT_DOSE_TIME_DAILY(String t_DOSE_TIME_DAILY) {
		T_DOSE_TIME_DAILY = t_DOSE_TIME_DAILY;
	}
	public String getT_DOSE_DURATION() {
		return T_DOSE_DURATION;
	}
	public void setT_DOSE_DURATION(String t_DOSE_DURATION) {
		T_DOSE_DURATION = t_DOSE_DURATION;
	}
	public String getT_DOSE_START_DATE() {
		return T_DOSE_START_DATE;
	}
	public void setT_DOSE_START_DATE(String t_DOSE_START_DATE) {
		T_DOSE_START_DATE = t_DOSE_START_DATE;
	}
	public String getT_DOSE_TIME() {
		return T_DOSE_TIME;
	}
	public void setT_DOSE_TIME(String t_DOSE_TIME) {
		T_DOSE_TIME = t_DOSE_TIME;
	}
	public String getT_REQUEST_DOC() {
		return T_REQUEST_DOC;
	}
	public void setT_REQUEST_DOC(String t_REQUEST_DOC) {
		T_REQUEST_DOC = t_REQUEST_DOC;
	}
	public String getT_DOCTOR_NAME() {
		return T_DOCTOR_NAME;
	}
	public void setT_DOCTOR_NAME(String t_DOCTOR_NAME) {
		T_DOCTOR_NAME = t_DOCTOR_NAME;
	}
	public String getT_REMARKS() {
		return T_REMARKS;
	}
	public void setT_REMARKS(String t_REMARKS) {
		T_REMARKS = t_REMARKS;
	}
    
}
