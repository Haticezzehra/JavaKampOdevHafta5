package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.FrameWorkService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.GetIdFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateFrameWorkRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllFrameWorkResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetIdFrameWorkResponse;

@RestController
@RequestMapping("api/frameworks")
public class FrameWorkController {
	FrameWorkService frameWorkService;

	@Autowired
	public FrameWorkController(FrameWorkService frameWorkService) {
		super();
		this.frameWorkService = frameWorkService;
	}

	@GetMapping("/getAll")
	public List<GetAllFrameWorkResponse> getAll() {
		return frameWorkService.getAll();
	}
	@PostMapping("/add")
	public void add(CreateFrameWorkRequest createFrameWorkRequest) {
		frameWorkService.add(createFrameWorkRequest);
	}
    
	@PutMapping("/update")
	public void update(UpdateFrameWorkRequest updateFrameWorkRequest) throws Exception {
		frameWorkService.update(updateFrameWorkRequest);
	}
	@DeleteMapping("/delete")
	public void delete(DeleteFrameWorkRequest deleteFrameWorkRequest) {
		frameWorkService.delete(deleteFrameWorkRequest);
	}

	@GetMapping("/getbyId")
	public GetIdFrameWorkResponse getById(GetIdFrameWorkRequest getIdFrameWorkRequest) throws Exception {
		return frameWorkService.getById(getIdFrameWorkRequest);
	}

}
