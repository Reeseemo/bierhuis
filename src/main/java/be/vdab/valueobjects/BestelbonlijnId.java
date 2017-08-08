package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BestelbonlijnId  implements Serializable {
	
    @Column(name = "bierid")
    private long bierid;
    @Column(name = "bestelbonid")
    private long bestelbonid;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bestelbonid ^ (bestelbonid >>> 32));
		result = prime * result + (int) (bierid ^ (bierid >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BestelbonlijnId))
			return false;
		BestelbonlijnId other = (BestelbonlijnId) obj;
		if (bestelbonid != other.bestelbonid)
			return false;
		if (bierid != other.bierid)
			return false;
		return true;
	}
	public long getBierid() {
		return bierid;
	}
	public void setBierid(long bierid) {
		this.bierid = bierid;
	}
	public long getBestelbonid() {
		return bestelbonid;
	}
	public void setBestelbonid(long bestelbonid) {
		this.bestelbonid = bestelbonid;
	}
	
	

}
