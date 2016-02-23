package com.fisher.system.dao.daos;

import org.springframework.stereotype.Repository;

import com.fisher.base.dao.daos.EnableEntityDao;
import com.fisher.system.dao.interfaces.IAccountDao;
import com.fisher.system.model.models.Account;

@Repository("AccountDao")
public class AccountDao extends EnableEntityDao<Integer, Account> implements IAccountDao {


}
