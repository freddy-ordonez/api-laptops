package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Laptop;
import com.example.obrestdatajpa.entities.LaptopCaracteristica;
import com.example.obrestdatajpa.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		LaptopCaracteristica laptopCaracteristica1 = new LaptopCaracteristica(17, 16, "Intel Corei9 3.5ghz", 1000, 254);
		Laptop laptop1 = new Laptop("Hp", "g45", 295.000, laptopCaracteristica1);

		LaptopCaracteristica laptopCaracteristica2 = new LaptopCaracteristica(14, 8, "Intel Corei7 2.5ghz", 2000, 254);
		Laptop laptop2 = new Laptop("Hp", "g45", 295.000, laptopCaracteristica2);

		LaptopCaracteristica laptopCaracteristica3 = new LaptopCaracteristica(11, 4, "Intel Corei3 4.5ghz", 3000, 254);
		Laptop laptop3 = new Laptop("Hp", "g45", 295.000, laptopCaracteristica3);

		LaptopCaracteristica laptopCaracteristica4 = new LaptopCaracteristica(17, 16, "Intel Corei10 3.7ghz", 4000, 254);
		Laptop laptop4 = new Laptop("Hp", "g45", 295.000, laptopCaracteristica4);

		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);
		laptopRepository.save(laptop3);
		laptopRepository.save(laptop4);

	}

}
