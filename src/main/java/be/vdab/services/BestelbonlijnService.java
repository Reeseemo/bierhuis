package be.vdab.services;

import java.util.List;
import java.util.Map;

import be.vdab.entities.Bestelbonlijn;

public interface BestelbonlijnService {


	List<Bestelbonlijn> findAll();

	void add(Bestelbonlijn bestelbonlijn);

	Map<Long, Bestelbonlijn> getBestelbonlijnen();

	void create(long id, Map<Long, Bestelbonlijn> bestelbonlijnen); 

}
