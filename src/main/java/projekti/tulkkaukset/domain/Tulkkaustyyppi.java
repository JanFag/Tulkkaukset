package projekti.tulkkaukset.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Tulkkaustyyppi {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tulkkaustyyppi_id;
	private String tulkkaustyyppi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tulkkaustyyppi")
	private List<Tulkkaus> tulkkaukset;

	public Tulkkaustyyppi(String tulkkaustyyppi) {
		super();
		this.tulkkaustyyppi = tulkkaustyyppi;
		
	}

	public Tulkkaustyyppi() {
		
	}

	public Long getTulkkaustyyppi_id() {
		return tulkkaustyyppi_id;
	}

	public void setTulkkaustyyppi_id(Long tulkkaustyyppi_id) {
		this.tulkkaustyyppi_id = tulkkaustyyppi_id;
	}

	public String getTulkkaustyyppi() {
		return tulkkaustyyppi;
	}

	public void setTulkkaustyyppi(String tulkkaustyyppi) {
		this.tulkkaustyyppi = tulkkaustyyppi;
	}

	public List<Tulkkaus> getTulkkaukset() {
		return tulkkaukset;
	}

	public void setTulkkaukset(List<Tulkkaus> tulkkaukset) {
		this.tulkkaukset = tulkkaukset;
	}

	@Override
	public String toString() {
		return "Tulkkaustyyppi [tulkkaustyyppi_id=" + tulkkaustyyppi_id + ", tulkkaustyyppi=" + tulkkaustyyppi + "]";
	}
	
	
	
	
}
