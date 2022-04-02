package com.luminna.administrare.repository;

import com.luminna.administrare.entity.Provider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProviderRepositoryTest {

    @Autowired
    private ProviderRepository providerRepository;

    @Test
    public void saveProvider(){
        Provider provider4 = new Provider("Flos", 30.00, 6, "Italy");
        providerRepository.save(provider4);

    }



}