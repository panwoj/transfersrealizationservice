package com.wpirog.transfersrealizationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Payment {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String senderAccount;
    @Column
    private String recipientAccount;
    @Column
    private String title;
    @Column
    private BigDecimal amount;
}
