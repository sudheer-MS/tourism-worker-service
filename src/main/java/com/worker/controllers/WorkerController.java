package com.worker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worker.model.Worker;
import com.worker.service.IWorkerService;
/**
 * @author SudheerMS
 *
 */
@RestController
@RequestMapping("/worker-service")
public class WorkerController {
	
	IWorkerService workerService;
	
	@Autowired
	public void setWorkerService(IWorkerService workerService) {
		this.workerService = workerService;
	}

	@PostMapping("/worker")
	ResponseEntity<Worker> createWorker(@RequestBody Worker worker){
		Worker newWorker = workerService.createWorker(worker);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "create a worker api");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(newWorker);
	}
	
	@PutMapping("/worker")
	ResponseEntity<String> updateWorker(@RequestBody Worker worker){
		String reponse = workerService.updateWorker(worker);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "update a worker api");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body(reponse);
	}
	
	@DeleteMapping("/worker/{workerId}")
	ResponseEntity<String> deleteWorker(@PathVariable("workerId") int workerId){
		String reponse = workerService.deleteWorker(workerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "delete a worker by id api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(reponse);
	}
	
	@GetMapping("/worker/{workerId}")
	ResponseEntity<Worker> getWorkerById(@PathVariable("workerId") int workerId){
		Worker getWorker = workerService.getWorkerById(workerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get worker by id api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(getWorker);
	}
	
	@GetMapping("/worker")
	ResponseEntity<List<Worker>> getAllWorkers(){
		List<Worker> allWorkers = workerService.getAllWorkers();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get all workers api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(allWorkers);
	}
	
	@GetMapping("/worker/name/{name}")
	ResponseEntity<List<Worker>> getWorkerByName(@PathVariable("name") String workerName){
		List<Worker> workersByName = workerService.getWorkerByName(workerName);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get workers by name api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(workersByName);
	}
	
	@GetMapping("/worker/type/{type}")
	ResponseEntity<List<Worker>> getWorkerByType(@PathVariable("type") String type){
		List<Worker> workersByType = workerService.getWorkerByType(type);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get workers by type api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(workersByType);
	}
	
	@GetMapping("/worker/availability/{availability}")
	ResponseEntity<List<Worker>> getWorkerByAvailability(@PathVariable("availability") String availability){
		List<Worker> workersByAvailability = workerService.getWorkerByAvailability(availability);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get workers by availability api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(workersByAvailability);
	}
	
	@GetMapping("/worker/no-task")
	ResponseEntity<List<Worker>> getWorkerByNoTask(){
		List<Worker> noTaskWorkers = workerService.getWorkerByNoTask();
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "get no task workers api");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(noTaskWorkers);
	}
	
}