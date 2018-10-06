/**
 * Copyright (C) 2018 MIB Group 
 */
package pt.ua.MIB.sdk;

import java.net.URI;
import pt.ua.MIB.sdk.datastructs.Report;
import pt.ua.MIB.sdk.task.Task;

/**
 * Index Interface Plugin. Indexers analyze documents for performing queries. They may index
 * documents by DICOM metadata for instance, but other document processing procedures may be involved.
 *
 * @author Luís A. Bastião Silva <bastiao@ua.pt>
 * @author Frederico Valente <fmvalente@ua.pt>
 */
public interface IndexerInterface extends MIBPlugin {

    /**
     * Indexes the file path to the database. Indexation procedures are asynchronous, and will return
     * immediately after the call. The outcome is a report that can be retrieved from the given task
     * as a future.
     *
     * @param file directory or file to index
     * @return a representation of the asynchronous indexation task
     */
    public Task<Report> index(StorageInputStream file, Object ... parameters);

    /**
     * Indexes multiple file paths to the database. Indexation procedures are asynchronous, and will return
     * immediately after the call. The outcomes are aggregated into a single report and can be retrieved from
     * the given task as a future.
     *
     * @param files a collection of directories and/or files to index
     * @return a representation of the asynchronous indexation task
     */
    public Task<Report> index(Iterable<StorageInputStream> files, Object ... parameters);

    
    /**
     * Checks whether the file in the given path can be indexed by this indexer. The indexer should verify if
     * the file holds compatible content (e.g. a DICOM file). If this method returns false, the file will not
     * be indexed.
     *
     * @param path a URI to the file to check
     * @return whether the indexer can handle the file at the given path
     */
    public default boolean handles(URI path) {
        return true;
    }
    
    /**
     * Removes the indexed file at the given path from the database.
     * 
     * @param path the URI of the document
     * @return whether it was successfully deleted from the database
     */
    public boolean unindex(URI path);
}
