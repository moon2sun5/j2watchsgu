package com.sgu.j2watch.serviceImpl;

import java.util.List;

import com.sgu.j2watch.services.ProDetailService;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.ProDetail;
import com.sgu.j2watch.repositories.ProDetailRepository;

@Service
public class ProDetailServicelmpl implements ProDetailService {

    private ProDetailRepository proDetailRepository;

    public ProDetailServicelmpl(ProDetailRepository prodetailRepository) {
        this.proDetailRepository = prodetailRepository;
    }

    @Override
    public List<ProDetail> getAllProDetails() {
        return proDetailRepository.findAll();
    }

    @Override
    public ProDetail getProDetailById(int id_product) {
        return proDetailRepository.findById(id_product).orElse(null);
    }

    @Override
    public ProDetail saveProdetail(ProDetail prodetail) {
        return proDetailRepository.save(prodetail);
    }

    @Override
    public void deleteProDetail(int id_product) {
        proDetailRepository.deleteById(id_product);
    }
}

