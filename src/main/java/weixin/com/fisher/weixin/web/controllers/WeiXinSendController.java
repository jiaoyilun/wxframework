package com.fisher.weixin.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONArray;
import com.fisher.base.controller.BaseController;
import com.fisher.system.auth.AuthPassport;
import com.fisher.system.web.models.WXCreateMenuModel;

@Controller
@RequestMapping(value = "/weixinsend")
public class WeiXinSendController extends BaseController {
	
	@Autowired
    @Qualifier("wxMpService")
	protected WxMpService wxMpService;
	
	@RequestMapping(value="/test", method = {RequestMethod.GET})
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		/*final DefaultSender defaultSender = DefaultSender.newInstance(); 
		String appid="wx468d07762e99c0d5";
		String secret="040068131817b2661ff50975a9896eb4";
		String ret=defaultSender.getAccessTokenJson(appid, secret);*/
	}
	
	@AuthPassport
	@RequestMapping(value="/createmenu", method = {RequestMethod.GET})
	public String createMenu(HttpServletRequest request, Model model){
		if(!model.containsAttribute("contentModel")){
            model.addAttribute("contentModel", new WXCreateMenuModel());
        }
        return "weixinsend/createmenu";
	}
	
	@AuthPassport
	@RequestMapping(value="/createmenu", method = {RequestMethod.POST})
	public String createMenu(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") WXCreateMenuModel wxCreateMenuModel, BindingResult result) throws IOException{
		/*if(result.hasErrors())
            return createMenu(request, model);
		
		String appid="wx468d07762e99c0d5";
		String secret="040068131817b2661ff50975a9896eb4";
		final DefaultSender defaultSender = DefaultSender.newInstance(); 
		String accessTokenJson=defaultSender.getAccessTokenJson(appid, secret);
		
		JSONObject jsonObject = JSONObject.fromObject(accessTokenJson);
		AccessTokenModel accessTokenModel = (AccessTokenModel) JSONObject.toBean(jsonObject, AccessTokenModel.class);
		
		String ret=defaultSender.createMenu(accessTokenModel.getAccess_token(), wxCreateMenuModel.getContent());*/
		
		return "weixinsend/createmenu";
	}
	
	@AuthPassport
	@RequestMapping(value="/getmenu", method = {RequestMethod.GET})
	public String getMenu(HttpServletRequest request, Model model) throws IOException, WxErrorException{
		WxMenu wxMenu = wxMpService.menuGet();
		
		model.addAttribute("contentModel", wxMenu.toJson());
		
        return "weixinsend/getmenu";
	}
	
}
