package com.Prospecta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Prospecta.Bean.EntryData;


@Repository
public interface ProspectaRepository extends JpaRepository<EntryData, Integer>{

}
