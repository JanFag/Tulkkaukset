package projekti.tulkkaukset.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Tulkkauskieli {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tulkkauskieli_id;
	private String tulkkauskieli;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tulkkauskieli")
	private List<Tulkkaus> tulkkaukset;

	public Tulkkauskieli() {
		
	}

	public Tulkkauskieli(String tulkkauskieli) {
		super();
		this.tulkkauskieli = tulkkauskieli;
	}

	public Long getTulkkauskieli_id() {
		return tulkkauskieli_id;
	}

	public void setTulkkauskieli_id(Long tulkkauskieli_id) {
		this.tulkkauskieli_id = tulkkauskieli_id;
	}

	public String getTulkkauskieli() {
		return tulkkauskieli;
	}

	public void setTulkkauskieli(String tulkkauskieli) {
		this.tulkkauskieli = tulkkauskieli;
	}

	public List<Tulkkaus> getTulkkaukset() {
		return tulkkaukset;
	}

	public void setTulkkaukset(List<Tulkkaus> tulkkaukset) {
		this.tulkkaukset = tulkkaukset;
	}

	@Override
	public String toString() {
		return "Tulkkauskieli [tulkkauskieli_id=" + tulkkauskieli_id + ", tulkkauskieli=" + tulkkauskieli + "]";
	}
	
	
	
}
