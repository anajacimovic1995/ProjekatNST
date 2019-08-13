package com.softveri.entity;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softveri.entity.Company;

@Entity
@Table(name="korisnik")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private Long id;  
    private String ime; 
    private String prezime;
    private String username;
    private String password;
    private String email;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "kompanijaId")
    private Company kompanija; 


    public User() {
    }

    public User(String ime, String prezime, String username, String password, String email, Company kompanija) {
       
    	this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.email = email;
        this.kompanija = kompanija;
    }
    
    public User(Long id, String ime, String prezime, String username, String password, String email, Company kompanija) {
        
    	this.id = id;
    	this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.email = email;
        this.kompanija = kompanija;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getKompanija() {
        return kompanija;
    }

    public void setKompanija(Company kompanija) {
        this.kompanija = kompanija;
    }


    @Override
    public String toString() {
        return ime + " " + prezime;
    }
}
