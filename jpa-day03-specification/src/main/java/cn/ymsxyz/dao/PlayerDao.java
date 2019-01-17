package cn.ymsxyz.dao;


import cn.ymsxyz.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PlayerDao extends JpaRepository<Player,Long>,JpaSpecificationExecutor<Player>{}
