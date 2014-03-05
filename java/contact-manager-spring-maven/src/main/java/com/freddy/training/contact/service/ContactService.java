package com.freddy.training.contact.service;

import java.util.List;

import com.freddy.training.contact.model.Contact;

public interface ContactService {

	public void addContact(Contact contact);

	public List<Contact> listContact();

	public void removeContact(Integer id);
}
