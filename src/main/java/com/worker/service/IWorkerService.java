package com.worker.service;

import java.util.List;

import com.worker.model.Worker;
/**
 * @author SudheerMS
 *
 */
public interface IWorkerService {
	
	Worker createWorker(Worker worker);
	
	String updateWorker(Worker worker);
	
	String deleteWorker(int workerId);
	
	Worker getWorkerById(int workerId);
	
	List<Worker> getAllWorkers();
	
	List<Worker> getWorkerByName(String workerName);
	
	List<Worker> getWorkerByType(String type);
	
	List<Worker> getWorkerByAvailability(String availability);
	
	List<Worker> getWorkerByNoTask();
}
