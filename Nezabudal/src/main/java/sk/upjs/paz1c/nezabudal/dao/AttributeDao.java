package sk.upjs.paz1c.nezabudal.dao;


import sk.upjs.paz1c.nezabudal.entity.Attribute;
import java.util.ArrayList;
import java.util.List;
import sk.upjs.paz1c.nezabudal.entity.Category;

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

    public List<Attribute> getAttributes();
    
    public Attribute getById(Long id);
         
    public void saveOrEdit(Attribute attribute);  
    
    public void delete(Attribute attribute);   
    
    public List<Attribute> getByCategory(Category category);
}
