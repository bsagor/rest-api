package sa.com.rufaida.domain;

import java.io.Serializable;

public class PatientLabResult implements Serializable{

	private static final long serialVersionUID = 1498631981564962339L;
	
	  public String PatNo;
      public String PatName;
      public String RequestNo;       
      public String AnalysisCode;
      public String AnalysisName;
      public String Result;
      public String ResultNotes;
      public String Range;
      public String LabNo;
      public String LabName;
      public String WSCode;
	public String getPatNo() {
		return PatNo;
	}
	public void setPatNo(String patNo) {
		PatNo = patNo;
	}
	public String getPatName() {
		return PatName;
	}
	public void setPatName(String patName) {
		PatName = patName;
	}
	public String getRequestNo() {
		return RequestNo;
	}
	public void setRequestNo(String requestNo) {
		RequestNo = requestNo;
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
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
	public String getResultNotes() {
		return ResultNotes;
	}
	public void setResultNotes(String resultNotes) {
		ResultNotes = resultNotes;
	}
	public String getRange() {
		return Range;
	}
	public void setRange(String range) {
		Range = range;
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
      
      
      
}
