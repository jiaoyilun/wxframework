package com.fisher.system.service.interfaces;

import com.fisher.base.service.interfaces.IChainEntityService;
import com.fisher.common.utilities.PageList;
import com.fisher.system.dao.interfaces.IAuthorityDao;
import com.fisher.system.model.models.Authority;
import com.fisher.system.service.models.AuthoritySearch;

public interface IAuthorityService extends IChainEntityService<Integer, Authority, IAuthorityDao> {

	public PageList<Authority> listPage(AuthoritySearch search, int pageNo, int pageSize);
	
}