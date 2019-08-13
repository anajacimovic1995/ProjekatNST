package com.softveri.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vrednostatributa")
public class VrednostPoljaDokumenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int VrednostID;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "DokumentID")      
    private Dokument dokument;
    @Column(nullable=true, name = "vrednostInteger") 
    private int vrednostInteger;
    @Column(nullable=true, name = "vrednostDouble") 
    private double vrednostDouble;
    @Column(nullable=true, name = "vrednostBoolean") 
    private boolean vrednostBoolean = false;
    
    @ManyToOne
    @JoinColumn(name = "TemplejtAtributaID")
    private TemplejtAtributa templejtatributa;
    @Column(nullable=true, name = "vrednostString") 
    private String vrednostString;
    
	public VrednostPoljaDokumenta(int vrednostID, Dokument dokument, int vrednostInteger, double vrednostDouble,
			boolean vrednostBoolean, TemplejtAtributa templejtatributa, String vrednostString) {
		super();
		VrednostID = vrednostID;
		this.dokument = dokument;
		this.vrednostInteger = vrednostInteger;
		this.vrednostDouble = vrednostDouble;
		this.vrednostBoolean = vrednostBoolean;
		this.templejtatributa = templejtatributa;
		this.vrednostString = vrednostString;
	}

	public VrednostPoljaDokumenta() {
		super();
	}

	public int getVrednostID() {
		return VrednostID;
	}

	public void setVrednostID(int vrednostID) {
		VrednostID = vrednostID;
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	public int getVrednostInteger() {
		return vrednostInteger;
	}

	public void setVrednostInteger(int vrednostInteger) {
		this.vrednostInteger = vrednostInteger;
	}

	public double getVrednostDouble() {
		return vrednostDouble;
	}

	public void setVrednostDouble(double vrednostDouble) {
		this.vrednostDouble = vrednostDouble;
	}

	public boolean isVrednostBoolean() {
		return vrednostBoolean;
	}

	public void setVrednostBoolean(boolean vrednostBoolean) {
		this.vrednostBoolean = vrednostBoolean;
	}


	public TemplejtAtributa getTemplejtatributa() {
		return templejtatributa;
	}

	public void setTemplejtatributa(TemplejtAtributa templejtatributa) {
		this.templejtatributa = templejtatributa;
	}

	public String getVrednostString() {
		return vrednostString;
	}

	public void setVrednostString(String vrednostString) {
		this.vrednostString = vrednostString;
	}



	@Override
	public String toString() {
		return "VrednostPoljaDokumenta [dokument=" + dokument.getNazivDokumenta() + ", templejtatributa=" + templejtatributa.getNazivAtributa() + "]";
	}
    
    
    
    
    
}
