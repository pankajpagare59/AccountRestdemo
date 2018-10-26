package springboot.service;

import java.util.List;

import springboot.model.Account;

public interface AccountService {
	
	 Account findById(long id);
	
	 List<Account> findAllAccount();

	
	
}