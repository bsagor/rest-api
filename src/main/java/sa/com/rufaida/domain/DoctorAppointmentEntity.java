package sa.com.rufaida.domain;

import java.io.Serializable;

public class DoctorAppointmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public String appt_date;
	public String appt_time;
	public String pat_no;
	public String pat_name;
	public String clinic_name_lang2;
	public String clinic_doc_code;
	public String arrival_status;

	public String getAppt_date() {
		return appt_date;
	}

	public void setAppt_date(String appt_date) {
		this.appt_date = appt_date;
	}
	
	public String getAppt_time() {
		return appt_time;
	}

	public void setAppt_time(String appt_time) {
		this.appt_time = appt_time;
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

	public String getClinic_name_lang2() {
		return clinic_name_lang2;
	}

	public void setClinic_name_lang2(String clinic_name_lang2) {
		this.clinic_name_lang2 = clinic_name_lang2;
	}

	public String getClinic_doc_code() {
		return clinic_doc_code;
	}

	public void setClinic_doc_code(String clinic_doc_code) {
		this.clinic_doc_code = clinic_doc_code;
	}

	public String getArrival_status() {
		return arrival_status;
	}

	public void setArrival_status(String arrival_status) {
		this.arrival_status = arrival_status;
	}
}
