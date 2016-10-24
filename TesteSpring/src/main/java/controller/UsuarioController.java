/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.UsuarioImpl;
import model.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Joao_Jardim
 */
@Controller
public class UsuarioController {
    
    private UsuarioImpl usuarioImpl;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap model) {
        model.addAttribute("user", new Usuario());
        return "users";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
 
        usuarioImpl.cadastrar(usuario);
 
        return "redirect:/";
    }
 
    @RequestMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        usuarioImpl.deletar(userId);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public @ResponseBody String listUsersJson(ModelMap model) throws JSONException {
    JSONArray userArray = new JSONArray();
    for (Usuario usuario : usuarioImpl.listar(model)) {
        JSONObject userJSON = new JSONObject();
        userJSON.put("id", usuario.getId());
        userJSON.put("firstName", usuario.getClassificacao());
        userJSON.put("lastName", usuario.getNome());
        userJSON.put("email", usuario.getEmail());
        userArray.put(userJSON);
    }
    return userArray.toString();
}   
}
