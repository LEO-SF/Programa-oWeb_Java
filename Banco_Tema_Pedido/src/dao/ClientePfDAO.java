package dao;

import classes.ClientePF;

import java.sql.*;

public class ClientePfDAO implements OperacoesDAO<ClientePF> {

    public ClientePF pesquisaCPF(String cpf) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt =
                     connection.prepareStatement(EnumSQL.FIND_BY_CPF.getSql())) {
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new ClientePF(
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getString("cpf"),
                        rs.getString("telefone")
                );
            }
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClientePfDAO.java no método pesquisaCPF");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClientepfDAO.java no método pesquisaCPF");
        }
        return null;
    }


    public int deletarNome(String nome) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt =
                     connection.prepareStatement(EnumSQL.DELETE_CLIENTE_NOME.getSql())) {
            stmt.setString(1, nome.toLowerCase());
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClientePfDAO.java no método deletarNome");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClientepfDAO.java no método deletarNome");
        }
        return -1;
    }

    @Override
    public int inserir(ClientePF cli) {
        int chavePrimaria = -1;
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt =
                     connection.prepareStatement(EnumSQL.INSERT_CLIENTEPF.getSql(),
                             Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getEndereco());
            stmt.setString(3, cli.getTelefone());
            stmt.setString(4, cli.getCpf());
            stmt.execute();
            ResultSet chaves = stmt.getGeneratedKeys();
            if (chaves.next()) chavePrimaria = chaves.getInt(1);
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClientePfDAO.java no método inserir");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClientepfDAO.java no método inserir");
            e.printStackTrace();
        }
        return chavePrimaria;
    }

    @Override
    public MinhaGen<ClientePF> listarTodos() {
        MinhaGen<ClientePF> lista = new MinhaGen<>();
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt =
                     connection.prepareStatement(EnumSQL.LISTALL_CLIENTEPF.getSql())) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String cpf = rs.getString("cpf");
                lista.cadastrar(new ClientePF(nome, endereco, telefone, cpf));
            }
            return lista;
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClientePfDAO.java no método listarTodos");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClientepfDAO.java no método listarTodos");
        }
        return null;
    }

    @Override
    public int atualizar(ClientePF cli) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt =
                     connection.prepareStatement(EnumSQL.UPDATE_CLIENTEPF.getSql())) {
            stmt.setString(1, cli.getNome());
            stmt.setString(2, cli.getEndereco());
            stmt.setString(3, cli.getCpf());
            stmt.setString(4, cli.getTelefone());
            stmt.setInt(5, cli.getIdCliente());
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClientePfDAO.java no método atualizar");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClientepfDAO.java no método atualizar");
        }
        return -1;
    }

    @Override
    public int deletar(ClientePF cli) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt =
                     connection.prepareStatement(EnumSQL.DELETE_CLIENTEPF.getSql())) {
            stmt.setInt(1, cli.getIdCliente());
            System.out.println("Conex�o aberta!");
            return stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClientePfDAO.java no método deletar");
            e.printStackTrace();
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClientepfDAO.java no método deletar");
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public ClientePF pesquisarID(int id) {
        ClientePF cli = null;
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt =
                     connection.prepareStatement(EnumSQL.FIND_BY_ID_CLIENTEPF.getSql())) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String CPF = rs.getString("CPF");
                String telefone = rs.getString("telefone");
                cli = new ClientePF(nome, endereco, CPF, telefone);
            }
        }catch(SQLException e){
            System.out.println("Exceção SQL" + e.getMessage() + "\n" + "Verificar classe ClientePfDAO.java no método pesquisarID");
        }catch(Exception e){
            System.out.println("Exceção Classe não encontrada:" + e.getMessage() + "\n" + "Verificar classe ClientepfDAO.java no método pesquisarID");
        }
        return cli;
    }
}
