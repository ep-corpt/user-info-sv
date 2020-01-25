package com.epcorpt.userinfoapi.dao.repository;

import com.epcorpt.userinfoapi.dao.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, String> {

}
