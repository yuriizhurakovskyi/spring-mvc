package ua.yurii.zhurakovskyi.spring.mvc.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.yurii.zhurakovskyi.spring.mvc.springmvc.dao.ParticipantRepo;
import ua.yurii.zhurakovskyi.spring.mvc.springmvc.domain.Participant;

@Service
public class ParticipantService {
	@Autowired
	private ParticipantRepo repo;

	public List<Participant> findAll() {
		return repo.findAll();
	}

	public Participant findOne(int id) {
		return repo.findOne(id);
	}

	public void save(Participant participant) {
		repo.save(participant);
	}

	public void delete(int id) {
		repo.delete(id);
	}
}
