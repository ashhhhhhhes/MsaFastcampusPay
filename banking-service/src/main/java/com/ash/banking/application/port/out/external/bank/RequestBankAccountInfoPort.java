package com.ash.banking.application.port.out.external.bank;

import com.ash.banking.adapter.out.external.bank.BankAccountInfo;
import com.ash.banking.adapter.out.external.bank.GetBankAccountInfoRequest;

public interface RequestBankAccountInfoPort {

    BankAccountInfo getBankAccountInfo(GetBankAccountInfoRequest request);
}
