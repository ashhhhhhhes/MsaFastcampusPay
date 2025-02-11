package com.ash.money.adapter.in.web.response;

import lombok.Data;

import java.util.Arrays;

@Data
public class MoneyChangeResultDetail {

    private String moneyChangingRequestId;

    private MoneyChangingType moneyChangingType; // 0: increase, 1: decrease

    private MoneyChangeResultStatus moneyChangeResultStatus;

    private int amount;

    public void setMoneyChangingType(int ordinal) {
        this.moneyChangingType = MoneyChangingType.of(ordinal);
    }

    public enum MoneyChangingType {
        INCREASE,
        DECREASE,
        ;

        public static MoneyChangingType of(int ordinal) {
            return Arrays.stream(MoneyChangingType.values()).filter(
                    v -> v.ordinal() == ordinal
            ).findAny().get();
        }
    }

    public enum MoneyChangeResultStatus {
        SUCCESS,
        FAILED,
        FAILED_NOT_ENOUGH_MONEY, // 돈이 부족함
        FAILED_NOT_EXIST_MEMBERSHIP, // 멤버십이 존재하지 않음
        FAILED_NOT_EXIST_MONEY_CHANGING_REQUEST, // 요청한 돈 변동이 존재하지 않음
    }

}