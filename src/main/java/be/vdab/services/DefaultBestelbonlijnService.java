package be.vdab.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import be.vdab.entities.Bestelbonlijn;
import be.vdab.repositories.BestelbonlijnRepository;

@Service
@ReadOnlyTransactionalService
public class DefaultBestelbonlijnService implements BestelbonlijnService {

	private final BestelbonlijnRepository bestelbonlijnRepository;
	private Map<Long, Bestelbonlijn> bestelbonlijnen;

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
			bestelbonlijnen = new HashMap<>();
		}
		bestelbonlijnen.put(bestelbonlijn.getBestelbonlijnId().getBierid(), bestelbonlijn);
	}

	@Override
	public Map<Long, Bestelbonlijn> getBestelbonlijnen() {
		return bestelbonlijnen;
	}

}
