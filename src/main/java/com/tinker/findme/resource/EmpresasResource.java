package com.tinker.findme.resource;

import com.tinker.findme.config.ServiceLocator;
import com.tinker.findme.ejbsessionremote.EmpresasEjbBeanRemote;
import com.tinker.findme.iresource.IEmpresasResource;
import com.tinker.findme.model.Empresas;
import com.tinker.findme.util.SecurityUtil;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author petervs
 */
@Path("/empresas")
public class EmpresasResource implements IEmpresasResource{

    private final ServiceLocator sl;
    
    @Inject
    private SecurityUtil securityUtil;
    
    private final EmpresasEjbBeanRemote ejbEmpresas;

    public EmpresasResource() {
        sl = new ServiceLocator();
        ejbEmpresas = (EmpresasEjbBeanRemote) sl.findServiceRemote("EmpresasEjbBean", EmpresasEjbBeanRemote.class.getName());
    }
    
    @Override
    public List<Empresas> getEmpresasByNombre(String nombre) {
        System.out.println("Clave: "+securityUtil.encodeText("Peter"));
        return ejbEmpresas.getEmpresasByNombre(nombre);
    }
    
}
