package ebig.oracle.cloud.integration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import ebig.oracle.cloud.integration.connector.ReportServiceConnector;

@Configuration
public class ReportServiceConfig {
	
	/*@Value("${USERNAMEWSDL}")
    private String userNameWSDL;
	
	
	@Value("${PASSWORDWSDL}")
    private String passwordWSDL;*/


	@Bean
	public Jaxb2Marshaller leadIntegrationServiceMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this is the package name specified in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("ebig.oracle.cloud.integration.ReportService");

		return marshaller;
	}

	@Bean
	public ReportServiceConnector reportServiceSoapConnector(Jaxb2Marshaller marshaller) {
		ReportServiceConnector client = new ReportServiceConnector();
		client.setDefaultUri("https://ebig.fa.us2.oraclecloud.com/xmlpserver/services/v2/ReportService?WSDL");
		client.setMarshaller(leadIntegrationServiceMarshaller());
		client.setUnmarshaller(leadIntegrationServiceMarshaller());
		 // set a HttpComponentsMessageSender which provides support for basic authentication
	   // client.setMessageSender(reportServiceHttpComponentsMessageSender());

		return client;
	}

	/*@Bean
	public HttpComponentsMessageSender reportServiceHttpComponentsMessageSender() {
		HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
		// set the basic authorization credentials
		httpComponentsMessageSender.setCredentials(reportServiceUsernamePasswordCredentials());

		return httpComponentsMessageSender;
	}

	@Bean
	public UsernamePasswordCredentials reportServiceUsernamePasswordCredentials() {
		// pass the user name and password to be used
		return new UsernamePasswordCredentials(userNameWSDL.trim(), passwordWSDL.trim());
	}*/

}
