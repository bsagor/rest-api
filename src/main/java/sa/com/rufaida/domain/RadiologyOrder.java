package sa.com.rufaida.domain;

import java.io.Serializable;

public class RadiologyOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8822530823728324597L;
	public String T_PAT_NO;
    public String T_ORDER_NO;
    public String T_ORDER_DATE;
    public String T_DOCTOR_NAME;
    public String T_ORDER_PROC;
    public String T_ENTRY_DATE;
    public String T_UPD_DATE;
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
	public String getT_ORDER_DATE() {
		return T_ORDER_DATE;
	}
	public void setT_ORDER_DATE(String t_ORDER_DATE) {
		T_ORDER_DATE = t_ORDER_DATE;
	}
	public String getT_DOCTOR_NAME() {
		return T_DOCTOR_NAME;
	}
	public void setT_DOCTOR_NAME(String t_DOCTOR_NAME) {
		T_DOCTOR_NAME = t_DOCTOR_NAME;
	}
	public String getT_ORDER_PROC() {
		return T_ORDER_PROC;
	}
	public void setT_ORDER_PROC(String t_ORDER_PROC) {
		T_ORDER_PROC = t_ORDER_PROC;
	}
	public String getT_ENTRY_DATE() {
		return T_ENTRY_DATE;
	}
	public void setT_ENTRY_DATE(String t_ENTRY_DATE) {
		T_ENTRY_DATE = t_ENTRY_DATE;
	}
	public String getT_UPD_DATE() {
		return T_UPD_DATE;
	}
	public void setT_UPD_DATE(String t_UPD_DATE) {
		T_UPD_DATE = t_UPD_DATE;
	}
    
    
    
}
