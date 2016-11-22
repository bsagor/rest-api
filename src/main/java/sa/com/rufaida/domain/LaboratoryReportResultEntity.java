package sa.com.rufaida.domain;

import java.io.Serializable;

public class LaboratoryReportResultEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String pat_no;
	public String request_no;
	public String analysis_code;
	public String request_date;
	public String request_time;
	public String spec_no;
	public String lab_no;
	public String received_date;
	public String received_time;
	public String notes;
	public String upd_date;
	public String pat_name;
	public String birth_date;
	public String specimen_name;
	public String gender;
	public String nationality;
	public String result_value;
	public String analysis_name;
	public String range;

	public String getPat_no() {
		return pat_no;
	}

	public void setPat_no(String pat_no) {
		this.pat_no = pat_no;
	}

	public String getRequest_no() {
		return request_no;
	}

	public void setRequest_no(String request_no) {
		this.request_no = request_no;
	}

	public String getAnalysis_code() {
		return analysis_code;
	}

	public void setAnalysis_code(String analysis_code) {
		this.analysis_code = analysis_code;
	}

	public String getRequest_date() {
		return request_date;
	}

	public void setRequest_date(String request_date) {
		this.request_date = request_date;
	}

	public String getRequest_time() {
		return request_time;
	}

	public void setRequest_time(String request_time) {
		this.request_time = request_time;
	}

	public String getSpec_no() {
		return spec_no;
	}

	public void setSpec_no(String spec_no) {
		this.spec_no = spec_no;
	}

	public String getLab_no() {
		return lab_no;
	}

	public void setLab_no(String lab_no) {
		this.lab_no = lab_no;
	}

	public String getReceived_date() {
		return received_date;
	}

	public void setReceived_date(String received_date) {
		this.received_date = received_date;
	}

	public String getReceived_time() {
		return received_time;
	}

	public void setReceived_time(String received_time) {
		this.received_time = received_time;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getUpd_date() {
		return upd_date;
	}

	public void setUpd_date(String upd_date) {
		this.upd_date = upd_date;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getSpecimen_name() {
		return specimen_name;
	}

	public void setSpecimen_name(String specimen_name) {
		this.specimen_name = specimen_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getResult_value() {
		return result_value;
	}

	public void setResult_value(String result_value) {
		this.result_value = result_value;
	}

	public String getAnalysis_name() {
		return analysis_name;
	}

	public void setAnalysis_name(String analysis_name) {
		this.analysis_name = analysis_name;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}
}
