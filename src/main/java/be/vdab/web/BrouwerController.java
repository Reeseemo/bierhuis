package be.vdab.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BierService;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
	private static final String BROUWERS_VIEW = "/brouwers";
	private final BrouwerService brouwerService;
	private final BierService bierService;

	BrouwerController(BrouwerService brouwerService, BierService bierService) {
		this.brouwerService = brouwerService;
		this.bierService = bierService;
	}

	@GetMapping
	ModelAndView findAll(Pageable pageable) {
		return new ModelAndView(BROUWERS_VIEW, "page", brouwerService.findAll(pageable));
	}

	@GetMapping("{id}")
	ModelAndView read(@PathVariable Long id) {
		Map<String, Object> model = new HashMap<String, Object>();
		if (id != null) {
			model.put("brouwer", brouwerService.read(id)); 
			model.put("bieren", bierService.findByBrouwerId(brouwerService.read(id)));
		}
		return new ModelAndView(BROUWERS_VIEW, "model", model);
	}

}
