package com.fisher.system.service.interfaces;

import com.fisher.base.service.interfaces.IEnableEntityService;
import com.fisher.common.exception.EntityOperateException;
import com.fisher.common.exception.ValidatException;
import com.fisher.common.utilities.PageList;
import com.fisher.system.dao.interfaces.IRoleDao;
import com.fisher.system.model.models.Role;
import com.fisher.system.service.models.RoleSearch;

public interface IRoleService extends IEnableEntityService<Integer, Role, IRoleDao> {

	public PageList<Role> listPage(RoleSearch search, int pageNo, int pageSize);
	public void saveAuthorize(Integer roleId, Integer[] authorityIds) throws ValidatException, EntityOperateException;

}