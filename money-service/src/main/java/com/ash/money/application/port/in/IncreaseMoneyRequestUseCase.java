package com.ash.money.application.port.in;

import com.ash.money.domain.MoneyChangingRequest;

public interface IncreaseMoneyRequestUseCase {

    MoneyChangingRequest increaseRequestMoneyChanging(IncreaseMoneyRequestCommand command);

}
