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

import pt.iade.ricardopereiradanielalmeida.qrity.models.repositories.PermissionItemRepository;
import pt.iade.ricardopereiradanielalmeida.qrity.models.PermissionItem;
import pt.iade.ricardopereiradanielalmeida.qrity.models.response.Response;
import pt.iade.ricardopereiradanielalmeida.qrity.models.exceptions.NotFoundException;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/permissiondoor")
public class PermissionController {
private Logger logger = LoggerFactory.getLogger(PermissionController.class);
@Autowired
private PermissionItemRepository permissionRepository;

@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
public Iterable<PermissionItem> getMapping() {
logger.info("Sending all door permissions");
return permissionRepository.findAll();
}

@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
public PermissionItem savePermissionItem(@RequestBody PermissionItem permissionItem) {
PermissionItem savedPermissionItem = permissionRepository.save(permissionItem);
logger.info("Saving door permissions with id " + savedPermissionItem.getId());
return savedPermissionItem;
}

@DeleteMapping(path = "/{id:[0-9]+}", produces =
MediaType.APPLICATION_JSON_VALUE)
public Response deletePermissionItem(@PathVariable int id) {
logger.info("Deleting door permissions with id " + id);
// No verification to see if it exists
permissionRepository.deleteById(id);
return new Response("Deleted door permissions with id " + id, null);
}

@GetMapping(path = "/{id:[0-9]+}", produces=
MediaType.APPLICATION_JSON_VALUE)
public PermissionItem getpPermissionItem(@PathVariable int id) {
logger.info("Sending door permissions with id " + id);
Optional<PermissionItem> _permissionItem = permissionRepository.findById(id);
if (_permissionItem.isEmpty())
throw new NotFoundException("" + id, "Permission", "id");
else return _permissionItem.get();
}
}

