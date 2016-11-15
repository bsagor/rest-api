package sa.com.rufaida.domain;

import java.io.Serializable;

public class Onset implements Serializable{

	private static final long serialVersionUID = 4465988450001447961L;
	
	public String ONSET_CODE;
     public String LANG2_NAME;
     public String LANG1_NAME;
     public String ONSET_COMM;
     public String ENTRY_DATE;
     public String ENTRY_USER;
     public String UPD_DATE;
     public String UPD_USER;
	public String getONSET_CODE() {
		return ONSET_CODE;
	}
	public void setONSET_CODE(String oNSET_CODE) {
		ONSET_CODE = oNSET_CODE;
	}
	public String getLANG2_NAME() {
		return LANG2_NAME;
	}
	public void setLANG2_NAME(String lANG2_NAME) {
		LANG2_NAME = lANG2_NAME;
	}
	public String getLANG1_NAME() {
		return LANG1_NAME;
	}
	public void setLANG1_NAME(String lANG1_NAME) {
		LANG1_NAME = lANG1_NAME;
	}
	public String getONSET_COMM() {
		return ONSET_COMM;
	}
	public void setONSET_COMM(String oNSET_COMM) {
		ONSET_COMM = oNSET_COMM;
	}
	public String getENTRY_DATE() {
		return ENTRY_DATE;
	}
	public void setENTRY_DATE(String eNTRY_DATE) {
		ENTRY_DATE = eNTRY_DATE;
	}
	public String getENTRY_USER() {
		return ENTRY_USER;
	}
	public void setENTRY_USER(String eNTRY_USER) {
		ENTRY_USER = eNTRY_USER;
	}
	public String getUPD_DATE() {
		return UPD_DATE;
	}
	public void setUPD_DATE(String uPD_DATE) {
		UPD_DATE = uPD_DATE;
	}
	public String getUPD_USER() {
		return UPD_USER;
	}
	public void setUPD_USER(String uPD_USER) {
		UPD_USER = uPD_USER;
	}
     
}
