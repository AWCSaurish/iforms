package com.awcsoftware.dto;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dto.poheader.Result;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class POResponse {
	private List<Result> header;
	private List<com.awcsoftware.dto.poline.Result> line;
	public POResponse() {
	}
	public List<Result> getHeader() {
		return header;
	}
	public void setHeader(List<Result> header) {
		this.header = header;
	}
	public List<com.awcsoftware.dto.poline.Result> getLine() {
		return line;
	}
	public void setLine(List<com.awcsoftware.dto.poline.Result> line) {
		this.line = line;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((line == null) ? 0 : line.hashCode());
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
		POResponse other = (POResponse) obj;
		if (header == null) {
			if (other.header != null)
				return false;
		} else if (!header.equals(other.header))
			return false;
		if (line == null) {
			if (other.line != null)
				return false;
		} else if (!line.equals(other.line))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "POResponse [header=" + header + ", line=" + line + "]";
	}
	
}
