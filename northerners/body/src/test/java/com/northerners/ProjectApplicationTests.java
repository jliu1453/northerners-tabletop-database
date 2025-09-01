package com.northerners;

import com.northerners.dto.inventoryMini;
import com.northerners.mapper.impl.*;
import com.northerners.model.*;
import com.northerners.service.impl.inventoryService;
import com.northerners.service.impl.miniService;
import com.northerners.service.impl.userService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class ProjectApplicationTests {

	@Autowired
	userService userService;

	@Autowired
	miniService miniService;

	@Autowired
	inventoryService inventoryService;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@BeforeEach
	void resetTable() {
		// Clears the table and resets auto-increment in correct order
		jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 0");
		jdbcTemplate.execute("TRUNCATE TABLE inventory_mini");
		jdbcTemplate.execute("TRUNCATE TABLE mini");
		jdbcTemplate.execute("TRUNCATE TABLE inventory");
		jdbcTemplate.execute("TRUNCATE TABLE user");
		jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 1");
	}

	@Test
	void testService(){
		int temp;

		user user = new user();
		List<user> userList = new ArrayList<>();

		mini mini = new mini();
		List<mini> miniList = new ArrayList<>();

		inventory inventory = new inventory();
		List<inventory> inventList = new ArrayList<>();

		inventoryMini inventoryMini = new inventoryMini();

		user.setUserName("one");
		user.setPassword("password123");

		temp = userService.createNewUser(user);
		System.out.println("testing create user...result is ");
		System.out.println(temp);
		inventory.setUserId(user.getUserId());
		inventoryService.createInventory(inventory);
		System.out.println("inventory id inserted: "+ inventoryService.findByUserId(user.getUserId()).getInventoryId());

		userList = userService.findAllUser();
		System.out.println(userList.getFirst().getUserName());
		System.out.println(userList.getFirst().getPassword());

		System.out.println("testing create&find all minis...");
		for(int i = 0; i < 5; i++){
			mini.setModelName("mini" + i);
			mini.setPoints(100 + i);
			mini.setBaseSize(200 + i);
			mini.setFaction("faction" + i);
			miniService.createNewMini(mini);
			inventoryMini.setInventoryId(inventoryService.findByUserId(user.getUserId()).getInventoryId());
			inventoryMini.setMiniId(mini.getMiniId());
			inventoryService.insertMini(inventoryMini);
		}
		miniList = miniService.findAllMini();
		for(mini element: miniList){

			System.out.println("mini id: " + element.getMiniId());
			System.out.println("mini name: " + element.getModelName());
			System.out.println("mini faction: " + element.getFaction());
			System.out.println("base: " + element.getBaseSize());
			System.out.println("points: " + element.getPoints());
		}

		mini = miniService.findMiniById(1);
		System.out.println("testing get mini By id, get " + mini.getModelName());
		mini = miniService.findMiniByName("mini2");
		System.out.println("testing get mini by name, get " + mini.getModelName()
				+ "with points of " + mini.getPoints());
		System.out.println("get the inventmini..." + miniService.findByInventoryId(inventoryService.findByUserId(1).getInventoryId()).getFirst().getModelName());

	}



}
