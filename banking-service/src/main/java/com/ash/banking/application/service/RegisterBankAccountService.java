package com.ash.banking.application.service;

import com.ash.banking.adapter.out.persistence.RegisteredBankAccountJpaEntity;
import com.ash.banking.adapter.out.persistence.RegisteredBankAccountMapper;
import com.ash.banking.application.port.in.RegisterBankAccountCommand;
import com.ash.banking.application.port.in.RegisterBankAccountUserCase;
import com.ash.banking.application.port.out.RegisterBankAccountPort;
import com.ash.banking.domain.RegisteredBankAccount;
import com.ash.common.UserCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@UserCase
@Transactional
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUserCase {

    private final RegisterBankAccountPort registerBankAccountPort;
    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    @Override
    public RegisteredBankAccount registerMembership(RegisterBankAccountCommand command) {
        RegisteredBankAccountJpaEntity jpaEntity = registerBankAccountPort.createRegisteredBankAccount(
                new RegisteredBankAccount.MembershipId(command.getMembershipId()),
                new RegisteredBankAccount.BankName(command.getBankName()),
                new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                new RegisteredBankAccount.LinkedStatusIsValid(command.isValid())
        );

        // entity -> domain
        return registeredBankAccountMapper.mapToDomainEntity(jpaEntity);
    }
}
