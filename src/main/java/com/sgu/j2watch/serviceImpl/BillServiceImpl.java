package com.sgu.j2watch.serviceImpl;

import com.sgu.j2watch.entities.Bill;
import com.sgu.j2watch.repositories.BillRepository;
import com.sgu.j2watch.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class BillServiceImpl implements BillService {
    @Autowired
    private  BillRepository billRepository;

    @Override
    public Bill saveData(String deliver_address, Float totalPrice, int user_id, Integer voucher_id, int status_id, String dienthoai, String fullname, String email, String discription_bill) {
        Bill lastEntity = billRepository.findTopByOrderByIdDesc();

        int NextId = (lastEntity != null ) ? lastEntity.getId() + (int) 1 : 1;

        Bill entity = new Bill();
        entity.setId(NextId);
        entity.setDeliver_address(deliver_address);
        entity.setCreateDate(new Date());
        entity.setTotalPrice(totalPrice);
        entity.setUser_id(user_id);
        entity.setVoucher_id(voucher_id);
        entity.setStatus_id(status_id);
        entity.setDienthoai(dienthoai);
        entity.setFullname(fullname);
        entity.setEmail(email);
        entity.setDiscription_bill(discription_bill);
        return billRepository.save(entity);
    }

    @Override
    public List<Bill> getBillsByMonth(int year, int month) {
        Date startDate = new Date(year - 1900, month - 1, 1);
        Date endDate = new Date(year - 1900, month, 1);

        return billRepository.findByCreateDateBetween(startDate, endDate);
    }

    @Override
    public List<Double> getMonthlyRevenueData() {
        List<Double> monthlyRevenueData = new ArrayList<>();

        // Lấy dữ liệu doanh thu theo tháng từ CSDL
        // Sử dụng BillRepository để truy vấn CSDL
        // ...

        // Giả sử dữ liệu trả về là List<Bill>
        List<Bill> bills = billRepository.findAll();

        // Logic tính toán doanh thu theo tháng
        // Giả sử có một hàm tính tổng giá trị hóa đơn
        for (int i = 1; i <= 12; i++) {
            double totalRevenue = calculateTotalRevenueForMonth(bills, i);
            monthlyRevenueData.add(totalRevenue);
        }

        return monthlyRevenueData;
    }

    @Override
    public List<Double> getWeeklyRevenueData() {
        List<Double> weeklyRevenueData = new ArrayList<>();

        // Lấy dữ liệu doanh thu theo thứ từ CSDL
        // Sử dụng BillRepository để truy vấn CSDL
        // ...

        // Giả sử dữ liệu trả về là List<Bill>
        List<Bill> bills = billRepository.findAll();

        // Logic tính toán doanh thu theo thứ
        // Giả sử có một hàm tính tổng giá trị hóa đơn
        for (int i = 1; i <= 7; i++) {
            double totalRevenue = calculateTotalRevenueForDayOfWeek(bills, i);
            weeklyRevenueData.add(totalRevenue);
        }

        return weeklyRevenueData;
    }

    private double calculateTotalRevenueForMonth(List<Bill> bills, int month) {

        double total = 0;

        for (Bill bill : bills) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(bill.getCreateDate());
            if (cal.get(Calendar.MONTH) + 1 == month) {
                total += bill.getTotalPrice();
            }
        }

        return total;
    }

    private double calculateTotalRevenueForDayOfWeek(List<Bill> bills, int dayOfWeek) {

        double total = 0;

        for (Bill bill : bills) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(bill.getCreateDate());
            if(cal.get(Calendar.DAY_OF_WEEK) == dayOfWeek) {
                total += bill.getTotalPrice();
            }
        }

        return total;
    }
}
