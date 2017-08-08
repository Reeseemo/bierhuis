package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;
import be.vdab.repositories.BierRepository;

@Service
@ReadOnlyTransactionalService
class DefaultBierService implements BierService {
	private final BierRepository bierRepository;

	DefaultBierService(BierRepository bierRepository) {
		this.bierRepository = bierRepository;
	}

	@Override
	public Bier read(long id) {
		return bierRepository.findOne(id);
	}

	@Override
	public Page<Bier> findAll(Pageable pageable) {
		return bierRepository.findAll(pageable);
	}

	@Override
	public long findAantalBieren() {
		return bierRepository.count();
	}

	@Override
	public List<Bier> findByBrouwerId(Brouwer brouwer) {
		return bierRepository.findByBrouwerId(brouwer.getId());
	}

	@Override
	public List<Bier> findAll() {
		return bierRepository.findAll(new Sort("naam"));
	}
}