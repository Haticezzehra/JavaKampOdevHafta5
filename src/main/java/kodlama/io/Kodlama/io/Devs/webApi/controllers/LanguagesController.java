package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetIdLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetIdLanguageResponse;

@RestController // Sen kontrollersin diyoruz.
@RequestMapping("/api/languages") // Adresleme //buraya böyle erişilsin.
public class LanguagesController {

	private LanguageService languageService;

	@Autowired // Parametresine bak
	public LanguagesController(LanguageService languageService) {

		this.languageService = languageService;
	}

	@GetMapping("/getAll")
	public List<GetAllLanguageResponse> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		languageService.add(createLanguageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageService.delete(deleteLanguageRequest);
	}

	@PutMapping("/update")
	public void update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		languageService.update(updateLanguageRequest);
	}


	@GetMapping("/getbyId")
	public GetIdLanguageResponse getById(GetIdLanguageRequest getIdLanguageRequest) throws Exception {
		return languageService.getById(getIdLanguageRequest);
	}

}
