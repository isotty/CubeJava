package com.cube.cube.services;

import com.cube.cube.domain.Heroes;

import java.util.List;

public interface HeroesService {
    List<Heroes> findAll();
    Heroes findById(Long id);
    void save(Heroes heroes);
    void deleteById(Long id);
}
