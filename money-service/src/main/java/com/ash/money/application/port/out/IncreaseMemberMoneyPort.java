package com.ash.money.application.port.out;

import com.ash.money.domain.MemberMoney;

public interface IncreaseMemberMoneyPort<T> {

    T increaseMoney(
            MemberMoney.MembershipId memberMoneyId
            , int increasingMoneyAmount
    );

}
