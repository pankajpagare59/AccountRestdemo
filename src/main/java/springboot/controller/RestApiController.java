package springboot.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import springboot.model.Account;
import springboot.service.AccountService;
import springboot.util.CustomErrorType;


@RestController
@RequestMapping("/api")
public class RestApiController {
	
	
public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);


@Autowired
AccountService accountServies;

//@RequestMapping(value= "/account/",method= RequestMethod.GET)
@GetMapping(value="/account",produces="application/json")
public ResponseEntity<List<Account>> listAllAccount()
{
	List<Account> accounts = accountServies.findAllAccount();
	
			if(accounts.isEmpty())
			{
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
}


//@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
@GetMapping(value="account/{id}",produces="application/json")
public ResponseEntity<?> getUser(@PathVariable("id") long id) {
	
    logger.info("Fetching User with id {}", id);
    Account account = accountServies.findById(id);
    
    if (account == null) {
        logger.error("User with id {} not found.", id);
        return new ResponseEntity(new CustomErrorType("User with id " + id 
                + " not found"), HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Account>(account, HttpStatus.OK);
}


}
