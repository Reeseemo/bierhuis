package be.vdab.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbon;
import be.vdab.entities.Bestelbonlijn;
import be.vdab.services.BestelbonService;
import be.vdab.services.BestelbonlijnService;

@Controller
@RequestMapping("/mandje")
public class BestelbonlijnController {
	private static final String VIEW = "mandje";
	private static final String VIEW_BESTELBON = "bestelbon";
	
	private final BestelbonlijnService bestelbonlijnService;
	private final BestelbonService bestelbonService;

	BestelbonlijnController(BestelbonlijnService bestelbonlijnService, BestelbonService bestelbonService) {
		this.bestelbonlijnService = bestelbonlijnService;
		this.bestelbonService = bestelbonService;
	}

	@GetMapping("/view")
	ModelAndView index() {
		return new ModelAndView(VIEW);
	}
	
	@InitBinder("bestelbon")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
	
	@ModelAttribute("bestelbon")
	public Bestelbon getBestelbonlijnObject() {
		return new Bestelbon();
	}

	@PostMapping("/view")
	ModelAndView add(@Valid Bestelbonlijn bestelbonlijn, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(VIEW);
		}		
		bestelbonlijnService.add(bestelbonlijn);
		ModelAndView model = new ModelAndView(VIEW, "mandje", bestelbonlijnService.getBestelbonlijnen());
		return model;
	}
	
	@PostMapping ("/bestelbon")
	ModelAndView add(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(VIEW);
		}
		bestelbonService.create(bestelbon);
		bestelbonlijnService.create(bestelbon.getId(), bestelbonlijnService.getBestelbonlijnen());
		ModelAndView model = new ModelAndView(VIEW_BESTELBON, "bestelbon", bestelbonService.read(bestelbon.getId()));
		return model;
	}

}
