package com.sgu.j2watch.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.ProDetail;
import com.sgu.j2watch.repositories.ProDetailRepository;
import com.sgu.j2watch.services.ProDetailSrevice;
import com.sgu.j2watch.services.ProductDetailService;

@Service
public class ProDetailServicelmpl implements ProDetailSrevice{

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

