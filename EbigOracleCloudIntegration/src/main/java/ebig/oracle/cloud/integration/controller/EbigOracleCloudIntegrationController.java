package ebig.oracle.cloud.integration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ebig.oracle.cloud.integration.dao.IEbigOracleCloudIntegrationService;
import ebig.oracle.cloud.integration.entity.DataDS;
import ebig.oracle.cloud.integration.entity.ReportServiceData;
//Commit 31 Jan 2019 All Methods
@RestController
public class EbigOracleCloudIntegrationController {

	@Value("${USERNAMEPRO}")
	private String userNameProperty;


	@Value("${PASSWORD}")
	private String passwordProperty;

	@Autowired
	private IEbigOracleCloudIntegrationService eBigOrcleCloudIntegrationService;

	private static final Logger logger = LoggerFactory.getLogger(EbigOracleCloudIntegrationController.class);

	@RequestMapping(value = {"/getReport"}, produces = {"application/json"})
	private @ResponseBody List<ReportServiceData> getEmployee(@RequestParam(value = "username" ,required = true) String userName, @RequestParam(value = "password", required = true) String password,
			HttpServletRequest request,
			HttpServletResponse response){

		List<ReportServiceData> reportServiceData = new ArrayList<ReportServiceData>() ;

		logger.info("User Name ::" + userName);

		if(userName.equals(userNameProperty.trim()) && password.equals(passwordProperty.trim())) {

			DataDS dataDS = eBigOrcleCloudIntegrationService.getReportServiceData();


			if(dataDS!=null){
				return dataDS.getG_1();
			}else{
				ReportServiceData data = new ReportServiceData();
				data.setMessage("Invalid Credentials");
				reportServiceData.add(data);
			}
		}else{

			ReportServiceData data = new ReportServiceData();
			data.setMessage("Invalid Credentials");
			reportServiceData.add(data);
		}


		return reportServiceData;
	}

}
