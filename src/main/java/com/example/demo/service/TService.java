package com.example.demo.service;

import com.example.demo.bean.T;
import com.example.demo.mapper.TMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.function.Consumer;

@Service
public class TService {
    @Resource
    private TMapper tMapper;

    public void none(TSEntity entity){
        entry(entity, "none");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void rd(TSEntity entity){
        entry(entity, "rd");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void ss(TSEntity entity){
        entry(entity, "ss");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void mt(TSEntity entity){
        entry(entity, "mt");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void rn(TSEntity entity){
        entry(entity, "rn");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void ns(TSEntity entity){
        entry(entity, "ns");
    }

    @Transactional(propagation = Propagation.NEVER)
    public void nr(TSEntity entity){
        entry(entity, "nr");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void ne(TSEntity entity){
        entry(entity, "ne");
    }

    private void soo(TSEntity en) {
        en.setCanCallSun(true);
        en.setSunCanSeeFather(tMapper.select().contains("one"));
        tMapper.insert(T.newT(2, "two"));
        if (en.isSunThrow()){
            int i = 2 / 0;
        }
    }

    private void foo(TSEntity en) {
        en.setCanCallFather(true);
        try {
            tMapper.insert(T.newT(1, "one"));
            en.setSun(true);
            en.getSun().accept(en);
        } catch (Exception e) {
            if (!en.isFatherCatch()){
                throw e;
            }
        }finally {
            en.setFatherCanSeeSun(tMapper.select().contains("two"));
        }
        if (en.isFatherThrow()){
            int i = 1 / 0;
        }
    }


    private void entry(TSEntity entity, String name) {
        if (entity.isSun()){
            entity.setSunName(name);
            soo(entity);
        }else {
            entity.setFatherName(name);
            foo(entity);
        }
    }
}
