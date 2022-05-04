package ebig.oracle.cloud.integration.connector;
//commit
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ReportServiceConnector extends WebServiceGatewaySupport {
	
	  public Object callWebService(String url, Object request){
	        return getWebServiceTemplate().marshalSendAndReceive(url, request);
	    }

}
