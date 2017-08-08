package be.vdab.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbonlijn;
import be.vdab.services.BestelbonlijnService;
import be.vdab.services.BierService;

@Controller
@RequestMapping("/bieren")
public class BierController {
	private static final String BIER_VIEW = "/bier";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/mandje";
	private final BierService bierService;
	private final BestelbonlijnService bestelbonlijnService;

	public BierController(BierService bierService, BestelbonlijnService bestelbonlijnService) {
		this.bierService = bierService;
		this.bestelbonlijnService = bestelbonlijnService;
	}

	@GetMapping("{bierid}")
	ModelAndView findBeer(@PathVariable Long bierid) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (bierid != null) {
			model.put("bier", bierService.read(bierid));
			model.put("soort", bierService.read(bierid).getSoort());
			model.put("brouwer", bierService.read(bierid).getBrouwer());
		}
		return new ModelAndView(BIER_VIEW, "model", model);
	}

	@InitBinder("bestelbonlijn")
	void initBinderFiliaal(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}

	@ModelAttribute("bestelbonlijn")
	public Bestelbonlijn getBestelbonlijnObject() {
		return new Bestelbonlijn();
	}

}
