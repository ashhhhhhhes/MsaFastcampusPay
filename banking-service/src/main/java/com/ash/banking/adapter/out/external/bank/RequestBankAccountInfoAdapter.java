package com.ash.banking.adapter.out.external.bank;

import com.ash.banking.application.port.out.external.bank.RequestBankAccountInfoPort;
import com.ash.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class RequestBankAccountInfoAdapter implements RequestBankAccountInfoPort {

    @Override
    public BankAccountInfo getBankAccountInfo(GetBankAccountInfoRequest request) {
//        boolean randomLinkedStatus = new Random().nextBoolean();
        return new BankAccountInfo(request.getBankName(), request.getBankAccountNumber(), true);
    }

}
