package mirea.mosit.serversfy.repository;

import mirea.mosit.serversfy.entity.Action;
import mirea.mosit.serversfy.entity.Auth;
import mirea.mosit.serversfy.entity.Observed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthRepository extends JpaRepository<Auth, Integer> {

    @Query(value = "select * from auth", nativeQuery = true)
    List<Auth> allAuths();

    @Query(value = "select password from auth where auth.login=:login", nativeQuery = true)
    String getPassword(@Param("login") String login);
}
