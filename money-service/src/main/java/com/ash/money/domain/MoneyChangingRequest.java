package com.ash.money.domain;

import com.ash.common.Domain;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Domain
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {

    @Getter
    private final String moneyChangingRequestId;

    @Getter
    private final String targetMembershipId;

    @Getter
    private final ChangingType changingType; // 0 : increase, 1 : decrease

    @Getter
    private final int changingMoneyAmount;

    @Getter
    private final ChangingMoneyStatus changingMoneyStatus; // 0 : requested, 1 : approved, 2 : rejected

    @Getter private final UUID uuid;

    public enum ChangingType {
        INCREASE,
        DECREASE;

        public static ChangingType fromInt(int value) {
            return value == 0 ? INCREASE : DECREASE;
        }
    }

    public enum ChangingMoneyStatus {
        REQUESTED,
        SUCCESS,
        FAILED,
        CANCELED;

        public static ChangingMoneyStatus fromInt(int value) {
            return switch (value) {
                case 0 -> REQUESTED;
                case 1 -> SUCCESS;
                case 2 -> FAILED;
                case 3 -> CANCELED;
                default -> throw new IllegalArgumentException("Unexpected value: " + value);
            };
        }
    }

    public static MoneyChangingRequest generateMoneyChangingRequest(
            MoneyChangingRequestId moneyChangingRequestId,
            TargetMembershipId targetMembershipId,
            ChangingType changingType,
            ChangingMoneyAmount changingMoneyAmount,
            ChangingMoneyStatus changingMoneyStatus,
            UUID uuid
    ) {
        return new MoneyChangingRequest(
                moneyChangingRequestId.value(),
                targetMembershipId.value(),
                changingType,
                changingMoneyAmount.value(),
                changingMoneyStatus,
                uuid
        );
    }

    public record MoneyChangingRequestId(String value) {
    }

    public record TargetMembershipId(String value) {
    }

    public record ChangingMoneyAmount(int value) {
    }

}
