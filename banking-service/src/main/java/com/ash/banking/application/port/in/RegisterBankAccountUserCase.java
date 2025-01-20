package com.ash.banking.application.port.in;

import com.ash.banking.domain.RegisteredBankAccount;

public interface RegisterBankAccountUserCase {

    RegisteredBankAccount registerBankAccount(RegisterBankAccountCommand command);
}
