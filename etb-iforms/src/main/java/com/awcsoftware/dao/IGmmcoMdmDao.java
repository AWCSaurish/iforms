package com.awcsoftware.dao;

import java.util.List;

import com.awcsoftware.dto.mdm.MdmEmployeeMaster;

public interface IGmmcoMdmDao {
	public List<MdmEmployeeMaster> getListOfEmployees();
	public MdmEmployeeMaster getEmployee(String empCode);
}
