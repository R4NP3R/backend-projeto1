package javaapplication.dao;

import javaapplication.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class ClienteMapDAO implements IClienteDAO {

    private Map<Long, Cliente> map;


    public ClienteMapDAO(){
        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(Cliente client) {
        if (this.map.containsKey(client.getCpf())) {
            return false;
        }
        this.map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteCadastrado = this.map.get(cpf);

        if (clienteCadastrado != null) {
            this.map.remove(clienteCadastrado.getCpf(), clienteCadastrado);
        }

    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = this.map.get(cliente.getCpf());

        clienteCadastrado.setNome(cliente.getNome());
        clienteCadastrado.setTel(cliente.getTel());
        clienteCadastrado.setNumero(cliente.getNumero());
        clienteCadastrado.setEnd(cliente.getEnd());
        clienteCadastrado.setCidade(cliente.getCidade());
        clienteCadastrado.setEstado(cliente.getEstado());

    }

    @Override
    public Cliente consultar(Long cpf) {

        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
