package kodlama.io.Kodlama.io.Devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllFrameWorkResponse {
	private int id;
	private String name;
	private int language_id;
}
