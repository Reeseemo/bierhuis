package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String naam;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String straat;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String huisNr;
	@NotBlank
	@Length(min = 1, max = 50)
	@SafeHtml
	private String gemeente;
	@Min(1000)
	@Max(9999)
	private int postcode;
	private Integer omzet;

	public Brouwer(String naam, String straat, String huisNr, String gemeente, int postcode, Integer omzet) {
		this.naam = naam;
		this.straat = straat;
		this.huisNr = huisNr;
		this.gemeente = gemeente;
		this.postcode = postcode;
		this.omzet = omzet;
	}

	public Brouwer(long id, String naam, String straat, String huisNr, String gemeente, int postcode, Integer omzet) {
		this(naam, straat, huisNr, gemeente, postcode, omzet);
		this.id = id;
	}

	public Brouwer() {
	}

	@OneToMany(mappedBy = "brouwer")
	private Set<Bier> bieren;

	public Set<Bier> getBieren() {
		return Collections.unmodifiableSet(bieren);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}

	public String getGemeente() {
		return gemeente;
	}

	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}

}
