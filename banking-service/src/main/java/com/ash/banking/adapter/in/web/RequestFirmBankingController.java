package com.ash.banking.adapter.in.web;

import com.ash.banking.application.port.in.RequestFirmBankingCommand;
import com.ash.banking.application.port.in.RequestFirmBankingUserCase;
import com.ash.banking.domain.FirmbankingRequest;
import com.ash.common.WebAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

    private final RequestFirmBankingUserCase requestFirmBankingUserCase;

    @PostMapping("/banking/firmbanking/request")
    FirmbankingRequest registerMembership(@RequestBody FirmBankingHttpRequest request) {
        // Req -> Cmd
        RequestFirmBankingCommand command = RequestFirmBankingCommand.builder()
                .fromBankName(request.getFromBankName())
                .fromBankAccountNumber(request.getFromBankAccountNumber())
                .toBankName(request.getToBankName())
                .toBankAccountNumber(request.getToBankAccountNumber())
                .moneyAmount(request.getMoneyAmount())
                .build();

        return requestFirmBankingUserCase.requestFirmBanking(command);
    }

}