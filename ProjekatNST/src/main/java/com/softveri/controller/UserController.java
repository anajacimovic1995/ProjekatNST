package com.softveri.controller;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softveri.entity.Company;
import com.softveri.entity.Dokument;
import com.softveri.entity.Templejt;
import com.softveri.entity.TemplejtAtributa;
import com.softveri.entity.User;
import com.softveri.entity.VrednostPoljaDokumenta;
import com.softveri.service.CompanyService;
import com.softveri.service.CompanyServiceImpl;
import com.softveri.service.DokumentService;
import com.softveri.service.TemplejtAtributaService;
import com.softveri.service.TemplejtService;
import com.softveri.service.UserService;
import com.softveri.service.VrednostPoljaDokumentaService;


@Controller
public class UserController implements ResourceLoaderAware{
	// Constructor based Dependency Injection
	
	private UserService userService;
	private DokumentService dokumentService;

	private TemplejtService templejtService;
	private TemplejtAtributaService templejtAtributaService;
	private VrednostPoljaDokumentaService vrednostService;
	private CompanyService companyService;
   
	private ResourceLoader resourceLoader;
    
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
	public UserController() {

	}

	@Autowired
	public UserController(CompanyService companyService,UserService userService,DokumentService dokumentService,TemplejtService templejtService, TemplejtAtributaService templejtAtributaService,
			VrednostPoljaDokumentaService vrednostService) {
		
		this.userService = userService;
		this.dokumentService = dokumentService;
		this.templejtService = templejtService;
		this.templejtAtributaService = templejtAtributaService;
		this.vrednostService = vrednostService;
		this.companyService = companyService;
		
	}
	
	private Dokument dokumentGlobal = new Dokument();
	private User korisnik = new User();
	int idTemplejta = 0;
	Templejt noviT = new Templejt();
	int idAtributa = 100;
	Dokument dAzuriranje = new Dokument();
	int atribseAzurira =0;
	int idVrednostiAzuriranje = 100;
	
	TemplejtAtributa taAz = new TemplejtAtributa();
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public ModelAndView home(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/kreirajDokDugme", method = RequestMethod.GET)
	public ModelAndView kreirajDokDugme(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		List<Dokument> dokumentList = dokumentService.getAllDocuments();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		System.out.println(dokumentList.get(0).getNazivDokumenta());
		System.out.println(templejtList.get(0).getNazivTemplejta());
		mv.addObject("dokumentList", dokumentList);	
		mv.addObject("templejtList", templejtList);
		mv.setViewName("kreirajDokDugme");
		return mv;
	}
	@RequestMapping(value = "/uploadfile", method = RequestMethod.GET)
	public ModelAndView uploadfile(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		mv.addObject("templejtList", templejtList);	
		mv.setViewName("uploadfile");
		return mv;
	}

	
	@RequestMapping(value = "/uploadfile1", method = RequestMethod.POST)
	public ModelAndView uploadfile1(@RequestParam("dokument") String dok, @RequestParam("templejt") String tepmlejt,HttpServletResponse response) throws IOException {
		Templejt provera = new Templejt();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		for (Templejt templejtclan : templejtList) {
			if(templejtclan.getNazivTemplejta().equals(tepmlejt))
				provera = templejtclan;
		}
		List<TemplejtAtributa> atributit = new ArrayList<TemplejtAtributa>();
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(templejtAtributa.getTemplejt().getTemplejtID()==provera.getTemplejtID())
				atributit.add(templejtAtributa);
		}
		System.out.println(atributit.get(0).getNazivAtributa());
		Resource banner = resourceLoader.getResource("file:"+ dok);
		InputStream in = banner.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = "";
        String pline = "";
        
    	int brojac = 0;
        int brojac2 = 0;
        while (true) {          	

        		pline = reader.readLine();	        		
        		if (pline == null) {
        			System.out.println("brojac je " + brojac2);
        			break;
        		}
        		System.out.println(pline + "pline");
        		System.out.println(atributit.get(brojac).getNazivAtributa() + "atribut");
        		
        		if(pline.contains(atributit.get(brojac).getNazivAtributa())) {        			
        			brojac2 = brojac2+1;
        			
        		}       		
        		brojac=brojac+1;
        		line += pline;
        	
        	
        }

	    reader.close();
        System.out.println(line);        
        
        System.out.println("velicina je " + atributit.size());
        
        ModelAndView mv = new ModelAndView();
        if(brojac2==atributit.size()) {        	
        	mv.addObject("dokument", dok);
        	mv.addObject("templejt", tepmlejt);        	
        	mv.setViewName("uploadfile1");	
        	
        }else {
        	List<Templejt> templejtList2 = templejtService.getAllTemplejts();
    		mv.addObject("templejtList", templejtList2);	
        	mv.setViewName("uploadfile");
        	
        }

        return mv;
	}
	
