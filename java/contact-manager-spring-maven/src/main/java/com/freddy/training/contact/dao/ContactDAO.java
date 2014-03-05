package com.freddy.training.contact.dao;

import java.util.List;

import com.freddy.training.contact.model.Contact;
 
public interface ContactDAO {
     
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}
