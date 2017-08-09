package be.vdab.services;

import org.springframework.stereotype.Service;

import be.vdab.entities.Bestelbon;
import be.vdab.repositories.BestelbonRepository;

@Service
@ReadOnlyTransactionalService
public class DefaultBestelbonService implements BestelbonService {

	private final BestelbonRepository bestelbonRepository;

	DefaultBestelbonService(BestelbonRepository bestelbonRepository) {
		this.bestelbonRepository = bestelbonRepository;
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Bestelbon bestelbon) {
		bestelbonRepository.save(bestelbon);
	}

	@Override
	public Bestelbon read(long id) {
		return bestelbonRepository.findOne(id);
	}

}
