package com.ash.banking.adapter.out.persistence;

import com.ash.banking.domain.RegisteredBankAccount;
import org.springframework.stereotype.Component;

@Component
public class RegisteredBankAccountMapper {

    public RegisteredBankAccount mapToDomainEntity(RegisteredBankAccountJpaEntity registeredBankAccountJpaEntity) {
        return RegisteredBankAccount.generateRegisteredBankAccountId(
                new RegisteredBankAccount.RegisteredBankAccountId(registeredBankAccountJpaEntity.getRegisteredBankAccountId() + ""),
                new RegisteredBankAccount.MembershipId(registeredBankAccountJpaEntity.getMembershipId()),
                new RegisteredBankAccount.BankName(registeredBankAccountJpaEntity.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(registeredBankAccountJpaEntity.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(registeredBankAccountJpaEntity.isLinkedStatusIsValid())
        );
    }
}