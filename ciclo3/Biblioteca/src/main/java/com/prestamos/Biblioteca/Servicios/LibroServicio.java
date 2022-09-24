package com.prestamos.Biblioteca.Servicios;

import com.prestamos.Biblioteca.Entidades.Libro;
import com.prestamos.Biblioteca.Repositorio.LibroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServicio {

    private LibroRepositorio repositorio;

    public LibroServicio(LibroRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Libro> listaLibros(){
        return (List<Libro>) repositorio.findAll(); //Consultar todos los libros
    }

    public Libro BuscarLibro(String isbn){
        return repositorio.findById(isbn).get();
    }

    public Libro PorAutor(String autor){
        return repositorio.findById(autor).get();
    }
}
