/**
 * Copyright (C) 2014  MIB Group 
 */
package pt.ua.MIB.sdk;

import pt.ua.MIB.sdk.settings.ConfigurationHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.restlet.resource.ServerResource;

import pt.ua.MIB.sdk.core.MIBPlatformInterface;
import pt.ua.MIB.sdk.core.PlatformCommunicatorInterface;

/**
 * @author Luís A. Bastião Silva <bastiao@ua.pt>
 * @author Luís S. Ribeiro
 */
public abstract class PluginBase implements PluginSet, PlatformCommunicatorInterface {
    
	protected List<IndexerInterface> indexPlugins = new ArrayList<>();
    protected List<QueryInterface> queryPlugins = new ArrayList<>();
    protected List<JettyPluginInterface> jettyPlugins = new ArrayList<>();
    protected List<StorageInterface> storagePlugins = new ArrayList<>();
    protected List<ServerResource> services = new ArrayList<>();
    protected ConfigurationHolder settings = null;
    
    protected MIBPlatformInterface platform;
    
    @Override
    public List<IndexerInterface> getIndexPlugins() {
        return indexPlugins;
    }

    @Override
    public List<QueryInterface> getQueryPlugins() {
        return queryPlugins;
    }
   
    @Override
    public List<ServerResource> getRestPlugins() {
        return services;
    }
    
    @Override
    public List<JettyPluginInterface> getJettyPlugins(){
        return jettyPlugins;
    }
      
    @Override
    public abstract String getName();
    
    @Override
    public ConfigurationHolder getSettings(){
        return settings;
    }
    
    @Override
    public void setSettings(ConfigurationHolder xmlSettings){
        settings = xmlSettings;
    }

    @Override
    public Collection<StorageInterface> getStoragePlugins() 
    {
        return storagePlugins;
    }
    
    @Override
	public void setPlatformProxy(MIBPlatformInterface core) {
		this.platform = core;
	}
}
