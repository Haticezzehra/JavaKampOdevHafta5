package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.LanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetIdLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllFrameWorkResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetIdLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.FrameWorkRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.FrameWork;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;

// //IOC YE EKLEMESİ İÇİN BUNU YAZIYORUZ.bİR KERE NEWLE Bu snıf bussines
// nesnesidir
@Service
public class LanguageManager implements LanguageService {
	private LanguageRepository languageRepository;// Interfacei kullandık ilerde başka türdde dataAcces ge
	private FrameWorkRepository frameWorkRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository,FrameWorkRepository frameWorkRepository) {

		this.languageRepository = languageRepository;
		this.frameWorkRepository=frameWorkRepository;
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		// İş kuralları

		List<Language> languages = languageRepository.findAll();
		List<FrameWork> frameworks = frameWorkRepository.findAll();

		List<GetAllLanguageResponse> languageResponse = new ArrayList<GetAllLanguageResponse>();
		for (Language language : languages) {
			List<GetAllFrameWorkResponse> frameworkResponses = new ArrayList<>();
			GetAllLanguageResponse languageItem = new GetAllLanguageResponse();
			languageItem.setId(language.getLanguage_id());
			languageItem.setName(language.getName());
			languageItem.setFrameworks(frameworkResponses);
			languageResponse.add(languageItem);
			
			for (FrameWork framework : frameworks) {
                if (languageItem.getId() == framework.getLanguage().getLanguage_id()) {
                    GetAllFrameWorkResponse addItem1 = new GetAllFrameWorkResponse();
                    addItem1.setId(framework.getId());
                    addItem1.setName(framework.getName());
                    addItem1.setLanguage_id(framework.getLanguage().getLanguage_id());
                    frameworkResponses.add(addItem1);
                }
            }
        }
		

		return languageResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		this.languageRepository.save(language);

	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language = new Language();
		language.setLanguage_id(deleteLanguageRequest.getLanguage_id());
		this.languageRepository.delete(language);

	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language = new Language();
		language.setName(updateLanguageRequest.getName());
		language.setLanguage_id(updateLanguageRequest.getLanguage_id());
		this.languageRepository.save(language);

	}

	@Override
	public GetIdLanguageResponse getById(GetIdLanguageRequest getIdLanguageRequest) throws Exception {
		List<Language> languages = languageRepository.findAll();
		GetIdLanguageResponse responseItem = new GetIdLanguageResponse();

		for (Language language : languages) {
			if (language.getName().equals(getIdLanguageRequest.getName()))
				responseItem.setId(language.getLanguage_id());

		}
		return responseItem;
	}

	/*
	 * @Override public void add(Language language) throws Exception { // TODO
	 * Auto-generated method stub if (language.getName().isEmpty()) { throw new
	 * Exception("Programlama dili adı bos gecilemez"); }
	 * 
	 * for (Language lang : getAll()) { if
	 * (lang.getName().equals(language.getName())) { throw new
	 * Exception("Bu programlama dili zaten var"); } }
	 * languageRepository.add(language);
	 * 
	 * }
	 * 
	 * @Override public void delete(int id) throws Exception { // TODO
	 * Auto-generated method stub for (Language lang : getAll()) { if (lang.getId()
	 * == id) { languageRepository.delete(id); break; } else { throw new
	 * Exception("Listede bu programlama dili yok"); } }
	 * 
	 * }
	 * 
	 * @Override public void update(int id, String name) throws Exception { // TODO
	 * Auto-generated method stub for (Language lang : getAll()) { if (lang.getId()
	 * == id) { languageRepository.update(id, name);
	 * 
	 * } else { throw new
	 * Exception("Listede bu programlama dili yok.Güncelleme yapılamaz."); } }
	 * 
	 * }
	 * 
	 * @Override public Language getById(int id) { // TODO Auto-generated method
	 * stub
	 * 
	 * return languageRepository.getById(id); }
	 */
}
