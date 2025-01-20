package com.ash.banking.application.port.in;

import com.ash.banking.domain.FirmbankingRequest;

public interface RequestFirmBankingUserCase {

    FirmbankingRequest requestFirmBanking(RequestFirmBankingCommand command);
}
