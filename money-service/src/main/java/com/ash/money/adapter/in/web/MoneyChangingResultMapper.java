package com.ash.money.adapter.in.web;

import com.ash.money.adapter.in.web.response.MoneyChangeResultDetail;
import com.ash.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MoneyChangingResultMapper {

    public MoneyChangeResultDetail mapToMoneyChangingResult(MoneyChangingRequest moneyChangingRequest) {
        MoneyChangeResultDetail resultDetail = new MoneyChangeResultDetail();
        resultDetail.setMoneyChangingRequestId(moneyChangingRequest.getMoneyChangingRequestId());
        resultDetail.setAmount(moneyChangingRequest.getChangingMoneyAmount());
        resultDetail.setMoneyChangingType(moneyChangingRequest.getChangingType().ordinal());

        if (Objects.requireNonNull(moneyChangingRequest.getChangingMoneyStatus()) == MoneyChangingRequest.ChangingMoneyStatus.SUCCESS) {
            resultDetail.setMoneyChangeResultStatus(MoneyChangeResultDetail.MoneyChangeResultStatus.SUCCESS);
        } else {
            resultDetail.setMoneyChangeResultStatus(MoneyChangeResultDetail.MoneyChangeResultStatus.FAILED);
        }

        return resultDetail;
    }

}
