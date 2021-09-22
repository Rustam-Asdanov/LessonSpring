package com.hibernate.a5_eager_vs_lazy.bi.example_1;

import com.hibernate.a5_eager_vs_lazy.bi.example_1.model.Cart;
import com.hibernate.a5_eager_vs_lazy.bi.example_1.model.Item;
import com.hibernate.a5_eager_vs_lazy.bi.example_1.repository.CartRepository;
import com.hibernate.a5_eager_vs_lazy.bi.example_1.repository.ItemRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RunSpring {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(RunSpring.class);

        CartRepository cartRepository = context.getBean("cartRepository", CartRepository.class);
        ItemRepository itemRepository = context.getBean("itemRepository", ItemRepository.class);

        Cart cart = new Cart("C9999");
        Item item_one = new Item("S123",cart);
        Item item_two = new Item("S312",cart);
        List<Item> items = Arrays.asList(item_one,item_two);

        cart.setItems(items);

//        cartRepository.save(cart);

        cartRepository.deleteById(1);
        context.close();
    }
}
