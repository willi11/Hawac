/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.presentation.controller;

/**
 *
 * @author William
 */
import javax.swing.JOptionPane;
import tienda.Application;
import tienda.entities.Usuario;
import tienda.logic.model.Model;
import tienda.presentation.model.UserModel;
import tienda.presentation.view.UsuarioView;

/**
 *
 * @author William
 */
public class UserController {

    UsuarioView view;
    UserModel model;
    Model logicModel = new Model();

    public UserController(UsuarioView view, UserModel model) {
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void buscar() {
        String id = view.UsuarioTex.getText();
        Usuario row = logicModel.getUsuario(id);
       
        if (id.isEmpty()) {
            view.Usuariolbl.setBorder(Application.BORDER_ERROR);
            if (!view.Contraseña.getText().isEmpty()) {
                view.Contrasenalbl.setBorder(Application.BORDER_NOBORDER);
                return;
            }
        } else {
            view.Usuariolbl.setBorder(Application.BORDER_NOBORDER);
        }
        if (view.Contraseña.getText().isEmpty()) {
            view.Contrasenalbl.setBorder(Application.BORDER_ERROR);
            return;
        } else {
            view.Contrasenalbl.setBorder(Application.BORDER_NOBORDER);
        }
        if (row == null) {
            JOptionPane.showMessageDialog(view, "Usuario y ó contraseña incorrecta");
        } else if (!row.getContraseña().equals(String.valueOf(view.Contraseña.getPassword()))) {
            System.out.println("contraseña bd " + row.getContraseña() + " contraseña usuario " + view.Contraseña.getText());
            JOptionPane.showMessageDialog(view, "contraseña incorrecta");
        } else {
            if(row.getTipo().equals("normal")){
                Application.HOME.usuarioBt.setVisible(false);
            }
            else{
                Application.HOME.usuarioBt.setVisible(true);
            }
            Application.HOME.setVisible(true);
            //Application.HOME.setBienvenidaLabel("BIENVENIDO " + view.UsuarioTex.getText());
            //Application.HOME.setTipo(row.getTipo());
            System.out.println("TIPOOOOO : "+row.getTipo());
            view.setVisible(false);
        }
    }

    public void guardar() {
        /*
        Cliente nueva = new Cliente();
        model.clearErrors();
        
        nueva.setId(view.idFld.getText());
        if (view.idFld.getText().length()==0){
            model.getErrores().put("id", "Id requerido");
        }
        else if (!isNumeric(view.idFld.getText())) {
            model.getErrores().put("id", "La identificación debe ser numeral");
        }else if(!logicModel.existeCliente(view.idFld.getText()).isEmpty()) {
            model.getErrores().put("id", "El cliente existe, digite una nueva identificación ");
        } else {
            int n = Integer.parseInt(view.idFld.getText());
            if (n < 0) {
                model.getErrores().put("id", "Id requerido");
            }
        }
        
        nueva.setNombre(view.nombreFld.getText());
        if (view.nombreFld.getText().length()==0){
            model.getErrores().put("nombre", "Nombre requerido");
        }
        nueva.setPrimerApellido(view.apellido1Fld.getText());
        if (view.apellido1Fld.getText().length()==0){
            model.getErrores().put("primer apellido", "Primer apellido requerido");
        }
        nueva.setSegundoApellido(view.apellido2Fld.getText());
        if (view.apellido2Fld.getText().length()==0){
            model.getErrores().put("segundo apellido", "Segundo apellido requerido");
        }
        nueva.setDireccion(view.direccionFld.getText());
        if (view.direccionFld.getText().length()==0){
            model.getErrores().put("direccion", "Dirección requerida");
        }
        nueva.setTelefono(view.telefonoFld.getText());
        if (view.telefonoFld.getText().length()==0){
            model.getErrores().put("telefono", "Teléfono requerido");
        }
        
        if (model.getErrores().isEmpty()){
            try{
                switch(model.getModo()){
                    case Application.MODO_AGREGAR:
                        logicModel.addCliente(nueva);
                        model.setMensaje("CLIENTE AGREGADO");
                        model.setClienteCurrent(new Cliente());
                        List<Cliente> rowsAgr = logicModel.searchClientes(model.getFiltro());
                        model.setClientes(rowsAgr);                        
                        break;
                    case Application.MODO_EDITAR:
                        logicModel.updateCliente(nueva);
                        model.setMensaje("CLIENTE MODIFICADO");
                       // model.setClienteCurrent(nueva);
                        model.setClienteCurrent(new Cliente());
                        model.setModo(Application.MODO_AGREGAR);
                        List<Cliente> rowsMod = logicModel.searchClientes(model.getFiltro());
                        model.setClientes(rowsMod);
                        view.setVisible(false);
                        break;
                }
            }
            catch(Exception e){
                model.getErrores().put("id", "Cliente ya existe");
                model.setMensaje("CLIENTE YA EXISTE");
                model.setClienteCurrent(nueva);
            }
        }
        else{
            model.setMensaje("HAY ERRORES ...");
            model.setClienteCurrent(nueva);
        }
         */
    }

    public boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

