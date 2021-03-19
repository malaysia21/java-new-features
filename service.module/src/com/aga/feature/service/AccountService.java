package com.aga.feature.service;

import com.aga.feature.service.utils.AccountUtils;

import java.util.Arrays;

public class AccountService {

    public static void main(String[] args) {
        AccountUtils accountUtils = new AccountUtils();
        accountUtils.startingCreatingAccount(Arrays.asList("Tom", "Kate"));

    }
}
