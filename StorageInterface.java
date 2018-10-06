/**
 * Copyright (C) 2014  MIB Group 
 */
package pt.ua.MIB.sdk;

import java.io.IOException;
import java.net.URI;
import java.util.Objects;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.io.DicomInputStream;

/** Storage plugin interface. These types of plugins provide an abstraction to reading and writing from
 * files or data blobs.
 * 
 * @author Luís A. Bastião Silva <bastiao@ua.pt>
 * @author Frederico Valente
 */
public interface StorageInterface extends MIBPlugin {    
    
    /**
     * Gets the scheme URI of this storage plugin.
     *
     * @see URI
     * @return a string denoting the scheme that this plugin associates to
     */
    public String getScheme();
    
    /**
     * Checks whether the file in the given path can be handled by this storage plugin.
     *
     * @param location a URI containing a scheme to be verified
     * @return true if this storage plugin is in charge of URIs in the given form 
     */
    @Deprecated
    public default boolean handles(URI location) {
        return Objects.equals(this.getScheme(), location.getScheme());
    }
    
    /**
     * Provides a means of iteration over existing objects at a specified location.
     * This method is particularly nice for use in for-each loops.
     * The provided scheme is not relevant at this point, but the developer must avoid calling this method
     * with a path of a different schema.
     * 
     * <pre>for(StorageInputStream dicomObj : storagePlugin.at("file://dataset/")){
     *      System.err.println(dicomObj.getURI());
     * }</pre>
     * 
     * @param location the location to read
     * @param parameters a variable list of extra parameters for the retrieve
     * @return an iterable of storage input streams
     * @see StorageInputStream
     */
    public Iterable<StorageInputStream> at(URI location, Object ... parameters);
    
    /**
     * Stores a DICOM object into the storage.
     *
     * @param dicomObject Object to be Stored
     * @param parameters a variable list of extra parameters for the retrieve
     * @return The URI of the previously stored Object.
     */
    public URI store(DicomObject dicomObject, Object ... parameters);

    /**
     * Stores a new element into the storage.
     *
     * @param inputStream an input stream with the contents to be stored
     * @param parameters a variable list of extra parameters for the retrieve
     * @return the URI of the stored data
     * @throws IOException if an I/O error occurs
     */
    public URI store(DicomInputStream inputStream, Object ... parameters) throws IOException;
    
    /** Removes an element at the given URI.
     * 
     * @param location the URI of the stored data
     */
    public void remove(URI location);
}
