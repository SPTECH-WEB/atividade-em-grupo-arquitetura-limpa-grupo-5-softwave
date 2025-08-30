package com.softwave.clean_arch_softwave.controller;

import com.softwave.clean_arch_softwave.adapters.ClienteRequestDTO;
import com.softwave.clean_arch_softwave.adapters.ClienteResponseDTO;
import com.softwave.clean_arch_softwave.entities.Cliente;
import com.softwave.clean_arch_softwave.useCase.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteRequestDTO> cadastrar(@Valid @RequestBody ClienteRequestDTO dto){
        ClienteRequestDTO clienteCadastrado = ClienteRequestDTO.toDTO(
                clienteService.cadastrar(
                        ClienteRequestDTO.toEntity(dto)
                )
        );

        return ResponseEntity.status(201).body(clienteCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable("id") int id){

        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(ClienteResponseDTO.toResponseDto(cliente));
    }
}