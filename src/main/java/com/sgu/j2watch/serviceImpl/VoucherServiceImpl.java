package com.sgu.j2watch.serviceImpl;

import java.security.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.j2watch.entities.Voucher;
import com.sgu.j2watch.repositories.VoucherRepository;
import com.sgu.j2watch.services.VoucherService;

@Service
public class VoucherServiceImpl implements VoucherService {

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public Voucher getVoucherById(Integer id) {
        return voucherRepository.findById(id).orElse(null);
    }

    @Override
    public List<Voucher> getAllVouchers() {
        return (List<Voucher>) voucherRepository.findAll();
    }

    @Override
    public void saveVoucher(Voucher voucher) {
        voucherRepository.save(voucher);
    }

    @Override
    public void updateVoucher(Voucher voucher) {
        voucherRepository.save(voucher);
    }

    @Override
    public void deleteVoucher(Integer id) {
        voucherRepository.deleteById(id);
    }

	@Override
	public List<Voucher> getVouchersByStartDateBeforeAndEndDateAfter(Timestamp startDate, Timestamp endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Voucher> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Voucher> findById(int id_voucher) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
}
