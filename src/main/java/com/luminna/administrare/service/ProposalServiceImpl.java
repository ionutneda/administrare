package com.luminna.administrare.service;

import com.luminna.administrare.entity.Product;
import com.luminna.administrare.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ProposalServiceImpl implements ProposalService{

    @Autowired
    ProposalRepository proposalRepository;

    private Map<Product, Integer> proposal = new LinkedHashMap<>();

    @Override
    public void addProduct(Product product) {
        if (proposal.containsKey(product)){
            proposal.replace(product, proposal.get(product) -1);
        } else {
            proposal.put(product, 1);
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (proposal.containsKey(product)) {
            if (proposal.get(product) > 1)
                proposal.replace(product, proposal.get(product) -1);
            else if (proposal.get(product) == 1) {
                proposal.remove(product);
            }
        }
    }

    @Override
    public void clearProducts() {
        proposal.clear();
    }

    @Override
    public Map<Product, Integer> productsInProposal() {
        return Collections.unmodifiableMap(proposal);
    }

    @Override
    public BigDecimal totalPrice() {
        return proposal.entrySet().stream()
                .map(k -> k.getKey().getPrice().multiply(BigDecimal.valueOf(k.getValue()))).sorted()
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }



}
