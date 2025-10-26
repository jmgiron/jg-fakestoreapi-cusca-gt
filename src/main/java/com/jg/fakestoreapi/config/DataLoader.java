
package com.jg.fakestoreapi.config;

import com.jg.fakestoreapi.entity.Client;
import com.jg.fakestoreapi.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final ClientRepository clientRepository;

    public DataLoader(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (clientRepository.count() == 0) {
            Client c = new Client();
            c.setName("John Doe");
            c.setEmail("john@example.com");
            c.setAddress("123 Main St");
            clientRepository.save(c);
        }
    }
}
