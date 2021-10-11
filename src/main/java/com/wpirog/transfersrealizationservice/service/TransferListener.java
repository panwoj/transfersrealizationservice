package com.wpirog.transfersrealizationservice.service;

import com.wpirog.commons.TransferMessage;
import com.wpirog.transfersrealizationservice.mapper.PaymentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class TransferListener {
    @Autowired
    private PaymentMapper paymentMapper;

    @Autowired
    private DbService dbService;

    @Autowired
    private AccountsProducer accountsProducer;

    @KafkaListener(topics = "transfers")
    public void consume(@Payload TransferMessage transferMessage) throws IOException {
        log.info("Consumed transferMessage: {}", transferMessage);
        var payment = dbService.savePayment(paymentMapper.mapToPayment(transferMessage));
        accountsProducer.sendTransfer(payment);
    }

}