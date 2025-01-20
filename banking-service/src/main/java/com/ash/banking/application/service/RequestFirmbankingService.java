package com.ash.banking.application.service;

import com.ash.banking.adapter.out.external.bank.ExternalFirmbankingRequest;
import com.ash.banking.adapter.out.external.bank.FirmbankingResult;
import com.ash.banking.adapter.out.persistence.FirmbankingRequestJpaEntity;
import com.ash.banking.adapter.out.persistence.FirmbankingRequestMapper;
import com.ash.banking.application.port.in.RequestFirmBankingCommand;
import com.ash.banking.application.port.in.RequestFirmBankingUserCase;
import com.ash.banking.application.port.out.FirmbankingRequestPort;
import com.ash.banking.application.port.out.external.bank.RequestExternalFirmbankingPort;
import com.ash.banking.domain.FirmbankingRequest;
import com.ash.common.UserCase;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@UserCase
@Transactional
@RequiredArgsConstructor
public class RequestFirmbankingService implements RequestFirmBankingUserCase {

    private final FirmbankingRequestMapper firmbankingRequestMapper;
    private final FirmbankingRequestPort firmbankingRequestPort;
    private final RequestExternalFirmbankingPort requestExternalFirmbankingPort;

    @Override
    public FirmbankingRequest requestFirmBanking(RequestFirmBankingCommand command) {
        // Business Logic
        // a -> b 계좌 송금

        // 1. 요청에 대한 정보 먼저 write
        FirmbankingRequestJpaEntity entity = firmbankingRequestPort.createFirmbankingRequest(
                new FirmbankingRequest.FromBankName(command.getFromBankName()),
                new FirmbankingRequest.FromBankAccountNumber(command.getFromBankAccountNumber()),
                new FirmbankingRequest.ToBankName(command.getToBankName()),
                new FirmbankingRequest.ToBankAccountNumber(command.getToBankAccountNumber()),
                new FirmbankingRequest.MoneyAmount(command.getMoneyAmount()),
                new FirmbankingRequest.FirmbankingStatus(0) // 0: 요청중, 1: 성공, 2: 실패
        );

        // 2. 외부 은행에 폰뱅킹 요청
        FirmbankingResult result = requestExternalFirmbankingPort.requestExternalFirmbanking(
                new ExternalFirmbankingRequest(
                        command.getFromBankName(),
                        command.getFromBankAccountNumber(),
                        command.getToBankName(),
                        command.getToBankAccountNumber(),
                        command.getMoneyAmount()
                )
        );

        UUID randomUUID = UUID.randomUUID();
        entity.setUuid(randomUUID);
        // 3. 결과에 따라 1번에서 작성했던, FirmbankingRequest 정보를 업데이트
        if (result.getResultCode() == 0) {
            entity.setFirmbakingStatus(1);
        } else {
            entity.setFirmbakingStatus(2);
        }

        return firmbankingRequestMapper.mapToDomainEntity(
                firmbankingRequestPort.modifyFirmbankingRequest(entity),
                randomUUID
        );
    }

}
