package sa.com.rufaida.domain;

import java.io.Serializable;

public class DrugInteraction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7788132340016826173L;
	public String ENTRY_DATE;
    public String ENTRY_USER;
    public String GEN_CODE;
    public String SIGNIF_CODE;
    public String ONSET_CODE;
    public String SEVERITY_CODE;
    public String DOCUM_CODE;
    public String GEN_GEN_DDI;
    public String DDI_COMM;
    public String GEN_DESC;
    public String GEN_GEN_DDI_DESC;
    public String PAGE_NO;
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
	public String getGEN_CODE() {
		return GEN_CODE;
	}
	public void setGEN_CODE(String gEN_CODE) {
		GEN_CODE = gEN_CODE;
	}
	public String getSIGNIF_CODE() {
		return SIGNIF_CODE;
	}
	public void setSIGNIF_CODE(String sIGNIF_CODE) {
		SIGNIF_CODE = sIGNIF_CODE;
	}
	public String getONSET_CODE() {
		return ONSET_CODE;
	}
	public void setONSET_CODE(String oNSET_CODE) {
		ONSET_CODE = oNSET_CODE;
	}
	public String getSEVERITY_CODE() {
		return SEVERITY_CODE;
	}
	public void setSEVERITY_CODE(String sEVERITY_CODE) {
		SEVERITY_CODE = sEVERITY_CODE;
	}
	public String getDOCUM_CODE() {
		return DOCUM_CODE;
	}
	public void setDOCUM_CODE(String dOCUM_CODE) {
		DOCUM_CODE = dOCUM_CODE;
	}
	public String getGEN_GEN_DDI() {
		return GEN_GEN_DDI;
	}
	public void setGEN_GEN_DDI(String gEN_GEN_DDI) {
		GEN_GEN_DDI = gEN_GEN_DDI;
	}
	public String getDDI_COMM() {
		return DDI_COMM;
	}
	public void setDDI_COMM(String dDI_COMM) {
		DDI_COMM = dDI_COMM;
	}
	public String getGEN_DESC() {
		return GEN_DESC;
	}
	public void setGEN_DESC(String gEN_DESC) {
		GEN_DESC = gEN_DESC;
	}
	public String getGEN_GEN_DDI_DESC() {
		return GEN_GEN_DDI_DESC;
	}
	public void setGEN_GEN_DDI_DESC(String gEN_GEN_DDI_DESC) {
		GEN_GEN_DDI_DESC = gEN_GEN_DDI_DESC;
	}
	public String getPAGE_NO() {
		return PAGE_NO;
	}
	public void setPAGE_NO(String pAGE_NO) {
		PAGE_NO = pAGE_NO;
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
