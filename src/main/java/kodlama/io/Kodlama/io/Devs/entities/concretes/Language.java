package kodlama.io.Kodlama.io.Devs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data //Üsttekilerin hepsini kapsayan lombok toolu.
//Lombok bizim yerimize gettter setter, constructorları oluşturuyor.
//Buranın veritabanında bir alan olduğunu söylüyoruz.
@Table(name = "languages")
@Entity
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Bir bir artmasını söylüyoruz
	@Column(name = "id")
	private int language_id;
	@Column(name = "name")
	private String name;

	// Dilden birtane framworkden birden fazla gelebilir diyoruz. Burada aralarında
	// ilişki var
	@OneToMany(mappedBy =  "language")
	private List<FrameWork> frameWorks;

}	
