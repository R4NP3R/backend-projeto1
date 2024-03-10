package javaapplication.dao;

import javaapplication.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente client);
    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar(Long cpf);
    public Collection<Cliente> buscarTodos();
}
