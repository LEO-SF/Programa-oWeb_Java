package dao;

public enum EnumSQL {

    //ENUMSQL PARA CLIENTE
    INSERT_CLIENTE("insert into cliente(nome, endereco) values (?, ?)"),
    LISTALL_CLIENTE("select * from cliente"),
    UPDATE_CLIENTE("update cliente set nome=?, endereco=? where idpessoa=?"),
    DELETE_CLIENTE("delete from cliente where idclientepf=? "),
    FIND_BY_ID_CLIENTE("select * from cliente where idpessoa=?"),

    //ENUM SQL PARA CLIENTE_PF
    DELETE_CLIENTEPF("delete from clientepf where idclientepf=? "),
    INSERT_CLIENTEPF("insert into clientepf(nome, endereco, telefone, cpf) values (?, ?, ?, ?)"),
    LISTALL_CLIENTEPF("select * from clientepf"),
    FIND_BY_CPF("select * from clientepf where cpf= ?"),
    FIND_BY_ID_CLIENTEPF("select * from clientepf where idpessoa=?"),
    UPDATE_CLIENTEPF("update clientepf set nome=?, endereco=? where idpessoa=?"),
    DELETE_CLIENTE_NOME("delete from clientepf where nome=? ");

    private final String sql;
    EnumSQL(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }    
}

