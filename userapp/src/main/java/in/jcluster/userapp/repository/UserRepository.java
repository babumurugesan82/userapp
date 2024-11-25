package in.jcluster.userapp.repository;


import in.jcluster.userapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
