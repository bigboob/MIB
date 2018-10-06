/**
 * Copyright (C) 2014  MIB Group 
 */
package pt.ua.MIB.sdk;

import org.eclipse.jetty.server.handler.HandlerList;

/** Plugin interface for allowing developers to make Jetty-based pluggable web services for MIB.
 *
 * @author Frederico Valente
 * @author Luís A. Bastião Silva <bastiao@ua.pt>
 */
public interface JettyPluginInterface extends MIBPlugin {
    
    /** Obtains the list of handlers to be attached to MIB's web server resource hierarchy.
     * 
     * @return a list of servlet handlers to be attached
     */
    HandlerList getJettyHandlers();
}
