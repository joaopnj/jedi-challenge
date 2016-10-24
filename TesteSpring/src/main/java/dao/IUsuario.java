/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Usuario;

/**
 *
 * @author Joao_Jardim
 */
public interface IUsuario {
    void cadastrar(Usuario usuario);
    List listar(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(Long id);
}
