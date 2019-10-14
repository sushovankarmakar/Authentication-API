package com.tavisca.gce.AuthenticationApi.repository;

import com.tavisca.gce.AuthenticationApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
