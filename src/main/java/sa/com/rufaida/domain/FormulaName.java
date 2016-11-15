package sa.com.rufaida.domain;

import java.io.Serializable;

public class FormulaName implements Serializable{

	private static final long serialVersionUID = -7352699056792493413L;
	
	public String ENTRY_DATE;
    public String ENTRY_USER;
    public String FRMLRY_CODE;
    public String LANG2_NAME;
    public String SHRT_LANG2_NAME;
    public String LANG1_NAME;
    public String SHRT_LANG1_NAME;
    public String UPD_DATE;
    public String UPD_USER;
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
	public String getFRMLRY_CODE() {
		return FRMLRY_CODE;
	}
	public void setFRMLRY_CODE(String fRMLRY_CODE) {
		FRMLRY_CODE = fRMLRY_CODE;
	}
	public String getLANG2_NAME() {
		return LANG2_NAME;
	}
	public void setLANG2_NAME(String lANG2_NAME) {
		LANG2_NAME = lANG2_NAME;
	}
	public String getSHRT_LANG2_NAME() {
		return SHRT_LANG2_NAME;
	}
	public void setSHRT_LANG2_NAME(String sHRT_LANG2_NAME) {
		SHRT_LANG2_NAME = sHRT_LANG2_NAME;
	}
	public String getLANG1_NAME() {
		return LANG1_NAME;
	}
	public void setLANG1_NAME(String lANG1_NAME) {
		LANG1_NAME = lANG1_NAME;
	}
	public String getSHRT_LANG1_NAME() {
		return SHRT_LANG1_NAME;
	}
	public void setSHRT_LANG1_NAME(String sHRT_LANG1_NAME) {
		SHRT_LANG1_NAME = sHRT_LANG1_NAME;
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
