package edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.repository;

import edu.miu.cs.cs425.studentmgmt.model.mystudentmgmtapp.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
}
