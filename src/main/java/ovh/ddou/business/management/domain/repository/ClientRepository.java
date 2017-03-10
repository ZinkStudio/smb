package ovh.ddou.business.management.domain.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import ovh.ddou.business.management.domain.model.Client;

@Transactional
public interface ClientRepository extends JpaRepository<Client, Long> {

}
