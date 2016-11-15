package sa.com.rufaida.domain;

import java.io.Serializable;

public class Profile implements Serializable{
	private static final long serialVersionUID = -8731039031813841117L;
	
	public String ID;
    public String NAME;
    public String ADDRESS;
    public String EMAIL;
    public String PHONE;
    public String t_entry_date;
    public String t_last_upd_date;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getT_entry_date() {
		return t_entry_date;
	}
	public void setT_entry_date(String t_entry_date) {
		this.t_entry_date = t_entry_date;
	}
	public String getT_last_upd_date() {
		return t_last_upd_date;
	}
	public void setT_last_upd_date(String t_last_upd_date) {
		this.t_last_upd_date = t_last_upd_date;
	}
    
    
}
