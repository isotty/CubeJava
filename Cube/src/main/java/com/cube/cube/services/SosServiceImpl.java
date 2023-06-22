package com.cube.cube.services;

import com.cube.cube.repositories.SosRepositories;
import com.cube.cube.domain.Sos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SosServiceImpl implements SosService{

    private final SosRepositories sosRepositories;

    public SosServiceImpl(SosRepositories sosRepositories) {
        this.sosRepositories = sosRepositories;
    }

    @Override
    public List<Sos> findAll() {
        return (List<Sos>) sosRepositories.findAll();
    }

    @Override
    public Sos findById(Long id) {
        return sosRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Sos sos) {
        sosRepositories.save(sos);
    }

    @Override
    public void deleteById(Long id) {
        sosRepositories.deleteById(id);
    }
}
