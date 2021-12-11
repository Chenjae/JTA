package com.mycompany.webapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.webapp.dao.db1.Db1AccountDao;
import com.mycompany.webapp.dao.db2.Db2AccountDao;
import com.mycompany.webapp.dto.Account;
import com.mycompany.webapp.exception.NotFoundAccountException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountService {	
	@Resource
	private Db1AccountDao db1AccountDao;
	
	@Resource
	private Db2AccountDao db2AccountDao;
	
	public List<Account> getDb1Accounts() {
		log.info("getDb1Accounts 실행");
		List<Account> accounts = db1AccountDao.selectAll();
		return accounts;
	}
	
	public List<Account> getDb2Accounts() {
		log.info("getDb2Accounts 실행");
		List<Account> accounts = db2AccountDao.selectAll();
		return accounts;
	}
	
	//JTA 환경이 감지되면 Spring은 JtaTransactionManager를 자동으로 사용
	@Transactional
	public void accountTransfer(int fromAno, int toAno, int amount) {
		log.info("accountTransfer 실행");
		try {
			//출금하기
			Account fromAccount = db1AccountDao.selectByAno(fromAno);
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			db1AccountDao.updateBalance(fromAccount);
			
			//예금하기
			Account toAccount = db2AccountDao.selectByAno(toAno);
			toAccount.setBalance(toAccount.getBalance() + amount);
			db2AccountDao.updateBalance(toAccount);
		} catch(Exception e) {
			throw new NotFoundAccountException("계좌가 존재하지 않습니다.");
		}
	}
}












