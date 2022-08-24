package sv.edu.udb.www.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.edu.udb.www.beans.Empresa;

public class EmpresasModel extends Conexion{
	
	public List<Empresa> listaEmpresas() throws SQLException{
		try {
			List<Empresa> lista= new ArrayList<>();
			String sql= "CALL sp_listarEmpresas()";
			this.conectar();
			cs =conexion.prepareCall(sql);
			rs= cs.executeQuery();
			while(rs.next()) {
				Empresa empresa =new Empresa();
				empresa.setIdEmpresa(rs.getString("Id_Empresa "));
				empresa.setNombreEmpresa(rs.getString("Nombre_Empresa"));
				empresa.setDireccionEmpresa(rs.getString("Dirección_Empresa"));
				empresa.setContactoEmpresa(rs.getString("Contacto_Empresa"));
				empresa.setTelefonoEmpresa(rs.getString("Telefono_Empresa"));
				empresa.setCorreoEmpresa(rs.getString("Correo_Empresa"));
				empresa.setRubroEmpresa(rs.getString("Rubro_Empresa"));
				empresa.setComisionEmpresa(rs.getInt("Comision_Empresa"));
				lista.add(empresa);
			}
			this.desconectar();
			return lista;
		}catch (SQLException ex) {
			Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
			 this.desconectar();
			 return null;
		}
	}
	
	public int insertarEmpresa(Empresa empresa) throws SQLException{
		try {
			int filasAfectadas=0;
			String sql = "CALL sp_insertarEmpresa(?,?,?,?,?,?,?,?)";
			this.conectar();
			cs= conexion.prepareCall(sql);
			cs.setString(1, empresa.getIdEmpresa());
			cs.setString(2, empresa.getNombreEmpresa());
			cs.setString(3, empresa.getDireccionEmpresa());
			cs.setString(4, empresa.getContactoEmpresa());
			cs.setString(5, empresa.getTelefonoEmpresa());
			cs.setString(6, empresa.getCorreoEmpresa());
			cs.setString(7, empresa.getRubroEmpresa());
			cs.setInt(8, empresa.getComisionEmpresa());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			 Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
			 this.desconectar();
			 return 0;
		}
	}
	
	public int eliminarEmpresa(String id) throws SQLException{
		try {
			int filasAfectadas=0;
			String sql = "CALL sp_eliminarEmpresa(?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, id);
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		} catch (SQLException ex) {
			 Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
			 this.desconectar();
			 return 0;
		}
    }
	
	public int modificarEmpresa(Empresa empresa) throws SQLException{
		try {
			int filasAfectadas=0;
			String sql = "CALL sp_insertarEmpresa(?,?,?,?,?,?,?,?)";
			this.conectar();
			cs= conexion.prepareCall(sql);
			cs.setString(1, empresa.getIdEmpresa());
			cs.setString(2, empresa.getNombreEmpresa());
			cs.setString(3, empresa.getDireccionEmpresa());
			cs.setString(4, empresa.getContactoEmpresa());
			cs.setString(5, empresa.getTelefonoEmpresa());
			cs.setString(6, empresa.getCorreoEmpresa());
			cs.setString(7, empresa.getRubroEmpresa());
			cs.setInt(8, empresa.getComisionEmpresa());
			filasAfectadas = cs.executeUpdate();
			this.desconectar();
			return filasAfectadas;
		}catch (SQLException ex) {
			 Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
			 this.desconectar();
			 return 0;
		}
	}
	
	public Empresa obtenerEmpresa(String id) throws SQLException{
		try {
			String sql = "CALL sp_obtenerEmpresa(?)";
			this.conectar();
			cs = conexion.prepareCall(sql);
			cs.setString(1, id);
			rs = cs.executeQuery();
			if(rs.next()) {
				Empresa empresa = new Empresa();
				empresa.setIdEmpresa(rs.getString("Id_Empresa "));
				empresa.setNombreEmpresa(rs.getString("Nombre_Empresa"));
				empresa.setDireccionEmpresa(rs.getString("Dirección_Empresa"));
				empresa.setContactoEmpresa(rs.getString("Contacto_Empresa"));
				empresa.setTelefonoEmpresa(rs.getString("Telefono_Empresa"));
				empresa.setCorreoEmpresa(rs.getString("Correo_Empresa"));
				empresa.setRubroEmpresa(rs.getString("Rubro_Empresa"));
				empresa.setComisionEmpresa(rs.getInt("Comision_Empresa"));
				this.desconectar();
				return empresa;
			}
			this.desconectar();
			return null;
		}catch (SQLException ex) {
			Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
			 this.desconectar();
			 return null;
		}
	}
	
	public int totalEmpresa () throws SQLException{
		try {
			int totalemp=0;
			String sql = "SELECT COUNT(Id_Empresa) as totalemp FROM empresa";
			this.conectar();
			st = conexion.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				totalemp = rs.getInt("totalemp");
			}
			return totalemp;
		}catch (SQLException ex) {
			Logger.getLogger(EmpresasModel.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}finally {
			 this.desconectar();
		}
	}
}

