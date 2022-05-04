/**
 * 
 */
package com.awcsoftware.dto;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Pratik
 *
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UploadResponse {

	private int docId;
	private String name,size,ext;
	private int imageIndex;
	private StringBuffer status;
	public UploadResponse() {
	}
	public UploadResponse(int docId, String name, String size, String ext, int imageIndex, StringBuffer status) {
		super();
		this.docId = docId;
		this.name = name;
		this.size = size;
		this.ext = ext;
		this.imageIndex = imageIndex;
		this.status = status;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public int getImageIndex() {
		return imageIndex;
	}
	public void setImageIndex(int imageIndex) {
		this.imageIndex = imageIndex;
	}
	public StringBuffer getStatus() {
		return status;
	}
	public void setStatus(StringBuffer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "UploadResponse [docId=" + docId + ", name=" + name + ", size=" + size + ", ext=" + ext + ", imageIndex="
				+ imageIndex + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + docId;
		result = prime * result + ((ext == null) ? 0 : ext.hashCode());
		result = prime * result + imageIndex;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		UploadResponse other = (UploadResponse) obj;
		if (docId != other.docId)
			return false;
		if (ext == null) {
			if (other.ext != null)
				return false;
		} else if (!ext.equals(other.ext))
			return false;
		if (imageIndex != other.imageIndex)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
		
}
