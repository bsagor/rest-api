package sa.com.rufaida.domain;

import java.io.Serializable;

public class Route implements Serializable{

	private static final long serialVersionUID = -5331573097756274229L;
	public String ENTRY_USER;
    public String ENTRY_DATE;
    public String DRUG_ROUTE_CODE;
    public String LANG1_NAME;
    public String LANG2_NAME;
    public String UPD_USER;
    public String UPD_DATE;
	public String getENTRY_USER() {
		return ENTRY_USER;
	}
	public void setENTRY_USER(String eNTRY_USER) {
		ENTRY_USER = eNTRY_USER;
	}
	public String getENTRY_DATE() {
		return ENTRY_DATE;
	}
	public void setENTRY_DATE(String eNTRY_DATE) {
		ENTRY_DATE = eNTRY_DATE;
	}
	public String getDRUG_ROUTE_CODE() {
		return DRUG_ROUTE_CODE;
	}
	public void setDRUG_ROUTE_CODE(String dRUG_ROUTE_CODE) {
		DRUG_ROUTE_CODE = dRUG_ROUTE_CODE;
	}
	public String getLANG1_NAME() {
		return LANG1_NAME;
	}
	public void setLANG1_NAME(String lANG1_NAME) {
		LANG1_NAME = lANG1_NAME;
	}
	public String getLANG2_NAME() {
		return LANG2_NAME;
	}
	public void setLANG2_NAME(String lANG2_NAME) {
		LANG2_NAME = lANG2_NAME;
	}
	public String getUPD_USER() {
		return UPD_USER;
	}
	public void setUPD_USER(String uPD_USER) {
		UPD_USER = uPD_USER;
	}
	public String getUPD_DATE() {
		return UPD_DATE;
	}
	public void setUPD_DATE(String uPD_DATE) {
		UPD_DATE = uPD_DATE;
	}
    
    
}
