package sa.com.rufaida.domain;

import java.io.Serializable;

public class LabRequest implements Serializable{

	private static final long serialVersionUID = -1371741633184974892L;
	
	public String RequestNo;
    public String PatNo;
    public String LabRefNo;
    public String PatientName;
    public String PatAge;
    public String RequestDate;
    public String AnalysisCode;
    public String AnalysisName;
    public String LabNo;
    public String LabName;
    public String WSCode;
    public String ReceivedDate;
    public String RefHosName;
    public String ReqStatus;
    public String ReqStatusName;
    public String T_ENTRY_DATE;
    public String T_UPD_DATE;
	public String getRequestNo() {
		return RequestNo;
	}
	public void setRequestNo(String requestNo) {
		RequestNo = requestNo;
	}
	public String getPatNo() {
		return PatNo;
	}
	public void setPatNo(String patNo) {
		PatNo = patNo;
	}
	public String getLabRefNo() {
		return LabRefNo;
	}
	public void setLabRefNo(String labRefNo) {
		LabRefNo = labRefNo;
	}
	public String getPatientName() {
		return PatientName;
	}
	public void setPatientName(String patientName) {
		PatientName = patientName;
	}
	public String getPatAge() {
		return PatAge;
	}
	public void setPatAge(String patAge) {
		PatAge = patAge;
	}
	public String getRequestDate() {
		return RequestDate;
	}
	public void setRequestDate(String requestDate) {
		RequestDate = requestDate;
	}
	public String getAnalysisCode() {
		return AnalysisCode;
	}
	public void setAnalysisCode(String analysisCode) {
		AnalysisCode = analysisCode;
	}
	public String getAnalysisName() {
		return AnalysisName;
	}
	public void setAnalysisName(String analysisName) {
		AnalysisName = analysisName;
	}
	public String getLabNo() {
		return LabNo;
	}
	public void setLabNo(String labNo) {
		LabNo = labNo;
	}
	public String getLabName() {
		return LabName;
	}
	public void setLabName(String labName) {
		LabName = labName;
	}
	public String getWSCode() {
		return WSCode;
	}
	public void setWSCode(String wSCode) {
		WSCode = wSCode;
	}
	public String getReceivedDate() {
		return ReceivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		ReceivedDate = receivedDate;
	}
	public String getRefHosName() {
		return RefHosName;
	}
	public void setRefHosName(String refHosName) {
		RefHosName = refHosName;
	}
	public String getReqStatus() {
		return ReqStatus;
	}
	public void setReqStatus(String reqStatus) {
		ReqStatus = reqStatus;
	}
	public String getReqStatusName() {
		return ReqStatusName;
	}
	public void setReqStatusName(String reqStatusName) {
		ReqStatusName = reqStatusName;
	}
	public String getT_ENTRY_DATE() {
		return T_ENTRY_DATE;
	}
	public void setT_ENTRY_DATE(String t_ENTRY_DATE) {
		T_ENTRY_DATE = t_ENTRY_DATE;
	}
	public String getT_UPD_DATE() {
		return T_UPD_DATE;
	}
	public void setT_UPD_DATE(String t_UPD_DATE) {
		T_UPD_DATE = t_UPD_DATE;
	}
    
}
