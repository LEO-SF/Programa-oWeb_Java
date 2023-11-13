package dao;

import classes.Cliente;
import java.sql.*;

public class ClienteDAO implements OperacoesDAO<Cliente> {
    @Override
    public int inserir(Cliente cli) {
        int chavePrimaria = -1;
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt =
                    connection.prepareStatement(EnumSQL.INSERT_CLIENTE.getSql(),
                            Statement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getEndereco());
            stmt.execute();
            ResultSet chaves = stmt.getGeneratedKeys();
            if (chaves.next())  chavePrimaria= chaves.getInt(1);
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método inserir");
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método inserir");
        }
        return chavePrimaria;
    }

    @Override
    public MinhaGen<Cliente> listarTodos() {
        MinhaGen<Cliente> lista = new MinhaGen<>();
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt =
                    connection.prepareStatement(EnumSQL.LISTALL_CLIENTE.getSql())){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                int idpessoa = rs.getInt("idcliente");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                lista.cadastrar(new Cliente(idpessoa, nome, endereco));
            }
            return lista;
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método listarTodos");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método listarTodos");
        }
        return null;
    }

    @Override
    public int atualizar(Cliente cli){
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt =
                    connection.prepareStatement(EnumSQL.UPDATE_CLIENTE.getSql())){
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getEndereco());
            stmt.setInt(3, cli.getIdCliente());
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método atualizar");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método atualizar");
        }
        return -1;
    }
    @Override
    public int deletar(Cliente cli){
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt =
                    connection.prepareStatement(EnumSQL.DELETE_CLIENTE.getSql())){
            stmt.setInt(1, cli.getIdCliente());
            System.out.println("Conex�o aberta!");
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método deletar");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no deletar");
        }
        return -1;
    }

    @Override
    public Cliente pesquisarID(int id){
        Cliente p = null;
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt =
                    connection.prepareStatement(EnumSQL.FIND_BY_ID_CLIENTE.getSql())){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                p=new Cliente(nome, endereco);
            }
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método pesquisarID");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClienteDAO.java no método pesquisarID");
        }
        return p;
    }
}

