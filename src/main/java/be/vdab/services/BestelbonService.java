package be.vdab.services;

import be.vdab.entities.Bestelbon;

public interface BestelbonService {
	void create(Bestelbon Bestelbon);

	Bestelbon read(long id);
}
