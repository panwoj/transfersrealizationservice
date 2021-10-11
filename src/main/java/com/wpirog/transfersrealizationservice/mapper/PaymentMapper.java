package com.wpirog.transfersrealizationservice.mapper;

import com.wpirog.commons.TransferMessage;
import com.wpirog.transfersrealizationservice.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    public Payment mapToPayment(TransferMessage transferMessage) {
        return Payment.builder()
                .recipientAccount(transferMessage.getTransfer().getRecipientAccount())
                .senderAccount(transferMessage.getTransfer().getSenderAccount())
                .title(transferMessage.getTransfer().getTitle())
                .amount(transferMessage.getTransfer().getAmount())
                .build();
    }
}
