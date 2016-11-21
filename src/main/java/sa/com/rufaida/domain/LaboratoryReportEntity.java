package sa.com.rufaida.domain;

import java.io.Serializable;

public class LaboratoryReportEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String request_no;
	public String pat_no;
	public String pat_name;
	public String request_date;
	public String lab_name;
	public String ws_code;
	public String received_date;
	public String analysis_code;
	public String analysis;
	public String lab_no;
	public String lab_location;
	public String status_code;
	public String status_name;
	public String yrs;
	public String mos;
	public String days;
	public String sex;
	
	public String getRequest_no() {
		return request_no;
	}
	public void setRequest_no(String request_no) {
		this.request_no = request_no;
	}
	public String getPat_no() {
		return pat_no;
	}
	public void setPat_no(String pat_no) {
		this.pat_no = pat_no;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getRequest_date() {
		return request_date;
	}
	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}
	public String getLab_name() {
		return lab_name;
	}
	public void setLab_name(String lab_name) {
		this.lab_name = lab_name;
	}
	public String getWs_code() {
		return ws_code;
	}
	public void setWs_code(String ws_code) {
		this.ws_code = ws_code;
	}
	public String getReceived_date() {
		return received_date;
	}
	public void setReceived_date(String received_date) {
		this.received_date = received_date;
	}
	public String getAnalysis_code() {
		return analysis_code;
	}
	public void setAnalysis_code(String analysis_code) {
		this.analysis_code = analysis_code;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	public String getLab_no() {
		return lab_no;
	}
	public void setLab_no(String lab_no) {
		this.lab_no = lab_no;
	}
	public String getLab_location() {
		return lab_location;
	}
	public void setLab_location(String lab_location) {
		this.lab_location = lab_location;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getStatus_name() {
		return status_name;
	}
	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	public String getYrs() {
		return yrs;
	}
	public void setYrs(String yrs) {
		this.yrs = yrs;
	}
	public String getMos() {
		return mos;
	}
	public void setMos(String mos) {
		this.mos = mos;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
}
