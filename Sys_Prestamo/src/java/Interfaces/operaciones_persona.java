/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;

/**
 *
 * @author garcia
 * @param <Entidad>
 */
public interface operaciones_persona<Entidad> {
     public int  create(Entidad key);
    public Entidad read(Object key);
    public boolean update(Entidad key);
    public int delete(Object key);
    public List<Entidad> reaDALL();
}
