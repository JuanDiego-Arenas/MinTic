package com.prestamos.Biblioteca.Repositorio;

import com.prestamos.Biblioteca.Entidades.Prestamo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepositorio extends CrudRepository<Prestamo,Integer> {

}
