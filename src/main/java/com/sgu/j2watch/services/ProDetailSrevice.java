package com.sgu.j2watch.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.ProDetail;


@Service
public interface ProDetailSrevice  {

	public List<ProDetail> getAllProDetails();

	public ProDetail getProDetailById(int id_product);

	public ProDetail saveProdetail(ProDetail prodetail);

	public void deleteProDetail(int id_product);

}
