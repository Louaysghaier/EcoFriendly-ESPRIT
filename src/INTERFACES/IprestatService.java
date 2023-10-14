/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFACES;

import java.util.List;

/**
 *
 * @author louay
 */

public interface IprestatService<T> {
    
     public void ajouterpre(T t);
    public void modifierpre(T t);
    public void supprimerpre(int id);
   public T getOnepre(int id );
   public List<T> getAllpre() ;
      public  T getPrestataireServById(int id) ;
 
    
}
