package be.vdab.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.entities.Bestelbonlijn;
import be.vdab.repositories.BestelbonlijnRepository;

@Service
@ReadOnlyTransactionalService
public class DefaultBestelbonlijnService implements BestelbonlijnService {

	private final BestelbonlijnRepository bestelbonlijnRepository;
	private List<Bestelbonlijn> bestelbonlijnen;

	DefaultBestelbonlijnService(BestelbonlijnRepository bestelbonlijnRepository) {
		this.bestelbonlijnRepository = bestelbonlijnRepository;
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Bestelbonlijn bestelbonlijn) {
		bestelbonlijnRepository.save(bestelbonlijn);
	}

	@Override
	public List<Bestelbonlijn> findAll() {
		return bestelbonlijnRepository.findAll();
	}

	@Override
	public void add(Bestelbonlijn bestelbonlijn) {
		if (bestelbonlijnen == null) {
			bestelbonlijnen = new ArrayList<>();
		}
		bestelbonlijnen.add(bestelbonlijn);
	}

	@Override
	public List<Bestelbonlijn> getBestelbonlijnen() {
		return bestelbonlijnen;
	}
	

}
