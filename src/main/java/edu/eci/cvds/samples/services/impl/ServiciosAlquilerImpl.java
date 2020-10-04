package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import org.mybatis.guice.transactional.Transactional;
import java.sql.Date;
import java.util.List;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

   @Inject
   private ItemDAO itemDAO;
   
   @Inject
   private ClienteDAO clienteDAO;

   @Inject
   private TipoItemDAO tipoItemDAO;

   @Override
   public int valorMultaRetrasoxDia(int itemId) {
       try {
           return (int) itemDAO.load(itemId).getTarifaxDia();
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Override
   public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
       try {
           return clienteDAO.load(docu);
       } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Override
   public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
       try {
           return clienteDAO.loadItemsCliente(idcliente);
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Override
   public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
       try {
            return clienteDAO.loadClientes();
       } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet.");
       }
       
   }

   @Override
   public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
       try {
           return itemDAO.load(id);
       } catch (PersistenceException ex) {
           throw new ExcepcionServiciosAlquiler("Error al consultar el item "+id,ex);
       }
   }

   @Override
   public List<Item> consultarItemsDisponibles() {
       try {
           return itemDAO.consultarItemsDisponibles();
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Override
   public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
       try {
           
       } catch (Exception e) {
           //TODO: handle exception
       }
       throw new UnsupportedOperationException("Not supported yet.");
   }

   @Override
   public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
       try{
        return tipoItemDAO.load(id);
       }
       catch(Exception e){
        throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Override
   public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
       try{
           return tipoItemDAO.loadItems();
       } catch(Exception e){
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Override
   public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
       try {
           /* clienteDAO.saveItemRentadoCliente(id, idit, fechainicio, fechafin); */
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Transactional
   @Override
   public void registrarCliente(Cliente c) throws ExcepcionServiciosAlquiler {
       try {
           clienteDAO.addCliente(c);
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Override
   public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
       try {
           return numdias * itemDAO.load(iditem).getTarifaxDia();
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Transactional
   @Override
   public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
       try {
           itemDAO.actualizarTarifaItem(id, tarifa);
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }

   @Transactional
   @Override
   public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
       try {
           itemDAO.save(i);
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet."); 
       }
   }

   @Transactional
   @Override
   public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
       try {
           clienteDAO.vetarCliente(docu, estado);
       } catch (Exception e) {
           throw new UnsupportedOperationException("Not supported yet.");
       }
   }
}