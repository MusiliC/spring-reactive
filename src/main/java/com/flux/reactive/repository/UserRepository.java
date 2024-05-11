package com.flux.reactive.repository;

import com.flux.reactive.entity.User;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Integer > {
}
