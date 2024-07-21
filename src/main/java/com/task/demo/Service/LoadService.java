package com.task.demo.Service;

import java.util.UUID;
import java.util.List;
import com.task.demo.Entities.Load;

public interface LoadService {

    public Load getLoadById(Long loadId);
    public List<Load> getLoadByShipperId(UUID shipperId);
    public Load createLoad(Load load);
    public Load updateLoad(Long loadId, Load load);
    public void deleteLoad(Long loadId);
}
