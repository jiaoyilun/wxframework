package com.fisher.system.web.models.extension;

import com.fisher.system.model.models.Role;
import com.fisher.system.service.models.RoleSearch;
import com.fisher.system.web.models.RoleEditModel;
import com.fisher.system.web.models.RoleSearchModel;

public class RoleModelExtension {
	public static RoleSearch toRoleSearch(RoleSearchModel searchModel){
		RoleSearch ret=new RoleSearch();
		ret.setName(searchModel.getName());
		
		return ret;
	}
	
	public static Role toRole(RoleEditModel editModel){
		Role role=new Role();
		role.setId(editModel.getId());
		role.setName(editModel.getName());
		return role;
	}
}
