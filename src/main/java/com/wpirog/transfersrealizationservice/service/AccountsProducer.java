package com.wpirog.transfersrealizationservice.service;

import com.wpirog.commons.PaymentDto;
import com.wpirog.commons.PaymentMessage;
import com.wpirog.transfersrealizationservice.domain.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountsProducer {
    private static final String ACCOUNTS_TOPIC = "accounts2";
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendTransfer(final Payment payment) {
        var paymentDto = PaymentDto.builder()
                .senderAccount(payment.getSenderAccount())
                .recipientAccount(payment.getRecipientAccount())
                .amount(payment.getAmount())
                .title(payment.getTitle())
                .build();

        PaymentMessage paymentMessage = new PaymentMessage(paymentDto);
        log.info("Sending message to Kafka, paymentMessage: {}", paymentMessage);
        kafkaTemplate.send(ACCOUNTS_TOPIC, paymentMessage);
        log.info("Message was sent");
    }
}
