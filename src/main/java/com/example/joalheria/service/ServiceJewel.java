package com.example.joalheria.service;

import com.example.joalheria.model.Jewel;
import com.example.joalheria.repository.IRepositoryJewel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceJewel implements IServiceJewel{

    @Autowired
    private IRepositoryJewel repo;

    @Override
    public Jewel insert(Jewel jewel) {
        return repo.save(jewel);
    }

    @Override
    public List<Jewel> listar() {
        return (List<Jewel>) repo.findAll();
    }

    @Override
    public void deletar(long id) {
        repo.delete(this.obterPorId(id));
    }

    @Override
    public Jewel atualizar(Jewel jewel) {
        obterPorId(jewel.getId());
        return repo.save(jewel);
    }

    private Jewel obterPorId(long id){
        return repo.findById(id).get();
    }
}
