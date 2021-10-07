package com.worker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.model.Worker;
import com.worker.repository.IWorkerRepository;
/**
 * @author SudheerMS
 *
 */
@Service
public class WorkerServiceImpl implements IWorkerService {
	
	IWorkerRepository workerRepository;
	
	@Autowired
	public void setWorkerRepository(IWorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

	@Override
	public Worker createWorker(Worker worker) {
		Worker newWorker = workerRepository.save(worker);
		return newWorker;
	}

	@Override
	public String updateWorker(Worker worker) {
		workerRepository.save(worker);
		return "Worker updated successfully";
	}

	@Override
	public String deleteWorker(int workerId) {
		workerRepository.deleteById(workerId);
		return "worker deleted successfully";
	}

	@Override
	public Worker getWorkerById(int workerId) {
		Worker worker = workerRepository.findById(workerId).get();
		return worker;
	}

	@Override
	public List<Worker> getAllWorkers() {
		List<Worker> allWorkers = workerRepository.findAll();
		return allWorkers;
	}

	@Override
	public List<Worker> getWorkerByName(String workerName) {
		List<Worker> workersByName = workerRepository.findByWorkerName(workerName);
		return workersByName;
	}

	@Override
	public List<Worker> getWorkerByType(String type) {
		List<Worker> workersByType = workerRepository.findByType(type);
		return workersByType;
	}

	@Override
	public List<Worker> getWorkerByAvailability(String availability) {
		List<Worker> workersByAvailability = workerRepository.findByAvailability(availability);
		return workersByAvailability;
	}

	@Override
	public List<Worker> getWorkerByNoTask() {
		List<Worker> workersByNoTask = workerRepository.findWorkerByNoTask();
		return workersByNoTask;
	}

}
