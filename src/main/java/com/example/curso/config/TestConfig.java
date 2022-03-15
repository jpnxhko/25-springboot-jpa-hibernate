package com.example.curso.config;

import com.example.curso.entities.Category;
import com.example.curso.entities.Order;
import com.example.curso.entities.Product;
import com.example.curso.entities.User;
import com.example.curso.enums.OrderStatus;
import com.example.curso.repository.CategoryRepository;
import com.example.curso.repository.OrderRepository;
import com.example.curso.repository.ProductRepository;
import com.example.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "111111111", "senha1");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "222222222", "senha2");

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        Product product1 = new Product(null, "Product 1", "Description 1", 1.0,"");
        Product product2 = new Product(null, "Product 2", "Description 2", 2.0,"");
        Product product3 = new Product(null, "Product 3", "Description 3", 3.0,"");
        Product product4 = new Product(null, "Product 4", "Description 4", 4.0,"");
        Product product5 = new Product(null, "Product 5", "Description 5", 5.0,"");

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        product1.getCategories().add(category2);
        product2.getCategories().add(category1);
        product2.getCategories().add(category3);
        product3.getCategories().add(category3);
        product4.getCategories().add(category3);
        product5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));
    }
}
