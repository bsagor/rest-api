package sa.com.rufaida.domain;

import java.io.Serializable;

public class Appointment implements Serializable{

	private static final long serialVersionUID = -6382654375626278336L;
	//T_APPT_TIME,T_APPT_DATE,t03001.T_PAT_NO,T_CLINIC_NAME_LANG2,T07003.T_CLINIC_DOC_CODE
    //public String T_APPT_TIME;
    public String T_APPT_DATE;
    public String T_PAT_NO;
    //public String T_CLINIC_NAME_LANG2;
    //public String T_CLINIC_DOC_CODE;
    public String T_PAT_NAME;
    //public String YRS;
    //public String MOS;
    //public String DAYS;
    //public String T_GENDER;
    //public String T_APPT_TYPE;
    //public String T_APPT_STATUS;
	public String getT_APPT_DATE() {
		return T_APPT_DATE;
	}
	public void setT_APPT_DATE(String t_APPT_DATE) {
		T_APPT_DATE = t_APPT_DATE;
	}
	public String getT_PAT_NO() {
		return T_PAT_NO;
	}
	public void setT_PAT_NO(String t_PAT_NO) {
		T_PAT_NO = t_PAT_NO;
	}
	public String getT_PAT_NAME() {
		return T_PAT_NAME;
	}
	public void setT_PAT_NAME(String t_PAT_NAME) {
		T_PAT_NAME = t_PAT_NAME;
	}
    
    
    
}
