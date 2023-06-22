package com.cube.cube.services;

import com.cube.cube.domain.ListAccidentType;


import java.util.List;

public interface ListAccidentService {
    List<ListAccidentType> findAll();
    ListAccidentType findById(Long id);
    void save(ListAccidentType listAccidentType);
    void deleteById(Long id);
}
