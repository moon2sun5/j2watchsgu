package com.sgu.j2watch.services;



import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Voucher;




@Service
public interface VoucherService {

	List<Voucher> getAllVouchers();

	Voucher getVoucherById(Integer id);

	void saveVoucher(Voucher voucher);

	void deleteVoucher(Integer id);

	List<Voucher> getVouchersByStartDateBeforeAndEndDateAfter(Timestamp startDate, Timestamp endDate);

	Iterable<Voucher> findAll();

	Optional<Voucher> findById(int id_voucher);

	void updateVoucher(Voucher voucher);
	

}
