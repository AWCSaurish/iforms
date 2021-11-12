package com.awcsoftware.dto.mdm;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MdmEmployeeMaster {
	private String sr_no;	
	private String employee_code;	
	private String employee_name;	
	private String employee_email_id;	
	private String division_code;	
	private String division_description;	
	private String location;	
	private String department_code;	
	private String department_description;
	public MdmEmployeeMaster() {
	}
	public String getSr_no() {
		return sr_no;
	}
	public void setSr_no(String sr_no) {
		this.sr_no = sr_no;
	}
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_email_id() {
		return employee_email_id;
	}
	public void setEmployee_email_id(String employee_email_id) {
		this.employee_email_id = employee_email_id;
	}
	public String getDivision_code() {
		return division_code;
	}
	public void setDivision_code(String division_code) {
		this.division_code = division_code;
	}
	public String getDivision_description() {
		return division_description;
	}
	public void setDivision_description(String division_description) {
		this.division_description = division_description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}
	public String getDepartment_description() {
		return department_description;
	}
	public void setDepartment_description(String department_description) {
		this.department_description = department_description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department_code == null) ? 0 : department_code.hashCode());
		result = prime * result + ((department_description == null) ? 0 : department_description.hashCode());
		result = prime * result + ((division_code == null) ? 0 : division_code.hashCode());
		result = prime * result + ((division_description == null) ? 0 : division_description.hashCode());
		result = prime * result + ((employee_code == null) ? 0 : employee_code.hashCode());
		result = prime * result + ((employee_email_id == null) ? 0 : employee_email_id.hashCode());
		result = prime * result + ((employee_name == null) ? 0 : employee_name.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((sr_no == null) ? 0 : sr_no.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MdmEmployeeMaster other = (MdmEmployeeMaster) obj;
		if (department_code == null) {
			if (other.department_code != null)
				return false;
		} else if (!department_code.equals(other.department_code))
			return false;
		if (department_description == null) {
			if (other.department_description != null)
				return false;
		} else if (!department_description.equals(other.department_description))
			return false;
		if (division_code == null) {
			if (other.division_code != null)
				return false;
		} else if (!division_code.equals(other.division_code))
			return false;
		if (division_description == null) {
			if (other.division_description != null)
				return false;
		} else if (!division_description.equals(other.division_description))
			return false;
		if (employee_code == null) {
			if (other.employee_code != null)
				return false;
		} else if (!employee_code.equals(other.employee_code))
			return false;
		if (employee_email_id == null) {
			if (other.employee_email_id != null)
				return false;
		} else if (!employee_email_id.equals(other.employee_email_id))
			return false;
		if (employee_name == null) {
			if (other.employee_name != null)
				return false;
		} else if (!employee_name.equals(other.employee_name))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (sr_no == null) {
			if (other.sr_no != null)
				return false;
		} else if (!sr_no.equals(other.sr_no))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MdmEmployeeMaster [sr_no=" + sr_no + ", employee_code=" + employee_code + ", employee_name="
				+ employee_name + ", employee_email_id=" + employee_email_id + ", division_code=" + division_code
				+ ", division_description=" + division_description + ", location=" + location + ", department_code="
				+ department_code + ", department_description=" + department_description + "]";
	}
	
}
