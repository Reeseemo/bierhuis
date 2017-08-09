package be.vdab.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Bestelbon;
import be.vdab.services.BestelbonService;
import be.vdab.services.BestelbonlijnService;

@Controller
@RequestMapping("/bestelbon")
public class BestelbonMandjeController {

	private static final String VIEW = "bestelbon";
	private final BestelbonService bestelbonService;
	private final BestelbonlijnService bestelbonlijnService;

	BestelbonMandjeController(BestelbonService bestelbonService, BestelbonlijnService bestelbonlijnService) {
		this.bestelbonService = bestelbonService;
		this.bestelbonlijnService = bestelbonlijnService;
	}

	@PostMapping
	ModelAndView add(@Valid Bestelbon bestelbon, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(VIEW);
		}
		bestelbonService.create(bestelbon);
//		bestelbonlijnService.create(bestelbon.getId());
		ModelAndView model = new ModelAndView(VIEW, "bestelbon", bestelbonService.read(bestelbon.getId()));
		return model;
	}

}
