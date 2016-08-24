/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alum.fial1
 */
public interface Operaciones<Entidad> {

    public boolean create(Entidad e);

    public Entidad read(int key);

    public boolean delete(int key);

    public boolean update(Entidad e);

    public List<Entidad> readall();
}
