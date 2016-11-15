package sa.com.rufaida.domain;

import java.io.Serializable;

public class FormulaNotes implements Serializable{

	private static final long serialVersionUID = 6491115334831382118L;
	
	public String GEN_CODE;
    public String FORMULA_CODE;
    public String FORMULA_NOTES;
    public String ENTRY_DATE;
    public String ENTRY_USER;
    public String UPD_DATE;
    public String UPD_USER;
	public String getGEN_CODE() {
		return GEN_CODE;
	}
	public void setGEN_CODE(String gEN_CODE) {
		GEN_CODE = gEN_CODE;
	}
	public String getFORMULA_CODE() {
		return FORMULA_CODE;
	}
	public void setFORMULA_CODE(String fORMULA_CODE) {
		FORMULA_CODE = fORMULA_CODE;
	}
	public String getFORMULA_NOTES() {
		return FORMULA_NOTES;
	}
	public void setFORMULA_NOTES(String fORMULA_NOTES) {
		FORMULA_NOTES = fORMULA_NOTES;
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
