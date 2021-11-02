package com.awcsoftware.dto.po;

public class Root{
    private D d;
    public Root() {
	}
	public D getD() {
		return d;
	}
	public void setD(D d) {
		this.d = d;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((d == null) ? 0 : d.hashCode());
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
		Root other = (Root) obj;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Root [d=" + d + "]";
	}
    
}
