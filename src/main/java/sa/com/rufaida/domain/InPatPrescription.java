package sa.com.rufaida.domain;

import java.io.Serializable;

public class InPatPrescription implements Serializable {

	private static final long serialVersionUID = -3344523797405281309L;
	public String GEN_CODE;
    public String PAT_NO;
    public String EPISODE_NO;
    public String DRUG_INACTIVE_FLAG;
    public String PAT_MEDICINE_SEQ;
    public String GENERIC_DESC;
    public String MFORM_DESC;
    public String ROUTE_DESC;
    public String REQUEST_STRENGTH;
    public String ENTRY_DATE;
    public String ENTRY_TIME;
    public String FREQUENCY;
    public String DOSE_DURATION;
    public String STOP_FRM;
    public String AMEND_USER;
	public String getGEN_CODE() {
		return GEN_CODE;
	}
	public void setGEN_CODE(String gEN_CODE) {
		GEN_CODE = gEN_CODE;
	}
	public String getPAT_NO() {
		return PAT_NO;
	}
	public void setPAT_NO(String pAT_NO) {
		PAT_NO = pAT_NO;
	}
	public String getEPISODE_NO() {
		return EPISODE_NO;
	}
	public void setEPISODE_NO(String ePISODE_NO) {
		EPISODE_NO = ePISODE_NO;
	}
	public String getDRUG_INACTIVE_FLAG() {
		return DRUG_INACTIVE_FLAG;
	}
	public void setDRUG_INACTIVE_FLAG(String dRUG_INACTIVE_FLAG) {
		DRUG_INACTIVE_FLAG = dRUG_INACTIVE_FLAG;
	}
	public String getPAT_MEDICINE_SEQ() {
		return PAT_MEDICINE_SEQ;
	}
	public void setPAT_MEDICINE_SEQ(String pAT_MEDICINE_SEQ) {
		PAT_MEDICINE_SEQ = pAT_MEDICINE_SEQ;
	}
	public String getGENERIC_DESC() {
		return GENERIC_DESC;
	}
	public void setGENERIC_DESC(String gENERIC_DESC) {
		GENERIC_DESC = gENERIC_DESC;
	}
	public String getMFORM_DESC() {
		return MFORM_DESC;
	}
	public void setMFORM_DESC(String mFORM_DESC) {
		MFORM_DESC = mFORM_DESC;
	}
	public String getROUTE_DESC() {
		return ROUTE_DESC;
	}
	public void setROUTE_DESC(String rOUTE_DESC) {
		ROUTE_DESC = rOUTE_DESC;
	}
	public String getREQUEST_STRENGTH() {
		return REQUEST_STRENGTH;
	}
	public void setREQUEST_STRENGTH(String rEQUEST_STRENGTH) {
		REQUEST_STRENGTH = rEQUEST_STRENGTH;
	}
	public String getENTRY_DATE() {
		return ENTRY_DATE;
	}
	public void setENTRY_DATE(String eNTRY_DATE) {
		ENTRY_DATE = eNTRY_DATE;
	}
	public String getENTRY_TIME() {
		return ENTRY_TIME;
	}
	public void setENTRY_TIME(String eNTRY_TIME) {
		ENTRY_TIME = eNTRY_TIME;
	}
	public String getFREQUENCY() {
		return FREQUENCY;
	}
	public void setFREQUENCY(String fREQUENCY) {
		FREQUENCY = fREQUENCY;
	}
	public String getDOSE_DURATION() {
		return DOSE_DURATION;
	}
	public void setDOSE_DURATION(String dOSE_DURATION) {
		DOSE_DURATION = dOSE_DURATION;
	}
	public String getSTOP_FRM() {
		return STOP_FRM;
	}
	public void setSTOP_FRM(String sTOP_FRM) {
		STOP_FRM = sTOP_FRM;
	}
	public String getAMEND_USER() {
		return AMEND_USER;
	}
	public void setAMEND_USER(String aMEND_USER) {
		AMEND_USER = aMEND_USER;
	}
    
    
}
