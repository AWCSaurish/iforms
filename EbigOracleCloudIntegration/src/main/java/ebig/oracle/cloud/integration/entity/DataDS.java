package ebig.oracle.cloud.integration.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "DATA_DS")
public class DataDS {
	
	@JacksonXmlProperty(localName = "G_1")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<ReportServiceData> G_1 = new ArrayList<ReportServiceData>();

	public List<ReportServiceData> getG_1() {
		return G_1;
	}

	public void setG_1(List<ReportServiceData> g_1) {
		G_1 = g_1;
	}

	
	


	
	
	

}
