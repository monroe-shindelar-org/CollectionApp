package com.mshindelar.collection;

import com.mshindelar.collection.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.awt.image.PackedColorModel;

@SpringBootApplication
public class CollectionApplication {
	public static void main(String[] args) { SpringApplication.run(CollectionApplication.class, args); }
}
