package com.cube.cube.services;

import com.cube.cube.domain.Sos;

import java.util.List;

public interface SosService {
    List<Sos> findAll();
    Sos findById(Long id);
    void save(Sos sos);
    void deleteById(Long id);
}
