package com.softveri.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "templejtatributa")
public class TemplejtAtributa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)       
    private int TemplejtAtributaID;
    private String NazivAtributa;    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "TemplejtID")    
    private Templejt templejt;
    private boolean Required;
    private String Tip;
    @OneToMany(mappedBy = "templejtatributa")
    private List<VrednostPoljaDokumenta> vrednosti;

	public List<VrednostPoljaDokumenta> getVrednosti() {
		return vrednosti;
	}

	public void setVrednosti(List<VrednostPoljaDokumenta> vrednosti) {
		this.vrednosti = vrednosti;
	}

	public TemplejtAtributa() {
		super();
	}

	public TemplejtAtributa(int templejtAtributaID, String nazivAtributa, Templejt templejt, boolean required,
			String tip) {
		super();
		TemplejtAtributaID = templejtAtributaID;
		NazivAtributa = nazivAtributa;
		this.templejt = templejt;
		Required = required;
		Tip = tip;
	}

	public int getTemplejtAtributaID() {
		return TemplejtAtributaID;
	}

	public void setTemplejtAtributaID(int templejtAtributaID) {
		TemplejtAtributaID = templejtAtributaID;
	}

	public String getNazivAtributa() {
		return NazivAtributa;
	}

	public void setNazivAtributa(String nazivAtributa) {
		NazivAtributa = nazivAtributa;
	}

	public Templejt getTemplejt() {
		return templejt;
	}

	public void setTemplejt(Templejt templejt) {
		this.templejt = templejt;
	}

	public boolean isRequired() {
		return Required;
	}

	public void setRequired(boolean required) {
		Required = required;
	}

	public String getTip() {
		return Tip;
	}

	public void setTip(String tip) {
		Tip = tip;
	}

	@Override
	public String toString() {
		return "TemplejtAtributa [NazivAtributa=" + NazivAtributa + "]";
	}    


}
