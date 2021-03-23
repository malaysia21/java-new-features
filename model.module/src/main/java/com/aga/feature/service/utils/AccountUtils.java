package com.aga.feature.service.utils;

import com.aga.feature.service.model.Account;

import java.util.List;

public class AccountUtils {

    public void startingCreatingAccount(List<String> accountNameList){
        accountNameList.forEach(accountName ->
                System.out.println(new Account(accountName).toString()));
    }
}
