package com.ash.money.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "money_changing_request")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyChangingRequestJpaEntity {

    @Id
    @GeneratedValue
    private Long moneyChangingRequestId;

    private String targetMembershipId;

    private int changingType; // 0 : increase, 1 : decrease

    private int moneyAmount;

    private int changingMoneyStatus; // 0 : requested, 1 : approved, 2 : rejected

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;

    private UUID uuid;

    public MoneyChangingRequestJpaEntity(String targetMembershipId, int changingType, int moneyAmount, int changingMoneyStatus, Timestamp timestamp, UUID uuid) {
        this.targetMembershipId = targetMembershipId;
        this.changingType = changingType;
        this.moneyAmount = moneyAmount;
        this.changingMoneyStatus = changingMoneyStatus;
        this.timestamp = timestamp;
        this.uuid = uuid;
    }
}
