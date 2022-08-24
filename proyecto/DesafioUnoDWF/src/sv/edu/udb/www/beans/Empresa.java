package sv.edu.udb.www.beans;

public class Empresa {
	private String idEmpresa;
	private String nombreEmpresa;
	private String direccionEmpresa;
	private String contactoEmpresa;
	private String telefonoEmpresa;
	private String correoEmpresa;
	private String rubroEmpresa;
	private int comisionEmpresa;
	
	public Empresa() {
		this.idEmpresa="";
		this.nombreEmpresa="";
		this.direccionEmpresa="";
		this.contactoEmpresa="";
		this.telefonoEmpresa="";
		this.correoEmpresa="";
		this.rubroEmpresa="";
		this.comisionEmpresa=0;
	}
	
	public Empresa(String idEmpresa, String nombreEmpresa, String direccionEmpresa, String contactoEmpresa,
			String telefonoEmpresa, String correoEmpresa, String rubroEmpresa, int comisionEmpresa) {
		this.idEmpresa = idEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.contactoEmpresa = contactoEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.rubroEmpresa = rubroEmpresa;
		this.comisionEmpresa = comisionEmpresa;
	}
	
	public Empresa(String nombreEmpresa) {
		this.nombreEmpresa=nombreEmpresa;
	}
	
	public String getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(String idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}
	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}
	public String getContactoEmpresa() {
		return contactoEmpresa;
	}
	public void setContactoEmpresa(String contactoEmpresa) {
		this.contactoEmpresa = contactoEmpresa;
	}
	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}
	public String getCorreoEmpresa() {
		return correoEmpresa;
	}
	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}
	public String getRubroEmpresa() {
		return rubroEmpresa;
	}
	public void setRubroEmpresa(String rubroEmpresa) {
		this.rubroEmpresa = rubroEmpresa;
	}
	public int getComisionEmpresa() {
		return comisionEmpresa;
	}
	public void setComisionEmpresa(int comisionEmpresa) {
		this.comisionEmpresa = comisionEmpresa;
	}
	
	
}
