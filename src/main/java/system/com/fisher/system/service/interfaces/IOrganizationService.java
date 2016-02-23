package com.fisher.system.service.interfaces;

import com.fisher.base.service.interfaces.IChainEntityService;
import com.fisher.common.utilities.PageList;
import com.fisher.system.dao.interfaces.IOrganizationDao;
import com.fisher.system.model.models.Organization;

public interface IOrganizationService extends IChainEntityService<Integer, Organization, IOrganizationDao> {

	public PageList<Organization> listPage(String name, int pageNo, int pageSize);
	
}