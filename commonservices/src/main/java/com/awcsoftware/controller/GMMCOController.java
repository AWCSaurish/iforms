package com.awcsoftware.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.awcsoftware.dto.PORequest;
import com.awcsoftware.dto.POResponse;
import com.awcsoftware.dto.poheader.Result;
import com.awcsoftware.services.IPOServices;
import com.awcsoftware.services.impl.POServicesImpl;

@RestController
@RequestMapping({"/"})
public class GMMCOController {
	static final Logger logger = Logger.getLogger(GMMCOController.class);
	  @Autowired
	  private ApplicationContext ctx;
	  
	  @GetMapping
	  public String sampleData()
	  {
	    return "GMMCO Services Up & Running";
	  }
	  @PostMapping({"getPoHeader"})
	  @ResponseBody
	  public List<Result> getPoHeader(@RequestBody PORequest req)
	  {
	    IPOServices services = (POServicesImpl)ctx.getBean(POServicesImpl.class);
	    logger.info("PORequest: " + req);
	    return services.getPoHeader(req.getFilter());
	  }
	  @PostMapping({"getPoLine"})
	  @ResponseBody
	  public List<com.awcsoftware.dto.poline.Result> getPoLine(@RequestBody PORequest req)
	  {
	    IPOServices services = (POServicesImpl)ctx.getBean(POServicesImpl.class);
	    logger.info("PORequest: " + req);
	    return services.getPOLines(req.getFilter());
	  }
	  @PostMapping({"getPoHistory"})
	  @ResponseBody
	  public void getPoHistory(@RequestBody PORequest req)
	  {
	    IPOServices services = (POServicesImpl)ctx.getBean(POServicesImpl.class);
	    logger.info("PORequest: " + req);
	    services.getPOHistory(req.getFilter());
	    //return services.getPOHistory(req.getFilter());
	  }
	  @PostMapping({"getPoDetails"})
	  @ResponseBody
	  public POResponse getPoDetails(@RequestBody PORequest req)
	  {
	    IPOServices services = (POServicesImpl)ctx.getBean(POServicesImpl.class);
	    logger.info("PORequest: " + req);
	    return services.getPODetails(req.getFilter());
	  }
}
