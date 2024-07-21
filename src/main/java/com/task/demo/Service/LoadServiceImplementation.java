package com.task.demo.Service;

import com.task.demo.Dao.LoadDao;
import com.task.demo.Entities.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

@Service
public class LoadServiceImplementation implements LoadService{

    @Autowired
    private LoadDao loadDao;

    @Override
    public Load getLoadById(Long loadId){

        return loadDao.findById(loadId).orElse(null);
    }

    @Override
    public List<Load> getLoadByShipperId(UUID shipperId) {
//        return loadDao.findByShipperId(shipperId);
          if(shipperId != null){
              return loadDao.findByShipperId(shipperId);
          }else{
              return loadDao.findAll();
          }
    }

    @Override
    public Load createLoad(Load load) {
        return loadDao.save(load);
    }

    @Override
    public Load updateLoad(Long loadId, Load load) {
        Load getLoad = loadDao.findById(loadId).orElse(null);
        if(getLoad != null){
            getLoad.setLoadingPoint(load.getLoadingPoint());
            getLoad.setUnloadingPoint(load.getUnloadingPoint());
            getLoad.setProductType(load.getProductType());
            getLoad.setTruckType(load.getTruckType());
            getLoad.setNoOfTrucks(load.getNoOfTrucks());
            getLoad.setWeight(load.getWeight());
            getLoad.setComment(load.getComment());
            getLoad.setDate(load.getDate());
            return loadDao.save(getLoad);
        }
        return null;
    }

    @Override
    public void deleteLoad(Long loadId) {
        loadDao.deleteById(loadId);
    }

}
