package sa.com.rufaida.domain;

import java.io.Serializable;

public class Patient implements Serializable {

	private static final long serialVersionUID = 1092188432614517480L;
	public String T_PAT_NO;
    public String T_PAT_NAME;
    public String T_PAT_AGE;
    public String T_PAT_SEX;
    public String T_PAT_DOB;
    public String T_PAT_NLTY;
    public String T_PAT_MARITAL_STATUS;
    public String T_MOBILE_NO;
    public String T_EMAIL;
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
	public String getT_PAT_AGE() {
		return T_PAT_AGE;
	}
	public void setT_PAT_AGE(String t_PAT_AGE) {
		T_PAT_AGE = t_PAT_AGE;
	}
	public String getT_PAT_SEX() {
		return T_PAT_SEX;
	}
	public void setT_PAT_SEX(String t_PAT_SEX) {
		T_PAT_SEX = t_PAT_SEX;
	}
	public String getT_PAT_DOB() {
		return T_PAT_DOB;
	}
	public void setT_PAT_DOB(String t_PAT_DOB) {
		T_PAT_DOB = t_PAT_DOB;
	}
	public String getT_PAT_NLTY() {
		return T_PAT_NLTY;
	}
	public void setT_PAT_NLTY(String t_PAT_NLTY) {
		T_PAT_NLTY = t_PAT_NLTY;
	}
	public String getT_PAT_MARITAL_STATUS() {
		return T_PAT_MARITAL_STATUS;
	}
	public void setT_PAT_MARITAL_STATUS(String t_PAT_MARITAL_STATUS) {
		T_PAT_MARITAL_STATUS = t_PAT_MARITAL_STATUS;
	}
	public String getT_MOBILE_NO() {
		return T_MOBILE_NO;
	}
	public void setT_MOBILE_NO(String t_MOBILE_NO) {
		T_MOBILE_NO = t_MOBILE_NO;
	}
	public String getT_EMAIL() {
		return T_EMAIL;
	}
	public void setT_EMAIL(String t_EMAIL) {
		T_EMAIL = t_EMAIL;
	}
    
}
