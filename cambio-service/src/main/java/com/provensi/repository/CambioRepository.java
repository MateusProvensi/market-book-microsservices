package com.provensi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.provensi.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long> {
	Cambio findByFromAndTo(String from, String to);
}
