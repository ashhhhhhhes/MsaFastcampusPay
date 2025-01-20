package com.ash.banking.application.port.out.external.bank;

import com.ash.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.ash.banking.adapter.out.external.bank.FirmbankingResult;

public interface RequestExternalFirmbankingPort {

    FirmbankingResult requestExternalFirmbanking(ExternalFirmbankingRequest request);
}
