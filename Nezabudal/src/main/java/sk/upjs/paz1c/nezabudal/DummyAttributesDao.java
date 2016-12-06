package sk.upjs.paz1c.nezabudal;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mikey
 */
class DummyAttributesDao {

    List<Attribute> attributes = new ArrayList<>();

    public DummyAttributesDao() {
        attributes.add(new Attribute("Názov", ""));
        attributes.add(new Attribute("Od", ""));
        attributes.add(new Attribute("Do", ""));
        attributes.add(new Attribute("Osoba", ""));
    }

   

    public List<Attribute> getAttributes() {
        return attributes;
    }
}
