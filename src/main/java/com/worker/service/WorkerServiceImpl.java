package com.worker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worker.exceptions.WorkerNotFoundException;
import com.worker.model.Availability;
import com.worker.model.Worker;
import com.worker.model.WorkerType;
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
	public Worker updateWorker(Worker worker) {
		Worker updatedWorker = workerRepository.save(worker);
		return updatedWorker;
	}

	@Override
	public String deleteWorker(int workerId) throws WorkerNotFoundException {
		if (getWorkerById(workerId) == null) {
			throw new WorkerNotFoundException("No worker found with the given Id");
		}
		workerRepository.deleteById(workerId);
		return "worker deleted successfully";
	}

	@Override
	public Worker getWorkerById(int workerId) throws WorkerNotFoundException {
		Worker worker = workerRepository.findById(workerId).get();
		if (worker == null) {
			throw new WorkerNotFoundException("No worker found with the given Id");
		}
		return worker;
	}

	@Override
	public List<Worker> getAllWorkers() throws WorkerNotFoundException {
		List<Worker> allWorkers = workerRepository.findAll();
		if (allWorkers.isEmpty()) {
			throw new WorkerNotFoundException("No workers found..Please create a new worker..");
		}
		return allWorkers;
	}

	@Override
	public List<Worker> getWorkerByName(String workerName) throws WorkerNotFoundException {
		List<Worker> workersByName = workerRepository.findByWorkerName(workerName);
		if (workersByName.isEmpty()) {
			throw new WorkerNotFoundException("No workers found with the given name");
		}
		return workersByName;
	}

	@Override
	public List<Worker> getWorkerByType(WorkerType type) throws WorkerNotFoundException {
		List<Worker> workersByType = workerRepository.findByType(type);
		if (workersByType.isEmpty()) {
			throw new WorkerNotFoundException("No workers found with the given Type");
		}
		return workersByType;
	}

	@Override
	public List<Worker> getWorkerByAvailability(Availability availability) throws WorkerNotFoundException {
		List<Worker> workersByAvailability = workerRepository.findByAvailability(availability);
		if (workersByAvailability.isEmpty()) {
			throw new WorkerNotFoundException("No workers found with the given Availability");
		}
		return workersByAvailability;
	}

	@Override
	public List<Worker> getWorkerByNoTask() throws WorkerNotFoundException {
		List<Worker> workersByNoTask = workerRepository.findWorkerByNoTask();
		if (workersByNoTask.isEmpty()) {
			throw new WorkerNotFoundException("No workers found. Every one is assigned with their repective works.");
		}
		return workersByNoTask;
	}

}
