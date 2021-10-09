package com.worker.service;

import java.util.List;

import com.worker.model.Availability;
import com.worker.model.Worker;
import com.worker.model.WorkerType;
/**
 * @author SudheerMS
 *
 */
public interface IWorkerService {
	
	Worker createWorker(Worker worker);
	
	Worker updateWorker(Worker worker);
	
	String deleteWorker(int workerId);
	
	Worker getWorkerById(int workerId);
	
	List<Worker> getAllWorkers();
	
	List<Worker> getWorkerByName(String workerName);
	
	List<Worker> getWorkerByType(WorkerType type);
	
	List<Worker> getWorkerByAvailability(Availability availability);
	
	List<Worker> getWorkerByNoTask();
}
