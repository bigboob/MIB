/**
 * Copyright (C) 2014  MIB Group 
 */
package pt.ua.MIB.sdk;

import pt.ua.MIB.sdk.settings.ConfigurationHolder;
import net.xeoh.plugins.base.Plugin;

/** Class interface representing a generic plugin.
 * <p>
 * These plugins can have an initialization process, and can be enabled or disabled by the system.
 * Furthermore, every plugin must have a name, so that MIB can address it and control it. No further
 * assumptions are made here regarding functionality. Any other more specific functionality must be defined
 * as a class inheriting from this one.</p>
 * 
 * @author Frederico Valente
 * @author Luís A. Bastião Silva <bastiao@ua.pt>
 */
public interface MIBPlugin extends Plugin {
    
    /**
     * Obtains the unique name of plugin. 
     * A plugin must have a name to serve as an ID, and this is the method from where it is retrieved. This
     * name must never change.
     * 
     * @return the name of the plugin
     */
    public String getName();
    
    /**
     * Issues the plugin to become enabled. It is expected that an enabled plugin, once configured, is ready
     * to perform its main tasks.
     * 
     * @return whether the plugin was successfully enabled
     */
    public boolean enable();
    
    /**
     * Issues the plugin to become disabled. When called, the plugin is responsible
     * for stopping all services that the plugin is running. 
     * @return whether the plugin was successfully disabled
     */
    public boolean disable();
    
    
    /**
     * Verifies if the plugin is enabled.
     *
     * @return whether the plugin is enabled
     */
    public boolean isEnabled();

    /** Sets the settings of this plugin.
     * This method lets the plugin receive its settings from the core MIB system.
     * 
     * @param settings the parameters that will be used by the plugin
     */
    public void setSettings(ConfigurationHolder settings);
    
    /**
     * Obtains access to the settings of the plugin.
     * @return the plugin's settings
     */
    public ConfigurationHolder getSettings();
}
