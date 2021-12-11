package com.mycompany.webapp.dao.db1;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mycompany.webapp.dto.Account;

@Mapper
public interface Db1AccountDao {
	public List<Account> selectAll();
	public Account selectByAno(int ano);
	public int updateBalance(Account account);
}


