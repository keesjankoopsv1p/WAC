package nl.hu.v1wac.firstapp.webservices;

import java.util.List;

import nl.hu.v1wac.firstapp.persistence.CountryPostgresDaoImpl;
import nl.hu.v1wac.firstapp.persistence.CountryDao;

public class WorldService {
	private CountryDao countryDao = new CountryPostgresDaoImpl();
	
	public List<Country> getAllCountries() {
		return countryDao.findAll();
	}
	
	public List<Country> get10LargestPopulations() {
		return countryDao.find10LargestPopulations();
	}

	public List<Country> get10LargestSurfaces() {
		return countryDao.find10LargestSurfaces();
	}
	
	public Country getCountryByCode(String code) {
		return countryDao.findByCode(code);
	}
}
