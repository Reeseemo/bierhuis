package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import be.vdab.valueobjects.BestelbonlijnId;

@Entity
@Table(name = "bestelbonlijnen")
public class Bestelbonlijn implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private BestelbonlijnId bestelbonlijnIdid;

	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal prijs;
	private int aantal;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bestelbonid")
	private long bestelbonid;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bierid")
	private long bierid;

	public Bestelbonlijn() {
	}

	public Bestelbonlijn(BigDecimal prijs, int aantal, long bestelbonid, long bierid) {
		this.prijs = prijs;
		this.aantal = aantal;
		this.bestelbonid = bestelbonid;
		this.bierid = bierid;
		this.bestelbonlijnIdid.setBestelbonid(bestelbonid);
		this.bestelbonlijnIdid.setBierid(bierid);
	}

	public BestelbonlijnId getBestelbonlijnIdid() {
		return bestelbonlijnIdid;
	}

	public void setBestelbonlijnIdid(BestelbonlijnId bestelbonlijnIdid) {
		this.bestelbonlijnIdid = bestelbonlijnIdid;
	}

	public BigDecimal getPrijs() {
		return prijs;
	}

	public void setPrijs(BigDecimal prijs) {
		this.prijs = prijs;
	}

	public int getAantal() {
		return aantal;
	}

	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

	public long getBestelbonid() {
		return bestelbonid;
	}

	public void setBestelbonid(long bestelbonid) {
		this.bestelbonid = bestelbonid;
	}

	public long getBierid() {
		return bierid;
	}

	public void setBierid(long bierid) {
		this.bierid = bierid;
	}

}
