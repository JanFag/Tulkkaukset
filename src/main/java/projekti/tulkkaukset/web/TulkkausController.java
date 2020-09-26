package projekti.tulkkaukset.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
	
	@GetMapping(value= {"/","/tulkkauslista"})
	public String index(Model model) {
		model.addAttribute("tulkkaukset", repository.findAll());
		return "tulkkauslista";
	}
	
	// RESTful service to get all tulkkaukset
    @RequestMapping(value="/tulkkaukset", method = RequestMethod.GET)
    public @ResponseBody List<Tulkkaus> tulkkausListRest() {	
        return (List<Tulkkaus>) repository.findAll();
    }    

	// RESTful service to get tulkkaus by id
    @RequestMapping(value="/tulkkaus/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Tulkkaus> findTulkkausRest(@PathVariable("id") Long tulkkausId) {	
    	return repository.findById(tulkkausId);
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
