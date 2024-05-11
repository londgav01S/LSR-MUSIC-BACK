package co.edu.uniquindio.repository;

import co.edu.uniquindio.model.LSR_Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpotifyRepository extends JpaRepository<LSR_Music, Long> {
}
