package kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Kodlama.io.Devs.entities.concretes.Language;
//İnterface interfacei extend eder
public interface LanguageRepository extends JpaRepository<Language,Integer> {
	// Repository veritabanı işleri yapacak sınıflara verilen isimler.
//List<Language> getAll();// Dilleri listeler. !!Artık gerek kalmadı zaten jpadan alabiliriz metodları

	//void add(Language language);
	//void update( int id,String name);
	//void delete(int id);
	//Language getById(int id);
	
}