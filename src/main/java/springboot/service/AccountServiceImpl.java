package springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import springboot.model.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	private static List<Account> accounts;

		
	static {
		accounts = duumyAccounts();
	}
	@Override
	public Account findById(long id) {
		for(Account account : accounts){
            if(account.getId() == id){
                return account;
            }
		}		
		return null;
	}

	private static List<Account> duumyAccounts() {
		// TODO Auto-generated method stub
		
		List<Account> accounts = new ArrayList<Account>();
		
		accounts.add(new Account(111,"Pankaj",25,99999));
		accounts.add(new Account(112,"Pj",35,999966));
		accounts.add(new Account(113,"Paj",25,9989));
		accounts.add(new Account(144,"Paaj",15,999));
		accounts.add(new Account(155,"Pank",85,899));
		
		System.out.println(accounts);
		return accounts;
		
	}

	@Override
	public List<Account> findAllAccount() {
		// TODO Auto-generated method stub
		return accounts;
	}

}
