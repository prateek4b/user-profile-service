package com.guide.cm.userprofileservice.controller;

import com.guide.cm.userprofileservice.entities.Client;
import com.guide.cm.userprofileservice.exceptions.ClientNotFoundException;
import com.guide.cm.userprofileservice.repository.ClientRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/add")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "executed successfully")})
    public Client addClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }


    @DeleteMapping("/delete/{id}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "executed successfully")})
    public void deleteClient(@RequestParam long id) {
        clientRepository.deleteById(id);
    }

    @GetMapping("/find/{id}")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "executed successfully"),@ApiResponse(responseCode = "404", description = "Client Not Found")})
    public Client findClient(@RequestParam long id) {
        return clientRepository.findById(id).orElseThrow(()->new ClientNotFoundException("Client not found"));
    }

    @PutMapping("/update")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "executed successfully")})
    public Client updateClient(@RequestBody Client client) {
        Client clientdb = clientRepository.findByGstNo(client.getGstNo());
        if (StringUtils.isNotEmpty(client.getName())) {
            clientdb.setName(client.getName());
        }

        if (StringUtils.isNotEmpty(client.getComments())) {
            clientdb.setComments(client.getComments());
        }

        if (StringUtils.isNotEmpty(client.getScheme())) {
            clientdb.setScheme(client.getScheme());
        }

        return clientRepository.save(clientdb);

    }


    @GetMapping("/findAll")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "executed successfully")})
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

}