	@RequestMapping(value = "/uploadfile2", method = RequestMethod.POST)
	public ModelAndView uploadfile2(@RequestParam("dokument") String dok, @RequestParam("templejt") String tepmlejt,@RequestParam("naziv") String naziv, 
			HttpServletResponse response) throws IOException {
		
		Templejt provera = new Templejt();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		for (Templejt templejtclan : templejtList) {
			if(templejtclan.getNazivTemplejta().equals(tepmlejt))
				provera = templejtclan;
		}
		
		List<TemplejtAtributa> atributit = new ArrayList<TemplejtAtributa>();
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(templejtAtributa.getTemplejt().getTemplejtID()==provera.getTemplejtID())
				atributit.add(templejtAtributa);
		}
		
		Dokument dokument = new Dokument();
		dokument.setNazivDokumenta(naziv);
		dokument.setTemplejt(provera);
		Company company = companyService.getCompanyById(1);
		dokument.setKompanija(company);
		dokumentService.saveDokument(dokument);
		
		Resource banner = resourceLoader.getResource("file:"+ dok);
		InputStream in = banner.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        
        String pline = "";        
    	int brojac = 0;
        int brojac2 = 0;
        
        while (true) {          	

        		pline = reader.readLine();	        		
        		if (pline == null) {
        			System.out.println("brojac je " + brojac2);
        			break;
        		}
        		System.out.println(pline + "pline");
        		System.out.println(atributit.get(brojac).getNazivAtributa() + "atribut");
        		
        		if(pline.contains(atributit.get(brojac).getNazivAtributa())) {        			
        			brojac2 = brojac2+1;
        			String[] vr = pline.split(": ");
        			VrednostPoljaDokumenta vp = new VrednostPoljaDokumenta();
        			vp.setDokument(dokument);
        			vp.setTemplejtatributa(atributit.get(brojac));
        			if(atributit.get(brojac).getTip().equalsIgnoreCase("String"))
        				vp.setVrednostString(vr[1]);
        			if(atributit.get(brojac).getTip().equalsIgnoreCase("Double"))
        				vp.setVrednostDouble(Double.parseDouble(vr[1]));
        			if(atributit.get(brojac).getTip().equalsIgnoreCase("Integer"))
        				vp.setVrednostInteger(Integer.parseInt(vr[1]));
        			if(atributit.get(brojac).getTip().equalsIgnoreCase("Boolean"))
        				vp.setVrednostBoolean(Boolean.parseBoolean(vr[1]));
        			vrednostService.saveVrednost(vp);  			
        		} 
        		
        		brojac=brojac+1;
        		      	
        	
        }

