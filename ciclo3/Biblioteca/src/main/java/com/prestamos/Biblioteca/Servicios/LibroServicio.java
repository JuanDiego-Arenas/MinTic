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

    public Optional<Libro> buscarLibro(String isbn){
        return repositorio.findById(isbn);
    }

    public List<Libro> PorAutor(String autor){
        return repositorio.findByAutor(autor);
    }

    public String agregarLibro(Libro libro){

        if(buscarLibro(libro.getIsbn()).isPresent()){
            return "El Libro Ya Existe....";
        }else{
            repositorio.save(libro);
            return "Libro registrado exitosamente!!";
        }
    }

    public String actualizarLibro(Libro libro){
        if (buscarLibro(libro.getIsbn()).isPresent()){
            repositorio.save(libro);
            return "Libro actualizado exitosamente!!";
        }else{
            return "El libro a actualizar no se encontró ❌";
        }
    }

    public String eliminarLibro(String isbn){
        if (buscarLibro(isbn).isPresent()){
            repositorio.deleteById(isbn);
            return "El libro eliminado";
        }else{
            return "El libro no se encontró";
        }
    }

}