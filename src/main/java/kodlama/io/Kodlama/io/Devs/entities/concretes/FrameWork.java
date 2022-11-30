package kodlama.io.Kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "frameWork")
public class FrameWork {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Bir bir artmasını söylüyoruz
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;

	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Language language;

}
 