package com.ash.banking.adapter.out.external.bank;

import com.ash.banking.application.port.out.external.bank.RequestBankAccountInfoPort;
import com.ash.banking.application.port.out.external.bank.RequestExternalFirmbankingPort;
import com.ash.common.ExternalSystemAdapter;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class BankAccountInfoAdapter implements RequestBankAccountInfoPort, RequestExternalFirmbankingPort {

    @Override
    public BankAccountInfo getBankAccountInfo(GetBankAccountInfoRequest request) {
//        boolean randomLinkedStatus = new Random().nextBoolean();
        return new BankAccountInfo(request.getBankName(), request.getBankAccountNumber(), true);
    }

    @Override
    public FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request) {

        return  new FirmbankingResult(0);
    }
}
