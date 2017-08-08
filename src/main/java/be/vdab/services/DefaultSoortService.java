package be.vdab.services;

import org.springframework.stereotype.Service;

import be.vdab.entities.Soort;
import be.vdab.repositories.SoortRepository;

@Service
@ReadOnlyTransactionalService
public class DefaultSoortService implements SoortService {

	private final SoortRepository soortRepository;

	DefaultSoortService(SoortRepository soortRepository) {
		this.soortRepository = soortRepository;
	}

	@Override
	public Soort read(long id) {
		return soortRepository.findOne(id);
	}



}
