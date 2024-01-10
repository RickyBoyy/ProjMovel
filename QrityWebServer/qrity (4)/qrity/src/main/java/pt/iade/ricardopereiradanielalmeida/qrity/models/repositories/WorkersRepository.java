package pt.iade.ricardopereiradanielalmeida.qrity.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pt.iade.ricardopereiradanielalmeida.qrity.models.WorkersItem;
public interface WorkersRepository extends CrudRepository<WorkersItem,Integer> { }
