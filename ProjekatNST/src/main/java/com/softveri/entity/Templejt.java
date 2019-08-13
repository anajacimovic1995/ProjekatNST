package com.softveri.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="templejt")
public class Templejt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int TemplejtID;
    private String NazivTemplejta;	
  
    @OneToMany(mappedBy = "templejt")
    private List<Dokument> dokumenti;
    
    @OneToMany(mappedBy = "templejt")
    private List<TemplejtAtributa> atributi;
    
    
    public List<TemplejtAtributa> getAtributi() {
		return atributi;
	}

	public void setAtributi(List<TemplejtAtributa> atributi) {
		this.atributi = atributi;
	}

	public Templejt() {
		
	}

	public Templejt(int templejtID, String nazivTemplejta) {
		
		this.TemplejtID = templejtID;
		this.NazivTemplejta = nazivTemplejta;
	}
	
	public Templejt(int templejtID, String nazivTemplejta, List<Dokument> dokumeti) {
		
		this.TemplejtID = templejtID;
		this.NazivTemplejta = nazivTemplejta;
		this.dokumenti = dokumeti;
	}
	

	public int getTemplejtID() {
		return TemplejtID;
	}

	public void setTemplejtID(int templejtID) {
		TemplejtID = templejtID;
	}

	public String getNazivTemplejta() {
		return NazivTemplejta;
	}

	public void setNazivTemplejta(String nazivTemplejta) {
		NazivTemplejta = nazivTemplejta;
	}

	public List<Dokument> getDokumenti() {
		return dokumenti;
	}

	public void setDokumenti(List<Dokument> dokumenti) {
		this.dokumenti = dokumenti;
	}

	@Override
	public String toString() {
		return "Templejt [NazivTemplejta=" + NazivTemplejta + "]";
	}
	
	
    
    
}
