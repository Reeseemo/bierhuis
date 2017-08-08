package be.vdab.services;

import java.util.List;

import be.vdab.entities.Bestelbonlijn;

public interface BestelbonlijnService {

	void create(Bestelbonlijn bestelbonlijn);

	List<Bestelbonlijn> findAll();

	void add(Bestelbonlijn bestelbonlijn); 

}
