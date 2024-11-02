package ca.sheridancollege.makaju.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ca.sheridancollege.makaju.beans.Gadget;
import ca.sheridancollege.makaju.repositories.GadgetRepositories;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	GadgetRepositories gadgetrepo;
	
	@GetMapping("/")
	public String home() {
		return "Home.html";
	}
	@GetMapping("/Add")
	public String Add(Model model) {
		model.addAttribute("gadgets", new Gadget());
		return "Add.html";
	}
	@PostMapping("/process")
	public String addGadget(Gadget gadgets, Model model) {
		gadgetrepo.addArt(gadgets);
		return "redirect:/Add";
	}
	@GetMapping("/View")
	public String View(Model model) {
		model.addAttribute("gadgets",gadgetrepo.getGadget());
		return "View.html";
	}
	@GetMapping("/edit/{id}")
	  public String edit(@PathVariable("id") int ID, Model model) 
	  {
		  Gadget gadgets = gadgetrepo.getGadgetsById(ID);
		  model.addAttribute("gadgets", gadgets);
		  return "Edit.html";
	  }
	@PostMapping("/edit")
    public String process(@ModelAttribute Gadget gadgets) {
		System.out.println(gadgets);
        gadgetrepo.editGadget(gadgets); 
        return "redirect:/View"; 
    }
	@GetMapping("/delete/{id}")
	 public String deletePage(@PathVariable int id, @ModelAttribute Gadget gadgets) {
		 	gadgetrepo.deleteGadget(gadgets,id);
		 	return "redirect:/View";
	 }

	    @GetMapping("/stats")
	    public String getStats(Model model) {
	        
	        int totalCustomers = 150; 
	        double averageSpending = 120.50; 
	        String mostPopularGadget = "Grappling Hook"; 
	        double totalSalesRevenue = 18000.00; 
	        int customerFeedbackCount = 75; 

	       
	        model.addAttribute("totalCustomers", totalCustomers);
	        model.addAttribute("averageSpending", averageSpending);
	        model.addAttribute("mostPopularGadget", mostPopularGadget);
	        model.addAttribute("totalSalesRevenue", totalSalesRevenue);
	        model.addAttribute("customerFeedbackCount", customerFeedbackCount);

	        return "Stats.html"; 
	    }

}

