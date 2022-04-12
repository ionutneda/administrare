package com.luminna.administrare.service;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.entity.Provider;
import com.luminna.administrare.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    ProviderRepository providerRepository;

    public List<Provider> findAll(){
        return providerRepository.findAll();
    }

    public Provider save(Provider provider) {

        return providerRepository.save(provider);
    }

    public List<Provider> saveAll(List<Provider> providers){
        return providerRepository.saveAll(providers);
    }

    public Provider findById(Long Id){
        return providerRepository.getById(Id);
    }


}