	    reader.close();
		ModelAndView mv = new ModelAndView();
		List<Dokument> dokumentList = dokumentService.getAllDocuments();
		List<Templejt> templejtList2 = templejtService.getAllTemplejts();
		mv.addObject("dokumentList", dokumentList);	
		mv.addObject("templejtList", templejtList2);
		mv.setViewName("documents");
		return mv;
	}
	@RequestMapping(value = "/kreirajTempDugme", method = RequestMethod.GET)
	public ModelAndView kreirajTempDugme(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		List<Dokument> dokumentList = dokumentService.getAllDocuments();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		System.out.println(dokumentList.get(0).getNazivDokumenta());
		System.out.println(templejtList.get(0).getNazivTemplejta());
		mv.addObject("dokumentList", dokumentList);	
		mv.addObject("templejtList", templejtList);
		mv.setViewName("kreirajTempDugme");
		return mv;
	}
	
	@RequestMapping(value = "/userForma", method = RequestMethod.POST)
	public ModelAndView main(@RequestParam("name") String name, @RequestParam("pass") String pass, HttpServletResponse response) throws IOException {
		System.out.println(name +"  "+ pass);
		List<User> userList = userService.getAllUsers();
		for (User user : userList) {
			if(user.getUsername().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(pass)) {
				ModelAndView mv = new ModelAndView();	
				korisnik = user;
				mv.setViewName("userForma");
				return mv;
			}
		}
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("home");
			return mv;		
		
	}
	@RequestMapping(value = "/documents1", method = RequestMethod.POST)
	public ModelAndView dokumenta(HttpServletResponse response) throws IOException {		
		
		ModelAndView mv = new ModelAndView();
		List<Dokument> dokumentList = dokumentService.getAllDocuments();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		System.out.println(dokumentList.get(0).getNazivDokumenta());
		System.out.println(dokumentList.size());
		mv.addObject("dokumentList", dokumentList);	
		mv.addObject("templejtList", templejtList);
		mv.setViewName("documents");
		return mv;
	}
	
	@RequestMapping(value = "/documents", method = RequestMethod.POST)
	public ModelAndView dokumenta(@RequestParam("name") String name, @RequestParam("pass") String pass,HttpServletResponse response) throws IOException {
		
		List<User> userList = userService.getAllUsers();
		for (User user : userList) {
			if(user.getUsername().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(pass)) {
				
				korisnik = user;
			}
		}
			
		ModelAndView mv = new ModelAndView();
		List<Dokument> dokumentList = dokumentService.getAllDocuments();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		System.out.println(dokumentList.get(0).getNazivDokumenta());
		System.out.println(dokumentList.size());
		mv.addObject("dokumentList", dokumentList);	
		mv.addObject("templejtList", templejtList);
		mv.setViewName("documents");
		return mv;
	}
	@RequestMapping(value = "/documents", method = RequestMethod.GET)
	public ModelAndView dokuments(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		List<Dokument> dokumentList = dokumentService.getAllDocuments();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		System.out.println(dokumentList.get(0).getNazivDokumenta());
		System.out.println(dokumentList.size());
		mv.addObject("dokumentList", dokumentList);	
		mv.addObject("templejtList", templejtList);
		mv.setViewName("documents");
		return mv;
	}

	@RequestMapping(value = "/izbrisiDokument/{id}", method = RequestMethod.GET)
	public ModelAndView izbrisiDokument(@PathVariable int id, HttpServletResponse response) throws IOException {
		List<VrednostPoljaDokumenta> vrednosti = vrednostService.getAllVrednosti();
		for (VrednostPoljaDokumenta vrednostPoljaDokumenta : vrednosti) {
			if(vrednostPoljaDokumenta.getDokument().getDokumentID()==id) {
				vrednostService.deleteVrednostById(vrednostPoljaDokumenta.getVrednostID());
			}
		}
		boolean isDeleted = dokumentService.deleteDokumentById(id);
		System.out.println("Dokument je obrisan: " + isDeleted);
		ModelAndView mv = new ModelAndView("redirect:/documents");
		return mv;
	}
	@RequestMapping(value = "/izbrisiAtribut/{id}", method = RequestMethod.GET)
	public ModelAndView izbrisiAtribut(@PathVariable int id, HttpServletResponse response) throws IOException {
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();
		System.out.println("ID ATRIBUTA KOJI SE BRISE JE " + id);
		for (TemplejtAtributa ta : atributi) {
			if(ta.getTemplejtAtributaID()==id) {
				templejtAtributaService.deleteTemplejtAtributaById(ta.getTemplejtAtributaID());
			}
		}
		boolean isDeleted = templejtAtributaService.deleteTemplejtAtributaById(id);
		System.out.println("Atribut je obrisan: " + isDeleted);
		ModelAndView mv = new ModelAndView("redirect:/dodajAtribut");
		return mv;
	}

	@RequestMapping(value = "/dodajTemplejt", method = RequestMethod.POST)
	public ModelAndView dodajTemplejt(@RequestParam("name") String name, @RequestParam("noviTemplejt") String templ,HttpServletResponse response) throws IOException {
		Templejt t = new Templejt();
		if(templ!= "") {
			t.setNazivTemplejta(templ);
		}else {
			t.setNazivTemplejta(name);}
		int provera = 0;
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		for (Templejt templejt : templejtList) {
			if(templejt.getNazivTemplejta().equalsIgnoreCase(name)) {
				provera = 1;
				idTemplejta = templejt.getTemplejtID();
				break;
				
			}
		}
		if(provera==0) {
			templejtService.saveTemplejt(t);
			
			noviT = templejtService.getAllTemplejts().get(templejtService.getAllTemplejts().size()-1);
			idTemplejta = noviT.getTemplejtID();
		}
		
		
		ModelAndView mv = new ModelAndView();
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();
		List<TemplejtAtributa> odredjeniAtributi = new ArrayList<TemplejtAtributa>();
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(templejtAtributa.getTemplejt().getTemplejtID()==idTemplejta)
				odredjeniAtributi.add(templejtAtributa);
		}

		mv.addObject("atributList", odredjeniAtributi);
		mv.setViewName("dodajTemplejt");
		return mv;
	}
	@RequestMapping(value = "/dodajDokument", method = RequestMethod.POST)
	public ModelAndView dodajDokument(@RequestParam("dokument") String name, @RequestParam("templejt") String tepmlejt, HttpServletResponse response) throws IOException {
        Dokument d = new Dokument();
        d.setNazivDokumenta(name);
        d.setKompanija(korisnik.getKompanija());
        System.out.println(korisnik.getKompanija().getImeKompanije());
		int provera = 0;
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		for (Templejt templejt : templejtList) {
			if(templejt.getNazivTemplejta().equalsIgnoreCase(tepmlejt)) {
				provera = 1;
				d.setTemplejt(templejt);
				dokumentGlobal = d;
				dokumentService.saveDokument(d);
				break;
				
			}
		}
		if(provera==0) {
		   System.out.println("Greska u nazivu templejta!");
			ModelAndView mv = new ModelAndView();
			mv.setViewName("redirect:/documents");
			return mv;
		}
		ModelAndView mv = new ModelAndView();
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(templejtAtributa.getTemplejt().getTemplejtID()==d.getTemplejt().getTemplejtID()) {
				idAtributa = templejtAtributa.getTemplejtAtributaID();
				System.out.println("evo atributa !!!!!" + templejtAtributa.getNazivAtributa());
				System.out.println("id !!!!" + templejtAtributa.getTemplejtAtributaID());
				mv.addObject("atribut", templejtAtributa);
				break;
			}
		}

		
		mv.addObject("dokument", d);
		mv.setViewName("dodajDokument");
		return mv;
	}
	@RequestMapping(value = "/dodajAtribut", method = RequestMethod.POST)
	public ModelAndView dodajAtribut(@RequestParam("name") String name, @RequestParam("tip") String tip,  @RequestParam("required") int required,HttpServletResponse response) throws IOException {
		TemplejtAtributa t = new TemplejtAtributa();
		t.setNazivAtributa(name);
		t.setTip(tip);
		t.setTemplejt(templejtService.getTemplejtById(idTemplejta));
		if(required==0) {
			t.setRequired(true);
		} else if(required==1) {
			t.setRequired(false);
		}
		templejtAtributaService.saveTemplejtAtributa(t);	
		System.out.println("sacuvan je prvi atribut templejta!!!!!");
		ModelAndView mv = new ModelAndView();
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();
		List<TemplejtAtributa> odredjeniAtributi = new ArrayList<TemplejtAtributa>();
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(templejtAtributa.getTemplejt().getTemplejtID()==idTemplejta)
				odredjeniAtributi.add(templejtAtributa);
		}

		mv.addObject("atributList", odredjeniAtributi);
		mv.setViewName("dodajAtribut");
		return mv;
	}
	@RequestMapping(value = "/dodajAtribut", method = RequestMethod.GET)
	public ModelAndView dodajAtribut(HttpServletResponse response) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();
		List<TemplejtAtributa> odredjeniAtributi = new ArrayList<TemplejtAtributa>();
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(templejtAtributa.getTemplejt().getTemplejtID()==idTemplejta)
				odredjeniAtributi.add(templejtAtributa);
		}

		mv.addObject("atributList", odredjeniAtributi);
		mv.setViewName("dodajAtribut");
		return mv;
	}
	@RequestMapping(value = "/sledeci", method = RequestMethod.POST)
	public ModelAndView sledeci(@RequestParam("vrednost") String vrednost, HttpServletResponse response) throws IOException {
		List<TemplejtAtributa> atributi = templejtAtributaService.getAllTemplejtAtributa();

		VrednostPoljaDokumenta vpd = new VrednostPoljaDokumenta();
		vpd.setDokument(dokumentGlobal);
		if(atribseAzurira==1) {
			vpd.setTemplejtatributa(taAz);

				if(taAz.getTip().equalsIgnoreCase("Integer")) {
					vpd.setVrednostInteger(Integer.parseInt(vrednost));
					
				}else if(taAz.getTip().equalsIgnoreCase("Double")) {
					vpd.setVrednostDouble(Double.parseDouble(vrednost));
					
				}else if(taAz.getTip().equalsIgnoreCase("Boolean")) {
					vpd.setVrednostBoolean(Boolean.parseBoolean(vrednost));
					
				} else {
					vpd.setVrednostString(vrednost);					
				}
		}else {
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(templejtAtributa.getTemplejtAtributaID()==idAtributa) {
				vpd.setTemplejtatributa(templejtAtributa);
				if(templejtAtributa.getTip().equalsIgnoreCase("Integer")) {
					vpd.setVrednostInteger(Integer.parseInt(vrednost));
					break;
				}else if(templejtAtributa.getTip().equalsIgnoreCase("Double")) {
					vpd.setVrednostDouble(Double.parseDouble(vrednost));
					break;
				}else if(templejtAtributa.getTip().equalsIgnoreCase("Boolean")) {
					vpd.setVrednostBoolean(Boolean.parseBoolean(vrednost));
					break;
				} else {
					vpd.setVrednostString(vrednost);					
				}
				
			}
		}
		}
		atribseAzurira=0;
		taAz = new TemplejtAtributa();
		vrednostService.saveVrednost(vpd);
		System.out.println("NAKON CUVANJA VREDNOSTI");
		ModelAndView mv = new ModelAndView();
		int pomocni2 = 0;		
		for (TemplejtAtributa templejtAtributa : atributi) {
			if(pomocni2 == 1 && templejtAtributa.getTemplejt().getTemplejtID() == dokumentGlobal.getTemplejt().getTemplejtID()) {
				mv.addObject("atribut", templejtAtributa);
				idAtributa=templejtAtributa.getTemplejtAtributaID();
				pomocni2=2;
				break;
				
			}
			if(templejtAtributa.getTemplejtAtributaID()==idAtributa) {
				pomocni2=1;
			}
			
		}
		if(pomocni2==1) {
			System.out.println("NEMA VISE!!!");
			mv.setViewName("redirect:/report");
			return mv;
		}
		List<VrednostPoljaDokumenta> vrednost1 = vrednostService.getAllVrednosti();
		List<VrednostPoljaDokumenta> odredjeneVrednosti = new ArrayList<VrednostPoljaDokumenta>();
		for (VrednostPoljaDokumenta vr : vrednost1) {
			if(vr.getDokument().getDokumentID()==dokumentGlobal.getDokumentID())
				odredjeneVrednosti.add(vr);
		}
		
		mv.addObject("odredjeneVrednosti", odredjeneVrednosti);
		mv.addObject("dokument", dokumentGlobal);
		mv.setViewName("sledeci");
		return mv;
	}
	

	
	@RequestMapping(value = "/dodajDokument", method = RequestMethod.GET)
	public ModelAndView dodajDokumenta(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		System.out.println(templejtList.get(0).getNazivTemplejta());
		mv.addObject("templejtList", templejtList);	
		mv.setViewName("dodajDokument");
		return mv;
	}

	@RequestMapping(value = "/prikaziTemplejt", method = RequestMethod.POST)
	public ModelAndView izaberiTemplejt(@RequestParam("templejt") String value, HttpServletResponse response) throws IOException {
		Templejt t = new Templejt();
		
		List<Templejt> templejtList = templejtService.getAllTemplejts();
		for (Templejt templejt : templejtList) {
			if(templejt.getNazivTemplejta().equalsIgnoreCase(value)) {
				t.setNazivTemplejta(templejt.getNazivTemplejta());
				t.setTemplejtID(templejt.getTemplejtID());
				t.setDokumenti(templejt.getDokumenti());
				
				break;
			}
		}

	
		List<Dokument> documentList = dokumentService.getAllDocuments();
		int id = documentList.size()+1;
		System.out.println("ID JE" + id);
		Dokument noviDokument = new Dokument();
		noviDokument.setDokumentID(id);
		noviDokument.setNazivDokumenta(value);
		noviDokument.setKompanija(korisnik.getKompanija());
		List<VrednostPoljaDokumenta> listaVrednosti = new ArrayList<VrednostPoljaDokumenta>();

		noviDokument.setTemplejt(t);
		noviDokument.setVredosti(listaVrednosti);
		dokumentGlobal = noviDokument;
		System.out.println(dokumentGlobal.getDokumentID()+"  !!!!!!");
		ModelAndView mv = new ModelAndView();
		mv.addObject("noviDokument", noviDokument);
		mv.setViewName("prikaziTemplejt");
		System.out.println("Dokument je prosledjen");
		return mv;
	}
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView report(HttpServletResponse response) throws IOException {
		
		List<VrednostPoljaDokumenta> vrednosti = vrednostService.getAllVrednosti();
		List<VrednostPoljaDokumenta> vrednosti2 = new ArrayList<VrednostPoljaDokumenta>();
		for (VrednostPoljaDokumenta vrednostPoljaDokumenta : vrednosti) {
			if(vrednostPoljaDokumenta.getDokument().getDokumentID()==dokumentGlobal.getDokumentID())
				vrednosti2.add(vrednostPoljaDokumenta);				
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("Dokument",dokumentGlobal);
		mv.addObject("lista", vrednosti2);
		mv.setViewName("report");
		return mv;
	}
	@RequestMapping(value = "/azurirajDokument/{id}", method = RequestMethod.GET)
	public ModelAndView azurirajDokument(@PathVariable int id) throws IOException {
		
		ModelAndView mv = new ModelAndView("/azurirajDokument");
		Dokument d = dokumentService.getDokumentById(id);
		dAzuriranje = d;
		List<VrednostPoljaDokumenta> vrednost1 = vrednostService.getAllVrednosti();
		System.out.println("vrednost prvog clana je " + vrednost1.get(0).getDokument().getNazivDokumenta());
		List<VrednostPoljaDokumenta> odredjeneVrednosti = new ArrayList<VrednostPoljaDokumenta>();
		for (VrednostPoljaDokumenta vr : vrednost1) {
			if(vr.getDokument().getDokumentID()==id)
				odredjeneVrednosti.add(vr);
			
		}
		System.out.println("vrednost prvog clana je " + odredjeneVrednosti.get(0).getDokument().getNazivDokumenta());
		mv.addObject("odredjeneVrednosti", odredjeneVrednosti);
		mv.addObject("headerMessage", "Edit document Details");
		mv.addObject("dokument", d);
		return mv;
	}
	@RequestMapping(value = "/azurirajVrednost/{id}", method = RequestMethod.GET)
	public ModelAndView azurirajVrednost(@PathVariable int id) throws IOException {
		
		ModelAndView mv = new ModelAndView();
		VrednostPoljaDokumenta vpd = vrednostService.getVrednostById(id);
		atribseAzurira = 1;
		taAz = vpd.getTemplejtatributa();
		mv.addObject("headerMessage", "Edit document Details");
		mv.addObject("vrednost", vpd);
		return mv;
	}
	@RequestMapping(value = "/azurirajVrednostDokumenta/{id}", method = RequestMethod.GET)
	public ModelAndView azurirajVrednostDokumenta(@PathVariable int id) throws IOException {
		
		ModelAndView mv = new ModelAndView("/azurirajVrednostDokumenta");
		VrednostPoljaDokumenta vpd = vrednostService.getVrednostById(id);
		idVrednostiAzuriranje = id;
		atribseAzurira = 1;
		System.out.println(idVrednostiAzuriranje+"id vrednosti koja se azurira kada se prosledi");
		taAz = vpd.getTemplejtatributa();
		mv.addObject("headerMessage", "Edit document Details");
	
		mv.addObject("vred", vpd);
		mv.addObject("vrednost", vpd);
		System.out.println(vpd.toString());
		
		return mv;
	}
	@RequestMapping(value = "/azurirajVrednostDokumenta/{id}", method = RequestMethod.POST)
	public ModelAndView saveVrednost(@ModelAttribute VrednostPoljaDokumenta v, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/azurirajDokument2");

		if (result.hasErrors()) {
			System.out.println(result.toString());
//			return new ModelAndView("error");
		}
		v.setDokument(dAzuriranje);
		v.setTemplejtatributa(taAz);

		boolean isSaved = vrednostService.saveVrednost(v);
		if (!isSaved) {

//			return new ModelAndView("error");
		}

		return mv;
	}
	@RequestMapping(value = "/azurirajDokument2", method = RequestMethod.GET)
	public ModelAndView azurirajDokument2(HttpServletResponse response) throws IOException {
		VrednostPoljaDokumenta vred1 = vrednostService.getVrednostById(idVrednostiAzuriranje);
		ModelAndView mv = new ModelAndView();
		Dokument d = dokumentService.getDokumentById(vred1.getDokument().getDokumentID());
	
		List<VrednostPoljaDokumenta> vrednost1 = vrednostService.getAllVrednosti();
		System.out.println("vrednost prvog clana je " + vrednost1.get(0).getDokument().getNazivDokumenta());
		List<VrednostPoljaDokumenta> odredjeneVrednosti = new ArrayList<VrednostPoljaDokumenta>();
		for (VrednostPoljaDokumenta vr : vrednost1) {
			if(vr.getDokument().getDokumentID()==d.getDokumentID())
				odredjeneVrednosti.add(vr);
			
		}
		System.out.println("vrednost prvog clana je " + odredjeneVrednosti.get(0).getDokument().getNazivDokumenta());
		mv.addObject("odredjeneVrednosti", odredjeneVrednosti);
		mv.addObject("headerMessage", "Edit document Details");
		mv.addObject("dokument", d);
		return mv;
	}
	@RequestMapping(value = "/azurirajDokument/{id}", method = RequestMethod.POST)
	public ModelAndView saveEditedUser(@ModelAttribute Dokument d, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/documents");

		if (result.hasErrors()) {
			System.out.println(result.toString());
//			return new ModelAndView("error");
		}
		d.setKompanija(dAzuriranje.getKompanija());
		d.setTemplejt(dAzuriranje.getTemplejt());
		boolean isSaved = dokumentService.saveDokument(d);
		if (!isSaved) {

//			return new ModelAndView("error");
		}

		return mv;
	}
	@RequestMapping(value="/odabir", method=RequestMethod.POST)
	public String odabir(@RequestParam String action){

	    if( action.equals("Kreiraj ponovo") ){
	       return "dodajDokument";
	    } else if( action.equals("Sacuvaj dokument") ){
	    	   dokumentGlobal.setVredosti(null);
	    	   dokumentService.saveDokument(dokumentGlobal);
		       return "sacuvaj";
		    }
	    
	       return "documents";	    

	} 
	

}
