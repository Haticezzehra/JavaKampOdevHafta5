package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetIdLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetIdLanguageResponse;

public interface LanguageService {
	List<GetAllLanguageResponse> getAll();

	void add(CreateLanguageRequest createLanguageRequest);

	void delete(DeleteLanguageRequest deleteLanguageRequest) ;

	void update(UpdateLanguageRequest updateLanguageRequest) ;

	 GetIdLanguageResponse getById(GetIdLanguageRequest getIdLanguageRequest) throws Exception;
}
