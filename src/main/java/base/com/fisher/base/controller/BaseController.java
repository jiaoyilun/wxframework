package com.fisher.base.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fisher.system.service.interfaces.IAccountService;
import com.fisher.system.service.interfaces.IAuthorityService;
import com.fisher.system.service.interfaces.IOrganizationService;
import com.fisher.system.service.interfaces.IRoleService;

public abstract class BaseController {  

	protected final String searchModelName="searchModel";
	protected final String treeDataSourceName="treeDataSource";
	protected final String selectDataSourceName="selectDataSource";
	
	@Autowired
    @Qualifier("RoleService")
    protected IRoleService roleService;
	
	@Autowired
    @Qualifier("AccountService")
    protected IAccountService accountService;
	
	@Autowired
    @Qualifier("AuthorityService")
	protected IAuthorityService authorityService;
	
	@Autowired
    @Qualifier("OrganizationService")
	protected IOrganizationService organizationService;
	
	@ExceptionHandler  
    public String exception(HttpServletRequest request, Exception e) {  
          
        request.setAttribute("exceptionMessage", e.getMessage());  
          
        // 根据不同错误转向不同页面  
        if(e instanceof SQLException) 
            return "testerror";   
        else
            return "error/error";  
    }  
	
}  
