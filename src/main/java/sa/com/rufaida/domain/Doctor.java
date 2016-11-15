package sa.com.rufaida.domain;

import java.io.Serializable;

public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7787461219238575181L;
	public String T_CLINIC_CODE;
    public String T_DOC_CODE;
    public String T_DOC_NAME;
    public String T_CLINIC_NAME_LANG2;
	public String getT_CLINIC_CODE() {
		return T_CLINIC_CODE;
	}
	public void setT_CLINIC_CODE(String t_CLINIC_CODE) {
		T_CLINIC_CODE = t_CLINIC_CODE;
	}
	public String getT_DOC_CODE() {
		return T_DOC_CODE;
	}
	public void setT_DOC_CODE(String t_DOC_CODE) {
		T_DOC_CODE = t_DOC_CODE;
	}
	public String getT_DOC_NAME() {
		return T_DOC_NAME;
	}
	public void setT_DOC_NAME(String t_DOC_NAME) {
		T_DOC_NAME = t_DOC_NAME;
	}
	public String getT_CLINIC_NAME_LANG2() {
		return T_CLINIC_NAME_LANG2;
	}
	public void setT_CLINIC_NAME_LANG2(String t_CLINIC_NAME_LANG2) {
		T_CLINIC_NAME_LANG2 = t_CLINIC_NAME_LANG2;
	}
    
    
    
}
