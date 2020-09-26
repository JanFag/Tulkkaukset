package projekti.tulkkaukset.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import projekti.tulkkaukset.domain.Tulkkaus;
import projekti.tulkkaukset.domain.TulkkausRepository;
import projekti.tulkkaukset.domain.TulkkauskieliRepository;
import projekti.tulkkaukset.domain.TulkkaustyyppiRepository;



@Controller
public class TulkkausController {
	
	@Autowired
	private TulkkausRepository repository;
	
	@Autowired
	private TulkkauskieliRepository krepository;
	
	@Autowired
	private TulkkaustyyppiRepository trepository;
	
	@GetMapping(value= {"/","/tulkkaukset"})
	public String index(Model model) {
		model.addAttribute("tulkkaukset", repository.findAll());
		return "tulkkauslista";
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("tulkkaus", new Tulkkaus());
		model.addAttribute("tulkkaustyypit", trepository.findAll());
		model.addAttribute("tulkkauskielet", krepository.findAll());
		return "addtulkkaus";
	}
	
	@PostMapping("/save")
	public String saveTulkkaus(Tulkkaus tulkkaus) {
		repository.save(tulkkaus);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTulkkaus(@PathVariable("id") Long tulkkausId, Model model){
		repository.deleteById(tulkkausId);
		return "redirect:../";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long tulkkausId, Model model) {
		model.addAttribute("tulkkaus", repository.findById(tulkkausId));
		model.addAttribute("tulkkaustyypit", trepository.findAll());
		model.addAttribute("tulkkauskielet", krepository.findAll());
		return "edittulkkaus";
	}
	
}
