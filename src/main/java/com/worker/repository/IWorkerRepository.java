package com.worker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.worker.model.Worker;
/**
 * @author SudheerMS
 *
 */
@Repository
public interface IWorkerRepository extends JpaRepository<Worker, Integer> {
	
	List<Worker> findByWorkerName(String workerName);
	
	List<Worker> findByType(String type);
	
	List<Worker> findByAvailability(String availability);
	
	@Query("from Worker w where w.task = null")
	List<Worker> findWorkerByNoTask();

}
