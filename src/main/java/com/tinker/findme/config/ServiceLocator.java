package com.tinker.findme.config;

/**
 *
 * @author pvasquez
 */
import java.io.Serializable;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator{
	final Hashtable<String, String> jndiProperties = new Hashtable<>();
//	final Hashtable jndiProperties = new Hashtable();
        
	public ServiceLocator(){
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//                jndiProperties.put("jboss.naming.client.ejb.context", true);
	}
	
	public Object findServiceRemote(String nombreBean, String nombreBeanRemoto){
		Object obj=null;
		try {
			Context context = new InitialContext(jndiProperties);
			obj = context.lookup("ejb:/findme-rs-1.0//"+nombreBean+"!"+nombreBeanRemoto);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}