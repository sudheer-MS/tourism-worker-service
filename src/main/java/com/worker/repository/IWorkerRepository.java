package com.worker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.worker.model.Availability;
import com.worker.model.Worker;
import com.worker.model.WorkerType;
/**
 * @author SudheerMS
 *
 */
@Repository
public interface IWorkerRepository extends JpaRepository<Worker, Integer> {
	
	List<Worker> findByWorkerName(String workerName);
	
	List<Worker> findByType(WorkerType type);
	
	List<Worker> findByAvailability(Availability availability);
	
	@Query("from Worker w where w.task = null")
	List<Worker> findWorkerByNoTask();

}
