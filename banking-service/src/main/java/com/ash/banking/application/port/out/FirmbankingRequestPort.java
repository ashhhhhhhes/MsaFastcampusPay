package com.ash.banking.application.port.out;

import com.ash.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.ash.banking.domain.FirmbankingRequest;

public interface FirmbankingRequestPort {
    FirmbankingRequestJpaEntity createFirmbankingRequest(
            FirmbankingRequest.FromBankName fromBankName,
            FirmbankingRequest.FromBankAccountNumber fromBankAccountNumber,
            FirmbankingRequest.ToBankName toBankName,
            FirmbankingRequest.ToBankAccountNumber toBankAccountNumber,
            FirmbankingRequest.MoneyAmount moneyAmount,
            FirmbankingRequest.FirmbankingStatus firmbankingStatus
    );

    FirmbankingRequestJpaEntity modifyFirmbankingRequest(
            FirmbankingRequestJpaEntity entity
    );
}
