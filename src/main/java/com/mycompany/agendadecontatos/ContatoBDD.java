/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agendadecontatos;

//Esse Classe aqui vai tipo "conversar" com o banco de dados feito ono MySQL

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryann
 */
public class ContatoBDD {
    public void salvarContato(Contato c){
        String sql = "INSERT INTO agenda_de_contatos (nome, telefone, email) VALUES (?, ?, ?)";
        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEmail());
            
            stmt.executeUpdate();
            
            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println("Erro ao salvar contato: " + e.getMessage());
        }

    }
    public List<Contato> listarContatos() {
    List<Contato> lista = new ArrayList<>();
    String sql = "SELECT * FROM agenda_de_contatos";
    
    try {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()){
            Contato c = new Contato();
            
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            c.setEmail(rs.getString("email"));
            
            lista.add(c);
        }
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        System.out.println("Erro ao listar contatos: " + e.getMessage());
    }
    
    return lista;

}
}




