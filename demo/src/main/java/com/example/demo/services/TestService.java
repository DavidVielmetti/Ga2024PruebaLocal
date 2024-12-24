package com.example.demo.services;

import com.example.demo.entities.Test;
import com.example.demo.repositories.TestRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TestService implements BaseService<Test> {

    private TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    @Transactional
    public List<Test> findAll() throws Exception {

        try {
            List<Test> entities = testRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Test findById(Long id) throws Exception{
        try{
            Optional<Test> entityOptional = testRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Test save(Test entity) throws Exception {
        try{
            entity = testRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Test update(Long id, Test entity) throws Exception {
        try {
            Optional<Test> entityOptional = testRepository.findById(id);
            Test test = entityOptional.get();
            test = testRepository.save(entity);
            return test;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try{
            if (testRepository.existsById(id)){
                testRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}