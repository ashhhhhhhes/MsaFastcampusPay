package com.ash.banking.application.port.out;

import com.ash.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.ash.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountPort {

    RegisteredBankAccountJpaEntity createRegisteredBankAccount(
            RegisteredBankAccount.MembershipId membershipId,
            RegisteredBankAccount.BankName bankName,
            RegisteredBankAccount.BankAccountNumber bankAccountNumber,
            RegisteredBankAccount.LinkedStatusIsValid linkedStatusIsValid
            );
}
