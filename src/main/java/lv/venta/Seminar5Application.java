package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Category;
import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class Seminar5Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar5Application.class, args);
	}
	
	@Bean// it will call this function automatically
	public CommandLineRunner testDatabase(IProductRepo prodRepo) {
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product productData1 = 
						new Product("Apple", Category.fruits, 0.99f, 3, "Red");
				
				Product productData2 = 
							new Product("Grapes", Category.fruits, 1.99f, 2, "Green");

				Product productData3 = 
							new Product("Watermelon", Category.fruits, 4.99f, 1, "Sweet");

				prodRepo.save(productData1);
				prodRepo.save(productData2);
				prodRepo.save(productData3);
				
				
			}
		};
		
		
	}

}
