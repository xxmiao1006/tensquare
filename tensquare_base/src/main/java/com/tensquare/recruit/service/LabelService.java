package com.tensquare.recruit.service;


import com.tensquare.recruit.dao.LabelDao;
import com.tensquare.recruit.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     *
     * @return
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     *
     * @return
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     *
     * @param label
     */
    public void add(Label label) {
        label.setId(idWorker.nextId() + "");//设置ID
        labelDao.save(label);
    }

    /**
     * 修改标签
     *
     * @param label
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除标签
     *
     * @param id
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 分页条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<Label> findSearch(Map searchMap, int page, int size) {
        Specification specification = createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification,pageRequest);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap) {
        return (root, criteriaQuery, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (searchMap.get("labelname") != null && !"".equals(searchMap.get("labelname"))) {
                predicateList.add(cb.like(root.get("labelname").as(String.class), "%" + searchMap.get("labelname") + "%"));
            }
            if (searchMap.get("state") != null && !"".equals(searchMap.get("state"))) {
                predicateList.add(cb.equal(root.get("state").as(String.class), searchMap.get("state")));
            }
            if (searchMap.get("recommend") != null && !"".equals(searchMap.get("recommend"))) {
                predicateList.add(cb.equal(root.get("recommend").as(String.class), searchMap.get("recommend")));
            }
            return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
    }

}
