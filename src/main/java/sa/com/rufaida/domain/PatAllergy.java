package sa.com.rufaida.domain;

import java.io.Serializable;

public class PatAllergy implements Serializable{

	private static final long serialVersionUID = 1936247247810755639L;
	public String T_DIET;
     public String T_MEDICATION;
     public String T_OTHERS;
	public String getT_DIET() {
		return T_DIET;
	}
	public void setT_DIET(String t_DIET) {
		T_DIET = t_DIET;
	}
	public String getT_MEDICATION() {
		return T_MEDICATION;
	}
	public void setT_MEDICATION(String t_MEDICATION) {
		T_MEDICATION = t_MEDICATION;
	}
	public String getT_OTHERS() {
		return T_OTHERS;
	}
	public void setT_OTHERS(String t_OTHERS) {
		T_OTHERS = t_OTHERS;
	}
     
}
