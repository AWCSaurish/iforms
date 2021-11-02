package com.awcsoftware.dto.po;

import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class POResponse {
	private List<HeaderResult> header;
	private List<LineResult> line;
	private List<HistoryResult> history;
	public POResponse() {
	}
	public List<HeaderResult> getHeader() {
		return header;
	}
	public void setHeader(List<HeaderResult> header) {
		this.header = header;
	}
	public List<LineResult> getLine() {
		return line;
	}
	public void setLine(List<LineResult> line) {
		this.line = line;
	}
	public List<HistoryResult> getHistory() {
		return history;
	}
	public void setHistory(List<HistoryResult> history) {
		this.history = history;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((header == null) ? 0 : header.hashCode());
		result = prime * result + ((history == null) ? 0 : history.hashCode());
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
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
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
		return "POResponse [header=" + header + ", line=" + line + ", history=" + history + "]";
	}
		
}
