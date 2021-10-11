package com.wpirog.transfersrealizationservice.service;

import com.wpirog.transfersrealizationservice.domain.Payment;
import com.wpirog.transfersrealizationservice.repostiory.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DbService {
    @Autowired
    private PaymentRepository repository;

    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }
}
