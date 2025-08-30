package com.softwave.clean_arch_softwave.useCase;

import com.softwave.clean_arch_softwave.entities.Cliente;
import com.softwave.clean_arch_softwave.ports.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente){
        Cliente clienteCadastrado = clienteRepository.save(cliente);

        clienteCadastrado.setRisco(clienteCadastrado.getIdade(), clienteCadastrado.getRendaMensal());

        return clienteCadastrado;
    }
}
