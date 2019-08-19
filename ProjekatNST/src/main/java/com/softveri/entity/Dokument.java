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
@Table(name="dokument")
public class Dokument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name="DokumentID")
    private int DokumentID;
//    @Column(name="NazivDokumenta")
    private String NazivDokumenta;
    
    @ManyToOne
    @JoinColumn(name = "TemplejtID")
    private Templejt templejt;
    
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "KompanijaID")
    private Company kompanija;

    @OneToMany(mappedBy = "dokument")
    private List<VrednostPoljaDokumenta> vredosti;
    
    
	public Dokument() {
	}
	
    public Dokument(int dokumentID, String nazivDokumenta, Templejt templejt, Company kompanija,List<VrednostPoljaDokumenta> vredosti) {
		super();
		DokumentID = dokumentID;
		NazivDokumenta = nazivDokumenta;
		this.templejt = templejt;
		this.kompanija = kompanija;
		this.vredosti = vredosti;
	}
	public Dokument(int DokumentID,String nazivDokumenta, Templejt templejt, Company kompanija, int dokumentID) {
		
		this.DokumentID = dokumentID;
		this.NazivDokumenta = nazivDokumenta;
		this.templejt = templejt;
		this.kompanija = kompanija;
	}
	
	public int getDokumentID() {
		return DokumentID;
	}

	public void setDokumentID(int dokumentID) {
		this.DokumentID = dokumentID;
	}

	public String getNazivDokumenta() {
		return NazivDokumenta;
	}

	public void setNazivDokumenta(String nazivDokumenta) {
		this.NazivDokumenta = nazivDokumenta;
	}

	public Templejt getTemplejt() {
		return templejt;
	}

	public void setTemplejt(Templejt templejt) {
		this.templejt = templejt;
	}

	public Company getKompanija() {
		return kompanija;
	}

	public void setKompanija(Company kompanija) {
		this.kompanija = kompanija;
	}

	public List<VrednostPoljaDokumenta> getVredosti() {
		return vredosti;
	}

	public void setVredosti(List<VrednostPoljaDokumenta> vredosti) {
		this.vredosti = vredosti;
	}

	@Override
	public String toString() {
		return "Dokument [NazivDokumenta=" + NazivDokumenta + "]";
	}
	
    
}
