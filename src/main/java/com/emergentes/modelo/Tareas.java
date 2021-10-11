
package com.emergentes.modelo;

public class Tareas {
    private int id;
    private String Tarea;
    private String pioridad;
    private String completado;

    public Tareas() {
        this.id=0;
        this.Tarea="";
        this.pioridad="";
        this.completado="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarea() {
        return Tarea;
    }

    public void setTarea(String Tarea) {
        this.Tarea = Tarea;
    }

    public String getPioridad() {
        return pioridad;
    }

    public void setPioridad(String pioridad) {
        this.pioridad = pioridad;
    }

    public String getCompletado() {
        return completado;
    }

    public void setCompletado(String completado) {
        this.completado = completado;
    }


}
