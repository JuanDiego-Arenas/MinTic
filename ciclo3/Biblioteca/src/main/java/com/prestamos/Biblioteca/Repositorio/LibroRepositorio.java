package com.prestamos.Biblioteca.Repositorio;

import com.prestamos.Biblioteca.Entidades.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends CrudRepository<Libro,String> {

}
