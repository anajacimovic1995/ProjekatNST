package com.softveri.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="kompanija")
public class Company {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "KompanijaID")
    private int KompanijaID;
//    @Column(name = "NazivKompanije")
    private String NazivKompanije;
//    @Column(name = "AdresaKompanije")
    private String AdresaKompanije;
//    @Column(name = "PIB")
    private String PIB;
   
    @OneToMany(mappedBy = "kompanija")
    private List<User> korisnici;
    
    @OneToMany(mappedBy = "kompanija")
    private List<Dokument> dokumenti;
    
    

    public Company() {
    }

    public Company(int kompanijaID, String imeKompanije, String adresa, String pib) {
        this.KompanijaID = kompanijaID;
        this.NazivKompanije = imeKompanije;
        this.AdresaKompanije = adresa;
        this.PIB = pib;
    }

    public Company(int kompanijaID, String imeKompanije, String adresa, String pib, List<User> korisnici, List<Dokument> dokumenti) {
        this.KompanijaID = kompanijaID;
        this.NazivKompanije = imeKompanije;
        this.AdresaKompanije = adresa;
        this.PIB = pib;
        this.korisnici.forEach(x -> x.setKompanija(this));
        this.dokumenti.forEach(x -> x.setKompanija(this));
    }

    public int getIdKompanije() {
        return KompanijaID;
    }

    public void setIdKompanije(int idKompanije) {
        this.KompanijaID = idKompanije;
    }

    public String getImeKompanije() {
        return NazivKompanije;
    }

    public void setImeKompanije(String imeKompanije) {
        this.NazivKompanije = imeKompanije;
    }

    public String getAdresa() {
        return AdresaKompanije;
    }

    public void setAdresa(String adresa) {
        this.AdresaKompanije = adresa;
    }

    public String getPib() {
        return PIB;
    }

    public void setPib(String pib) {
        this.PIB = pib;
    }

    public List<User> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(List<User> korisnici) {
		this.korisnici = korisnici;
	}
	
	public List<Dokument> getDokumenti() {
		return dokumenti;
	}

	public void setDokumenti(List<Dokument> dokumenti) {
		this.dokumenti = dokumenti;
	}

	@Override
    public String toString() {
        return "Company{" + "imeKompanije=" + NazivKompanije + '}';
    }
}
