package sa.com.rufaida.domain;

import java.io.Serializable;

public class NursingPatient implements Serializable {

	private static final long serialVersionUID = -1357202022844522951L;
	public String PAT_NO;
    public String PATIENT_NAME;       
    public String ipm_code_description;       
    public String ipm_bed_no;
    public String chart_no;
	public String getPAT_NO() {
		return PAT_NO;
	}
	public void setPAT_NO(String pAT_NO) {
		PAT_NO = pAT_NO;
	}
	public String getPATIENT_NAME() {
		return PATIENT_NAME;
	}
	public void setPATIENT_NAME(String pATIENT_NAME) {
		PATIENT_NAME = pATIENT_NAME;
	}
	public String getIpm_code_description() {
		return ipm_code_description;
	}
	public void setIpm_code_description(String ipm_code_description) {
		this.ipm_code_description = ipm_code_description;
	}
	public String getIpm_bed_no() {
		return ipm_bed_no;
	}
	public void setIpm_bed_no(String ipm_bed_no) {
		this.ipm_bed_no = ipm_bed_no;
	}
	public String getChart_no() {
		return chart_no;
	}
	public void setChart_no(String chart_no) {
		this.chart_no = chart_no;
	}  
    
    
}
