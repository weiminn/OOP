package com.smuxoopg1t2.repository;

import com.smuxoopg1t2.model.Vessel;
import com.smuxoopg1t2.model.VesselIdentity;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;

public interface IVesselRepository extends CrudRepository<Vessel, VesselIdentity> {

    /**
     * The @Query is used to define SQL to execute for a Spring Data repository
     * method. It also takes precedence over named queries, which are annotated
     * with @NamedQuery or defined in an orm.xml file.
     * */
    @Query
    (value = "SELECT * " +
             "FROM vessel " +
             "WHERE (berthing_time BETWEEN :fromDateTime AND :toDateTIME) " +
             "ORDER BY `berthing_time` ASC",
             nativeQuery = true)
    Collection<Vessel> findAllVesselsOnDate(@Param("fromDateTime") String fromDateTime, @Param("toDateTIME") String toDateTIME);

    @Override
    Optional<Vessel> findById(VesselIdentity vesselIdentity);
}

