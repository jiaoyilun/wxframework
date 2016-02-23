package com.fisher.weixin.web.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlOutTextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/weixinrequest")
public class WeiXinRequestController {
	
	protected WxMpConfigStorage wxMpConfigStorage;
	protected WxMpService wxMpService;
	protected WxMpMessageRouter wxMpMessageRouter;
	
	@RequestMapping(value="/process", method = {RequestMethod.GET})
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws NoSuchAlgorithmException, IOException{
		WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
		config.setAppId("..."); // 设置微信公众号的appid
		config.setSecret("..."); // 设置微信公众号的app corpSecret
		config.setToken("..."); // 设置微信公众号的token
		config.setAesKey("..."); // 设置微信公众号的EncodingAESKey
		
		wxMpService = new WxMpServiceImpl();
	    wxMpService.setWxMpConfigStorage(wxMpConfigStorage);
		
	    String signature = request.getParameter("signature");
	    String nonce = request.getParameter("nonce");
	    String timestamp = request.getParameter("timestamp");
	    
	    if (!wxMpService.checkSignature(timestamp, nonce, signature)) {
	        // 消息签名不正确，说明不是公众平台发过来的消息
	        response.getWriter().println("非法请求");
	        return;
	      }

	      String echostr = request.getParameter("echostr");
	      if (StringUtils.isNotBlank(echostr)) {
	        // 说明是一个仅仅用来验证的请求，回显echostr
	        response.getWriter().println(echostr);
	        return;
	      }

	}
	
	@RequestMapping(value="/process", method = {RequestMethod.POST})
	public void processPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String encryptType = request.getParameter("encrypt_type");
		encryptType = StringUtils.isBlank(encryptType) ? "raw" : encryptType;

		WxMpXmlMessage inMessage = null;
		
	      if ("raw".equals(encryptType)) {
	        // 明文传输的消息
	        inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
	      }

	      if ("aes".equals(encryptType)) {
	        // 是aes加密的消息
	        String msgSignature = request.getParameter("msg_signature");
		    String nonce = request.getParameter("nonce");
		    String timestamp = request.getParameter("timestamp");
	        inMessage = WxMpXmlMessage.fromEncryptedXml(request.getInputStream(), wxMpConfigStorage, timestamp, nonce, msgSignature);
	      }
	      response.getWriter().println("不可识别的加密类型");
	      
	      
	      
	      WxMpMessageHandler handler = new WxMpMessageHandler() {
	          @Override public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) {
	            WxMpXmlOutTextMessage m
	                = WxMpXmlOutMessage.TEXT().content("测试消息").fromUser(wxMessage.getToUserName())
	                .toUser(wxMessage.getFromUserName()).build();
	            return m;
	          }
	        };
	      
	      //业务处理逻辑
	      
	      wxMpMessageRouter = new WxMpMessageRouter(wxMpService);
	      wxMpMessageRouter
	          .rule()
	          .async(false)
	          .content("哈哈") // 拦截内容为“哈哈”的消息
	          .handler(handler)
	          .end();
	      
	      
	      
	      WxMpXmlOutMessage outMessage = wxMpMessageRouter.route(inMessage);
	      
	      String returnContent = "";
	      if ("raw".equals(encryptType)) {
	          returnContent = outMessage.toXml();
	        } else if ("aes".equals(encryptType)) {
	          returnContent = outMessage.toEncryptedXml(wxMpConfigStorage);
	        }
	}

}
