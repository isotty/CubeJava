package com.cube.cube.services;

import com.cube.cube.repositories.ListAccidentRepositories;
import com.cube.cube.domain.ListAccidentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAccidentServiceImpl implements ListAccidentService{

    private final ListAccidentRepositories listAccidentRepositories;

    public ListAccidentServiceImpl(ListAccidentRepositories listAccidentRepositories) {
        this.listAccidentRepositories = listAccidentRepositories;
    }

    @Override
    public List<ListAccidentType> findAll() {
        return (List<ListAccidentType>) listAccidentRepositories.findAll();
    }

    @Override
    public ListAccidentType findById(Long id) {
        return listAccidentRepositories.findById(id).orElse(null);
    }

    @Override
    public void save(ListAccidentType listAccidentType) {
        listAccidentRepositories.save(listAccidentType);
    }

    @Override
    public void deleteById(Long id) {
        listAccidentRepositories.deleteById(id);
    }
}
