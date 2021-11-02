package com.awcsoftware.dto.mdm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.mdm.MdmEmployeeMaster;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MdmEmployeeMasterMapper implements RowMapper<MdmEmployeeMaster>{
	static final Logger logger = Logger.getLogger(MdmEmployeeMasterMapper.class);
	@Autowired
	private ApplicationContext ctx;
	@Override
	public MdmEmployeeMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		MdmEmployeeMaster master=ctx.getBean(MdmEmployeeMaster.class);
		master.setDepartment_code(rs.getString("department_code"));
		master.setDepartment_description(rs.getString("department_description"));
		master.setDivision_code(rs.getString("division_code"));
		master.setDivision_description(rs.getString("division_description"));
		master.setEmployee_code(rs.getString("employee_code"));
		master.setEmployee_email_id(rs.getString("employee_email_id"));
		master.setEmployee_name(rs.getString("employee_name"));
		master.setLocation(rs.getString("location"));
		master.setSr_no(rs.getString("sr_no"));
		logger.info(master);
		return master;
	}

}
