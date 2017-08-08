package be.vdab.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.entities.Bier;
import be.vdab.entities.Brouwer;

public interface BierService {

	public Page<Bier> findAll(Pageable pageable);

	List<Bier> findAll();

	Bier read(long id);

	long findAantalBieren();

	List<Bier> findByBrouwerId(Brouwer brouwer);

}
