/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author louay
 */
public class lessive extends ECOservice{
    private int maintenanceId;
    private String typeProbleme;
    private String instructions;

    public lessive(int maintenanceId, String typeProbleme, String instructions, String type, Utilisateur demandeur) {
        super(type, demandeur);
        this.maintenanceId = maintenanceId;
        this.typeProbleme = typeProbleme;
        this.instructions = instructions;
    }

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public String getTypeProbleme() {
        return typeProbleme;
    }

    public void setTypeProbleme(String typeProbleme) {
        this.typeProbleme = typeProbleme;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "lessive{" + "maintenanceId=" + maintenanceId + ", typeProbleme=" + typeProbleme + ", instructions=" + instructions + '}';
    }
    
}
