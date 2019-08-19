package com.softveri;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

import com.softveri.entity.Company;
import com.softveri.entity.Dokument;
import com.softveri.entity.Templejt;
import com.softveri.entity.TemplejtAtributa;
import com.softveri.service.CompanyServiceImpl;
import com.softveri.service.DokumentService;
import com.softveri.service.DokumentServiceImpl;
import com.softveri.service.TemplejtAtributaServiceImpl;
import com.softveri.service.TemplejtServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ServiceUnitTest {
	
	@Mock
	TemplejtServiceImpl service;	
	
	@Mock
	TemplejtAtributaServiceImpl serviceAtributa;
	
	@Mock
	DokumentServiceImpl serviceDkument;
	
	@Mock
	CompanyServiceImpl serviceCompany;

	
    @Test
    public void getTemplejtByIdTest()
    {
    	
        Mockito.when(service.getTemplejtById(1)).thenReturn(new Templejt(1, "Faktura"));         
        Templejt t = service.getTemplejtById(1);         
        assertEquals("Faktura", t.getNazivTemplejta());
        
        System.out.println("Uspesno vracen ID templejta!");
       
    }
    
    @Test
    public void sacuvajTemlejtTest()
    {
    	Templejt t = new Templejt(1, "Faktura");          
        service.saveTemplejt(t);         
        Mockito.verify(service, Mockito.times(1)).saveTemplejt(t);

        System.out.println("Uspesno sacuvan templejt!");
    }
    
    @Test
    public void vratiSveTemplejteTest()
    {
    	List<Templejt> templejti = new ArrayList<Templejt>();
    	Templejt t = new Templejt(1, "Faktura"); 
    	Templejt t2 = new Templejt(2, "Menica"); 
    	Templejt t3 = new Templejt(3, "Uplatnica"); 
         
        templejti.add(t);
        templejti.add(t2);
        templejti.add(t3);
         
        Mockito.when(service.getAllTemplejts()).thenReturn(templejti);
         
        //test
        
        List<Templejt> tempList = service.getAllTemplejts();         
        assertEquals(3, tempList.size());
        Mockito.verify(service, Mockito.times(1)).getAllTemplejts();

        System.out.println("Uspesno vracena lista!");
    }
    
    @Test
    public void getTemplejtAtributaByIdTest()
    {
    	
        Mockito.when(serviceAtributa.getTemplejtAtributaById(1)).thenReturn(new TemplejtAtributa(1, "Naziv atributa", null, true, "String"));         
        TemplejtAtributa t = serviceAtributa.getTemplejtAtributaById(1);         
        assertEquals("Naziv atributa", t.getNazivAtributa());
        assertEquals(true, t.isRequired());
        assertEquals("String", t.getTip());
        
        System.out.println("Uspesno vracen ID templejta atributa!");
       
    }
    @Test
    public void sacuvajTemlejtAtributaTest()
    {
    	TemplejtAtributa t = new TemplejtAtributa(1, "Naziv atributa", null, true, "String");          
        serviceAtributa.saveTemplejtAtributa(t);         
        Mockito.verify(serviceAtributa, Mockito.times(1)).saveTemplejtAtributa(t);

        System.out.println("Uspesno sacuvan templejt atributa!");
    }
    
    @Test
    public void vratiSveTemplejteAtributaTest()
    {
    	List<TemplejtAtributa> templejti = new ArrayList<TemplejtAtributa>();
    	TemplejtAtributa t = new TemplejtAtributa(1, "Naziv atributa", null, true, "String"); 
    	TemplejtAtributa t2 = new TemplejtAtributa(2, "Adresa", null, false, "String"); 
    	TemplejtAtributa t3 = new TemplejtAtributa(3, "Suma", null, true, "Double"); 
         
        templejti.add(t);
        templejti.add(t2);
        templejti.add(t3);
         
        Mockito.when(serviceAtributa.getAllTemplejtAtributa()).thenReturn(templejti);
         
        //test
        
        List<TemplejtAtributa> tempList = serviceAtributa.getAllTemplejtAtributa();         
        assertEquals(3, tempList.size());
        Mockito.verify(serviceAtributa, Mockito.times(1)).getAllTemplejtAtributa();

        System.out.println("Uspesno vracena lista atributa!");
    }   
    
    @Test
    public void getCompanyByIdTest()
    {
    	;
        Mockito.when(serviceCompany.getCompanyById(0)).thenReturn(new Company(0, "Avisto", "Zorana Djindjica", "12345"));         
        Company c = serviceCompany.getCompanyById(0);
        
        assertEquals("Avisto", c.getImeKompanije());
        
        System.out.println("Uspesno vracen naziv kompanije!");
       
    }
    
    @Test
    public void sacuvajCompanyTest()
    {
    	Company c = new Company();    
    	serviceCompany.saveCompany(c);   
        Mockito.verify(serviceCompany, Mockito.times(1)).saveCompany(c);
        System.out.println("Uspesno sacuvana kompanija!");
    }
    
    @Test
    public void getDokumentByIdTest()
    {
    	List<Templejt> templejti = service.getAllTemplejts();
    	List<Company> kompanije = serviceCompany.getAllCompanies();
        Mockito.when(serviceDkument.getDokumentById(47)).thenReturn(new Dokument());         
        Dokument d = serviceDkument.getDokumentById(47); 
        
        assertEquals(null, d.getNazivDokumenta());
        
        System.out.println("Uspesno vracen ID dokumenta!");
       
    }
    
    @Test
    public void sacuvajDokumentTest()
    {
    	List<Templejt> templejti = service.getAllTemplejts();
    	List<Company> kompanije = serviceCompany.getAllCompanies();
    	Dokument d = new Dokument(); 
    	serviceDkument.saveDokument(d);         
        Mockito.verify(serviceDkument, Mockito.times(1)).saveDokument(d);
        System.out.println("Uspesno sacuvan dokument!");
    }
    
    @Test
    public void vratiSveDokumenteTest()
    {
    	List<Templejt> templejti = service.getAllTemplejts();
    	List<Company> kompanije = serviceCompany.getAllCompanies();
    	List<Dokument> dokumenti = new ArrayList<Dokument>();
    	Dokument d = new Dokument(); 
    	Dokument d2 = new Dokument(); 
    	Dokument d3 = new Dokument(); 
        dokumenti.add(d);
        dokumenti.add(d2);
        dokumenti.add(d3);
         
        Mockito.when(serviceDkument.getAllDocuments()).thenReturn(dokumenti);
         
        //test
        
        List<Dokument> dokList = serviceDkument.getAllDocuments();       
        assertEquals(3, dokList.size());
        Mockito.verify(serviceDkument, Mockito.times(1)).getAllDocuments();

        System.out.println("Uspesno vracena lista dokumenata!");
    }
    
}
