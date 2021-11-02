package com.awcsoftware.services;

import java.util.List;

import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
import com.awcsoftware.dto.po.HeaderResult;
import com.awcsoftware.dto.po.HistoryResult;
import com.awcsoftware.dto.po.POResponse;

public interface IPOServices {
	public List<HeaderResult> getPoHeader(String filter);
	public List<com.awcsoftware.dto.po.LineResult> getPOLines(String filter) ;
	public POResponse getPODetails(String filter) ;
	public List<HistoryResult> getPOHistory(String filter) ;
	public List<MdmEmployeeMaster> getListOfEmployees();
}
