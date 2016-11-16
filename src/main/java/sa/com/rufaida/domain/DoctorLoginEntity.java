package sa.com.rufaida.domain;

import java.io.Serializable;

public class DoctorLoginEntity implements Serializable {
	private static final long serialVersionUID = -6315999499086624074L;

	public String login_name;
	public String pwd;
	public String doc_code;
	public String role_code;
	public String emp_code;
	public String user_code;

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

	public String getRole_code() {
		return role_code;
	}

	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}

	public String getEmp_code() {
		return emp_code;
	}

	public void setEmp_code(String emp_code) {
		this.emp_code = emp_code;
	}

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

}
