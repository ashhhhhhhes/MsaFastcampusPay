package com.ash.money.application.port.out;

import com.ash.money.domain.MoneyChangingRequest;

import java.util.UUID;

public interface ChangingMoneyRequestPort<T> {

    T createChangingMoneyRequest(MoneyChangingRequest.TargetMembershipId targetMembershipId
            , MoneyChangingRequest.ChangingType changingType
            , MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount
            , MoneyChangingRequest.ChangingMoneyStatus changingMoneyStatus
            , UUID uuid
    );

}
