package com.emergentes.controlador;

import com.emergentes.modelo.Tareas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession ses = request.getSession();
        if(ses.getAttribute("listtar")== null){
            ArrayList<Tareas> listaux=new ArrayList<Tareas>();
            ses.setAttribute("listtar", listaux);
        }
        ArrayList<Tareas> lista= (ArrayList<Tareas>) ses.getAttribute("listtar");
        
        String op =request.getParameter("op");
        String opcion= (op!= null) ? request.getParameter("op") :"view";
        
        Tareas obj1= new Tareas();
        int id,pos;
        
        switch (opcion){
            case "nuevo" : // insertar nuevo registro
                request.setAttribute("mitarea",obj1);
                request.getRequestDispatcher("editar.jsp").forward(request,response);
                break;
                
            case "editar"://modificar registro
                id= Integer.parseInt(request.getParameter("id"));
                pos= buscarIndice(request,id);
                obj1= lista.get(pos);
                request.setAttribute("mitarea", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
              case "eliminar"://modificar registro
                pos= buscarIndice(request,Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listtar", lista);
                response.sendRedirect("index.jsp");
                break;  
              case "view":
              response.sendRedirect("index.jsp");
        }
     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<Tareas> lista= (ArrayList<Tareas>) ses.getAttribute("listtar");
        
        Tareas obj1=new Tareas();
        
      obj1.setId(Integer.parseInt(request.getParameter("id")));
      obj1.setTarea(request.getParameter("tarea"));
      obj1.setPioridad(request.getParameter("pioridad"));
      obj1.setCompletado(request.getParameter("completado"));
      
      int idt = obj1.getId();
      if(idt ==0){
          int ultID;
          ultID =ultimoId(request);
          obj1.setId(ultID);
          lista.add(obj1);
      }else{
          lista.set(buscarIndice(request,idt),obj1);
      }
      ses.setAttribute("listtar",lista);
      response.sendRedirect("index.jsp");

    }

    private int ultimoId(HttpServletRequest request) {
         HttpSession ses = request.getSession();
        ArrayList<Tareas> lista= (ArrayList<Tareas>) ses.getAttribute("listtar");
    int idaux=0;
    
    for (Tareas item : lista){
        idaux = item.getId();
    }
    return idaux + 1;
    }
    
    private int buscarIndice(HttpServletRequest request, int id) {
        HttpSession ses = request.getSession();
        ArrayList<Tareas> lista= (ArrayList<Tareas>) ses.getAttribute("listtar"); //To change body of generated methods, choose Tools | Templates.
    int i =0;
    if(lista.size()>0){
        while(i<lista.size()){
        if(lista.get(i).getId() == id){
            break;
    }else{
            i++;
        }
     }
    }
return i;
   
}
}