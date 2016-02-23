package com.fisher.system.dao.daos;

import org.springframework.stereotype.Repository;

import com.fisher.base.dao.daos.EnableEntityDao;
import com.fisher.system.dao.interfaces.IRoleDao;
import com.fisher.system.model.models.Role;

@Repository("RoleDao")
public class RoleDao extends EnableEntityDao<Integer, Role> implements IRoleDao {


}
