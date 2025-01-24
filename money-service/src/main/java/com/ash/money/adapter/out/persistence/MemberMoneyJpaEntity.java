package com.ash.money.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "momber_money")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberMoneyJpaEntity {

    @Id
    @GeneratedValue
    private Long memberMoneyId;
    private String membershipId;
    private int balance;
    private boolean linkedStatusIsValid;

    public MemberMoneyJpaEntity(String membershipId, int balance) {
        this.membershipId = membershipId;
        this.balance = balance;
    }

    public MemberMoneyJpaEntity(String membershipId, int balance, boolean linkedStatusIsValid) {

        this.membershipId = membershipId;
        this.balance = balance;
        this.linkedStatusIsValid = linkedStatusIsValid;
    }
}
