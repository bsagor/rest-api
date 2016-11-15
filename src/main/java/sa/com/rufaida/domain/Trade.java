package sa.com.rufaida.domain;

import java.io.Serializable;

public class Trade implements Serializable {

	private static final long serialVersionUID = 7752994824077970882L;
	public String ENTRY_USER;
    public String ENTRY_DATE;
    public String UPD_USER;
    public String UPD_DATE;
    public String GEN_CODE;
    public String TRADE_CODE;
    public String LANG1_NAME;
    public String LANG2_NAME;       
    public String ACTIVE_FLAG;
    public String MANUF_CODE;
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
	public String getGEN_CODE() {
		return GEN_CODE;
	}
	public void setGEN_CODE(String gEN_CODE) {
		GEN_CODE = gEN_CODE;
	}
	public String getTRADE_CODE() {
		return TRADE_CODE;
	}
	public void setTRADE_CODE(String tRADE_CODE) {
		TRADE_CODE = tRADE_CODE;
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
	public String getACTIVE_FLAG() {
		return ACTIVE_FLAG;
	}
	public void setACTIVE_FLAG(String aCTIVE_FLAG) {
		ACTIVE_FLAG = aCTIVE_FLAG;
	}
	public String getMANUF_CODE() {
		return MANUF_CODE;
	}
	public void setMANUF_CODE(String mANUF_CODE) {
		MANUF_CODE = mANUF_CODE;
	}
    
}
