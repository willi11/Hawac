/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import tienda.presentation.controller.AbonoController;
import tienda.presentation.controller.AbonosController;
import tienda.presentation.controller.ApartadoController;
import tienda.presentation.controller.ApartadosController;
import tienda.presentation.controller.ClienteController;
import tienda.presentation.controller.ClientesController;
import tienda.presentation.controller.ProductoController;
import tienda.presentation.controller.ProductosController;
import tienda.presentation.controller.UserController;
import tienda.presentation.controller.UsuarioController;
import tienda.presentation.controller.UsuariosController;
import tienda.presentation.model.AbonoModel;
import tienda.presentation.model.ApartadoModel;
import tienda.presentation.model.ProductoModel;
import tienda.presentation.model.TiendaModel;
import tienda.presentation.model.UserModel;
import tienda.presentation.view.AbonosView;
import tienda.presentation.view.ApartadosView;
import tienda.presentation.view.ClientesView;
import tienda.presentation.view.FormularioAbono;
import tienda.presentation.view.FormularioApartado;
import tienda.presentation.view.FormularioCliente;
import tienda.presentation.view.FormularioProducto;
import tienda.presentation.view.FormularioUsuario;
import tienda.presentation.view.Home;
import tienda.presentation.view.ProductosView;
import tienda.presentation.view.UsuarioView;
import tienda.presentation.view.UsuariosView;

/**
 *
 * @author Marco
 */
public class Application {
    public static void main(String[] args) {
      // Model=new ModelProxy();
        //Model=new Model();

//        try {
//            UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
//        } catch (ClassNotFoundException | InstantiationException |
//                IllegalAccessException | UnsupportedLookAndFeelException e) {
//            System.out.println(e);
//        }
        UserModel modeluser=new UserModel();
        UsuarioView usuario=new UsuarioView();
        USUARIO_VIEW=usuario;
        usuario.setVisible(true);
        UserController contuser =new UserController(usuario,modeluser); 
        
        
        Home homeView = new Home();
        HOME=homeView;
        
        
        //---------------CLIENTE---------CLIENTES------------
        
        TiendaModel tiendaModel = new TiendaModel();
        ClientesView clientesView = new ClientesView(homeView, true);
        CLIENTES_VIEW = clientesView;
        ClientesController clientescontroller = new ClientesController(clientesView, tiendaModel);
        //----------------------------------------------------------------------------------------
        FormularioCliente clienteView = new FormularioCliente(homeView, true);
        CLIENTE_VIEW = clienteView;
        ClienteController clienteController = new ClienteController(clienteView, tiendaModel);
        
        //-------------------------PRODUCTOS-------------------------------------
        ProductoModel productoModel = new ProductoModel();
        ProductosView productosView = new ProductosView(homeView, true);
        PRODUCTOS_VIEW = productosView;
        ProductosController productoscontroller = new ProductosController(productosView, productoModel);
        
         //----------------------------------------------------------------------------------------
        FormularioProducto productoView= new FormularioProducto(homeView,true);
        PRODUCTO_VIEW=productoView;
        ProductoController productoController=new ProductoController(productoView,productoModel);
        //--------------------------APARTADO-----APARTADOS--------------------------------
        ApartadoModel apartadoModel = new ApartadoModel();
        ApartadosView apartadosView = new ApartadosView(homeView,true);
        APARTADOS_VIEW = apartadosView;
        ApartadosController apartadosController = new ApartadosController(apartadosView,apartadoModel);
         //----------------------------------------------------------------------------------------
        
        FormularioApartado apartadoView = new FormularioApartado(homeView, true);
        APARTADO_VIEW = apartadoView;
        ApartadoController apartadoController = new ApartadoController(apartadoView, apartadoModel);
        
        // --------------------------- Abono -----------------------------------------
        AbonoModel abonoModel = new AbonoModel();
        FormularioAbono abonoView  = new FormularioAbono(homeView, true);
        FORMULARIO_ABONO = abonoView;
        AbonoController abonoController = new AbonoController(abonoView, abonoModel);
      
        AbonosView abonosView = new AbonosView(homeView, true);
        ABONOS_VIEW = abonosView;
        AbonosController abonosController = new AbonosController(abonosView, abonoModel);
        
        
        FormularioUsuario fusuario=new FormularioUsuario(homeView, true);
        FUSUARIO_VIEW=fusuario;
        UsuarioController fusuariocontroller=new UsuarioController(fusuario,modeluser);
        
        UsuariosView usuarios= new UsuariosView(homeView,true);
        USUARIOS_VIEW=usuarios;
        UsuariosController usuarioscontroller=new UsuariosController(usuarios,modeluser);
    }
    
    
    public static ClientesView CLIENTES_VIEW; 
    public static FormularioCliente CLIENTE_VIEW;
    public static ProductosView PRODUCTOS_VIEW;
    public static FormularioProducto PRODUCTO_VIEW;
    public static ApartadosView APARTADOS_VIEW;
    public static FormularioApartado APARTADO_VIEW; 
    public static FormularioAbono FORMULARIO_ABONO;
    public static AbonosView ABONOS_VIEW;
    public static Home HOME;
    public static UsuarioView USUARIO_VIEW;
    public static FormularioUsuario FUSUARIO_VIEW;
    public static UsuariosView USUARIOS_VIEW;
       
    public static  final int  MODO_AGREGAR=0;
    public static final int MODO_EDITAR=1;
    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);
    
    //public static IModel Model;
}
