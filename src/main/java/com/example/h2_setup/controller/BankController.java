package com.example.h2_setup.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2_setup.entity.Bank;
import com.example.h2_setup.entity.Todo;
import com.example.h2_setup.model.BitcoinPriceIndex;
import com.example.h2_setup.service.BankService;
import com.example.h2_setup.service.TodoService;
import com.google.gson.Gson;

@RestController
public class BankController {
	
    @Autowired
    BankService service;//取得Service物件
    
    @PostMapping("/addBank")
    public Bank saveTodo (@RequestBody Bank todo) {
        return service.addTodo(todo);
    }
    
    @GetMapping("/getBank")
    public List<Bank> getAll () {
    	return service.getAllTodo();
    }
  
  	@PutMapping("/editBank")
    public Bank updateTodo (@RequestBody Bank todo) {
        return service.editTodo(todo);
    }
  	
  	@DeleteMapping("/deleteBank")
    public String deleteTodo (int id) {
        return service.deleteTodo(id);
    }
  	
  	// 取 舊的API的code
    @GetMapping("/getOldData")
    public List<Bank> getOldData () {
    	
        try {
            // 設置URL
            URL url = new URL("https://api.coindesk.com/v1/bpi/currentprice.json");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // 檢查響應碼
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            // 讀取響應
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();

            // 使用Gson解析JSON
            Gson gson = new Gson();
            BitcoinPriceIndex bitcoinPriceIndex = gson.fromJson(response.toString(), BitcoinPriceIndex.class);

            // 輸出解析後的數據
            System.out.println("Updated time: " + bitcoinPriceIndex.getTime().getUpdated());
            System.out.println("USD Rate: " + bitcoinPriceIndex.getBpi().getUSD().getRate());
            System.out.println("GBP Rate: " + bitcoinPriceIndex.getBpi().getGBP().getRate());
            System.out.println("EUR Rate: " + bitcoinPriceIndex.getBpi().getEUR().getRate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	
    	return null;
    }

}
