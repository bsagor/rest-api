package sa.com.rufaida.domain;

import java.io.Serializable;

public class DdlValueEntity implements Serializable{
	private static final long serialVersionUID = -6045303977572908765L;
	
	public String Name;
    public String Code;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
    
}
