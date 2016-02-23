package com.fisher.system.service.interfaces;

import java.security.NoSuchAlgorithmException;

import com.fisher.base.service.interfaces.IEnableEntityService;
import com.fisher.common.exception.EntityOperateException;
import com.fisher.common.exception.ValidatException;
import com.fisher.common.utilities.PageList;
import com.fisher.system.dao.interfaces.IAccountDao;
import com.fisher.system.model.models.Account;
//import com.demo.service.models.AccountSearch;

public interface IAccountService extends IEnableEntityService<Integer, Account, IAccountDao> {

	/*public Page<Account> listPage(AccountSearch search, int pageNo, int pageSize);
	public void saveAuthorize(Integer AccountId, Integer[] authorityIds) throws ValidatException, EntityOperateException;*/
	public PageList<Account> listPage(String name, String username, int pageNo, int pageSize);
	public boolean accountExist(String username);
	public Account login(String username, String password) throws NoSuchAlgorithmException;
	public void saveRegister(Account account) throws NoSuchAlgorithmException, EntityOperateException, ValidatException;
	public void updateBind(Integer id, Integer roleId, Integer organizationId) throws ValidatException, EntityOperateException;

}