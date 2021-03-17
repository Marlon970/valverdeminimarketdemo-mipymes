package miimarketdemo.api.soap.auditoria;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import examen_valverde.model.component.entities.AudBitacora;
import mueblespruebavalverde.model.auditoria.manager.ManagerAuditoria;

@WebService(serviceName = "ServiceSoapAuditoria")

public class ServiceSoapAuditoria {
	
	@EJB
	private ManagerAuditoria mAuditoria;
	
	
	
	
	

}
