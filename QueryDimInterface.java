/**
 * Copyright (C) 2014  MIB Group 
 */
package pt.ua.MIB.sdk;


import pt.ua.MIB.sdk.datastructs.SearchResult;
import pt.ua.MIB.sdk.datastructs.dim.*;
import pt.ua.MIB.sdk.utils.QueryException;

/**
 *
 * Query Interface provides methods to query at different levels in DICOM Information Model.
 *
 * Created by bastiao on 02-02-2017.
 */
public interface QueryDimInterface extends QueryInterface {




    /**
     * Performs a search on the database.
     *
     * The consumer of the results would either request an iterator or use a for-each loop. The underlying
     * iterator implementation can be redefined to wait for more results at the caller. Furthermore, the
     * resulting iterable is expected to be traversed only once.
     *
     * @param query a string describing the query. The underlying plugin is currently free to follow any
     * query format, but only those based on Lucene with work with the search user interface.
     * @param parameters A variable list of parameters of the query. The plugin can use them to establish
     * their own API's, which may require more complex data structures (e.g. images).
     *
     * @return the results of the query as a (possibly lazy) iterable with <b>Patient</b>
     */
    public Iterable<? extends PatientInterface> queryPatient(String query, Object ... parameters) throws QueryException;

    /**
     *
     * Performs a search on the database.
     *
     * @param query a string describing the query. The underlying plugin is currently free to follow any
     *      * query format
     * @param parameters
     * @return the results of the query as a (possibly lazy) iterable with <b>Study</b>
     */
    public Iterable<? extends StudyInterface> queryStudy(String query, Object ... parameters) throws QueryException;

    /**
     *
     * Performs a search on the database.
     *
     * @param query a string describing the query. The underlying plugin is currently free to follow any
     *      * query format, but only those based on Lucene with work with the search user interface.
     * @param parameters
     * @return the results of the query as a (possibly lazy) iterable with <b>Series</b>
     */
    public Iterable<? extends SeriesInterface> querySeries(String query, Object ... parameters) throws QueryException;

    /**
     *
     * Performs a search on the database.
     *
     * @param query a string describing the query. The underlying plugin is currently free to follow any
     * query format.
     * @param level a level of the query, for instance, Patient, Study, Series or Instance
     * @param parameters A variable list of parameters of the query. The plugin can use them to establish
     * their own API's, which may require more complex data structures (e.g. images).
     * @return the results of the query as a (possibly lazy) iterable
     */
    public Iterable<SearchResult> query(String query, DimLevel level, Object ... parameters) throws QueryException;
    
}
