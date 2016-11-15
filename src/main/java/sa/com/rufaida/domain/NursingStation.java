package sa.com.rufaida.domain;

import java.io.Serializable;

public class NursingStation implements Serializable {

	private static final long serialVersionUID = 3328625935854771580L;
	public String nursing_station_code;
    public String hdm_loc_dscrptn;
	public String getNursing_station_code() {
		return nursing_station_code;
	}
	public void setNursing_station_code(String nursing_station_code) {
		this.nursing_station_code = nursing_station_code;
	}
	public String getHdm_loc_dscrptn() {
		return hdm_loc_dscrptn;
	}
	public void setHdm_loc_dscrptn(String hdm_loc_dscrptn) {
		this.hdm_loc_dscrptn = hdm_loc_dscrptn;
	}
    
}
