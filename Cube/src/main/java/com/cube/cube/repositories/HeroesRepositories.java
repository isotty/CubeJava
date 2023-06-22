package com.cube.cube.repositories;

import com.cube.cube.domain.Heroes;
import org.springframework.data.repository.CrudRepository;

public interface HeroesRepositories extends CrudRepository<Heroes, Long> {
}
