package sa.com.rufaida.domain;

import java.io.Serializable;

public class TradeDescription implements Serializable {
	private static final long serialVersionUID = -4110602828378391915L;
	public String DRUG_MASTER_CODE;
    public String ITEM_CODE;
    public String ITEM_DSCRPTN;
	public String getDRUG_MASTER_CODE() {
		return DRUG_MASTER_CODE;
	}
	public void setDRUG_MASTER_CODE(String dRUG_MASTER_CODE) {
		DRUG_MASTER_CODE = dRUG_MASTER_CODE;
	}
	public String getITEM_CODE() {
		return ITEM_CODE;
	}
	public void setITEM_CODE(String iTEM_CODE) {
		ITEM_CODE = iTEM_CODE;
	}
	public String getITEM_DSCRPTN() {
		return ITEM_DSCRPTN;
	}
	public void setITEM_DSCRPTN(String iTEM_DSCRPTN) {
		ITEM_DSCRPTN = iTEM_DSCRPTN;
	}
    
}
