package sa.com.rufaida.domain;

import java.io.Serializable;

public class DoctorLoginEntity implements Serializable {
	private static final long serialVersionUID = -6315999499086624074L;

	public String login_name;
	public String pwd;
	public String doc_code;
	public String spclty_code;
	public String emp_qualif;
	public String emp_code;
	public String role_code;
	public String user_name;
	public String designation;
	public String designation_lang2_name;
	public String emp_sex;
	
	
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getDoc_code() {
		return doc_code;
	}
	public void setDoc_code(String doc_code) {
		this.doc_code = doc_code;
	}
	public String getSpclty_code() {
		return spclty_code;
	}
	public void setSpclty_code(String spclty_code) {
		this.spclty_code = spclty_code;
	}
	public String getEmp_qualif() {
		return emp_qualif;
	}
	public void setEmp_qualif(String emp_qualif) {
		this.emp_qualif = emp_qualif;
	}
	public String getEmp_code() {
		return emp_code;
	}
	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDesignation_lang2_name() {
		return designation_lang2_name;
	}
	public void setDesignation_lang2_name(String designation_lang2_name) {
		this.designation_lang2_name = designation_lang2_name;
	}
	public String getEmp_sex() {
		return emp_sex;
	}
	public void setEmp_sex(String emp_sex) {
		this.emp_sex = emp_sex;
	}
	
	
}
