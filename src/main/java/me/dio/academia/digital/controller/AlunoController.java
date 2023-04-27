package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

  @Autowired
  private AlunoServiceImpl service;

  @PostMapping
  public Aluno create(@Valid @RequestBody AlunoForm form) {
    return service.create(form);
  }

  @GetMapping("/avaliacoes/{id}")
  public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@PathVariable Long id) {
    return service.getAllAvaliacaoFisicaId(id);
  }

  @GetMapping
  public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false)
                                  String dataDeNacimento){
    return service.getAll(dataDeNacimento);
  }



  @GetMapping
  public Page<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento,
                            @RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "size", defaultValue = "10") int size,
                            @RequestParam(value = "sort", defaultValue = "id,asc") String[] sort) {
    Sort sortOrder = Sort.by(sort[0]).ascending();
    if (sort.length > 1) {
      for (int i = 1; i < sort.length; i++) {
        String[] s = sort[i].split(",");
        if (s.length > 1 && s[1].equalsIgnoreCase("desc")) {
          sortOrder = sortOrder.and(Sort.by(Sort.Direction.DESC, s[0]));
        } else {
          sortOrder = sortOrder.and(Sort.by(Sort.Direction.ASC, s[0]));
        }
      }
    }
    Pageable pageable = PageRequest.of(page, size, sortOrder);
    return service.getAll(dataDeNascimento, pageable);
  }
}
