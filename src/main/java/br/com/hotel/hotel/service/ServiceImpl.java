package br.com.hotel.hotel.service;

import br.com.hotel.hotel.mapper.clienteMapper.ClienteMapper;
import br.com.hotel.hotel.mapper.quartoMapper.QuartoMapper;
import br.com.hotel.hotel.model.clienteModel.ClienteRequest;
import br.com.hotel.hotel.model.clienteModel.ClienteResponse;
import br.com.hotel.hotel.model.quartoModel.QuartoRequest;
import br.com.hotel.hotel.model.quartoModel.QuartoResponse;
import br.com.hotel.hotel.persistence.entity.Cliente;
import br.com.hotel.hotel.persistence.entity.Quarto;
import br.com.hotel.hotel.persistence.repository.ClienteRepository;
import br.com.hotel.hotel.persistence.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements QuartoService, ClienteService {

    @Autowired
    private QuartoRepository quartoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public QuartoResponse newQuarto(QuartoRequest request) {
        Quarto quarto = new Quarto();
        quarto.setNumero(request.getNumero());
        quarto.setSituacao(request.getSituacao());
        quarto.setNumeroDeCamas(request.getNumeroDeCamas());

        quartoRepository.save(quarto);

        return QuartoMapper.quartoModelToResponseMapper(quarto);

    }

    @Override
    public List<QuartoResponse> findAllQuartos() {
        List<QuartoResponse> responses = new ArrayList<>();

        List<Quarto> quartos = quartoRepository.findAll();
        if(!quartos.isEmpty()){
            quartos.forEach(quarto -> responses.add(QuartoMapper.quartoModelToResponseMapper(quarto)));
        }

        return responses;
    }

    @Override
    public ClienteResponse newCliente(ClienteRequest request) {
        Cliente cliente = new Cliente();

        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());

        clienteRepository.save(cliente);

        return ClienteMapper.clienteModelToResponseMapper(cliente);
    }
    @Override
    public Cliente findClienteByCPF(String cpf) {
        return clienteRepository.findByCpf(cpf);

    }
    @Override
    public List<ClienteResponse> findAllClientes() {
        List<ClienteResponse> responses = new ArrayList<>();

        List<Cliente> clientes = clienteRepository.findAll();
        if(!clientes.isEmpty()){
            clientes.forEach(cliente -> responses.add(ClienteMapper.clienteModelToResponseMapper(cliente)));
        }

        return responses;
    }
}
