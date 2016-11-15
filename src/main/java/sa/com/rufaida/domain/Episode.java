package sa.com.rufaida.domain;

import java.io.Serializable;

public class Episode implements Serializable{

	private static final long serialVersionUID = 1130205148365396846L;
	public String PAT_NO;
    public String EPISODE_NO;
    public String ADMIT_DATE;
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
	public String getADMIT_DATE() {
		return ADMIT_DATE;
	}
	public void setADMIT_DATE(String aDMIT_DATE) {
		ADMIT_DATE = aDMIT_DATE;
	}
    
    
}
