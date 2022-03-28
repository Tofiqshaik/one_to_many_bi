package one_to_many_bi.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String item_name;
	private String Ordered_person_name;
	@OneToMany(mappedBy = "item",cascade = CascadeType.PERSIST)
	private List<MedOrder> medOrder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getOrdered_person_name() {
		return Ordered_person_name;
	}

	public void setOrdered_person_name(String ordered_person_name) {
		Ordered_person_name = ordered_person_name;
	}

	public List<MedOrder> getMedOrder() {
		return medOrder;
	}

	public void setMedOrder(List<MedOrder> medOrder) {
		this.medOrder = medOrder;
	}

}
