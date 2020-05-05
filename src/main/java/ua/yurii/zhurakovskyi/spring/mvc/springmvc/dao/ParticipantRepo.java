package ua.yurii.zhurakovskyi.spring.mvc.springmvc.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import ua.yurii.zhurakovskyi.spring.mvc.springmvc.domain.Level;
import ua.yurii.zhurakovskyi.spring.mvc.springmvc.domain.Participant;

@Repository
public class ParticipantRepo {
	private List<Participant> participants = new ArrayList<>();

	@PostConstruct
	public void init() {
		Participant participant1 = new Participant();
		participant1.setId(1);
		participant1.setName("Oleg");
		participant1.setEmail("oleg@email.com");
		participant1.setPrimarySkill("Running");
		participant1.setLevel(Level.L5);

		Participant participant2 = new Participant();
		participant2.setId(2);
		participant2.setName("Iryna");
		participant2.setEmail("iryna@email.com");
		participant2.setPrimarySkill("Swimming");
		participant2.setLevel(Level.L4);

		Participant participant3 = new Participant();
		participant3.setId(3);
		participant3.setName("Nazar");
		participant3.setEmail("nazar@email.com");
		participant3.setPrimarySkill("Canoeing");
		participant3.setLevel(Level.L3);

		Participant participant4 = new Participant();
		participant4.setId(4);
		participant4.setName("Kateryna");
		participant4.setEmail("kateryna@email.com");
		participant4.setPrimarySkill("Chessing");
		participant4.setLevel(Level.L2);

		Participant participant5 = new Participant();
		participant5.setId(5);
		participant5.setName("Ihor");
		participant5.setEmail("Ihor@email.com");
		participant5.setPrimarySkill("Alpinism");
		participant5.setLevel(Level.L1);

		participants.add(participant1);
		participants.add(participant2);
		participants.add(participant3);
		participants.add(participant4);
		participants.add(participant5);
	}

	public List<Participant> findAll() {
		return participants;
	}

	public Participant findOne(int id) {
		return participants.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	public void save(Participant participant) {
		Participant participantToUpdate = null;

		if (participant.getId() != null) {
			participantToUpdate = findOne(participant.getId());
			int index = participants.indexOf(participantToUpdate);
			participantToUpdate.setName(participant.getName());
			participantToUpdate.setEmail(participant.getEmail());
			participantToUpdate.setLevel(participant.getLevel());
			participantToUpdate.setPrimarySkill(participant.getPrimarySkill());
			participants.set(index, participantToUpdate);
		} else {
			participant.setId(participants.stream().mapToInt(p -> p.getId()).max().getAsInt() + 1);
			participants.add(participant);
		}
	}

	public void delete(int id) {
		Iterator<Participant> iterator = participants.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getId() == id) {
				iterator.remove();
			}
		}
	}
}
