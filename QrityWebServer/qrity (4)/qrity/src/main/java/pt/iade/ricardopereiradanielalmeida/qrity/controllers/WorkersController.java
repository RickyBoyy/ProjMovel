package pt.iade.ricardopereiradanielalmeida.qrity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import pt.iade.ricardopereiradanielalmeida.qrity.models.repositories.WorkersRepository;
import pt.iade.ricardopereiradanielalmeida.qrity.models.WorkersItem;
import pt.iade.ricardopereiradanielalmeida.qrity.models.response.Response;
import pt.iade.ricardopereiradanielalmeida.qrity.models.exceptions.NotFoundException;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/workers")
public class WorkersController {
private Logger logger = LoggerFactory.getLogger(WorkersController.class);
@Autowired
private WorkersRepository workersRepository;
@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
public Iterable<WorkersItem> getWorkerItem() {
logger.info("Sending all workers");
return workersRepository.findAll();
}

@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
public WorkersItem saveWorkersItem(@RequestBody WorkersItem workersItem) {
WorkersItem savedWorkersItem = workersRepository.save(workersItem);
logger.info("Saving workers with id " + savedWorkersItem.getId());
return savedWorkersItem;
}

@DeleteMapping(path = "/{id:[0-9]+}", produces =
MediaType.APPLICATION_JSON_VALUE)
public Response deleteWorkersItem(@PathVariable int id) {
logger.info("Deleting workers with id " + id);
// No verification to see if it exists
workersRepository.deleteById(id);
return new Response("Deleted workers with id " + id, null);
}

@GetMapping(path = "/{id:[0-9]+}", produces=
MediaType.APPLICATION_JSON_VALUE)
public WorkersItem getWorkersItem(@PathVariable int id) {
logger.info("Sending workers with id " + id);
Optional<WorkersItem> _workersItem = workersRepository.findById(id);
if (_workersItem.isEmpty())
throw new NotFoundException("" + id, "WorkersItem", "id");
else return _workersItem.get();
}
}

