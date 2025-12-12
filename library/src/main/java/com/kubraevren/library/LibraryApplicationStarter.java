package com.kubraevren.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Aşağıdaki satırlara gerek yok çünkü Spring Boot zaten alt paketleri tarar
// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class LibraryApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplicationStarter.class, args);
	}

}


/*

package com.kubraevren.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // DOĞRU IMPORT BU
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.kubraevren.library.model"}) // Model paketini göster
@EnableJpaRepositories(basePackages = {"com.kubraevren.library.repository"}) // Repo paketini göster
@SpringBootApplication
public class LibraryApplicationStarter {

    public static void main(String[] args) {
       SpringApplication.run(LibraryApplicationStarter.class, args);
    }
}


 */