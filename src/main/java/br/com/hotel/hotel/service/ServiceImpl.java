package br.com.hotel.hotel.service;

import br.com.hotel.hotel.mapper.clienteMapper.ClienteMapper;
import br.com.hotel.hotel.mapper.quartoMapper.QuartoMapper;
import br.com.hotel.hotel.model.clienteModel.ClienteRequest;
import br.com.hotel.hotel.model.clienteModel.ClienteResponse;
import br.com.hotel.hotel.model.clienteModel.ReservaRequest;
import br.com.hotel.hotel.model.quartoModel.QuartoRequest;
import br.com.hotel.hotel.model.quartoModel.QuartoResponse;
import br.com.hotel.hotel.persistence.entity.Cliente;
import br.com.hotel.hotel.persistence.entity.Quarto;
import br.com.hotel.hotel.persistence.repository.ClienteRepository;
import br.com.hotel.hotel.persistence.repository.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
        quarto.setTipo(request.getTipo());
        quarto.setValor(request.getValor());
        quarto.setDescricao(request.getDescricao());


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
    public QuartoResponse findQuartoByNumero(int numero) {
        return QuartoMapper.quartoModelToResponseMapper(quartoRepository.findByNumero(numero));
    }

    @Override
    public Void deleteQuarto(String id) {
        quartoRepository.deleteById(id);
        return null;
    }

    @Override
    public ClienteResponse newCliente(ClienteRequest request) {
        Cliente cliente = new Cliente();

        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setEndereco(request.getEndereco());
        cliente.setCidade(request.getCidade());
        cliente.setSituacao("inativo");
        cliente.setQuartoReservado(0);
        cliente.setPagamento(0);


        clienteRepository.save(cliente);

        return ClienteMapper.clienteModelToResponseMapper(cliente);
    }
    @Override
    public ClienteResponse findClienteByCPF(String cpf) {
        return ClienteMapper.clienteModelToResponseMapper(clienteRepository.findByCpf(cpf));

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

    @Override
    public Void deleteCliente(String id) {
        clienteRepository.deleteById(id);
        return null;
    }

    @Override
    public Void checkin(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        Quarto quarto = quartoRepository.findByNumero(cliente.getQuartoReservado());

        cliente.setSituacao("Ativo");
        quarto.setSituacao("Ocupado");

        clienteRepository.save(cliente);
        quartoRepository.save(quarto);

        return null;
    }

    @Override
    public Void checkout(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        Quarto quarto = quartoRepository.findByNumero(cliente.getQuartoReservado());

        cliente.setSituacao("Inativo");
        cliente.setQuartoReservado(0);
        cliente.setCheckin(null);
        cliente.setCheckout(null);
        quarto.setSituacao("Livre");

        clienteRepository.save(cliente);
        quartoRepository.save(quarto);

        return null;
    }

    public ClienteResponse reservar(ReservaRequest request) {
        System.out.println(calcularDiferencaDias(request.getChekin(), request.getChekout()));
        Cliente cliente = clienteRepository.findByCpf(request.getCpf());
        Quarto quarto = quartoRepository.findByNumero(request.getQuarto());
        cliente.setQuartoReservado(request.getQuarto());
        cliente.setCheckin(request.getChekin());
        cliente.setCheckout(request.getChekout());
        cliente.setPagamento(calcularDiferencaDias(request.getChekin(), request.getChekout()) * quarto.getValor());

        clienteRepository.save(cliente);
        return ClienteMapper.clienteModelToResponseMapper(cliente);
    }

    public void pagarHotel(String cpf){
        Cliente cliente = clienteRepository.findByCpf(cpf);
                cliente.setPagamento(0);
                clienteRepository.save(cliente);

    }
        public static long calcularDiferencaDias(LocalDate dataInicio, LocalDate dataFim) {
            long diferencaDias = ChronoUnit.DAYS.between(dataInicio, dataFim);

            return diferencaDias;
        }

}
