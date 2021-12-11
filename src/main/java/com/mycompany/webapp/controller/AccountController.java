package com.mycompany.webapp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Account;
import com.mycompany.webapp.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AccountController {
	@Resource
	private AccountService accountService;
	
	@RequestMapping("/")
	public String content(Model model) {
		log.info("실행");
		List<Account> accounts1 = accountService.getDb1Accounts();
		model.addAttribute("accounts1", accounts1);
		List<Account> accounts2 = accountService.getDb2Accounts();
		model.addAttribute("accounts2", accounts2);
		return "content";
	}
	
	@RequestMapping("/accountTransfer")
	public String accountTransfer(int fromAno, int toAno, int amount) {
		log.info("실행");
		accountService.accountTransfer(fromAno, toAno, amount);
		return "redirect:/";
	}
}










