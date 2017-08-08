package be.vdab.services;

import java.util.List;

import org.springframework.stereotype.Service;

import be.vdab.entities.Bestelbonlijn;
import be.vdab.repositories.BestelbonlijnRepository;

@Service
@ReadOnlyTransactionalService
public class DefaultBestelbonlijnService implements BestelbonlijnService {

	private final BestelbonlijnRepository bestelbonlijnRepository;

	DefaultBestelbonlijnService(BestelbonlijnRepository bestelbonlijnRepository) {
		this.bestelbonlijnRepository = bestelbonlijnRepository;
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Bestelbonlijn bestelbonlijn) {
		bestelbonlijnRepository.saveAndFlush(bestelbonlijn);
	}

	@Override
	public List<Bestelbonlijn> findAll() {
		return bestelbonlijnRepository.findAll();
	}

}
