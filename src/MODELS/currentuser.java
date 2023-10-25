/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

/**
 *
 * @author Dorra
 */
public class currentuser {
    private static int  iduser;

    public currentuser() {
    }

    public static int getIduser() {
        return iduser;
    }

    public static void setIduser(int iduser) {
        currentuser.iduser = iduser;
    }

}
