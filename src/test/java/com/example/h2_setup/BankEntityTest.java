package com.example.h2_setup;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.h2_setup.Util.DateUtil;
import com.example.h2_setup.controller.BankController;
import com.example.h2_setup.entity.Bank;
import com.example.h2_setup.repository.BankRepository;
import com.example.h2_setup.service.BankService;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BankEntityTest {
	
	@Autowired
	private BankRepository bankRepository;
	
	@Test
	@Order(1) // 依照順序執行
	@Rollback(value = false) //讓測試數據不影響實際的數據庫狀態，保證每次測試都在一個乾淨的環境中執行。
	public void saveBankTest() {
		Bank bank = new Bank();
		bank.setId(1);
		bank.setCode("US");
		bank.setDescription("美元");
		bank.setRate("11.1");
		bank.setUpdateTime(DateUtil.getNow());
		
	    System.out.println("加入資訊: ");
	    System.out.println("ID: " + bank.getId());
	    System.out.println("代碼: " + bank.getCode());
	    System.out.println("描述: " + bank.getDescription());
	    System.out.println("匯率: " + bank.getRate());
	    System.out.println("更新時間: " + bank.getUpdateTime());
		
		bankRepository.save(bank);
	    Assertions.assertThat(bank.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void getBankAllTest() {
		List<Bank> bank = bankRepository.findAll();
		System.out.println(bank.size());
		assertThat(bank.size()).isGreaterThan(0);	
	}
	
	@Test
	public void getOneBankTest() {
		Bank bank = bankRepository.findById(1).orElse(null);
	    System.out.println("查詢的資訊: ");
	    System.out.println("ID: " + bank.getId());
	    System.out.println("代碼: " + bank.getCode());
	    System.out.println("描述: " + bank.getDescription());
	    System.out.println("匯率: " + bank.getRate());
	    System.out.println("更新時間: " + bank.getUpdateTime());
	    Assertions.assertThat(bank).isNotNull();
	    Assertions.assertThat(bank.getId()).isEqualTo(1L);
	}
	
	@Test
	@Order(3)
	@Rollback(value = false)
	public void updateBankTest() {
		Bank bank = bankRepository.findById(1).orElse(null);

        assertThat(bank).isNotNull();

        bank.setRate("99.9");
        
        bankRepository.save(bank);

        Bank updatedBank = bankRepository.findById(1).orElse(null);
        assertThat(updatedBank).isNotNull();
        assertThat(bank.getRate()).isEqualTo("99.9");
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void deleteBankTest() {
        Bank employee = bankRepository.findById(1).orElse(null);

        assertThat(employee).isNotNull();

        bankRepository.delete(employee);

        Optional<Bank> optionalEmployee = bankRepository.findByRate("99.9");
        Bank employee1 = optionalEmployee.orElse(null);

        assertThat(employee1).isNull();
		
	}
	
	
	


}
