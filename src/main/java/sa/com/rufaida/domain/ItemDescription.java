package sa.com.rufaida.domain;

import java.io.Serializable;

public class ItemDescription implements Serializable{

	private static final long serialVersionUID = 6148327451361723848L;
	
	public String UPD_USER;
    public String UPD_DATE;
    public String BSE_UM;
    public int BSE_UNIT_COST_AVG;
    public String DRUG_CODE;
    public String ITEM_CODE;       
    public String ITEM_DSCRPTN;
    public String ITEM_DSCRPTN_SNDX;
    public int LAST_LOT_NO;
    public int LEAD_TIME;
    public String MAIN_STK_LOC_CODE;
    public String VENDOR_CODE;       
    public String IOS_NUMBER;
    public String PROD_CAT_MCODE;
    public String PROD_CAT_SCODE;
    public String PROD_CLASS_CODE;
    public String PHYSICAL_STATE;
    public String MANUFACTURER_CODE;
    public int MARKUP_QTY;
    public String ITEM_ACTIVE_FLAG;
    public String EXPIRY_DATE_FLAG;
    public String MON_NONMOH_FLAG;
    public String ITEM_DSCRPTN_ARB;
    public String MOH_ITEM_CODE;       
    public String DRUG_MASTER_CODE;
    public String OLD_BSE;
    public String ACTIVE_FLAG;
    public double BUS_CNTR_PRICE;
    public String ENTRY_USER;
    public String ENTRY_DATE;
	public String getUPD_USER() {
		return UPD_USER;
	}
	public void setUPD_USER(String uPD_USER) {
		UPD_USER = uPD_USER;
	}
	public String getUPD_DATE() {
		return UPD_DATE;
	}
	public void setUPD_DATE(String uPD_DATE) {
		UPD_DATE = uPD_DATE;
	}
	public String getBSE_UM() {
		return BSE_UM;
	}
	public void setBSE_UM(String bSE_UM) {
		BSE_UM = bSE_UM;
	}
	public int getBSE_UNIT_COST_AVG() {
		return BSE_UNIT_COST_AVG;
	}
	public void setBSE_UNIT_COST_AVG(int bSE_UNIT_COST_AVG) {
		BSE_UNIT_COST_AVG = bSE_UNIT_COST_AVG;
	}
	public String getDRUG_CODE() {
		return DRUG_CODE;
	}
	public void setDRUG_CODE(String dRUG_CODE) {
		DRUG_CODE = dRUG_CODE;
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
	public String getITEM_DSCRPTN_SNDX() {
		return ITEM_DSCRPTN_SNDX;
	}
	public void setITEM_DSCRPTN_SNDX(String iTEM_DSCRPTN_SNDX) {
		ITEM_DSCRPTN_SNDX = iTEM_DSCRPTN_SNDX;
	}
	public int getLAST_LOT_NO() {
		return LAST_LOT_NO;
	}
	public void setLAST_LOT_NO(int lAST_LOT_NO) {
		LAST_LOT_NO = lAST_LOT_NO;
	}
	public int getLEAD_TIME() {
		return LEAD_TIME;
	}
	public void setLEAD_TIME(int lEAD_TIME) {
		LEAD_TIME = lEAD_TIME;
	}
	public String getMAIN_STK_LOC_CODE() {
		return MAIN_STK_LOC_CODE;
	}
	public void setMAIN_STK_LOC_CODE(String mAIN_STK_LOC_CODE) {
		MAIN_STK_LOC_CODE = mAIN_STK_LOC_CODE;
	}
	public String getVENDOR_CODE() {
		return VENDOR_CODE;
	}
	public void setVENDOR_CODE(String vENDOR_CODE) {
		VENDOR_CODE = vENDOR_CODE;
	}
	public String getIOS_NUMBER() {
		return IOS_NUMBER;
	}
	public void setIOS_NUMBER(String iOS_NUMBER) {
		IOS_NUMBER = iOS_NUMBER;
	}
	public String getPROD_CAT_MCODE() {
		return PROD_CAT_MCODE;
	}
	public void setPROD_CAT_MCODE(String pROD_CAT_MCODE) {
		PROD_CAT_MCODE = pROD_CAT_MCODE;
	}
	public String getPROD_CAT_SCODE() {
		return PROD_CAT_SCODE;
	}
	public void setPROD_CAT_SCODE(String pROD_CAT_SCODE) {
		PROD_CAT_SCODE = pROD_CAT_SCODE;
	}
	public String getPROD_CLASS_CODE() {
		return PROD_CLASS_CODE;
	}
	public void setPROD_CLASS_CODE(String pROD_CLASS_CODE) {
		PROD_CLASS_CODE = pROD_CLASS_CODE;
	}
	public String getPHYSICAL_STATE() {
		return PHYSICAL_STATE;
	}
	public void setPHYSICAL_STATE(String pHYSICAL_STATE) {
		PHYSICAL_STATE = pHYSICAL_STATE;
	}
	public String getMANUFACTURER_CODE() {
		return MANUFACTURER_CODE;
	}
	public void setMANUFACTURER_CODE(String mANUFACTURER_CODE) {
		MANUFACTURER_CODE = mANUFACTURER_CODE;
	}
	public int getMARKUP_QTY() {
		return MARKUP_QTY;
	}
	public void setMARKUP_QTY(int mARKUP_QTY) {
		MARKUP_QTY = mARKUP_QTY;
	}
	public String getITEM_ACTIVE_FLAG() {
		return ITEM_ACTIVE_FLAG;
	}
	public void setITEM_ACTIVE_FLAG(String iTEM_ACTIVE_FLAG) {
		ITEM_ACTIVE_FLAG = iTEM_ACTIVE_FLAG;
	}
	public String getEXPIRY_DATE_FLAG() {
		return EXPIRY_DATE_FLAG;
	}
	public void setEXPIRY_DATE_FLAG(String eXPIRY_DATE_FLAG) {
		EXPIRY_DATE_FLAG = eXPIRY_DATE_FLAG;
	}
	public String getMON_NONMOH_FLAG() {
		return MON_NONMOH_FLAG;
	}
	public void setMON_NONMOH_FLAG(String mON_NONMOH_FLAG) {
		MON_NONMOH_FLAG = mON_NONMOH_FLAG;
	}
	public String getITEM_DSCRPTN_ARB() {
		return ITEM_DSCRPTN_ARB;
	}
	public void setITEM_DSCRPTN_ARB(String iTEM_DSCRPTN_ARB) {
		ITEM_DSCRPTN_ARB = iTEM_DSCRPTN_ARB;
	}
	public String getMOH_ITEM_CODE() {
		return MOH_ITEM_CODE;
	}
	public void setMOH_ITEM_CODE(String mOH_ITEM_CODE) {
		MOH_ITEM_CODE = mOH_ITEM_CODE;
	}
	public String getDRUG_MASTER_CODE() {
		return DRUG_MASTER_CODE;
	}
	public void setDRUG_MASTER_CODE(String dRUG_MASTER_CODE) {
		DRUG_MASTER_CODE = dRUG_MASTER_CODE;
	}
	public String getOLD_BSE() {
		return OLD_BSE;
	}
	public void setOLD_BSE(String oLD_BSE) {
		OLD_BSE = oLD_BSE;
	}
	public String getACTIVE_FLAG() {
		return ACTIVE_FLAG;
	}
	public void setACTIVE_FLAG(String aCTIVE_FLAG) {
		ACTIVE_FLAG = aCTIVE_FLAG;
	}
	public double getBUS_CNTR_PRICE() {
		return BUS_CNTR_PRICE;
	}
	public void setBUS_CNTR_PRICE(double bUS_CNTR_PRICE) {
		BUS_CNTR_PRICE = bUS_CNTR_PRICE;
	}
	public String getENTRY_USER() {
		return ENTRY_USER;
	}
	public void setENTRY_USER(String eNTRY_USER) {
		ENTRY_USER = eNTRY_USER;
	}
	public String getENTRY_DATE() {
		return ENTRY_DATE;
	}
	public void setENTRY_DATE(String eNTRY_DATE) {
		ENTRY_DATE = eNTRY_DATE;
	}
    
}
