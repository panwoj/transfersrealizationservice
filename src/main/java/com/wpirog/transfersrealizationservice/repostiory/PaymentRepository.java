package com.wpirog.transfersrealizationservice.repostiory;

import com.wpirog.transfersrealizationservice.domain.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

    @Override
    Payment save(Payment payment);
}
