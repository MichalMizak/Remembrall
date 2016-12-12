package sk.upjs.paz1c.nezabudal.dao;

import sk.upjs.paz1c.nezabudal.entity.Attribute;
import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Category;
import sk.upjs.paz1c.nezabudal.entity.Item;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mikey
 */
public interface AttributeDao {

    public Attribute getByNameId(Long id);

    public Attribute getByNameId(Long nameId, Item item);

    public void saveOrEditName(Attribute attribute, Category category);

    public void saveOrEditValue(Attribute attribute, Item item);

    public void delete(Attribute attribute);

    public List<Attribute> getByCategory(Category category);

    public List<Attribute> getByItem(Item item);

}
