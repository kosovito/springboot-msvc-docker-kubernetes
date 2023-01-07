package org.kosovito.springcloud.msvc.cursos.repositories;

import org.kosovito.springcloud.msvc.cursos.entity.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
}
