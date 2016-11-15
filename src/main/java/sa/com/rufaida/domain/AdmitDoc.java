package sa.com.rufaida.domain;

import java.io.Serializable;

public class AdmitDoc implements Serializable{

	private static final long serialVersionUID = 8629451617298795555L;
	
	public String PAT_NO;       
    public String ADMIT_DOC_CODE;
    public String DOC_NAME;
	public String getPAT_NO() {
		return PAT_NO;
	}
	public void setPAT_NO(String pAT_NO) {
		PAT_NO = pAT_NO;
	}
	public String getADMIT_DOC_CODE() {
		return ADMIT_DOC_CODE;
	}
	public void setADMIT_DOC_CODE(String aDMIT_DOC_CODE) {
		ADMIT_DOC_CODE = aDMIT_DOC_CODE;
	}
	public String getDOC_NAME() {
		return DOC_NAME;
	}
	public void setDOC_NAME(String dOC_NAME) {
		DOC_NAME = dOC_NAME;
	} 
    
    
}
