package br.univille.dacs2022.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.dacs2022.entity.HealthPlan;

@Repository
public interface HealthPlanRepository extends JpaRepository<HealthPlan,Long>{
    
}
