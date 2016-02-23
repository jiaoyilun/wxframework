package com.fisher.system.model.models;

import java.util.List;

import com.fisher.base.model.interfaces.ICUDEable;
import com.fisher.base.model.models.EnableEntity;

public class Role extends EnableEntity<Integer> implements ICUDEable {

	private List<Authority> authorities;

	public void setAuthorities(List<Authority> authorities){
		this.authorities=authorities;
	}
	
	public List<Authority> getAuthorities(){
		return this.authorities;
	}
	
}
