package com.example.joalheria.service;

import com.example.joalheria.model.Jewel;

import java.util.List;

public interface IServiceJewel {
    Jewel insert(Jewel jewel);
    List<Jewel> listar();
    void deletar(long id);
    Jewel atualizar(Jewel jewel);
}
