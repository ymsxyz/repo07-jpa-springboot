package cn.ymsxyz.repository;

import cn.ymsxyz.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{

    @Override
    public List<User> findAll();
}
