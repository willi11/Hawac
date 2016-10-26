/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.logic.model;



import encryptserver.IEncrypt;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.database.Database;
import tienda.entities.Abono;
import tienda.entities.Apartado;
import tienda.entities.Cliente;
import tienda.entities.PagoCheque;
import tienda.entities.PagoEfectivo;
import tienda.entities.PagoTarjeta;
import tienda.entities.Producto;
import tienda.entities.Usuario;

/**
 *
 * @author Marco
 */
public class Model{
    IEncrypt proxy = new encryptserver.Model();
    private Database db;

    public Model() {
        this.db = new Database(null, null, null);
    }
    // ------------------Usuario-----------------
    public Usuario getUsuario(String id) {
        try {
            Usuario c = new Usuario();
            String st = "select * from usuario where nombre = '%s'";
            st = String.format(st, id);

            ResultSet rs = db.executeQuery(st);
            if (rs.next()) {
                c = returnUsuario(rs);
                return c;
            }
        } catch (Exception e) {
            System.out.println("getusuario");
            return null;
        }
        return null;
    }

    private Usuario returnUsuario(ResultSet rs) {

        Usuario c = new Usuario();
        try {
            System.out.println("nooombre " + rs.getString("nombre"));
            c.setNombre(rs.getString("nombre"));
            c.setContraseña(rs.getString("contraseña"));
            c.setTipo(rs.getString("tipo"));
            return c;
        } catch (SQLException ex) {
            c = null;
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return c;
        }
    }
    public void addUsuario(Usuario usuario) throws Exception {
        boolean a;
        //if ("A".equals(usuario.getTipo())) {
        //    System.out.println("Entre en admin");
        //    a = false;
        //} else {
        //    System.out.println("No entre en admin");
        //    a = true;
        //}
         
        String st = "insert into usuario(nombre,contraseña,tipo" + ") values ('" + usuario.getNombre()+ "','" + usuario.getContraseña()+ "','" + usuario.getTipo()+"')";
         //String st = "insert into usuario(nombre,contraseña,tipo) values ('Angel','angel','super')";
        System.out.println("orden " + st);
       // st = String.format(st, usuario.getNombre(), usuario.getContraseña(), a, usuario.getTipo());
        System.out.println(st); 
       //String st = "insert into producto(idProducto,color,talla,valor,genero,cantidad,descripcion) values ('cam','neg','s','20',1,98,'viva saprissa' )";
        System.out.print(st);
        int op = db.executeUpdate(st);
        if (op == 0) {
            throw new Exception("Usuario ya existe");
        } else {
            System.out.println("Se agregó Usuario");
        }
    }
    public  List<Usuario> searchUsuarios(Usuario filtro) {
        List<Usuario> resultado;
        resultado = new ArrayList<Usuario>();
        try {

             String sql= "SELECT * FROM usuario WHERE nombre LIKE '%%%s%%'";
            sql = String.format(sql, filtro.getNombre());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnUsuario(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
    public void updateUsuario(Usuario cliente) throws Exception {
        String aux = "select * from usuario where nombre = '%s'";
        aux = String.format(aux, cliente.getNombre());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Usuario no existe");
        } else {
            String sql = "update "
                    + "usuario set contraseña= '%s'"
                    + ", tipo= '%s'"
                    + " where nombre = '%s'";
            sql = String.format(sql, cliente.getContraseña(),cliente.getTipo(),
                    cliente.getNombre());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("Usuario no existe");
            }
        }
    }
    public void deleteUsuario(Usuario c) throws Exception {
        String aux = "select * from usuario where nombre = '%s'";
        aux = String.format(aux, c.getNombre());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Usuario no existe");
        } else {
            String sql = "delete from usuario where nombre = '%s'";
            sql = String.format(sql, c.getNombre());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("No se pudo eliminar al Usuario");
                
            }
        }
    }
    //----------------Cliente----------------------
    public  List<Cliente> searchClientesId(Cliente filtro) {
        List<Cliente> resultado;
        resultado = new ArrayList<Cliente>();
        try {

             String sql= "SELECT * FROM clientes WHERE id_cliente LIKE '%%%s%%'";
            sql = String.format(sql, filtro.getId());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnCliente(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
    public  List<Cliente> searchClientes(Cliente filtro) {
        List<Cliente> resultado;
        resultado = new ArrayList<Cliente>();
        try {

             String sql= "SELECT * FROM clientes WHERE nombre_cliente LIKE '%%%s%%'";
            sql = String.format(sql, filtro.getNombre());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnCliente(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }

    public void updateCliente(Cliente cliente) throws Exception {
        String aux = "select * from clientes where id_cliente = '%s'";
        aux = String.format(aux, cliente.getId());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Cliente no existe");
        } else {
            String sql = "update "
                    + "clientes set nombre_cliente= '%s'"
                    + ", apellido1_cliente= '%s'"
                    + ", apellido2_cliente= '%s'"
                    + ", direccion_cliente= '%s'"
                    + ", telefono_cliente= '%s'"
                    + " where id_cliente = '%s'";
            sql = String.format(sql, cliente.getNombre(),cliente.getPrimerApellido(),
                    cliente.getSegundoApellido(),cliente.getDireccion(),
                    cliente.getTelefono(),cliente.getId());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("Cliente no existe");
            }
        }
    }
    public  List<Cliente> existeCliente(String id) {
        List<Cliente> resultado;
        resultado = new ArrayList<Cliente>();
        try {
             String sql= "SELECT * FROM clientes WHERE id_cliente = '%s'";
            sql = String.format(sql, id);
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnCliente(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
     
    public Cliente getCliente(String id) throws Exception{
        Cliente c = new Cliente();
        String st = "select * from clientes where id_cliente = '%s'";
        st = String.format(st,id);
        ResultSet rs = db.executeQuery(st);
        if (rs != null){
            c = returnCliente(rs);
            return c;
        } else 
            return null;
    }
    
    private Cliente returnCliente(ResultSet rs){
        Cliente c = new Cliente();
        try {
            
            c.setId(rs.getString("id_cliente"));
            c.setDireccion(rs.getString("direccion_cliente"));
            c.setNombre(rs.getString("nombre_cliente"));
            c.setPrimerApellido(rs.getString("apellido1_cliente"));
            c.setSegundoApellido(rs.getString("apellido2_cliente"));
            c.setTelefono(rs.getString("telefono_cliente"));
            return c;
        } catch (SQLException ex) {
            c = null;
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return c;
        }
    }
    
    
    public void deleteCliente(Cliente c) throws Exception {
        String aux = "select * from clientes where id_cliente = '%s'";
        aux = String.format(aux, c.getId());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Cliente no existe");
        } else {
            String sql = "delete from clientes where id_cliente = '%s'";
            sql = String.format(sql, c.getId());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("No se pudo eliminar al Cliente");
                
            }
        }
    }
    
     
    public void addCliente(Cliente c) throws Exception {
        String st = "insert into clientes (id_cliente,nombre_cliente,apellido1_cliente,apellido2_cliente,"
                + "direccion_cliente,telefono_cliente)values('%s', '%s', '%s', '%s', '%s', '%s')";
        st = String.format(st, c.getId(), c.getNombre(), c.getPrimerApellido(),
                c.getSegundoApellido(), c.getDireccion(), c.getTelefono());
        int op = db.executeUpdate(st);
        
        if ( op == 0)
            throw new Exception("Cliente ya existe");
        else 
            System.out.println("Se agregó un cliente");
    }
    
    
     //----------------PRODUCTOS------------------------
    
    public  List<Producto> searchProductos(Producto filtro) {
        List<Producto> resultado;
        resultado = new ArrayList<Producto>();
        try {
            if(filtro.getDescripcion().isEmpty()){

             String sql= "SELECT * FROM productos";
            sql = String.format(sql, filtro.getDescripcion());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnProducto(rs));
            }
            }
            else{
                String sql= "SELECT * FROM productos where codigo like '"+filtro.getDescripcion()+"'";
            //sql = String.format(sql, filtro.getDescripcion());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnProducto(rs));
            }
            }

        } catch (SQLException ex) {}
        return resultado;
    }

    public void updateProducto(Producto producto) throws Exception {
        String aux = "select * from productos where codigo = '%s'";
        aux = String.format(aux, producto.getId());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Producto no existe");
        } else {
            String sql = "update "
                    + "productos set valor= '%s' where codigo = '%s'";
            sql = String.format(sql, producto.getValor(),producto.getId());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("Producto no existe");
            }
        }
    }
    public Producto getProducto(String id) throws Exception{
        Producto c = new Producto();
        String st = "select * from productos where codigo = '%s'";
        st = String.format(st, id);
        ResultSet rs = db.executeQuery(st);
        if (rs.next()){
            c = returnProducto(rs);
            return c;
        } else 
            return null;
    }
    
    public Producto returnProducto(ResultSet rs) {

        Producto c = new Producto();
        try {
            c.setId(rs.getString("codigo"));
            c.setTalla(rs.getString("talla"));
            c.setColor(rs.getString("color"));
            c.setDescripcion(rs.getString("descrippcion"));
            c.setGenero(rs.getString("genero"));
            c.setValor(Integer.parseInt(rs.getString("valor")));
            c.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            
            return c;
        } catch (SQLException ex) {
            c = null;
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return c;
        }
    }
    
    
    public void deleteProducto(Producto c) throws Exception {
        String aux = "select * from productos where codigo = '%s'";
        aux = String.format(aux, c.getId());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Producto no existe");
        } else {
            String sql = "delete from productos where codigo = '%s'";
            sql = String.format(sql, c.getId());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("No se pudo eliminar al Producto");
                
            }
        }
    }
     
    public void addProducto(Producto c) throws Exception {
        boolean a;
        String st = "insert into productos(codigo,talla,color,descrippcion,genero,valor,cantidad"
                + ")values('%s', '%s', '%s', '%s','%s','" + c.getValor() + "','" + c.getCantidad() + "')";
        // String st = "insert into usuario(nombre,contraseña,tipo) values ('Angel','angel','super')";
        st = String.format(st, c.getId(),c.getColor(), c.getTalla(), c.getDescripcion(), c.getGenero());
        //String st = "insert into producto(idProducto,color,talla,valor,genero,cantidad,descripcion) values ('cam','neg','s','20',1,98,'viva saprissa' )";
        System.out.print(st);
        int op = db.executeUpdate(st);
        if (op == 0) {
            throw new Exception("Camisa ya existe");
        } else {
            System.out.println("Se agregó camisa");
        }
    }
    
    //----------------APARTADOS------------------------
     public  List<Apartado> searchApartados(Apartado filtro) {
        List<Apartado> resultado;
        resultado = new ArrayList<Apartado>();
        try {

             String sql= "SELECT * FROM Apartados WHERE id_cliente LIKE '%%%s%%'";
            sql = String.format(sql, filtro.getId_cliente());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnApartado(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
     public  List<Apartado> searchApartadosId(Apartado filtro) {
        List<Apartado> resultado;
        resultado = new ArrayList<Apartado>();
        try {

             String sql= "SELECT * FROM Apartados WHERE numero_apartado LIKE '%%%s%%'";
            sql = String.format(sql, filtro.getNumeroApartado());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnApartado(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
     public  List<Apartado> searchNumberApartado(Apartado filtro) {
        List<Apartado> resultado;
        resultado = new ArrayList<Apartado>();
        try {

             String sql= "SELECT * FROM Apartados WHERE id_cliente = '%%%s%%'";
            sql = String.format(sql, filtro.getId_cliente());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnApartado(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }

    public void updateApartado(Apartado apartado) throws Exception {
        String aux = "select * from apartados where numero_apartado = '%s'";
        aux = String.format(aux, apartado.getNumeroApartado());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Apartado no existe");
        } else {
          
            String sql = "update "
                    + "apartados set descripcion= '%s'"
                    + ", monto= '%s', fecha_realizado = '%s', fecha_maxima = '%s',"
                    + "id_cliente = '%s' where numero_apartado = '%s'";
            sql = String.format(sql, apartado.getDescripcion(),
                    apartado.getMonto(),apartado.getFechaRealizado(),
                    apartado.getFechaMaximaRetiro(),
                    apartado.getId_cliente(),apartado.getNumeroApartado());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("Apartado no existe");
            }
        }
    }
   
    public void deleteApartado(Apartado c) throws Exception {
        String aux = "select * from apartados where numero_apartado = '%s'";
        aux = String.format(aux, c.getNumeroApartado());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Apartado no existe");
        } else {
            String sql = "delete from apartados where numero_apartado = '%s'";
            sql = String.format(sql, c.getNumeroApartado());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("No se pudo eliminar al Apartado");
                
            }
        }
    }
     
    public int addApartado(Apartado c) throws Exception {
        String st = "insert into Apartados (descripcion,monto,fecha_realizado,fecha_maxima, id_cliente)values('%s', '%s', '%s', '%s', '%s')";
        st = String.format(st, c.getDescripcion(),c.getMonto(), c.getFechaRealizado(), c.getFechaMaximaRetiro(), c.getId_cliente());
        ResultSet rs = db.executeUpdateWithKeys(st);
            rs.next();
            int numero = rs.getInt(1);
        if ( numero == 0)
            throw new Exception("Apartado ya existe");
        else return numero;
    }
      public  List<Apartado> getApartadoCliente(Cliente filtro) {
        List<Apartado> resultado;
        resultado = new ArrayList<Apartado>();
        try {

             String sql= "SELECT * FROM Apartados WHERE id_cliente = '%s'";
            sql = String.format(sql, filtro.getId());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnApartado(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
    public Apartado getApartado(String id) throws Exception{
        Apartado a= new Apartado();
        String st = "select * from apartados where numero_apartado = '%s'";
        st = String.format(st, id);
        ResultSet rs = db.executeQuery(st);
        if (rs != null){
            a = returnApartado(rs);
            return a;
        } else 
            return null;
    }
    private Apartado returnApartado(ResultSet rs){
        Apartado a= new Apartado();
        try {
            
            a.setDescripcion(rs.getString("descripcion"));
            a.setMonto(rs.getString("monto"));
            a.setFechaRealizado(rs.getString("fecha_realizado"));
            a.setFechaMaximaRetiro(rs.getString("fecha_maxima"));
            a.setId_cliente(rs.getString("id_cliente"));
            a.setNumeroApartado(rs.getString("numero_apartado"));
            return a;
        } catch (SQLException ex) {
            a = null;
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return a;
        }
    }
    public Apartado getApartadosAbono(Abono filtro){
        Apartado p=new Apartado();
        List<Apartado> resultado;
        resultado = new ArrayList<Apartado>();
        try {

             String sql= "SELECT * FROM Apartados WHERE numero_apartado = '%s'";
            sql = String.format(sql, filtro.getIdApartado());
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnApartado(rs));
            }

        } catch (SQLException ex) {}
        p=resultado.get(0);
        return p;
    }
    public List<Apartado> apartados(Cliente filtro){
        List<Apartado> resultado;
        resultado = new ArrayList<Apartado>();
        try {
             String sql= "select * from " + 
                    "apartados p inner join clientes e on p.id_cliente= e.id_cliente "+
                    "where p.id_cliente = '%s'";
            sql = String.format(sql, filtro.getId());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnApartado(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
    
   //----------------ABONOS------------------------
    public void deleteAbono(Apartado c) throws Exception {
        
            String aux = "select * from abonos where numero_apartado = '%s'";
            aux = String.format(aux, c.getNumeroApartado());
            ResultSet rs = db.executeQuery(aux);
           // while (rs.next()) {
              //  String sql = "delete from abonos where numero_apartado = '%s'";
           // }
            if (rs == null) {
            throw new Exception("Apartado no existe");
        } else {
            String sql = "delete from abonos where numero_apartado = '%s'";
            sql = String.format(sql, c.getNumeroApartado());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("No se pudo eliminar al Abono");
                
            }
        }
    }
    public List<Abono> abonos(Apartado filtro){
        List<Abono> resultado;
        resultado = new ArrayList<Abono>();
        try {
             String sql= "select * from " + 
                    "abonos p inner join apartados e on p.numero_apartado= e.numero_apartado "+
                    "where p.numero_apartado = '%s'";
            sql = String.format(sql, filtro.getNumeroApartado());
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnAbono(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }
     public  List<Abono> searchAbonos(String apartado) {
        List<Abono> resultado;
        resultado = new ArrayList<Abono>();
        try {

             String sql= "SELECT * FROM abonos WHERE numero_apartado LIKE '%%%s%%'";
            sql = String.format(sql, apartado);
            
            ResultSet rs = db.executeQuery(sql);
            while (rs.next()) {
                resultado.add(returnAbono(rs));
            }

        } catch (SQLException ex) {}
        return resultado;
    }

    public void updateAbono(Abono abono) throws Exception {
        String aux = "select * from abonos where numero_abono = '%s'";
        aux = String.format(aux, abono.getBoxNumber());
        ResultSet rs = db.executeQuery(aux);
        if (rs == null) {
            throw new Exception("Abono no existe");
        } else {
          
            String sql = "update "
                    + "abonos set monto= '%s'where numero_abono = '%s'";
            sql = String.format(sql, abono.getMount(),abono.getBoxNumber());
            int count = db.executeUpdate(sql);
            if (count == 0) {
                throw new Exception("Abono no existe");
            }
        }
    }
     
    public int addAbono(Abono c) throws Exception {
        String st = "";
        
        if(c instanceof PagoTarjeta){
            PagoTarjeta pt= (PagoTarjeta)c;
            String eC = proxy.encrypt(pt.getCardNumber());
        st = "insert into Abonos (monto,fecha_pago,forma_pago,numero_tarjeta,"
                + "fecha_vencimiento,numero_referencia,numero_apartado)values('%s', '%s', '%s', '%s', '%s', '%s', '%s')";
        st = String.format(st, pt.getMount(),pt.getPayDate(), "PT", eC, pt.getDeadLine(),pt.getReferenceNumber(),pt.getIdApartado());
        
        }
        else if(c instanceof PagoCheque){
            PagoCheque pc= (PagoCheque)c;
            String eC = proxy.encrypt(pc.getCheckNumber());
        st = "insert into Abonos (monto,fecha_pago,forma_pago,siglas_banco,numero_cheque"
                + ",numero_apartado)values('%s', '%s', '%s', '%s', '%s','%s')";
        st = String.format(st,pc.getMount(),pc.getPayDate(), "PC", pc.getBank(), eC,pc.getIdApartado());
        }
        else{
           
            st = "insert into Abonos (monto,fecha_pago,forma_pago"
                + ",numero_apartado)values('%s', '%s', '%s','%s')";
        st = String.format(st, c.getMount(),c.getPayDate(), "PE",c.getIdApartado());
        }
        ResultSet rs = db.executeUpdateWithKeys(st);
        rs.next();
        int numero = rs.getInt(1);
        if ( numero == 0)
            throw new Exception("Abono ya existe");
        else {
            System.out.println("Se agregó un Abono");
            return numero;
        }
        
    }
     
    public Abono getAbono(String id) throws Exception{
        Abono a= new PagoEfectivo();
        String st = "select * from abonos where numero_abono = '%s'";
        st = String.format(st, id);
        ResultSet rs = db.executeQuery(st);
        if (rs != null){
            a = returnAbono(rs);
            return a;
        } else 
            return null;
    }
    private Abono returnAbono(ResultSet rs){
        Abono a= new PagoEfectivo();
        try {
            Integer numero_abono=rs.getInt("numero_abono");
            a.setBoxNumber(numero_abono.toString());
            a.setMount(rs.getString("monto"));
            a.setPayDate(rs.getString("fecha_pago"));
            String tipoPago=rs.getString("forma_pago");
            if(tipoPago.equals("PT")){
                PagoTarjeta pt = new PagoTarjeta();
                String eC = proxy.decrypt(rs.getString("numero_tarjeta"));
                pt.setBoxNumber(a.getBoxNumber());
                pt.setMount(a.getMount());
                pt.setPayDate(a.getPayDate());
                pt.setCardNumber(eC);
                pt.setDeadLine(rs.getString("fecha_vencimiento"));
                pt.setReferenceNumber(rs.getString("numero_referencia"));
                return pt;
            }
            else if(tipoPago.equals("PC")){
                PagoCheque pc = new PagoCheque();
                String eC = proxy.decrypt(rs.getString("numero_cheque"));
                pc.setBoxNumber(a.getBoxNumber());
                pc.setMount(a.getMount());
                pc.setPayDate(a.getPayDate());
                pc.setBank(rs.getString("siglas_banco"));
                pc.setCheckNumber(eC);
                return pc;
            }
            else{
                return a;
            }
        } catch (SQLException ex) {
            a = null;
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            return a;
        }
    }
    
}