/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agendadecontatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Aluna(As): Ryanne Soares Pereira e Daniele da Silva Santos;
 * 2º B Informática
 */
public class Conexao {
    public static Connection conectar() {
        Connection conexao = null;
        try{
            String Url = "jdbc:mysql://localhost:3306/agenda_de_contatos";
            String user = "root";
            String password = "Ryanne123";
            
            conexao = DriverManager.getConnection(Url, user, password);
            System.out.println("Conectado com Sucesso");
            
        } catch (SQLException e){
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return conexao;
            
            
        }
    }

