package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemDAO {
    
    public void loadItems() throws PersistenceException;

    public TipoItem load(int id) throws PersistenceException;
}
