package org.kosovito.springcloud.msvc.usuarios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "msvc-cursos", url = "localhost:8002")
//@FeignClient(name = "msvc-cursos", url = "host.docker.internal:8002")
@FeignClient(name = "msvc-cursos", url = "msvc-cursos:8002")
public interface CursoClienteRest {

    @DeleteMapping("/eliminar-usuario/{id}")
    void eliminarCursoUsuarioPorId(@PathVariable Long id);
}
