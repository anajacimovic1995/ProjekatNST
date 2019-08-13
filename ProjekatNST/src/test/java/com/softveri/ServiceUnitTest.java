package com.softveri;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;


import com.softveri.entity.Templejt;
import com.softveri.entity.TemplejtAtributa;
import com.softveri.service.TemplejtAtributaServiceImpl;
import com.softveri.service.TemplejtServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class ServiceUnitTest {
	
	@Mock
	TemplejtServiceImpl service;	
	
	@Mock
	TemplejtAtributaServiceImpl serviceAtributa;

	
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

    
}
