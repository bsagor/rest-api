package sa.com.rufaida.domain;

import java.io.Serializable;

public class Drug implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7610678519398436312L;
	public String GEN_CODE;
    public String GEN_NAME;
	public String getGEN_CODE() {
		return GEN_CODE;
	}
	public void setGEN_CODE(String gEN_CODE) {
		GEN_CODE = gEN_CODE;
	}
	public String getGEN_NAME() {
		return GEN_NAME;
	}
	public void setGEN_NAME(String gEN_NAME) {
		GEN_NAME = gEN_NAME;
	}
    
}
