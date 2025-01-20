package com.ash.banking.application.service;

import com.ash.banking.adapter.out.external.bank.BankAccountInfo;
import com.ash.banking.adapter.out.external.bank.GetBankAccountInfoRequest;
import com.ash.banking.adapter.out.external.bank.RequestBankAccountInfoAdapter;
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
    private final RequestBankAccountInfoAdapter requestBankAccountInfoAdapter;
    private final RegisteredBankAccountMapper registeredBankAccountMapper;

    @Override
    public RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command) {

        BankAccountInfo bankAccountInfo = requestBankAccountInfoAdapter.getBankAccountInfo(new GetBankAccountInfoRequest(
                command.getBankName(),
                command.getBankAccountNumber()
        ));

        if (bankAccountInfo.isValid()) {
            RegisteredBankAccountJpaEntity savedBankAccount = registerBankAccountPort.createRegisteredBankAccount(
                    new RegisteredBankAccount.MembershipId(command.getMembershipId()),
                    new RegisteredBankAccount.BankName(command.getBankName()),
                    new RegisteredBankAccount.BankAccountNumber(command.getBankAccountNumber()),
                    new RegisteredBankAccount.LinkedStatusIsValid(true)
            );

            return registeredBankAccountMapper.mapToDomainEntity(savedBankAccount);
        } else {
            return null;
        }
    }
}
