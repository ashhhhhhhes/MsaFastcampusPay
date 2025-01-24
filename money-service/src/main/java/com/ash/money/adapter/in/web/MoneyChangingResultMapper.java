package com.ash.money.adapter.in.web;

import com.ash.money.adapter.in.web.response.MoneyChangeResultDetail;
import com.ash.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingResultMapper {

    public MoneyChangeResultDetail mapToMoneyChangingResult(MoneyChangingRequest moneyChangingRequest) {
        MoneyChangeResultDetail resultDetail = new MoneyChangeResultDetail();
        resultDetail.setMoneyChangingRequestId(moneyChangingRequest.getMoneyChangingRequestId());
        resultDetail.setAmount(moneyChangingRequest.getChangingMoneyAmount());
        resultDetail.setMoneyChangingType(moneyChangingRequest.getChangingType().ordinal());
        // RES SET.
//        resultDetail.setMoneyChangeResultStatus(
//
//        );

        return resultDetail;
    }

}
