package be.vdab.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;

@Service
@ReadOnlyTransactionalService
public class DefaultBrouwerService implements BrouwerService {

	private final BrouwerRepository brouwerRepository;

	DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}

	@Override
	public Brouwer read(long id) {
		return brouwerRepository.findOne(id);
	}

	@Override
	public Page<Brouwer> findAll(Pageable pageable) {
		return brouwerRepository.findAll(pageable);
	}

}
