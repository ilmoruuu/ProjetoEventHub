package br.org.upe.eventhub.services;

import br.org.upe.eventhub.entities.Evento;
import br.org.upe.eventhub.repositories.EventoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public Evento cadastrarEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento buscarEventoPorId(int id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Evento> buscarEventoPorTituloContaining(String titulo) {
        return eventoRepository.findByTituloContaining(titulo);
    }

    @Override
    public List<Evento> buscarEventoPorInicioTitulo(String titulo) {
        return eventoRepository.findByTituloLike('%' + titulo + '%');
    }
}
