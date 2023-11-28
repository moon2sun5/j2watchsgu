package com.sgu.j2watch.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Pin;
import com.sgu.j2watch.repositories.PinRepository;

@Service
public class PinService {

    private final PinRepository pinRepository;

    @Autowired
    public PinService(PinRepository pinRepository) {
        this.pinRepository = pinRepository;
    }

    public List<Pin> getAllPins() {
        return pinRepository.findAll();
    }
}