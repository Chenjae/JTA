package com.mycompany.webapp.dao.db2;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mycompany.webapp.dto.Account;

@Mapper
public interface Db2AccountDao {
	public List<Account> selectAll();
	public Account selectByAno(int ano);
	public int updateBalance(Account account);
}
