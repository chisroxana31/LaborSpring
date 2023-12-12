package Repo;

import Domain.PCRooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCRoomsRepository extends JpaRepository<PCRooms, Integer> {

}
