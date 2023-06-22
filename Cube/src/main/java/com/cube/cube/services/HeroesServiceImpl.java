package com.cube.cube.services;

import com.cube.cube.domain.Heroes;
import com.cube.cube.repositories.HeroesRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroesServiceImpl implements HeroesService{

    private final HeroesRepositories heroesRepositories;

    public HeroesServiceImpl(HeroesRepositories heroesRepositories) {
        this.heroesRepositories = heroesRepositories;
    }

    @Override
    public List<Heroes> findAll() {
        return (List<Heroes>) heroesRepositories.findAll();
    }

    @Override
    public Heroes findById(Long id) {
        return heroesRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(Heroes heroes) {
        heroesRepositories.save(heroes);
    }

    @Override
    public void deleteById(Long id) {
        heroesRepositories.deleteById(id);
    }
}
