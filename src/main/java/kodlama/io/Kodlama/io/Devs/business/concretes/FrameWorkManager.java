package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.FrameWorkService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetIdFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllFrameWorkResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetIdFrameWorkResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.FrameWorkRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.FrameWork;

@Service
public class FrameWorkManager implements FrameWorkService {
	FrameWorkRepository frameWorkRepository;

	@Autowired
	public FrameWorkManager(FrameWorkRepository frameWorkRepository) {
		super();
		this.frameWorkRepository = frameWorkRepository;
	}

	@Override
	public List<GetAllFrameWorkResponse> getAll() {
		List<FrameWork> frameWork = frameWorkRepository.findAll();
		List<GetAllFrameWorkResponse> frameWorkResponse = new ArrayList<GetAllFrameWorkResponse>();
		for (FrameWork frame : frameWork) {
			GetAllFrameWorkResponse responseItem = new GetAllFrameWorkResponse();
			responseItem.setId(frame.getId());
			responseItem.setName(frame.getName());
			frameWorkResponse.add(responseItem);
		}

		return frameWorkResponse;
	}

	@Override
	public void add(CreateFrameWorkRequest createFrameWorkRequest) {
		FrameWork frameWork = new FrameWork();
		frameWork.setName(createFrameWorkRequest.getName());
		frameWorkRepository.save(frameWork);

	}

	@Override
	public void delete(DeleteFrameWorkRequest deleteFrameWorkRequest) {
		FrameWork frameWork = new FrameWork();

		frameWork.setId(deleteFrameWorkRequest.getId());
		frameWorkRepository.delete(frameWork);

	}

	@Override
	public void update(UpdateFrameWorkRequest updateFrameWorkRequest) {
		FrameWork frameWork = new FrameWork();
		frameWork.setName(updateFrameWorkRequest.getName());
		frameWork.setId(updateFrameWorkRequest.getId());
		frameWorkRepository.save(frameWork);

	}

	@Override
	public GetIdFrameWorkResponse getById(GetIdFrameWorkRequest getIdFrameWorkRequest) {
		List<FrameWork> frameWorks = frameWorkRepository.findAll();
		GetIdFrameWorkResponse responseItem = new GetIdFrameWorkResponse();
		for (FrameWork frame : frameWorks) {
			if ((frame.getName().equals(getIdFrameWorkRequest.getName()))) {
				responseItem.setId(frame.getId());

			}
		}
		return responseItem;
	}

}
