package sv.edu.udb.www.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sv.edu.udb.www.beans.Empresa;
import sv.edu.udb.www.model.EmpresasModel;
import sv.edu.udb.www.utils.Validaciones;

@WebServlet(name = "EmpresasController", urlPatterns = {"/empresas.do"})
public class EmpresasController extends HttpServlet{
	
	ArrayList<String> listaErrores = new ArrayList<>();
	EmpresasModel modelo = new EmpresasModel();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
			 response.setContentType("text/html;charset=UTF-8");
			 try (PrintWriter out = response.getWriter()) {
			 if(request.getParameter("op")==null){
			 listar(request, response);
			 return;
			 }
			 String operacion = request.getParameter("op");

			 switch (operacion) {
			 case "listar":
			 listar(request, response);
			 break;
			 case "nuevo":
			 request.getRequestDispatcher("/empresas/nuevaEmpresa.jsp").forward(request, response);
			 break;
			 case "insertar":
			 insertar(request, response);
			 break;
			 case "obtener":
			 obtener(request, response);
			 break;
			 case "modificar":
			 modificar(request, response);
			 break;
			 case "eliminar":
			 eliminar(request, response);
			 break;
	        }
	   }
  }
	
	@Override
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 processRequest(request, response);
	 }
	
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 throws ServletException, IOException {
	 processRequest(request, response);
	 }
	
	@Override
	 public String getServletInfo() {
	 return "Short description";
	 }
	
	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listaEmpresas", modelo.listaEmpresas());
			request.getRequestDispatcher("/empresas/listaEmpresa.jsp").forward(request, response);
		}catch (SQLException | ServletException | IOException ex) {
			 Logger.getLogger(EmpresasController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaErrores.clear();
			Empresa miEmpresa = new Empresa();
			if(Validaciones.isInteger(request.getParameter("comision"))) {
				listaErrores.add("La comision de la Empresa es Obligatorio");
			}
			miEmpresa.setIdEmpresa(request.getParameter("id"));
			miEmpresa.setNombreEmpresa(request.getParameter("nombre"));
			miEmpresa.setDireccionEmpresa(request.getParameter("direccion"));
			miEmpresa.setContactoEmpresa(request.getParameter("contacto"));
			miEmpresa.setTelefonoEmpresa(request.getParameter("telefono"));
			miEmpresa.setCorreoEmpresa(request.getParameter("correo"));
			miEmpresa.setRubroEmpresa(request.getParameter("rubro"));
			miEmpresa.setComisionEmpresa(Integer.parseInt(request.getParameter("comision")));
			
			if(Validaciones.isEmpty(miEmpresa.getIdEmpresa())) {
				listaErrores.add("El código de la Empresa es Obligatorio");
			}else if(!Validaciones.esCodigoEmpresarial(miEmpresa.getIdEmpresa())) {
				listaErrores.add("El código de la Empresa debe seguir el siguiente formato EOR000");
			}
			if(Validaciones.isEmpty(miEmpresa.getNombreEmpresa())) {
				listaErrores.add("El nombre de la Empresa es Obligatorio");
			}
			if (Validaciones.isEmpty(miEmpresa.getDireccionEmpresa())) {
				listaErrores.add("La dirección de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getContactoEmpresa())) {
				listaErrores.add("El nombre del contacto de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getTelefonoEmpresa())) {
				listaErrores.add("El telefono de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getCorreoEmpresa())) {
				listaErrores.add("El correo electronico de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getRubroEmpresa())) {
				listaErrores.add("El rubro de la Empresa es Obligatorio");
			}
			
			
			if(listaErrores.size() > 0) {
				request.setAttribute("listaErrores", listaErrores);
				request.setAttribute("empresa", miEmpresa);
				request.getRequestDispatcher("empresas.do?op=nuevo").forward(request, response);
			}else {
				if(modelo.insertarEmpresa(miEmpresa) > 0) {
					request.getSession().setAttribute("exito", "Empresa registrada exitosamente");
					response.sendRedirect(request.getContextPath() + "/empresas.do?op=listar");
				}else {
					request.getSession().setAttribute("fracaso", "La empresa no ha sido registrada" + "ya hay un autor con este codigo");
					response.sendRedirect(request.getContextPath() + "/empresas.do?op=listar");
				}
			}
		} catch (IOException | SQLException | ServletException ex) {
			 Logger.getLogger(EmpresasController.class.getName()).log(Level.SEVERE, null, ex);
	}
}
	private void obtener (HttpServletRequest request, HttpServletResponse response) {
		try {
			String id= request.getParameter("id");
			Empresa miEmpresa = modelo.obtenerEmpresa(id);
			if(miEmpresa != null) {
				request.setAttribute("empresa", miEmpresa);
				request.getRequestDispatcher("/empresas/editarEmpresa.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+ "/error404.jsp");
			}
		}catch (SQLException | IOException | ServletException ex) {
			 Logger.getLogger(EmpresasController.class.getName()).log(Level.SEVERE, null, ex);
		 }
}
	
	private void modificar(HttpServletRequest request, HttpServletResponse response) {
		try {
			listaErrores.clear();
			Empresa miEmpresa = new Empresa();
			if(Validaciones.isInteger(request.getParameter("comision"))) {
				listaErrores.add("La comision de la Empresa es Obligatorio");
			}
			
			miEmpresa.setIdEmpresa(request.getParameter("id"));
			miEmpresa.setNombreEmpresa(request.getParameter("nombre"));
			miEmpresa.setDireccionEmpresa(request.getParameter("direccion"));
			miEmpresa.setContactoEmpresa(request.getParameter("contacto"));
			miEmpresa.setTelefonoEmpresa(request.getParameter("telefono"));
			miEmpresa.setCorreoEmpresa(request.getParameter("correo"));
			miEmpresa.setRubroEmpresa(request.getParameter("rubro"));
			miEmpresa.setComisionEmpresa(Integer.parseInt(request.getParameter("comision")));
			
			if(Validaciones.isEmpty(miEmpresa.getIdEmpresa())) {
				listaErrores.add("El código de la Empresa es Obligatorio");
			}else if(!Validaciones.esCodigoEmpresarial(miEmpresa.getIdEmpresa())) {
				listaErrores.add("El código de la Empresa debe seguir el siguiente formato EOR000");
			}
			if(Validaciones.isEmpty(miEmpresa.getNombreEmpresa())) {
				listaErrores.add("El nombre de la Empresa es Obligatorio");
			}
			if (Validaciones.isEmpty(miEmpresa.getDireccionEmpresa())) {
				listaErrores.add("La dirección de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getContactoEmpresa())) {
				listaErrores.add("El nombre del contacto de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getTelefonoEmpresa())) {
				listaErrores.add("El telefono de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getCorreoEmpresa())) {
				listaErrores.add("El correo electronico de la Empresa es Obligatorio");
			}
			if(Validaciones.isEmpty(miEmpresa.getRubroEmpresa())) {
				listaErrores.add("El rubro de la Empresa es Obligatorio");
			}
			if(!Validaciones.esEnteroPositivo(request.getParameter("comision"))) {
				listaErrores.add("La comision de la Empresa es Obligatorio");
			}
			
			if(listaErrores.size() > 0) {
				request.setAttribute("listaErrores", listaErrores);
				request.setAttribute("empresa", miEmpresa);
				request.getRequestDispatcher("empresas.do?op=obtener").forward(request, response);
			}else {
				if(modelo.modificarEmpresa(miEmpresa) > 0) {
					request.getSession().setAttribute("exito", "Empresa modificada exitosamente");
					response.sendRedirect(request.getContextPath() + "/empresas.do?op=listar");
				}else {
					request.getSession().setAttribute("fracaso", "La empresa no ha sido modificada" + "ya hay un autor con este codigo");
					response.sendRedirect(request.getContextPath() + "/empresas.do?op=listar");
				}
			}
		}catch (SQLException | IOException | ServletException ex) {
			 Logger.getLogger(EmpresasController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
		
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id= request.getParameter("id");
			if(modelo.eliminarEmpresa(id)>0) {
				request.setAttribute("exito", "Autor eliminado exitosamente");
			}else {
				request.setAttribute("fracaso", "No se puede eliminar esta empresa");
			}
			request.getRequestDispatcher("/empresas.do?op=listar").forward(request, response);
		}catch (SQLException | ServletException | IOException ex) {
			Logger.getLogger(EmpresasController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	
	
	
	
	
	
	
	
}
