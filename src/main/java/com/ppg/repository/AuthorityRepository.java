package com.ppg.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ppg.domain.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
