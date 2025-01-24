package com.ash.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {

    @Getter
    private final String memberMoneyId;
    @Getter
    private final String membershipId;

    @Getter
    private final int balance;

    @Getter
    private final boolean linkedStatusIsValid;

    public static MemberMoney generateMemberMoney(
            MemberMoneyId memberMoneyId,
            MembershipId membershipId,
            Balance balance,
            LinkedStatusIsValid linkedStatusIsValid
    ) {
        return new MemberMoney(
                memberMoneyId.value,
                membershipId.value,
                balance.value,
                linkedStatusIsValid.value
        );
    }

    public record MemberMoneyId(String value) {
    }

    public record MembershipId(String value) {
    }

    public record RegisteredBankAccountId(String value) {
    }

    public record Balance(int value) {
    }

    public record LinkedStatusIsValid(boolean value) {
    }

}
