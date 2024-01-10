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

import pt.iade.ricardopereiradanielalmeida.qrity.models.repositories.PermissionAreasRepository;
import pt.iade.ricardopereiradanielalmeida.qrity.models.PermissionAreasItem;
import pt.iade.ricardopereiradanielalmeida.qrity.models.response.Response;
import pt.iade.ricardopereiradanielalmeida.qrity.models.exceptions.NotFoundException;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/permissionarea")
public class PermissionAreasController {
private Logger logger = LoggerFactory.getLogger(PermissionAreasController.class);

@Autowired
private PermissionAreasRepository permissionAreasRepository;
@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
public Iterable<PermissionAreasItem> getMapping() {
logger.info("Sending all permissions");
return permissionAreasRepository.findAll();
}

@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
public PermissionAreasItem savePermissionAreasItem(@RequestBody PermissionAreasItem permissionAreasItem) {
PermissionAreasItem savedPermissionAreasItem = permissionAreasRepository.save(permissionAreasItem);
logger.info("Saving permissions with id " + savedPermissionAreasItem.getId());
return savedPermissionAreasItem;
}

@DeleteMapping(path = "/{id:[0-9]+}", produces =
MediaType.APPLICATION_JSON_VALUE)
public Response deletePermissionAreasItem(@PathVariable int id) {
logger.info("Deleting permissions with id " + id);
// No verification to see if it exists
permissionAreasRepository.deleteById(id);
return new Response("Deleted permissions with id " + id, null);
}

@GetMapping(path = "/{id:[0-9]+}", produces=
MediaType.APPLICATION_JSON_VALUE)
public PermissionAreasItem getpPermissionAreasItem(@PathVariable int id) {
logger.info("Sending permissions with id " + id);
Optional<PermissionAreasItem> _permissionAreasItem = permissionAreasRepository.findById(id);
if (_permissionAreasItem.isEmpty())
throw new NotFoundException("" + id, "PermissionAreas", "id");
else return _permissionAreasItem.get();
}
}

