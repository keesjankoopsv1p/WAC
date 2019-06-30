package nl.hu.v1wac.firstapp.persistence;

import java.util.List;

import nl.hu.v1wac.firstapp.webservices.Country;

public interface CountryDao {
	
	public boolean save(Country country);
	
	public List<Country> findAll();
	
	public Country findByCode(String code);
	
	public List<Country> find10LargestPopulations();
	
	public List<Country> find10LargestSurfaces();
	
	public boolean update(String code, String naam, String capital, String regio, int opv, int inw);
	
	public boolean delete(String code);

}