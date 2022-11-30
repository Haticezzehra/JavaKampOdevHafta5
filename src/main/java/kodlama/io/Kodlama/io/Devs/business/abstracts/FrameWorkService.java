package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetIdFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllFrameWorkResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetIdFrameWorkResponse;

public interface FrameWorkService {

	List<GetAllFrameWorkResponse> getAll();

	public void add(CreateFrameWorkRequest createFrameWorkRequest);

	public void delete(DeleteFrameWorkRequest deleteFrameWorkRequest);

	public void update(UpdateFrameWorkRequest updateFrameWorkRequest);

	GetIdFrameWorkResponse getById(GetIdFrameWorkRequest getIdFrameWorkRequest);

}
