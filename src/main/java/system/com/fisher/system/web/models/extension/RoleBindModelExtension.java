package com.fisher.system.web.models.extension;

import com.fisher.system.model.models.Role;
import com.fisher.system.web.models.RoleBindModel;

public class RoleBindModelExtension {
	
	public static RoleBindModel toRoleBindModel(Role role){
		RoleBindModel ret=new RoleBindModel();
		ret.setName(role.getName());
		
		return ret;
	}
	
}
