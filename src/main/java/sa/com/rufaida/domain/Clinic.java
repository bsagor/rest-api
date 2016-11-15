package sa.com.rufaida.domain;

import java.io.Serializable;

public class Clinic implements Serializable{

	private static final long serialVersionUID = -2383328164247057648L;
	
	 public String CLINIC_CODE;
     public String CLINIC_NAME_LANG1;
     public String CLINIC_NAME_LANG2;
     public String CLINIC_DOC_CODE;
     public String CLINIC_SPCLTY_CODE;
     public String ACTIVE_FLAG;
     public String CLINIC_HOSP_CODE;
	public String getCLINIC_CODE() {
		return CLINIC_CODE;
	}
	public void setCLINIC_CODE(String cLINIC_CODE) {
		CLINIC_CODE = cLINIC_CODE;
	}
	public String getCLINIC_NAME_LANG1() {
		return CLINIC_NAME_LANG1;
	}
	public void setCLINIC_NAME_LANG1(String cLINIC_NAME_LANG1) {
		CLINIC_NAME_LANG1 = cLINIC_NAME_LANG1;
	}
	public String getCLINIC_NAME_LANG2() {
		return CLINIC_NAME_LANG2;
	}
	public void setCLINIC_NAME_LANG2(String cLINIC_NAME_LANG2) {
		CLINIC_NAME_LANG2 = cLINIC_NAME_LANG2;
	}
	public String getCLINIC_DOC_CODE() {
		return CLINIC_DOC_CODE;
	}
	public void setCLINIC_DOC_CODE(String cLINIC_DOC_CODE) {
		CLINIC_DOC_CODE = cLINIC_DOC_CODE;
	}
	public String getCLINIC_SPCLTY_CODE() {
		return CLINIC_SPCLTY_CODE;
	}
	public void setCLINIC_SPCLTY_CODE(String cLINIC_SPCLTY_CODE) {
		CLINIC_SPCLTY_CODE = cLINIC_SPCLTY_CODE;
	}
	public String getACTIVE_FLAG() {
		return ACTIVE_FLAG;
	}
	public void setACTIVE_FLAG(String aCTIVE_FLAG) {
		ACTIVE_FLAG = aCTIVE_FLAG;
	}
	public String getCLINIC_HOSP_CODE() {
		return CLINIC_HOSP_CODE;
	}
	public void setCLINIC_HOSP_CODE(String cLINIC_HOSP_CODE) {
		CLINIC_HOSP_CODE = cLINIC_HOSP_CODE;
	}
     
     
}
