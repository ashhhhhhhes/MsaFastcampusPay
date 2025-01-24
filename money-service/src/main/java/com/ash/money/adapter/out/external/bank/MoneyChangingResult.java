package com.ash.money.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MoneyChangingResult {

    private int resultCode; // 0 : success, 1 : fail

}