package practica8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Practica8
{ 
    public static class Libro9Mayo implements Comparable<Libro9Mayo>
    {
        private String isbn;
        private String titulo;
        private String autor;
        private String categoria;
        private int anio;
 
        public Libro9Mayo(String isbn, String titulo, String autor, String categoria, int anio)
        {
            this.isbn = isbn;
            this.titulo = titulo;
            this.autor = autor;
            this.categoria = categoria;
            this.anio = anio;
        }
 
        public String getIsbn() { return isbn; }
        public String getTitulo() { return titulo; }
        public String getAutor() { return autor; }
        public String getCategoria() { return categoria; }
        public int getAnio() { return anio; }
 
        public void setTitulo(String titulo) { this.titulo = titulo; }
        public void setAutor(String autor) { this.autor = autor; }
        public void setCategoria(String categoria) { this.categoria = categoria; }
        public void setAnio(int anio) { this.anio = anio; }
 
        @Override
        public int compareTo(Libro9Mayo o) {
            // Comparación natural por título (case-insensitive)
            return this.titulo.toLowerCase().compareTo(o.titulo.toLowerCase());
        }
 
        @Override
        public String toString()
        {
            return String.format("[%s] \"%s\" - %s (%d) {%s}", isbn, titulo, autor, anio, categoria);
        }
 
        @Override
        public boolean equals(Object o)
        {
            if (this == o) return true;
            if (!(o instanceof Libro9Mayo)) return false;
            Libro9Mayo l = (Libro9Mayo) o;
            return Objects.equals(isbn, l.isbn);
        }
 
        @Override
        public int hashCode()
        {
            return Objects.hash(isbn);
        }
    }
 
    
    public static class Usuario
    {
        private String matricula; // key personalizada, ej. M3887
        private String nombre;
        private String correo;
 
        public Usuario(String matricula, String nombre, String correo)
        {
            this.matricula = matricula;
            this.nombre = nombre;
            this.correo = correo;
        }
 
        public String getMatricula() { return matricula; }
        public String getNombre() { return nombre; }
        public String getCorreo() { return correo; }
 
        @Override
        public String toString()
        {
            return String.format("%s (%s) - %s", nombre, matricula, correo);
        }
    }
 
    
    public static class ComparadorPorAutor implements Comparator<Libro9Mayo>
    {
        @Override
        public int compare(Libro9Mayo a, Libro9Mayo b)
        {
            return a.getAutor().toLowerCase().compareTo(b.getAutor().toLowerCase());
        }
    }
 
    public static class ComparadorPorAnio implements Comparator<Libro9Mayo>
    {
        @Override
        public int compare(Libro9Mayo a, Libro9Mayo b)
        {
            return Integer.compare(a.getAnio(), b.getAnio());
        }
    }
 
    
    public static class BibliotecaM3887
    {
        private List<Libro9Mayo> disponibles;
        private LinkedList<Libro9Mayo> colaReservas;
        private Map<String, Usuario> usuarios;
        private Set<String> categorias;
 
        private Map<String, String> prestados;
 
        public BibliotecaM3887()
        {
            this.disponibles = new ArrayList<>();
            this.colaReservas = new LinkedList<>();
            this.usuarios = new HashMap<>();
            this.categorias = new HashSet<>();
            this.prestados = new HashMap<>();
        }
 
        public void agregarLibro(Libro9Mayo libro)
        {
            disponibles.add(libro);
            categorias.add(libro.getCategoria());
        }
 
        public boolean eliminarLibroPorIsbn(String isbn)
        {
            Iterator<Libro9Mayo> it = disponibles.iterator();
            while (it.hasNext())
            {
                Libro9Mayo l = it.next();
                if (l.getIsbn().equals(isbn))
                {
                    it.remove();
                    prestados.remove(isbn);
                    return true;
                }
            }
            return false;
        }
 
        public Optional<Libro9Mayo> buscarPorIsbn(String isbn)
        {
            return disponibles.stream()
                    .filter(l -> l.getIsbn().equals(isbn))
                    .findFirst();
        }
 
        public boolean actualizarLibro(String isbn, String nuevoTitulo, String nuevoAutor, String nuevaCat, int nuevoAnio) {
            Optional<Libro9Mayo> opt = buscarPorIsbn(isbn);
            if (opt.isPresent())
            {
                Libro9Mayo l = opt.get();
                l.setTitulo(nuevoTitulo);
                l.setAutor(nuevoAutor);
                l.setCategoria(nuevaCat);
                l.setAnio(nuevoAnio);
                categorias.add(nuevaCat);
                return true;
            }
            return false;
        }
 
        public List<Libro9Mayo> listarDisponibles()
        {
            return new ArrayList<>(disponibles);
        }
 
        public void registrarUsuario(Usuario u)
        {
            usuarios.put(u.getMatricula(), u);
        }
 
        public Usuario obtenerUsuario(String matricula)
        {
            return usuarios.get(matricula);
        }
 
        public boolean eliminarUsuario(String matricula)
        {
            if (usuarios.containsKey(matricula))
            {
                usuarios.remove(matricula);
                prestados.values().removeIf(m -> m.equals(matricula));
                return true;
            }
            return false;
        }
 
        public void reservarLibro(String isbn)
        {
            Optional<Libro9Mayo> opt = buscarPorIsbn(isbn);
            opt.ifPresent(colaReservas::addLast);
        }
 
        public boolean prestarLibro(String isbn, String matricula)
        {
            Optional<Libro9Mayo> opt = buscarPorIsbn(isbn);
            if (opt.isPresent() && usuarios.containsKey(matricula) && !prestados.containsKey(isbn))
            {
                prestados.put(isbn, matricula);
                eliminarLibroPorIsbn(isbn);
                return true;
            }
            return false;
        }
 
        public boolean devolverLibro(Libro9Mayo libro)
        {
            String isbn = libro.getIsbn();
            if (prestados.containsKey(isbn))
            {
                prestados.remove(isbn);
                agregarLibro(libro);
                return true;
            }
            return false;
        }
 
        public List<Libro9Mayo> buscarPorAutor(String autor)
        {
            return disponibles.stream().filter(l -> l.getAutor().toLowerCase().contains(autor.toLowerCase())).collect(Collectors.toList());
        }
 
        public List<Libro9Mayo> filtrarPorCategoria(String categoria)
        {
            return disponibles.stream().filter(l -> l.getCategoria().equalsIgnoreCase(categoria)).collect(Collectors.toList());
        }
 
        public List<Libro9Mayo> buscarConPredicate(Predicate<Libro9Mayo> pred) {
            return disponibles.stream().filter(pred).collect(Collectors.toList());
        }
 
        public int eliminarLibrosAntesDe(int anioLimite)
        {
            int eliminado = 0;
            Iterator<Libro9Mayo> it = disponibles.iterator();
            while (it.hasNext()) 
            {
                Libro9Mayo l = it.next();
                if (l.getAnio() < anioLimite)
                {
                    it.remove();
                    eliminado++;
                }
            }
            return eliminado;
        }
 
        public Set<String> getCategoriasUnicas()
        {
            return new HashSet<>(categorias);
        }
 
        public LinkedList<Libro9Mayo> getColaReservas()
        {
            return colaReservas;
        }
 
        public Map<String, String> getPrestados()
        {
            return Collections.unmodifiableMap(prestados);
        }
    }
 
    public static void main(String[] args)
    {
        BibliotecaM3887 biblioteca = new BibliotecaM3887();
 
        Usuario estudiante = new Usuario("M3887", "M. Márquez", "m.marquez@example.com");
        biblioteca.registrarUsuario(estudiante);
 
        biblioteca.agregarLibro(new Libro9Mayo("ISBN-001", "Algoritmos y Estructuras", "C. S. Author", "Computación", 2015));
        biblioteca.agregarLibro(new Libro9Mayo("ISBN-002", "Introducción a Java", "J. Dev", "Computación", 2019));
        biblioteca.agregarLibro(new Libro9Mayo("ISBN-003", "Cálculo I", "M. Euler", "Matemáticas", 2010));
        biblioteca.agregarLibro(new Libro9Mayo("ISBN-004", "Historia Universal", "A. Hist", "Historia", 2005));
        biblioteca.agregarLibro(new Libro9Mayo("ISBN-005", "Redes de Computadoras", "N. Net", "Computación", 2021));
    }
}