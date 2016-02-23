package com.fisher.system.web.models.extension;

import com.fisher.system.model.models.Account;
import com.fisher.system.web.models.AccountRegisterModel;

public class AccountRegisterModelExtension {
	public static Account toAccount(AccountRegisterModel registerModel){
		Account ret=new Account();
		ret.setName(registerModel.getName());
		ret.setEmail(registerModel.getEmail());
		ret.setUsername(registerModel.getUsername());
		ret.setPassword(registerModel.getPassword());
		
		return ret;
	}
}
