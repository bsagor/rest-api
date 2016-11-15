package sa.com.rufaida.domain;

import java.io.Serializable;

public class LabValueEntity implements Serializable{

	private static final long serialVersionUID = -2675070754441870847L;
	
	public String analyzer_name;
	public String ws_name;
	public String analysis_name;
	public String gender_name;
	public String days_from;
	public String days_to;
	public String year_from;
	public String year_to;
	public String t_nr_from;
	public String t_nr_to;
	public String t_result_type;
	public String result_name;
	public String getAnalyzer_name() {
		return analyzer_name;
	}
	public void setAnalyzer_name(String analyzer_name) {
		this.analyzer_name = analyzer_name;
	}
	public String getWs_name() {
		return ws_name;
	}
	public void setWs_name(String ws_name) {
		this.ws_name = ws_name;
	}
	public String getAnalysis_name() {
		return analysis_name;
	}
	public void setAnalysis_name(String analysis_name) {
		this.analysis_name = analysis_name;
	}
	public String getGender_name() {
		return gender_name;
	}
	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}
	public String getDays_from() {
		return days_from;
	}
	public void setDays_from(String days_from) {
		this.days_from = days_from;
	}
	public String getDays_to() {
		return days_to;
	}
	public void setDays_to(String days_to) {
		this.days_to = days_to;
	}
	public String getYear_from() {
		return year_from;
	}
	public void setYear_from(String year_from) {
		this.year_from = year_from;
	}
	public String getYear_to() {
		return year_to;
	}
	public void setYear_to(String year_to) {
		this.year_to = year_to;
	}
	public String getT_nr_from() {
		return t_nr_from;
	}
	public void setT_nr_from(String t_nr_from) {
		this.t_nr_from = t_nr_from;
	}
	public String getT_nr_to() {
		return t_nr_to;
	}
	public void setT_nr_to(String t_nr_to) {
		this.t_nr_to = t_nr_to;
	}
	public String getT_result_type() {
		return t_result_type;
	}
	public void setT_result_type(String t_result_type) {
		this.t_result_type = t_result_type;
	}
	public String getResult_name() {
		return result_name;
	}
	public void setResult_name(String result_name) {
		this.result_name = result_name;
	}
	
	
}
