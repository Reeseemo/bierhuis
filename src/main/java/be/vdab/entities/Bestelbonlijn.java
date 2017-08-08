package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
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
	private BestelbonlijnId bestelbonlijnId;



	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Min(0)
	@Digits(integer = 10, fraction = 2)
	private BigDecimal prijs;
	private int aantal;

	public Bestelbonlijn() {
	}

	public Bestelbonlijn(BigDecimal prijs, int aantal, long bierid) {
		this.prijs = prijs;
		this.aantal = aantal;
		this.bestelbonlijnId.setBierid(bierid);
	}

	public Bestelbonlijn(BigDecimal prijs, int aantal, long bestelbonid, long bierid) {
		this.prijs = prijs;
		this.aantal = aantal;
		this.bestelbonlijnId.setBestelbonid(bestelbonid);
		this.bestelbonlijnId.setBierid(bierid);
	}

	public BestelbonlijnId getBestelbonlijnId() {
		return bestelbonlijnId;
	}

	public void setBestelbonlijnId(BestelbonlijnId bestelbonlijnId) {
		this.bestelbonlijnId = bestelbonlijnId;
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

}
